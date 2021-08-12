package com.example.movers_app.adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movers_app.R;
import com.example.movers_app.models.MovingOrders;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovingOrdersListAdapter extends RecyclerView.Adapter<MovingOrdersListAdapter.MovingOrdersViewHolder> {
    private List<MovingOrders> mMovingOrdersList;
    private Context mContext;

    public MovingOrdersListAdapter(Context context, List<MovingOrders> movingOrders) {
        mContext = context;
        mMovingOrdersList = movingOrders;
    }

    @NonNull
    @Override
    public MovingOrdersListAdapter.MovingOrdersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.moving_orders_list_item, parent, false);
       MovingOrdersViewHolder viewHolder = new MovingOrdersViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovingOrdersListAdapter.MovingOrdersViewHolder holder, int position) {
        holder.bindMovingOrder(mMovingOrdersList.get(position));
    }

    @Override
    public int getItemCount() {
        return mMovingOrdersList.size();
    }

    public class MovingOrdersViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.movingOrderImageView)
        ImageView mMovingOrderImageView;
        @BindView(R.id.companyName)
        TextView mCompanyName;
        @BindView(R.id.locations)
        TextView mLocations;
        @BindView(R.id.pickuptime)
        TextView mPickUpTime;
        @BindView(R.id.inventory)
        TextView mInventory;

        private Context mContext;

        public MovingOrdersViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }

        public void bindMovingOrder(MovingOrders order) {

            Picasso.get().load(R.drawable.tracking).into(mMovingOrderImageView);
            mCompanyName.setText(order.getMovingCompany());
            mPickUpTime.setText(order.getPickupTime());
            mInventory.setText(order.getInventory());
            mLocations.setText(order.getCurrentLocation() + " to " + order.getNewLocation());


        }

        @Override
        public void onClick(View v) {

        }
    }
}
