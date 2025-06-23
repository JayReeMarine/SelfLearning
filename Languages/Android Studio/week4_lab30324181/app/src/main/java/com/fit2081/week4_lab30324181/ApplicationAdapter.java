package com.fit2081.week4_lab30324181;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fit2081.week4_lab30324181.provider.DeviceFeature;
import com.fit2081.week4_lab30324181.provider.application;

import java.util.ArrayList;

public class ApplicationAdapter extends RecyclerView.Adapter<ApplicationAdapter.ApplicationViewHolder>{
    ArrayList<application> applications;

    public void setData(ArrayList<application> data) {
        applications = data;
    }

    @NonNull
    @Override
    public ApplicationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false); //CardView inflated as RecyclerView list item
        ApplicationViewHolder viewHolder=new ApplicationViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ApplicationViewHolder holder, int position) {
        holder.deviceName.setText(applications.get(position).getDevice_name());
        holder.year.setText(applications.get(position).getYear()+"");
        ArrayList<DeviceFeature> featurres = applications.get(position).getDevice_feature();
        String result = "";
        for(int i = 0; i < featurres.size(); i++) {
           result+=featurres.get(i).getFeatureName();

        }
        holder.deviceFeatures.setText(result);

    }

    @Override
    public int getItemCount() {
        return applications.size();
    }

    public class ApplicationViewHolder extends RecyclerView.ViewHolder {
        TextView deviceName;
        TextView year;
        TextView deviceFeatures;
        public ApplicationViewHolder(@NonNull View itemView) {
            super(itemView);
            deviceName=itemView.findViewById(R.id.device_name);
            year=itemView.findViewById(R.id.year);
            deviceFeatures=itemView.findViewById(R.id.device_features);
        }
    }
}
