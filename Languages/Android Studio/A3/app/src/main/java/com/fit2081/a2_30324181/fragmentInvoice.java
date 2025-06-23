package com.fit2081.a2_30324181;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fit2081.a2_30324181.provider.InvoiceViewModel;



public class fragmentInvoice extends Fragment implements IDeleteInvoice {

    InvoiceViewModel viewModel;


    public fragmentInvoice() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_invoice, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_invoice);
        InvoiceAdapter adapter= new InvoiceAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        viewModel = new ViewModelProvider(this).get(InvoiceViewModel.class);


        viewModel.getMyProducts().observe(getViewLifecycleOwner(), (newInvoices) -> {
            adapter.setInvoices(newInvoices);
            adapter.notifyDataSetChanged();
        });
        return view;
    }

    @Override
    public void onDeleteInvoiceById(int id) {
        viewModel.deleteInvoice(id); // Call the method on the viewModel instance
    }
}