package com.coludev.phprestigea;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ReciboAdapter extends RecyclerView.Adapter<ReciboAdapter.ViewHolder> {

    private final List<Recibo> mData;

    private final Context context;

    public ReciboAdapter(List<Recibo> mData, Context context) {;
        this.mData = mData;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
    @Override
    public ReciboAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_element, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ReciboAdapter.ViewHolder holder, final int position) {
        holder.id.setText(mData.get(position).getInquilinoID());
        holder.fecha.setText("F.P.: "+mData.get(position).getFechadepago());
        holder.cuotaMant.setText("C.P.: " + mData.get(position).getCuotaPagada());
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView id, fecha, cuotaMant;
        ViewHolder(View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.tvAptNum);
            fecha = itemView.findViewById(R.id.tvFechaPag);
            cuotaMant = itemView.findViewById(R.id.tvMMant);
        }
    }
}
