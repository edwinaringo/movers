package com.example.movers_app.adapters;

import android.content.Context;
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

public class MovingCompanyOrdersListAdapter extends RecyclerView.Adapter<MovingCompanyOrdersListAdapter.MovingCompanyOrdersViewHolder> {
    private List<MovingOrders> mMovingOrdersList;
    private Context mContext;

    public MovingCompanyOrdersListAdapter(Context context, List<MovingOrders> movingOrders) {
        mContext = context;
        mMovingOrdersList = movingOrders;
    }

    @NonNull
    @Override
    public MovingCompanyOrdersListAdapter.MovingCompanyOrdersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.moving_company_orders_list_item, parent, false);
        MovingCompanyOrdersListAdapter.MovingCompanyOrdersViewHolder viewHolder = new MovingCompanyOrdersListAdapter.MovingCompanyOrdersViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovingCompanyOrdersListAdapter.MovingCompanyOrdersViewHolder holder, int position) {
        holder.bindMovingOrder(mMovingOrdersList.get(position));
    }

    @Override
    public int getItemCount() {
        return mMovingOrdersList.size();
    }

    public class MovingCompanyOrdersViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.movingOrderImageView)
        ImageView mMovingOrderImageView;
        @BindView(R.id.userName)
        TextView mUserName;
        @BindView(R.id.locations)
        TextView mLocations;
        @BindView(R.id.pickuptime)
        TextView mPickUpTime;
        @BindView(R.id.inventory)
        TextView mInventory;

        private Context mContext;

        public MovingCompanyOrdersViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }

        public void bindMovingOrder(MovingOrders order) {

            Picasso.get().load(R.drawable.tracking).into(mMovingOrderImageView);
            mUserName.setText(order.getUserEmail());
            mPickUpTime.setText(order.getPickupTime());
            mInventory.setText(order.getInventory());
            mLocations.setText(order.getCurrentLocation() + " to " + order.getNewLocation());


        }

        @Override
        public void onClick(View v) {

        }
    }
}
