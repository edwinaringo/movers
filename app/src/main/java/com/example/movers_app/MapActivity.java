package com.example.movers_app;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.Autocomplete;
import com.google.android.libraries.places.widget.AutocompleteActivity;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class MapActivity extends AppCompatActivity implements View.OnClickListener, OnMapReadyCallback {

    LatLng source ;
    LatLng desination ;


    GoogleMap googleMap;

    EditText etSource,etDestination;
    Button proceed,btTrack;


    String sType;
    String []  orderInfo;

    String sSource,sDestination;
    double distance;

    double Lat1 = 0,Long1 = 0, Lat2 = 0, Long2 = 0;
    int flag = 0;









    /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        @Override
        public void onMapReady(GoogleMap googleMap1) {

            LatLng zoom = new LatLng(  -1.286389, 36.8219);
            googleMap= googleMap1;

            googleMap.addMarker(new MarkerOptions().position(zoom).title("Source Marker"));
            googleMap.getUiSettings().setZoomControlsEnabled(true);
            googleMap.getUiSettings().setAllGesturesEnabled(true);
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(zoom,6.0f));
           // googleMap.setMaxZoomPreference(6.0f);


            Toast.makeText(getApplicationContext(),"Zoom in or out to view selected locations ",Toast.LENGTH_SHORT).show();


        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_maps);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }


        proceed=findViewById(R.id.proceed);
        etSource = findViewById(R.id.et_source);
        etDestination = findViewById(R.id.et_destination);
        btTrack = findViewById(R.id.bt_track);

        //initialize places
        Places.initialize(getApplicationContext(),"AIzaSyATvNjtdd2UiIPQRyl-xzP11rth1AGUBwI");

        //set edit Text non focusable
        etSource.setFocusable(false);
        etSource.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Define type
                sType = "source";
                //initialize place field list
                List<Place.Field> fields = Arrays.asList(Place.Field.ADDRESS,
                        Place.Field.LAT_LNG);
                //Create intent
                Intent intent = new Autocomplete.IntentBuilder(AutocompleteActivityMode.OVERLAY,fields).build(getApplicationContext());
                //start activity result
                startActivityForResult(intent,100);

            }
        });

        etDestination.setFocusable(false);
        etDestination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Define type
                sType = "destination".trim();
                //initialize place field list
                List<Place.Field> fields = Arrays.asList(Place.Field.ADDRESS,
                        Place.Field.LAT_LNG);
                //Create intent
                Intent intent = new Autocomplete.IntentBuilder(AutocompleteActivityMode.OVERLAY,fields).build(getApplicationContext());
                //start activity result
                startActivityForResult(intent,100);
            }
        });

        proceed.setOnClickListener(this);
        sSource = etSource.getText().toString().trim();
        sDestination = etDestination.getText().toString().trim();

        //-------

//        Bundle extras = getIntent().getExtras();
//        double[] mapInfo = extras.getDoubleArray("mapInfo");

        source = new LatLng(Lat1, Long1);
        desination = new LatLng(Lat2,Long2);
//        distance = mapInfo[4];

        btTrack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sSource = etSource.getText().toString().trim();
                String sDestination = etDestination.getText().toString().trim();
                if (sSource.equals("") && sDestination.equals("")){
                    Toast.makeText(getApplicationContext(),"Enter both Location",Toast.LENGTH_LONG);
                }else {
                    DisplayTrack(sSource,sDestination);

                }
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //check condition
        if(requestCode == 100 && resultCode == RESULT_OK){
            //When success
            //initialize place
            Place place = Autocomplete.getPlaceFromIntent(data);
            //check condition
            if(sType.trim().equals("source")){
                //when type is source
                //increase flag value
                flag++;
                //set adrress to edit text
                etSource.setText(place.getAddress());
                //Get latitude and longitude
                String sSource = String.valueOf(place.getLatLng());
                sSource = sSource.trim().replaceAll("lat/lng:","");
                sSource = sSource.replace("(","");
                sSource = sSource.replace(")","");
                String[] split = sSource.split(",");
                if ( !sType.trim().equals("")) {
                    Lat1 = Double.parseDouble(split[0]);
                    Long1 = Double.parseDouble(split[1]);
                    googleMap.addMarker(new MarkerOptions().position(new LatLng(102.5, 102.4)).title("Source Marker"));
                    googleMap.getUiSettings().setZoomControlsEnabled(true);
                    googleMap.getUiSettings().setAllGesturesEnabled(true);
                    googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(desination,15f));

                }
            }else {
                //when type is destination
                //increase flag value
                flag++;
                etDestination.setText(place.getAddress());
                //Get latitude and longitude
                String sDestination = String.valueOf(place.getLatLng());
                sDestination = sDestination.replaceAll("lat/lng:","");
                sDestination = sDestination.replace("(","");
                sDestination = sDestination.replace(")","");
                String[] split = sDestination.split(",");
                if ( !sType.trim().equals("")) {
                    Lat2 = Double.parseDouble(split[0]);
                    Long2 = Double.parseDouble(split[1]);

                    googleMap.addMarker(new MarkerOptions().position(new LatLng(102.5, 103.1)).title("Destination Marker "));
                }
            }
            if(flag>= 2){
                //calculate distance
                distance(Lat1,Long1,Lat2,Long2);
            }
        }else if (requestCode == AutocompleteActivity.RESULT_ERROR){
            Status status = Autocomplete.getStatusFromIntent(data);
            Toast.makeText(getApplicationContext(),status.getStatusMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void distance(double lat1, double long1, double lat2, double long2) {
        //calculate longitude difference
        double longDiff = Long1 - Long2;
        //calculate distance
        distance = Math.sin(deg2rad(Lat1))
                *Math.sin(deg2rad(Lat2))
                +Math.cos(deg2rad(Lat1))
                *Math.cos(deg2rad(Lat2))
                *Math.cos(deg2rad(longDiff));
        distance = Math.acos(distance);
        //Convert distance radian to degree
        distance = rad2deg(distance);
        //Distance in miles
        distance = distance * 60 * 1.1515;
        //Distance in kilometers
        distance = distance *  1.609344;
        //set distance on text view
//        textView.setText(String.format(Locale.US,"%2f kilometers",distance).trim());
    }
    //convert radian to degree
    private double rad2deg(double distance) {
        return (distance * 180.0 / Math.PI);
    }

    //convert degree to radian
    private double deg2rad(double lat1) {
        return  (Lat1*Math.PI/180.0);
    }

    private void DisplayTrack(String sSource, String sDestination) {
        try {
            Uri uri = Uri.parse("https://www.google.co.in/maps/dir/" + sSource + "/" + sDestination);
            Intent intent = new Intent(Intent.ACTION_VIEW,uri);
            intent.setPackage("com.google.android.apps.maps");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }catch (ActivityNotFoundException e){
            Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.apps.maps");
            Intent intent = new Intent(Intent.ACTION_VIEW,uri);
            intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }

    @Override
    public void onClick(View v) {
            if(v == proceed){
                sSource = etSource.getText().toString().trim();
                sDestination = etDestination.getText().toString().trim();

                Bundle extras = getIntent().getExtras();
                orderInfo = extras.getStringArray("orderInfo");

                orderInfo[3] = sSource;
                orderInfo[4]=sDestination;
                orderInfo[6]= String.valueOf(distance);
                Intent intent2 =new Intent(getApplicationContext(),MoversList.class);


                intent2.putExtra("orderInfo",orderInfo);
                startActivity(intent2);


            }

    }
}