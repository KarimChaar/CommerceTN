package com.example.bi3wichri;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bi3wichri.Controller.ManageProducts;
import com.example.bi3wichri.Models.Produit;
import com.example.bi3wichri.RecyclerViewsAdaptaters.EmploisAdaptater;
import com.example.bi3wichri.RecyclerViewsAdaptaters.MultimediaAdaptater;
import com.example.bi3wichri.RecyclerViewsAdaptaters.ProductAdaptaters;

import java.util.ArrayList;

public class Emplois extends AppCompatActivity {
    private TextView nosales;
    RecyclerView recyclerViewEmplois;
    RecyclerView.LayoutManager layoutManager;
    EmploisAdaptater emploisAdaptater;
    ManageProducts manageProducts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emplois);
        recyclerViewEmplois=findViewById(R.id.rv_emplois);
        nosales=findViewById(R.id.nosale_emp);

        manageProducts=new ManageProducts(this);
        ArrayList<Produit> listeProds = (ArrayList<Produit>) manageProducts.getAllProductEmplois();
        if (listeProds==null){
                      nosales.setText("No jobs found for this moment");

        }else {
            layoutManager=new LinearLayoutManager(this);
            recyclerViewEmplois.setLayoutManager(layoutManager);


            emploisAdaptater = new EmploisAdaptater(this, listeProds);
            recyclerViewEmplois.setAdapter(emploisAdaptater);


            DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
            recyclerViewEmplois.addItemDecoration(dividerItemDecoration);
        }
    }
}