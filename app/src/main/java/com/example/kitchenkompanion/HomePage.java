package com.example.kitchenkompanion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;


public class HomePage extends AppCompatActivity{


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        TextView username = findViewById(R.id.username);
        TextView password = findViewById(R.id.password);

        MaterialButton loginbtn = findViewById(R.id.loginbtn);

        //admin and admin

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equals("user1") && password.getText().toString().equals("user1")){
                    //correct
                    Toast.makeText(HomePage.this,"LOGIN SUCCESSFUL",Toast.LENGTH_SHORT).show();
                    onClick(v);
                }else if(username.getText().toString().equals("user2") && password.getText().toString().equals("user2")){
                    //correct
                    Toast.makeText(HomePage.this,"LOGIN SUCCESSFUL",Toast.LENGTH_SHORT).show();
                    onClick(v);
                }else if(username.getText().toString().equals("user3") && password.getText().toString().equals("user3")){
                    //correct
                    Toast.makeText(HomePage.this,"LOGIN SUCCESSFUL",Toast.LENGTH_SHORT).show();
                    onClick(v);
                }else
                    //incorrect
                    Toast.makeText(HomePage.this,"LOGIN FAILED !!!",Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onClick(View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
