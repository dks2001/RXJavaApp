package com.dheerendrakumar.rxjavaapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RVCustomAdapter extends RecyclerView.Adapter<RVCustomAdapter.MyViewHolder> {

    private final List<Entry> entries = new ArrayList<>();

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item,parent,false);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Entry entry = entries.get(position);
        holder.setTxtName(entry.getEntryName());
        holder.setPrice(entry.getEntryPrice());
        holder.setDate(entry.getEntryDate());
    }

    @Override
    public int getItemCount() {
        return entries.size();
    }

    public void addToString(Entry entry) {
        entries.add(entry);
        notifyItemInserted(entries.size()-1);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txtName)
        TextView txtName;
        @BindView(R.id.txtPrice)
        TextView txtprice;
        @BindView(R.id.txtdate)
        TextView txtdate;

        private final NumberFormat numberFormat = new DecimalFormat("#0.00");

        public void setTxtName(String en) {
            this.txtName.setText(en);
        }

        public void setPrice(BigDecimal ep) {
            this.txtprice.setText(numberFormat.format(ep.doubleValue()));
        }

        public void setDate(Date ed) {
            this.txtdate.setText(android.text.format.DateFormat.format("yyyy-MM-dd hh:mm",ed));
        }

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            ButterKnife.bind(this,itemView);
        }
    }


}
