package com.example.bi3wichri.RecyclerViewsAdaptaters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bi3wichri.Models.Produit;
import com.example.bi3wichri.R;

import java.util.List;

public class VehiculeAdaptater extends RecyclerView.Adapter<VehiculeAdaptater.VehiculeViewHolder> {
    private Context c;
    private List<Produit> prod;

    public VehiculeAdaptater(Context c, List<Produit> prod) {
        this.c = c;
        this.prod = prod;
    }

    @NonNull
    @Override
    public VehiculeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerviewitems,parent,false);
        VehiculeViewHolder vehiculeViewHolder=new VehiculeViewHolder(view);
        return vehiculeViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull VehiculeViewHolder holder, int position) {
        Produit vehicule=prod.get(position);
        holder.nom_p.setText(vehicule.getNom_P());
        holder.price.setText(vehicule.getPrix_P());
        holder.description.setText(vehicule.getDescription_P());
    }

    @Override
    public int getItemCount() {
        return prod.size();
    }

    public class VehiculeViewHolder extends RecyclerView.ViewHolder{
        TextView nom_p;
        TextView price;
        TextView description;

        public VehiculeViewHolder(@NonNull View itemView) {
            super(itemView);
            nom_p=itemView.findViewById(R.id.name_P_recycle);
            price=itemView.findViewById(R.id.price_recycle);
            description=itemView.findViewById(R.id.description_recycle);
        }
    }
}
