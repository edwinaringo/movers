package com.example.movers_app;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.example.movers_app.models.MovingOrders;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovingOrdersDetailFragment  extends Fragment implements View.OnClickListener {

    @BindView(R.id.orderStatus)
    TextView mOrderStatus;
    @BindView(R.id.companyName)
    TextView mCompanyName;
    @BindView(R.id.userEmail)
    TextView mUserEmail;
    @BindView(R.id.inventory)
    TextView mInventory;
    @BindView(R.id.totalPrice)
    TextView mTotalPrice;
    @BindView(R.id.currentLocation)
    TextView mCurrentLocation;
    @BindView(R.id.newLocation)
    TextView mNewLocation;

    @BindView(R.id.pickupTime)
    TextView mPickupTime;



    private MovingOrders mMovingOrder;
    List<MovingOrders> mMovingOrdersList;

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

        mCompanyName.setText(mMovingOrder.getUserEmail());
        mUserEmail.setText(mMovingOrder.getUserEmail());
        mInventory.setText(mMovingOrder.getInventory());
        mTotalPrice.setText(mMovingOrder.getTotalPrice().toString());
        mPickupTime.setText(mMovingOrder.getPickupTime());
        mOrderStatus.setText(mMovingOrder.getOrderStatus());
        mCurrentLocation.setText(mMovingOrder.getCurrentLocation());
        mNewLocation.setText(mMovingOrder.getNewLocation());

        return view;

    }

    @Override
    public void onClick(View v) {

    }
}