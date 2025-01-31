package com.fit2081.a2_30324181.provider;

import static com.fit2081.a2_30324181.provider.Invoice.Invoice_table;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;
@Entity(tableName = Invoice_table)
public class Invoice {
    public static final String Invoice_table = "invoices";


    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "invoice_id")
    private String invoiceId;

    @ColumnInfo(name = "issuer_name")
    private String issuerName;
    @ColumnInfo(name = "buyer_name")
    private String buyerName;
    @ColumnInfo(name = "invoice_total")
    private double invoiceTotal;




    public Invoice(String invoiceId, String issuerName, String buyerName, double invoiceTotal) {
        this.invoiceId = invoiceId;
        this.issuerName = issuerName;
        this.buyerName= buyerName;
        this.invoiceTotal=invoiceTotal;
    }

    public int getId() {
        return id;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public String getIssuerName() {
        return issuerName;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public double getInvoiceTotal() {
        return invoiceTotal;
    }

    public void setId(int id) {
        this.id = id;
    }



}
