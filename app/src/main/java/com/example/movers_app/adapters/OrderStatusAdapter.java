package com.example.movers_app.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movers_app.R;
import com.example.movers_app.models.OrdersStatus;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderStatusAdapter extends RecyclerView.Adapter<OrderStatusAdapter.StatusViewHolder>{
    private List<OrdersStatus> mStatusList;
    private Context mContext;

    public OrderStatusAdapter (Context context, List<OrdersStatus> statusList) {
        mContext = context;
        mStatusList = statusList;
    }
    @NonNull
    @Override
    public OrderStatusAdapter.StatusViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.status_list_item, parent, false);
        StatusViewHolder  viewHolder = new StatusViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull OrderStatusAdapter.StatusViewHolder holder, int position) {
        holder.bindReview(mStatusList.get(position));
    }

    @Override
    public int getItemCount() {
        return mStatusList.size();
    }

    public class StatusViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @BindView(R.id.userName)
        TextView mUsernameTextView;
        @BindView(R.id.status) TextView mStatusTextView;

        private Context mContext;

        public StatusViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }

        public void bindReview(OrdersStatus statusOfOrder) {
            mUsernameTextView.setText (statusOfOrder.getEmail());
            mStatusTextView.setText(statusOfOrder.getStatus());
        }

        @Override
        public void onClick(View v) {
//            int itemPosition = getLayoutPosition();
//            Intent intent = new Intent(mContext, GamesDetailActivity.class);
//            intent.putExtra("position", itemPosition);
//            intent.putExtra("status", Parcels.wrap(mReviews));
//            mContext.startActivity(intent);
        }
    }

}
