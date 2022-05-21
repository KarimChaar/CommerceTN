package com.example.bi3wichri;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import com.example.bi3wichri.LiteDatabaseHelper;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.bi3wichri.Controller.SessionManager;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class HomePage extends AppCompatActivity {
    private TextView greetings;
    private Button btnlogout,testBtn;
    private CardView multimedia,emplois,vehicule,entreprises;
    SessionManager sessionManager;
    LiteDatabaseHelper ldb;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        sessionManager = new SessionManager(getApplicationContext());
        greetings=findViewById(R.id.Username);
        greetings.setText("Welcome to our application "+sessionManager.getName_U());
        //Partie ppour card views
        multimedia=findViewById(R.id.multimedia_card);
        emplois=findViewById(R.id.emplois_card);
        entreprises=findViewById(R.id.immobilier_card);
        vehicule=findViewById(R.id.vehicule_card);




        testBtn = findViewById(R.id.testbtn);
        testBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("----display----");
                System.out.println(ldb.fetchAllProds());

                // manageProducts.addProduct();
                //manageProducts.getAllProductsT();
            }
        });





        multimedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomePage.this,Multimedia.class));
            }
        });
        entreprises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomePage.this,Immobilier.class));
            }
        });
        emplois.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomePage.this,Emplois.class));
            }
        });
        vehicule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomePage.this,Vehicule.class));
            }
        });
        //PARTIE POUR LA NAV_BAR
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.home_page_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {
                    case R.id.home_page_nav:
                        return true;
                    case R.id.profile_nav:
                        startActivity(new Intent(getApplicationContext(),Profile.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.logout_nav:
                        AlertDialog.Builder builder=new AlertDialog.Builder(HomePage.this);
                        builder.setTitle("Log out");
                        builder.setMessage("Are you sure to log out?");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                sessionManager.setLogin(false);
                                sessionManager.setName_U("");
                                sessionManager.setID_U(0);
                                sessionManager.setLogin_U("");
                                startActivity(new Intent(getApplicationContext(), Login.class));
                                finish();
                            }
                        });
                        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                        AlertDialog alertDialog= builder.create();
                        alertDialog.show();
                        return true;
                }
                return false;
            }
        });

    }
}