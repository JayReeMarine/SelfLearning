package com.fit2081.fleetappprep;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fit2081.fleetappprep.provider.Fleet;

import java.util.ArrayList;

public class FleetAdapter extends RecyclerView.Adapter<FleetAdapter.FleetViewHolder> {

    ArrayList<Fleet> fleets;
    IDeleteFleet instance;

    private final int HEADER_CARD_TYPE = 0;
    private final int VALUE_CARD_TYPE = 1;

    public FleetAdapter(IDeleteFleet anInstance) {
        instance = anInstance;
    }


    public void setData(ArrayList<Fleet> data) {
        fleets = data;
    }


    @NonNull
    @Override
    public FleetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        if (viewType == VALUE_CARD_TYPE) {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false); //CardView inflated as RecyclerView list item
        } else {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.header_card_layout, parent, false); //CardView inflated as RecyclerView list item
        }
        FleetViewHolder viewHolder = new FleetViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FleetViewHolder holder, int position) {
        if (position != 0) {
            holder.fleetName.setText(fleets.get(position - 1).getName());
            holder.carsCount.setText(fleets.get(position - 1).getCars().size() + "");
            holder.delBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    instance.onDeleteInvoiceById(fleets.get(holder.getAdapterPosition()-1).getId());

                }
            });
        }
    }

    @Override
    public int getItemViewType(int position) {

        if (position == 0)
            return HEADER_CARD_TYPE;
        else return VALUE_CARD_TYPE;

    }

    @Override
    public int getItemCount() {
        return fleets.size() + 1;
    }

    public class FleetViewHolder extends RecyclerView.ViewHolder {
        TextView fleetName;
        TextView carsCount;

        View view;

        Button delBtn;
        public FleetViewHolder(@NonNull View itemView) {
            super(itemView);
            delBtn=itemView.findViewById(R.id.button2);
            view = itemView;
            fleetName = itemView.findViewById(R.id.fleet_name_id);
            carsCount = itemView.findViewById(R.id.cars_id);
        }
    }
}
