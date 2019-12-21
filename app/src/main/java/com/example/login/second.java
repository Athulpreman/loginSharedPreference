package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class second extends AppCompatActivity {

    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        b=(Button)findViewById(R.id.logout);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor ob=getSharedPreferences("login",MODE_PRIVATE).edit();
                ob.clear();
                ob.commit();

                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);            }
        });
    }
}
