package com.example.movers_app.ViewHolder;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movers_app.R;
import com.example.movers_app.models.OrdersStatus;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseStatusViewHolder extends RecyclerView.ViewHolder {

    View mView;
    Context mContext;
    private OrdersStatus ordersStatus;
    List<OrdersStatus> mListOrderStatus;
    public FirebaseStatusViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
        Log.i("view", String.valueOf(itemView.getContext()));
    }
    public void bindReview(OrdersStatus ordersStatus) {
        firebaseAdd();

        TextView userNameTextView = (TextView) mView.findViewById(R.id.userName);
        TextView commentTextView = (TextView) mView.findViewById(R.id.status);


    }
    public void firebaseAdd(){
        final ArrayList<OrdersStatus> ordersStatusArrayList = new ArrayList<>();

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        String uid = user.getUid();
        int itemPosition = getLayoutPosition();

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("OrderStatus");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {


            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    ordersStatusArrayList.add(snapshot.getValue(OrdersStatus.class));

                    for (int i = 0; i < ordersStatusArrayList.size(); i++) {

                        Log.i("status", ordersStatusArrayList.get(i).toString());

                    }
                    Log.i("status", ordersStatusArrayList.get(0).toString());



                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Log.i("database","The read failed: " + error.getCode());
            }
        });


    }



}








