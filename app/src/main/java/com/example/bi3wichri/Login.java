package com.example.bi3wichri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bi3wichri.Controller.ManageUsers;
import com.example.bi3wichri.Controller.SessionManager;
import com.example.bi3wichri.Models.User;

public class Login extends AppCompatActivity{
    public static final String Login = "Login" ;
    public static final String passwd = "mdp";

    SessionManager sessionManager;


    EditText login,mdp;
    Button btnLogin,register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login=findViewById(R.id.login);
        mdp=findViewById(R.id.pwd);
        btnLogin=findViewById(R.id.btnSignin);
        register=findViewById(R.id.btnRegister);

        sessionManager=new SessionManager(getApplicationContext());
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ManageUsers manageUsers=new ManageUsers(getApplicationContext());
                if(sessionManager.getLogin()){
                    startActivity(new Intent(getApplicationContext(),HomePage.class));
                }else{
                if(login.getText().toString().isEmpty() && mdp.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"everything is empty",Toast.LENGTH_SHORT).show();
                    /*SharedPreferences.Editor editor= sharedPreferences.edit();
                    editor.putString(Login, user.getLogin());
                    editor.putString(passwd,user.getMdp());
                    editor.commit();*/
                }else{
                User user=manageUsers.verifAuthentification(login.getText().toString(),mdp.getText().toString());
                if((user.getLogin() == null) && (user.getMdp()==null)){
                    Toast.makeText(Login.this,"Login or password is not correct !",Toast.LENGTH_LONG).show();
                }else
                {
                    sessionManager.setLogin(true);
                    sessionManager.setLogin_U(user.getLogin());
                    sessionManager.setID_U(user.getId_U());
                    sessionManager.setName_U(user.getNom_U());
                    Intent intent=new Intent(Login.this,HomePage.class);
                    startActivity(intent);
                }}
            }
            }
        });



        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this,MainActivity.class));

            }
        });
    }



    /*@Override
    public void onClick(View view) {


        switch (view.getId()){
            case R.id.btnSignin:
                ManageUsers manageUsers=new ManageUsers(this.getApplicationContext());
                //Users user=manageUsers.verifAuthentification(login.getText().toString(),mdp.getText().toString());
                if(login.getText().toString().isEmpty() && mdp.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"empty",Toast.LENGTH_SHORT).show();
                    /*SharedPreferences.Editor editor= sharedPreferences.edit();
                    editor.putString(Login, user.getLogin());
                    editor.putString(passwd,user.getMdp());
                    editor.commit();
                    intent=new Intent(Sign_in.this,HomePage.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(Sign_in.this,"Login or password is not correct !",Toast.LENGTH_LONG).show();
                }}
                break;
            case R.id.btnRegister:
                startActivity(new Intent(Login.this,MainActivity.class));

                break;
        }
    }*/
}