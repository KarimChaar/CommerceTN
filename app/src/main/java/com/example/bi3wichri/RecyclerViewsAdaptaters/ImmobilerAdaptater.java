package com.example.bi3wichri.RecyclerViewsAdaptaters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bi3wichri.Controller.ManageUsers;
import com.example.bi3wichri.Models.Produit;
import com.example.bi3wichri.Models.User;
import com.example.bi3wichri.R;

import java.util.List;

public class ImmobilerAdaptater extends RecyclerView.Adapter<ImmobilerAdaptater.ImmobilerViewHolder> {
    private Context c;
    private List<Produit> prod;
    ManageUsers manageUsers;
    public ImmobilerAdaptater(Context c, List<Produit> prod) {
        this.c = c;
        this.prod = prod;
    }

    @NonNull
    @Override
    public ImmobilerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerviewitems,parent,false);
        ImmobilerViewHolder immobilerViewHolder=new ImmobilerViewHolder(view);
        return  immobilerViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ImmobilerViewHolder holder, int position) {
        Produit immobilier=prod.get(position);
        holder.nom_p.setText(immobilier.getNom_P());
        holder.price.setText(immobilier.getPrix_P());
        holder.description.setText(immobilier.getDescription_P());
        /*holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                manageUsers=new ManageUsers(c);
                int id=immobilier.getId_user();
                String userphone=manageUsers.getPhoneNumber(id);
                System.out.print("tellllllllllllll "+userphone);
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.fromParts("tel", userphone, null));
                c.startActivity(intent);
                return false;

            }
        });*/
    }

    @Override
    public int getItemCount() {
        return prod.size();
    }

    public class ImmobilerViewHolder extends RecyclerView.ViewHolder {
        TextView nom_p;
        TextView price;
        TextView description;

        public ImmobilerViewHolder(@NonNull View itemView) {
            super(itemView);
            nom_p=itemView.findViewById(R.id.name_P_recycle);
            price=itemView.findViewById(R.id.price_recycle);
            description=itemView.findViewById(R.id.description_recycle);
        }
    }
}
