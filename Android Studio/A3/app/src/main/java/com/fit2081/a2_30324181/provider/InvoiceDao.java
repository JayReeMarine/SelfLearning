package com.fit2081.a2_30324181.provider;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface InvoiceDao {
    @Insert
    void addInvoice(Invoice invoice);

    @Query("select * from invoices")
    LiveData<List<Invoice>> getAllProducts();


    @Query("delete from invoices where id= :invoiceId")
    int deleteInvoiceById(int invoiceId);
}
