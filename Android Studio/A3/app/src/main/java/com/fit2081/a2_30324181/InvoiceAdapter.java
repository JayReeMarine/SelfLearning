package com.fit2081.a2_30324181;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fit2081.a2_30324181.provider.Invoice;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class InvoiceAdapter extends RecyclerView.Adapter<InvoiceAdapter.ViewHolder> {

    List<Invoice> invoices;

    private final int HEADER_CARD_TYPE =0;
    private final int VALUE_CARD_TYPE =1;

    IDeleteInvoice instance;
    public InvoiceAdapter(IDeleteInvoice anInstance){
        instance = anInstance;
    }

    public void setInvoices(List<Invoice> aList) {invoices=aList;}

    @NonNull
    @Override
    public InvoiceAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if(viewType==VALUE_CARD_TYPE) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.invoice_card_layout, parent, false);
        }else{
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.header_invoice_card_layout, parent, false);

        }
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull InvoiceAdapter.ViewHolder holder, int position) {

        if(position!=0) {
            int adjustedPosition = position - 1;
            holder.invoiceID.setText(invoices.get(adjustedPosition).getInvoiceId());
            holder.issuerName.setText(invoices.get(adjustedPosition).getIssuerName());
            holder.buyerName.setText(invoices.get(adjustedPosition).getBuyerName());
            holder.invoiceTotal.setText(String.valueOf((int) invoices.get(adjustedPosition).getInvoiceTotal()));


            holder.view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    instance.onDeleteInvoiceById(invoices.get(holder.getAdapterPosition()-1).getId());
                    int positionInList = holder.getAdapterPosition() - 1;
                    Invoice selectedInvoice = invoices.get(positionInList);
                    Snackbar.make(v, "Delete invoice " + selectedInvoice.getInvoiceId() + "?", Snackbar.LENGTH_LONG)
                                .setAction("DELETE", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        instance.onDeleteInvoiceById(selectedInvoice.getId());
                                    }
                                }).show();
                }
            });

        }

    }

    @Override
    public int getItemViewType(int position) {
        if(position==0)
            return HEADER_CARD_TYPE;
        else return VALUE_CARD_TYPE;
    }

    @Override
    public int getItemCount() {
        if (invoices == null)
            return 0;
        return invoices.size()+1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView invoiceID;
        TextView issuerName;
        TextView buyerName;
        TextView invoiceTotal;

        View view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view=itemView;
            invoiceID = itemView.findViewById(R.id.invoice_id);
            issuerName = itemView.findViewById(R.id.issuer_name);
            buyerName = itemView.findViewById(R.id.buyer_name);
            invoiceTotal = itemView.findViewById(R.id.invoice_total);
        }
    }

}
