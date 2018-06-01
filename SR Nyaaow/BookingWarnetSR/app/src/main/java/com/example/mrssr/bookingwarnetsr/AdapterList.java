package com.example.mrssr.bookingwarnetsr;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class AdapterList extends RecyclerView.Adapter<AdapterList.ViewHolder>{

    Context context;
    ArrayList<HashMap<String, String>> list_data;

    public AdapterList(MainActivityListBooking mainActivity, ArrayList<HashMap<String, String>> list_data) {
        this.context = mainActivity;
        this.list_data = list_data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_booking, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.Pc.setText(list_data.get(position).get("pc"));
        holder.Tanggal.setText(list_data.get(position).get("tanggal"));
    }

    @Override
    public int getItemCount() {
        return list_data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView Pc;
        TextView Tanggal;

        public ViewHolder(View itemView) {
            super(itemView);

            Pc = (TextView) itemView.findViewById(R.id.pc);
            Tanggal = (TextView) itemView.findViewById(R.id.tanggal);
        }
    }
}