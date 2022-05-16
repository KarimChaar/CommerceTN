package com.example.bi3wichri.RecyclerViewsAdaptaters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bi3wichri.Immobilier;
import com.example.bi3wichri.Models.Produit;
import com.example.bi3wichri.R;

import java.util.List;

public class ProductAdaptaters extends RecyclerView.Adapter<ProductAdaptaters.ImmobilierViewHolder> {
    private Context c;
    private List<Produit> immobiliers;
    public ProductAdaptaters(Context context, List<Produit> ims){
        this.c=context;
        this.immobiliers=ims;

    }
    @NonNull
    @Override
    public ImmobilierViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerviewitems,parent,false);
        ImmobilierViewHolder immobilierViewHolder=new ImmobilierViewHolder(view);
        return  immobilierViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ImmobilierViewHolder holder, int position) {
        Produit produit=immobiliers.get(position);
        holder.description.setText(produit.getDescription_P());
        holder.price.setText(produit.getPrix_P().toString());
        holder.nom_p.setText(produit.getNom_P());
    }



    @Override
    public int getItemCount() {
        return immobiliers.size();
    }

    public class ImmobilierViewHolder extends RecyclerView.ViewHolder{
        TextView nom_p;
        TextView price;
        TextView description;
        public ImmobilierViewHolder(@NonNull View itemView) {
            super(itemView);
            nom_p=itemView.findViewById(R.id.name_P_recycle);
            price=itemView.findViewById(R.id.price_recycle);
            description=itemView.findViewById(R.id.description_recycle);
        }
    }
}
