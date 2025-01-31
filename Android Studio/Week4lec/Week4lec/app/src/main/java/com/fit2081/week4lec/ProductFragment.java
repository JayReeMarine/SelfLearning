package com.fit2081.week4lec;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fit2081.week4lec.provider.ProductViewModel;


public class ProductFragment extends Fragment {
    ProductViewModel viewModel;


    public ProductFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_product, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_id);
        ProductsAdapter adapter = new ProductsAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        viewModel = new ViewModelProvider(this).get(ProductViewModel.class);


        viewModel.getMyProducts().observe(getViewLifecycleOwner(), (newProducts) -> {
            adapter.setProducts(newProducts);
            adapter.notifyDataSetChanged();
        });
        return view;
    }
}