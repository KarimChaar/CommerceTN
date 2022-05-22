package com.example.bi3wichri.RecyclerViewsAdaptaters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bi3wichri.Controller.ManageProducts;
import com.example.bi3wichri.Models.Produit;
import com.example.bi3wichri.Multimedia;
import com.example.bi3wichri.R;

import java.util.List;

public class MultimediaAdaptater extends RecyclerView.Adapter<MultimediaAdaptater.MultimediaViewHolder> {
    private Context c;
    private List<Produit> prod;
    ManageProducts manageProducts;
    public MultimediaAdaptater(Context context, List<Produit> Multimedias){
        this.c=context;
        this.prod=Multimedias;
    }

    @NonNull
    @Override
    public MultimediaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerviewitems,parent,false);
        MultimediaViewHolder multimediaViewHolder=new MultimediaViewHolder(view);
        return  multimediaViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull MultimediaViewHolder holder, int position) {
        Produit multimedia=prod.get(position);
        holder.nom_p.setText(multimedia.getNom_P());
        holder.price.setText(multimedia.getPrix_P());
        holder.description.setText(multimedia.getDescription_P());

    }

    @Override
    public int getItemCount() {
        return prod.size();
    }

    public class MultimediaViewHolder extends RecyclerView.ViewHolder{
        TextView nom_p;
        TextView price;
        TextView description;

        public MultimediaViewHolder(@NonNull View itemView) {
            super(itemView);
            nom_p=itemView.findViewById(R.id.name_P_recycle);
            price=itemView.findViewById(R.id.price_recycle);
            description=itemView.findViewById(R.id.description_recycle);
        }
    }
}
