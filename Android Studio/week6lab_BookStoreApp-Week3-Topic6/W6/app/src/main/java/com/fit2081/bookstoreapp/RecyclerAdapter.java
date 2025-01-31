package com.fit2081.bookstoreapp;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    ArrayList<BookItem> data;


    public RecyclerAdapter(ArrayList<BookItem> _data) {
        super();
        data = _data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_layout, viewGroup, false); //CardView inflated as RecyclerView list item
        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        Log.d("stock", "Bind a view for pos" + position);
        viewHolder.title.setText("Title: " + data.get(position).getTitle());
        viewHolder.bookId.setText("ID: " + data.get(position).getId());
        viewHolder.author.setText("Author: " + data.get(position).getAuthor());
        viewHolder.isbn.setText("ISBN: " + data.get(position).getIsbn());
        viewHolder.desc.setText("DESC: " + data.get(position).getDescription());
        viewHolder.price.setText("Price: " + data.get(position).getPrice() + "");

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public View itemView;
        public TextView title;
        public TextView bookId;
        public TextView author;
        public TextView isbn;
        public TextView desc;
        public TextView price;


        public ViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            title = itemView.findViewById(R.id.title_card_id);
            bookId = itemView.findViewById(R.id.book_id_card);
            author = itemView.findViewById(R.id.author_card_id);
            isbn = itemView.findViewById(R.id.isbn_card_id);
            desc = itemView.findViewById(R.id.desc_card_id);
            price = itemView.findViewById(R.id.price_card_id);
        }
    }


}
