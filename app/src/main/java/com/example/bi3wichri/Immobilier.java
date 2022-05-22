package com.example.bi3wichri;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.bi3wichri.Controller.ManageProducts;
import com.example.bi3wichri.Models.Produit;
import com.example.bi3wichri.RecyclerViewsAdaptaters.ImmobilerAdaptater;
import com.example.bi3wichri.RecyclerViewsAdaptaters.MultimediaAdaptater;
import com.example.bi3wichri.RecyclerViewsAdaptaters.ProductAdaptaters;

import java.util.ArrayList;

public class Immobilier extends AppCompatActivity {
    RecyclerView recyclerViewImmobilier;
    RecyclerView.LayoutManager layoutManager;
    ImmobilerAdaptater immobilerAdaptater;
    ManageProducts manageProducts;
    private TextView nosales;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_immobilier);
        recyclerViewImmobilier=findViewById(R.id.rv_immobilier);
        nosales=findViewById(R.id.nosale_imm);

        manageProducts=new ManageProducts(this);
        ArrayList<Produit> listeProds = (ArrayList<Produit>) manageProducts.getAllProductsIm();
        if (listeProds==null){
            nosales.setText("No furnitures found for this moment");

        }else {
            layoutManager=new LinearLayoutManager(this);
            recyclerViewImmobilier.setLayoutManager(layoutManager);

            immobilerAdaptater = new ImmobilerAdaptater(this, listeProds);
            recyclerViewImmobilier.setAdapter(immobilerAdaptater);


            DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
            recyclerViewImmobilier.addItemDecoration(dividerItemDecoration);

        }

    }
}