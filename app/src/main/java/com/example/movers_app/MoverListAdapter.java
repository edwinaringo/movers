package com.example.movers_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MoverListAdapter extends RecyclerView.Adapter<MoverListAdapter.MyViewHolder> {

    Context context;

    ArrayList<MoverBio> list;

    public MoverListAdapter(Context context, ArrayList<MoverBio> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        MoverBio moverBio = list.get(position);
        holder.companyName.setText(moverBio.getCompanyName());
        holder.contactInfo.setText(moverBio.getContactInfo());
        holder.extraServices.setText(moverBio.getExtraServices());
        holder.inventory.setText(moverBio.getInventory());
        holder.pricePerDistance.setText(moverBio.getPricePerDistance());



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView companyName, contactInfo, extraServices, inventory, pricePerDistance;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            companyName =itemView.findViewById(R.id.companyName);
            contactInfo = itemView.findViewById(R.id.contactInfo);
            extraServices = itemView.findViewById(R.id.extraServices);
            inventory = itemView.findViewById(R.id.inventory);
            pricePerDistance = itemView.findViewById(R.id.pricePerDistance);
        }
    }
}
