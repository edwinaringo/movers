package com.example.movers_app;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class MoverListAdapter extends RecyclerView.Adapter<MoverListAdapter.MyViewHolder> {



    Context context;

    private static ArrayList<MoverBio> list;
    private static RecyclerViewClickListener listener;
    private static String[] orderInfo;



    public MoverListAdapter(Context context, ArrayList<MoverBio> list, RecyclerViewClickListener listener, String[] orderInfo) {
        this.context = context;
        this.list = list;
        this.listener = listener;

        this.orderInfo=orderInfo;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new MyViewHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        MoverBio moverBio = list.get(position);
        holder.companyName.setText(moverBio.getCompanyName());


        holder.inventoryCharges.setText("KSH."+moverBio.getInventory());
        holder.pricePerDistance.setText("KSH."+moverBio.getPricePerDistance());




    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        TextView companyName,  inventoryCharges, pricePerDistance;
        private Context mContext;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            companyName = itemView.findViewById(R.id.companyName);
            inventoryCharges = itemView.findViewById(R.id.inventoryCharges);
            pricePerDistance = itemView.findViewById(R.id.chargePerDistance);

            mContext = itemView.getContext();

            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {
            listener.onClick(v, getAdapterPosition());

//            Intent intent = new Intent(mContext,PickupsActivity.class);
//            orderInfo[5]=list.get(getAdapterPosition()).companyName;
//            intent.putExtra("orderInfo",orderInfo);
//            mContext.startActivity(intent);

            double distance = Double.parseDouble(orderInfo[6]);
            double charge = ( (Double.parseDouble(list.get(getAdapterPosition()).pricePerDistance)* distance)) +(Double.parseDouble(list.get(getAdapterPosition()).inventory));
            int total_charge = (int) Math.floor((int)charge);
            orderInfo[7]=String.valueOf(total_charge);

            AlertDialog.Builder builder1 = new AlertDialog.Builder(mContext);
            builder1.setMessage("CONFIRM ORDER \n TOTAL CHARGES :\n KSH."+total_charge );
            builder1.setCancelable(true);
            builder1.setPositiveButton(
                    "Yes",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                            Intent intent = new Intent(mContext, PickupsActivity.class);
                                        orderInfo[5]=list.get(getAdapterPosition()).getCompanyName();
                                        orderInfo[8]=list.get(getAdapterPosition()).getEmailAddress();
                                        intent.putExtra("orderInfo",orderInfo);
                                        mContext.startActivity(intent);

                            mContext.startActivity(intent);

                        }
                    });

            builder1.setNegativeButton(
                    "No",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });

            AlertDialog alert11 = builder1.create();
            alert11.show();



        }
    }

    public interface RecyclerViewClickListener{
        void onClick(View v, int position);
    }
}