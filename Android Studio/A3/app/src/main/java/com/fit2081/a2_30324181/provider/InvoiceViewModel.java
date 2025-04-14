package com.fit2081.a2_30324181.provider;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class InvoiceViewModel extends AndroidViewModel {
    private InvoiceRepo repo;

    private LiveData<List<Invoice>> InvoiceList;

    public InvoiceViewModel(@NonNull Application application) {
        super(application);
        repo = new InvoiceRepo(application);
        InvoiceList = repo.getAllMyInvoices();
    }


    public void insertNewInvoice(Invoice invoice) {
        repo.addNewInvoice(invoice);
    }

    public LiveData<List<Invoice>> getMyProducts() {
        return InvoiceList;
    }

    public int deleteInvoice(int id){
        return repo.deleteInvoice(id);
    }
}
