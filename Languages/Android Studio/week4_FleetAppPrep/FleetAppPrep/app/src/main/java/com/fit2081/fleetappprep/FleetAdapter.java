package com.fit2081.fleetappprep;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fit2081.fleetappprep.provider.Fleet;

import java.util.ArrayList;

public class FleetAdapter extends RecyclerView.Adapter<FleetAdapter.FleetViewHolder> {

    ArrayList<Fleet> fleets;

    public void setData(ArrayList<Fleet> data) {
        fleets = data;
    }

    @NonNull
    @Override
    public FleetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false); //CardView inflated as RecyclerView list item
        FleetViewHolder viewHolder=new FleetViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FleetViewHolder holder, int position) {
        holder.fleetName.setText(fleets.get(position).getName());
        holder.carsCount.setText(fleets.get(position).getCars().size()+"");
    }

    @Override
    public int getItemCount() {
        return fleets.size();
    }

    public class FleetViewHolder extends RecyclerView.ViewHolder {
        TextView fleetName;
        TextView carsCount;
        public FleetViewHolder(@NonNull View itemView) {
            super(itemView);
            fleetName=itemView.findViewById(R.id.fleet_name_id);
            carsCount=itemView.findViewById(R.id.cars_id);
        }
    }
}
