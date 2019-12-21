package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText e1,e2;
Button button;
String user,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences preferences=getSharedPreferences("login1",MODE_PRIVATE);
        String value=preferences.getString("username",null);

        if (value!=null)
        {
            Intent intent=new Intent(getApplicationContext(),second.class);
            startActivity(intent);
        }

        e1=(EditText)findViewById(R.id.username);
        e2=(EditText)findViewById(R.id.password);
        button=(Button)findViewById(R.id.submit);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user = e1.getText().toString();
                pass = e2.getText().toString();

                if (user.equals("nandu") && pass.equals("12345"))
                {
                    SharedPreferences.Editor editor=getSharedPreferences("login1",MODE_PRIVATE).edit();
                    editor.putString("username",user);
                    editor.putString("password",pass);
                    editor.commit();

                    Intent intent=new Intent(getApplicationContext(),second.class);
                    startActivity(intent);
                }
            }
        });
    }
}
