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
    @BindView(R.id.orderImageView)
    ImageView mImageLabel;
    @BindView(R.id.userNameTextView)
    TextView mUserNameLabel;
    @BindView(R.id.inventoryTextView)
    TextView mInventoryLabel;
    @BindView(R.id.orderLocationsTextView)
    TextView mLocationsLabel;
    @BindView(R.id.orderPricesTextView)
    TextView mPricesLabel;
    @BindView(R.id.orderTimeTextView)
    TextView mPickUpTimeLabel;


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

        Picasso.get().load(R.drawable.box).into(mImageLabel);
        mUserNameLabel.setText(mMovingOrder.getUserEmail());
        mInventoryLabel.setText(mMovingOrder.getInventory());
        mPricesLabel.setText(mMovingOrder.getTotalPrice().toString());
        mPickUpTimeLabel.setText(mMovingOrder.getPickupTime());
        mLocationsLabel.setText(mMovingOrder.getCurrentLocation() + " to " + mMovingOrder.getNewLocation());

        return view;

    }

    @Override
    public void onClick(View v) {

    }
}
