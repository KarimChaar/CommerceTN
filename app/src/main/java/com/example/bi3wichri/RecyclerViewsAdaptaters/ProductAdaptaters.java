package com.example.bi3wichri.RecyclerViewsAdaptaters;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bi3wichri.Controller.ManageProducts;
import com.example.bi3wichri.Immobilier;
import com.example.bi3wichri.Models.Produit;
import com.example.bi3wichri.R;

import java.util.List;

public class ProductAdaptaters extends RecyclerView.Adapter<ProductAdaptaters.ProduitProfile> {
    private Context c;
    private List<Produit> prod;
    ManageProducts manageProducts;
    public ProductAdaptaters(Context context, List<Produit> ims){
        this.c=context;
        this.prod=ims;
    }


    @NonNull
    @Override
    public ProduitProfile onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_prod_item,parent,false);
        manageProducts = new ManageProducts(parent.getContext());
        ProduitProfile produitProfile=new ProduitProfile(view);
        return  produitProfile;
    }

    @Override
    public void onBindViewHolder(@NonNull ProduitProfile holder, int position) {

        Produit produit=prod.get(position);
        holder.description.setText(produit.getDescription_P());
        holder.price.setText(produit.getPrix_P());
        holder.category.setText(produit.getCategorie_P());
        holder.nom_p.setText(produit.getNom_P());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(c);
                builder.setTitle("Update");
                final EditText inputNameP = new EditText(c);
                final EditText inputPrice = new EditText(c);
                final Spinner spinnerCat=new Spinner(c);
                final EditText inputDesc = new EditText(c);
                final TextView name=new TextView(c);
                final TextView price=new TextView(c);
                final TextView categorie=new TextView(c);
                final TextView desc=new TextView(c);
                Produit getProd=manageProducts.getProduit(produit.getNom_P());
                name.setText("Name :");
                price.setText("Price :");
                categorie.setText("Category :");
                desc.setText("description :");
                LinearLayout lp = new LinearLayout(c);
                inputDesc.setText(getProd.getDescription_P());
                inputPrice.setText(getProd.getPrix_P());
                String [] category = new String[]{"Vehicule","Emplois","Multimedia","Immobilier"};
                ArrayAdapter<String> adapter = new ArrayAdapter<>(c,android.R.layout.simple_spinner_dropdown_item,category);
                spinnerCat.setAdapter(adapter);
                inputNameP.setText(getProd.getNom_P());
                lp.setOrientation(LinearLayout.VERTICAL);
                lp.addView(name);
                lp.addView(inputNameP);
                lp.addView(price);
                lp.addView(inputPrice);
                lp.addView(categorie);
                lp.addView(spinnerCat);
                lp.addView(desc);
                lp.addView(inputDesc);
                builder.setView(lp);
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ManageProducts manageProducts = new ManageProducts(c.getApplicationContext());
                        getProd.setNom_P(inputNameP.getText().toString());
                        getProd.setPrix_P(inputPrice.getText().toString());
                        getProd.setDescription_P( inputDesc.getText().toString());
                        getProd.setCategorie_P(spinnerCat.getSelectedItem().toString().trim());
                        long j=manageProducts.updateProduct(getProd);

                        if (j!=0) {
                            int PostionStart =holder.getAdapterPosition();
                            notifyItemChanged(PostionStart);
                            notifyItemRangeChanged(PostionStart,prod.size());
                            Toast.makeText(c,produit.getNom_P()+" is updated",Toast.LENGTH_SHORT).show();
                        }
                        else{
                           Toast.makeText(c," is prb",Toast.LENGTH_SHORT).show();
                        }

                        dialogInterface.dismiss();
                        int PostionStart =holder.getAdapterPosition();
                        notifyItemChanged(PostionStart);
                        notifyItemRangeChanged(PostionStart,prod.size());
                    }
                });

                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog alert= builder.create();
                alert.show();

            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(c);
                builder.setTitle("Delete");
                builder.setMessage("Are you sure of this action ?");
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ManageProducts manageProducts = new ManageProducts(c.getApplicationContext());
                        manageProducts.deleteProd(produit);
                        Toast.makeText(c,produit.getNom_P()+" deleted successfully",Toast.LENGTH_SHORT).show();
                        dialogInterface.dismiss();
                        int PostionStart =holder.getAdapterPosition();
                        prod.remove(PostionStart);

                        notifyItemRemoved(PostionStart);
                        notifyItemRangeChanged(PostionStart,prod.size());
                    }
                });

                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog alert= builder.create();
                alert.show();
                return false;
            }
        });
    }



    @Override
    public int getItemCount() {
        return prod.size();
    }

    public class ProduitProfile extends RecyclerView.ViewHolder{
        TextView nom_p;
        TextView price;
        TextView category;
        TextView description;

        public ProduitProfile(@NonNull View itemView) {
            super(itemView);
            nom_p=itemView.findViewById(R.id.nom_pdt);
            price=itemView.findViewById(R.id.prix_pdt);
            category=itemView.findViewById(R.id.category_pdt);
            description=itemView.findViewById(R.id.desk_pdt);

        }
    }


}
