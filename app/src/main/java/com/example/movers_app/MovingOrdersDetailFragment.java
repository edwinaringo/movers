package com.example.movers_app;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.example.movers_app.models.MovingOrders;
import com.example.movers_app.network.MoversAPI;
import com.example.movers_app.network.MoversClient;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovingOrdersDetailFragment  extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    @BindView(R.id.orderStatus)
    TextView mOrderStatus;
    @BindView(R.id.companyName)
    TextView mCompanyName;
    @BindView(R.id.userEmail)
    TextView mUserEmail;
    @BindView(R.id.inventory)
    TextView mInventory;
    @BindView(R.id.totalPrice2)
    TextView mTotalPrice;
    @BindView(R.id.currentLocation)
    TextView mCurrentLocation;
    @BindView(R.id.newLocation)
    TextView mNewLocation;

    @BindView(R.id.pickupTime)
    TextView mPickupTime;

    @BindView(R.id.spinner)
    Spinner mStatusSpinner;

    @BindView(R.id.spinner2)
    Spinner mStatusSpinner2;

    DatabaseReference database;
    private FirebaseAuth mAuth;



    ArrayAdapter<CharSequence> adapter;
    ArrayAdapter<CharSequence> adapter2;

    int id;
    String userName;
    String companyName;
    String userEmail;
    String inventory;
    int totalPrice;
    String currentLocation;
    String newLocation;
    String pickupTime;
    String orderStatus;
    String newOrderStatus;
    String companyEmail;

    String validCompanyName;

    String email;


    private MovingOrders mMovingOrder;
    List<MovingOrders> mMovingOrdersList;

//    private boolean inispinner;
int check = 0;

    public MovingOrdersDetailFragment(){

    }
    public static MovingOrdersDetailFragment newInstance(MovingOrders movingOrder){
        MovingOrdersDetailFragment movingOrdersDetailFragment = new MovingOrdersDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("movingOrders", Parcels.wrap(movingOrder));
        args.putParcelable("position", Parcels.wrap(movingOrder.getId()));

        movingOrdersDetailFragment.setArguments(args);
        return movingOrdersDetailFragment;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        assert getArguments() != null;
        mMovingOrder = Parcels.unwrap(getArguments().getParcelable("movingOrders"));


    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_moving_orders_detail, container, false);
        ButterKnife.bind(this, view);






        id=mMovingOrder.getId();
        companyName=mMovingOrder.getMovingCompany();
        userEmail=mMovingOrder.getUserEmail();
        inventory=mMovingOrder.getInventory();
        totalPrice=mMovingOrder.getTotalPrice();
        inventory=mMovingOrder.getInventory();
        pickupTime=mMovingOrder.getPickupTime();
        currentLocation=mMovingOrder.getCurrentLocation();
        newLocation=mMovingOrder.getNewLocation();
        orderStatus=mMovingOrder.getOrderStatus();
        companyEmail=mMovingOrder.getMovingCompanyEmail();

String price= String.valueOf(totalPrice);
        mCompanyName.setText(companyName);
        mUserEmail.setText(userEmail);
        mInventory.setText(inventory);
        mTotalPrice.setText(price);
        mPickupTime.setText(pickupTime);
        mOrderStatus.setText(orderStatus);
        mCurrentLocation.setText(currentLocation);
        mNewLocation.setText(newLocation);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        mAuth = FirebaseAuth.getInstance();
        String email = mAuth.getCurrentUser().getEmail();



        //spinner 1- company
        if(email.equals(companyEmail)){
            mStatusSpinner2.setVisibility(View.GONE);//user spinner

            adapter = ArrayAdapter.createFromResource(getContext(), R.array.company_order_status, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            mStatusSpinner.setAdapter(adapter);

            int spinnerPosition = adapter.getPosition(orderStatus);
//           mStatusSpinner.setSelected(false);
//            mStatusSpinner2.setSelection(0,true);
//            mStatusSpinner.setSelection(0,false);
//            mStatusSpinner.setSelection(Adapter.NO_SELECTION, true);
            mStatusSpinner.setSelection(spinnerPosition);
            mStatusSpinner.setOnItemSelectedListener(this);

        }

        //        spinner2 -user
        if(email.equals(userEmail)){


            adapter2 = ArrayAdapter.createFromResource(getContext(),R.array.user_order_status, android.R.layout.simple_spinner_item);
            adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            mStatusSpinner2.setAdapter(adapter2);

            int spinnerPosition2= adapter2.getPosition(orderStatus);
//            mStatusSpinner.setSelected(false);
//            mStatusSpinner2.setSelection(0,true);
//            mStatusSpinner2.setSelection(0,false);
//            mStatusSpinner2.setSelection(Adapter.NO_SELECTION, true);
            mStatusSpinner2.setSelection(spinnerPosition2);
            mStatusSpinner2.setOnItemSelectedListener(this);
            mStatusSpinner.setVisibility(View.GONE); //company spinner


        }

        return view;

    }

    @Override
    public void onClick(View v) {
        if(v == mStatusSpinner){

        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

//        if (!inispinner) {
//            inispinner = true;
//            return;
//        }
        if(++check > 1) {
            ((TextView) view).setText(null);

            newOrderStatus = parent.getItemAtPosition(position).toString();
            updateOrderStatus();
            mOrderStatus.setText(newOrderStatus);
//            Log.i("bbb",email);

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void updateOrderStatus(){

        MovingOrders movingOrder = new MovingOrders(userName,userEmail,inventory,currentLocation,newLocation,companyName,companyEmail,totalPrice,orderStatus,pickupTime);
        MoversAPI client = MoversClient.getClient();
        Call<MovingOrders> call = client.updateMovingOrderStatus(id,newOrderStatus,movingOrder);

        call.enqueue(new Callback<MovingOrders>() {
            @Override
            public void onResponse(Call<MovingOrders> call, Response<MovingOrders> response) {

                if(!response.isSuccessful()){
                    Toast.makeText(getContext(),"code"+response.code(),Toast.LENGTH_SHORT).show();
                    return;

                }

                mOrderStatus.setText(newOrderStatus);

                Toast.makeText(getContext(),"Status updated",Toast.LENGTH_SHORT).show();
//                Intent intent =new Intent(getContext(),MovingCompanyOrdersActivity.class);
//                intent.putExtra("companyName",companyName);
//                startActivity(intent);

//                if(email.equals(userEmail)){
//                    Intent intent =new Intent(getContext(),MovingOrdersActivity.class);
//                    intent.putExtra("username",userName);
//                    startActivity(intent);
//                }
//                 if(email.equals(companyEmail)){
//                     Intent intent =new Intent(getContext(),MovingCompanyOrdersActivity.class);
//                     intent.putExtra("companyName",companyName);
//                     startActivity(intent);
//                 }





            }

            @Override
            public void onFailure(Call<MovingOrders> call, Throwable t) {
                Toast.makeText(getContext(),t.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });

    }
}