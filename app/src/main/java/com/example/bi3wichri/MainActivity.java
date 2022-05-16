package com.example.bi3wichri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bi3wichri.Controller.ManageUsers;
import com.example.bi3wichri.Models.User;

public class MainActivity extends AppCompatActivity{

    private EditText name;
    private EditText surname;
    private EditText phone;
    private EditText login;
    private EditText pwd;
    private Button btnsignup,btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        surname = findViewById(R.id.surname);
        phone = findViewById(R.id.tel);
        login = findViewById(R.id.login);
        pwd = findViewById(R.id.pwd);
        btnsignup = findViewById(R.id.btnSignup);
        btnLogin=findViewById(R.id.btnLogin);

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ManageUsers manageUsers =new ManageUsers(getApplicationContext());
                User u=new User(
                        name.getText().toString().trim(),surname.getText().toString().trim(),
                        phone.getText().toString().trim(),login.getText().toString().trim(),
                        pwd.getText().toString().trim());
                Long add = manageUsers.addUser(u);
                if (add!=-1){
                    Toast.makeText(MainActivity.this,"ajout avec succés",Toast.LENGTH_LONG).show();
                }else
                {
                    Toast.makeText(MainActivity.this,"erreur",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Login.class));

            }
        });
    }

    /*@Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnSignup:
                ManageUsers manageUsers =new ManageUsers(getApplicationContext());
                Users u=new Users(
                        name.getText().toString().trim(),surname.getText().toString().trim(),
                        phone.getText().toString().trim(),login.getText().toString().trim(),
                        pwd.getText().toString().trim());
                Long add = manageUsers.addUser(u);
                if (add!=-1){
                    Toast.makeText(MainActivity.this,"ajout avec succés",Toast.LENGTH_LONG).show();
                }else
                {
                    Toast.makeText(MainActivity.this,"erreur",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnRegister:
                startActivity(new Intent(MainActivity.this,Login.class));
                finish();
                break;
        }*/
    //}
}