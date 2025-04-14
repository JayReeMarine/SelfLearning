package com.fit2081.a2_30324181;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;




import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class itemAdapter extends RecyclerView.Adapter<itemAdapter.ViewHolder> {

    ArrayList<item> data = new ArrayList<item>();
    private final int HEADER_CARD_TYPE =0;
    private final int VALUE_CARD_TYPE =1;

    public void setData(ArrayList<item> data) {
        this.data = data;
    }
    @NonNull
    @Override
    public itemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if(viewType==VALUE_CARD_TYPE) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_layout, parent, false);
        }else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.header_item_card_layout, parent, false);
        }

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull itemAdapter.ViewHolder holder, int position) {

        if(position!=0) {
            int adjustedPosition = position - 1;
            holder.itemName.setText(data.get(adjustedPosition).getItemName());
            holder.itemQuantity.setText(String.valueOf(data.get(adjustedPosition).getItemQuantity()));
            holder.itemCost.setText(String.valueOf(data.get(adjustedPosition).getItemCost()));
        }
    }

    @Override
    public int getItemCount() {
        return data.size()+1;
    }

    @Override
    public int getItemViewType(int position) {
        if(position==0)
            return HEADER_CARD_TYPE;
        else return VALUE_CARD_TYPE;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView itemName;
        TextView itemQuantity;
        TextView itemCost;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.item_name);
            itemQuantity = itemView.findViewById(R.id.item_quantity);
            itemCost = itemView.findViewById(R.id.item_cost);
        }
    }
}
