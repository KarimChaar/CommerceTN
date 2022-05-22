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

public class EmploisAdaptater extends RecyclerView.Adapter<EmploisAdaptater.EmploisViewHolder> {
    private Context c;
    private List<Produit> prod;

    public EmploisAdaptater(Context c, List<Produit> prod) {
        this.c = c;
        this.prod = prod;
    }


    @NonNull
    @Override
    public EmploisViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerviewitems,parent,false);
        EmploisViewHolder vehiculeViewHolder=new EmploisViewHolder(view);
        return vehiculeViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull EmploisAdaptater.EmploisViewHolder holder, int position) {
        Produit emplois=prod.get(position);
        holder.nom_p.setText(emplois.getNom_P());
        holder.price.setText(emplois.getPrix_P());
        holder.description.setText(emplois.getDescription_P());
    }

    @Override
    public int getItemCount() {
        return prod.size();
    }

    public class EmploisViewHolder extends RecyclerView.ViewHolder{
        TextView nom_p;
        TextView price;
        TextView description;

        public EmploisViewHolder(@NonNull View itemView) {
            super(itemView);
            nom_p=itemView.findViewById(R.id.name_P_recycle);
            price=itemView.findViewById(R.id.price_recycle);
            description=itemView.findViewById(R.id.description_recycle);
        }
    }
}
