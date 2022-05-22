package com.example.bi3wichri;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.bi3wichri.Controller.ManageProducts;
import com.example.bi3wichri.Models.Produit;
import com.example.bi3wichri.RecyclerViewsAdaptaters.MultimediaAdaptater;
import com.example.bi3wichri.RecyclerViewsAdaptaters.ProductAdaptaters;

import java.util.ArrayList;

public class Multimedia extends AppCompatActivity {
    RecyclerView recyclerViewMultimedia;
    RecyclerView.LayoutManager layoutManager;
    MultimediaAdaptater multimediaAdaptater;
    ManageProducts manageProducts;
    private TextView nosales;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multimedia);
        nosales=findViewById(R.id.nosale_mul);
        recyclerViewMultimedia=findViewById(R.id.rv_multimedia);




        manageProducts=new ManageProducts(this);
        ArrayList<Produit> listeProds = (ArrayList<Produit>) manageProducts.getAllProductMultimedia();
        if (listeProds==null){
            nosales.setText("No Multimedias found for this moment");

        }else {
            layoutManager=new LinearLayoutManager(this);
            recyclerViewMultimedia.setLayoutManager(layoutManager);

            multimediaAdaptater = new MultimediaAdaptater(this, listeProds);
            recyclerViewMultimedia.setAdapter(multimediaAdaptater);

            DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
            recyclerViewMultimedia.addItemDecoration(dividerItemDecoration);
        }
    }
}