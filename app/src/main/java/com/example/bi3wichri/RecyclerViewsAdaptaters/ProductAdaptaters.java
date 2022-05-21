package com.example.bi3wichri.RecyclerViewsAdaptaters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bi3wichri.Immobilier;
import com.example.bi3wichri.LiteDatabaseHelper;
import com.example.bi3wichri.Models.Produit;
import com.example.bi3wichri.R;

import java.util.List;

public class ProductAdaptaters extends RecyclerView.Adapter<ProductAdaptaters.ImmobilierViewHolder> {
    private Context c;
    private List<Produit> prod;
    LiteDatabaseHelper ldb;
    public ProductAdaptaters(Context context, List<Produit> ims){
        this.c=context;
        this.prod=ims;

    }
    @NonNull
    @Override
    public ImmobilierViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_prod_item,parent,false);
        ldb = new LiteDatabaseHelper(parent.getContext());
        ImmobilierViewHolder immobilierViewHolder=new ImmobilierViewHolder(view);
        return  immobilierViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ImmobilierViewHolder holder, int position) {
        Produit produit=prod.get(position);
        holder.description.setText(produit.getDescription_P());
        holder.price.setText(produit.getPrix_P().toString());
        holder.nom_p.setText(produit.getNom_P());
        holder.settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        holder.del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ldb.deleteProd(produit.getId_P());
            }
        });
    }



    @Override
    public int getItemCount() {
        return prod.size();
    }

    public class ImmobilierViewHolder extends RecyclerView.ViewHolder{
        TextView nom_p;
        TextView price;
        TextView description;
        ImageButton settings;
        ImageButton del;
        public ImmobilierViewHolder(@NonNull View itemView) {
            super(itemView);
            nom_p=itemView.findViewById(R.id.nom_pdt);
            price=itemView.findViewById(R.id.prix_pdt);
            description=itemView.findViewById(R.id.desk_pdt);
            settings = itemView.findViewById(R.id.settings_btn);
            del = itemView.findViewById(R.id.del_btn);
        }
    }
}
