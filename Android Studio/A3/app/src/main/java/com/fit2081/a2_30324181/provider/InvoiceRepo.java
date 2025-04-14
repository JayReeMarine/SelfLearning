package com.fit2081.a2_30324181.provider;
import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;
public class InvoiceRepo {
    private InvoiceDao invoiceDao;

    private LiveData<List<Invoice>> invoiceList;

    public InvoiceRepo(Application app) {
        InvoicesDatabase db = InvoicesDatabase.getInstance(app);
        invoiceDao = db.invoiceDao();

        invoiceList = invoiceDao.getAllProducts();
    }

    void addNewInvoice(Invoice invoice) {
        InvoicesDatabase.databaseWriteExecutors.execute(()->{
            invoiceDao.addInvoice(invoice);
        });

    }

    LiveData<List<Invoice>> getAllMyInvoices() {
        return invoiceList;
    }

    int deleteInvoice(int id){
        InvoicesDatabase.databaseWriteExecutors.execute(()->{
            invoiceDao.deleteInvoiceById(id);
        });
        return 1;
    }
}
