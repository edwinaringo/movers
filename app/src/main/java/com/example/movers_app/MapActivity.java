package com.example.movers_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends AppCompatActivity {

    LatLng source ;
    LatLng desination ;

    double distance;




    private OnMapReadyCallback callback = new OnMapReadyCallback() {

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
        public void onMapReady(GoogleMap googleMap) {
            googleMap.addMarker(new MarkerOptions().position(source).title("Source Marker"));

            googleMap.addMarker(new MarkerOptions().position(desination).title("Destination Marker "));
            googleMap.getUiSettings().setZoomControlsEnabled(true);
            googleMap.getUiSettings().setAllGesturesEnabled(true);
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(desination,15f));

            Toast.makeText(getApplicationContext(),"Zoom in or out to view selected locations ",Toast.LENGTH_SHORT).show();


        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_maps);

        Bundle extras = getIntent().getExtras();
        double[] mapInfo = extras.getDoubleArray("mapInfo");

        source = new LatLng(mapInfo[0], mapInfo[1]);
        desination = new LatLng(mapInfo[2],mapInfo[3]);
        distance = mapInfo[4];

        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }
}