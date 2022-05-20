package com.example.bi3wichri;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.bi3wichri.Controller.ManageProducts;
import com.example.bi3wichri.Models.Produit;
import com.example.bi3wichri.RecyclerViewsAdaptaters.ProductAdaptaters;

import java.util.ArrayList;

public class Emplois extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    ProductAdaptaters productAdaptaters;
    ManageProducts manageProducts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emplois);
        recyclerView=findViewById(R.id.RecyclerView);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(recyclerView.getContext(),DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        manageProducts=new ManageProducts(this);
        ArrayList<Produit> listeProds = (ArrayList<Produit>) manageProducts.getAllProductEmplois();
        productAdaptaters=new ProductAdaptaters(this,listeProds);
        recyclerView.setAdapter(productAdaptaters);

    }
}