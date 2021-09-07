package com.example.amiibojavaretrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Adaptery extends RecyclerView.Adapter<Adaptery.MyViewHolder> {
    private Context mContext;

    public Adaptery(Context mContext, List<Amiibo> amiibos) {
        this.mContext = mContext;
        this.amiibos = amiibos;
    }

    private List<Amiibo> amiibos;


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v;
        LayoutInflater layoutInflater=LayoutInflater.from(mContext);
        v=layoutInflater.inflate(R.layout.adapter_amiibo,parent,false);
        return new MyViewHolder(v);

    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.name.setText(amiibos.get(position).getName());
        holder.amiiboSeries.setText(amiibos.get(position).getAmiiboSeries());
        holder.gameSeries.setText(amiibos.get(position).getGameSeries());
        holder.head.setText(amiibos.get(position).getHead());
        holder.character.setText(amiibos.get(position).getCharacter());

        Glide.with(mContext)
                .load(amiibos.get(position).getImage())
                .into(holder.imageview);

    }

    @Override
    public int getItemCount() {
        return amiibos.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView name;
        TextView amiiboSeries;
        TextView gameSeries;
        TextView head;
        TextView character;
        ImageView imageview;


        public MyViewHolder(@NonNull View itemView) {

            super(itemView);
            name=itemView.findViewById(R.id.name);
            amiiboSeries=itemView.findViewById(R.id.amiiboSeries);
            gameSeries=itemView.findViewById(R.id.gameSeries);
            head=itemView.findViewById(R.id.head);
            character=itemView.findViewById(R.id.character);
            imageview=itemView.findViewById(R.id.imageview);

        }
    }
}
