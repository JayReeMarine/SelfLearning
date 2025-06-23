package com.fit2081.week3lec;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Week3RecyclerAdapter extends RecyclerView.Adapter<Week3RecyclerAdapter.ViewHolder> {

    ArrayList<Person> data;

    public void setData(ArrayList<Person> theData) {
        data = theData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.person_card, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nameTV.setText(data.get(position).getName());
        holder.ageTV.setText(String.valueOf(data.get(position).getAge()));
        holder.addressTV.setText(data.get(position).getAddress());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView nameTV;
        TextView ageTV;
        TextView addressTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTV = itemView.findViewById(R.id.person_card_name_id);
            ageTV = itemView.findViewById(R.id.person_card_age_id);
            addressTV = itemView.findViewById(R.id.person_card_address_id);
        }
    }
}
