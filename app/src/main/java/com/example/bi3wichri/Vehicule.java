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
import com.example.bi3wichri.RecyclerViewsAdaptaters.VehiculeAdaptater;

import java.util.ArrayList;

public class Vehicule extends AppCompatActivity {
    RecyclerView recyclerViewVehicule;
    RecyclerView.LayoutManager layoutManager;
    VehiculeAdaptater vehiculeAdaptater;
    ManageProducts manageProducts;

    private TextView nosales;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicule);
        recyclerViewVehicule=findViewById(R.id.rv_vehicule);
        nosales=findViewById(R.id.nosale_veh);



        manageProducts=new ManageProducts(this);
        ArrayList<Produit> listeProds = (ArrayList<Produit>) manageProducts.getAllProductVehicule();
        if (listeProds==null){
            nosales.setText("No Vehicules found for this moment");

        }else {
            layoutManager=new LinearLayoutManager(this);
            recyclerViewVehicule.setLayoutManager(layoutManager);
            vehiculeAdaptater = new VehiculeAdaptater(this, listeProds);
            recyclerViewVehicule.setAdapter(vehiculeAdaptater);
            DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
            recyclerViewVehicule.addItemDecoration(dividerItemDecoration);
        }
    }
}