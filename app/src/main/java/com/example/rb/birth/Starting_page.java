package com.example.rb.birth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Starting_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting_page);

        Button login = findViewById(R.id.hospital_signin);
        Button mo = findViewById(R.id.municipal_signin);
        Button hos = findViewById(R.id.hos_signin);
        TextView register = findViewById(R.id.signup);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Starting_page.this,hospital_user_signin.class);
                startActivity(intent);
            }
        });
        hos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Starting_page.this,hospital_signin.class);
                startActivity(intent);
            }
        });



        mo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Starting_page.this,mo_login.class);
                startActivity(intent);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Starting_page.this,hospital_user_register.class);
                startActivity(intent);
            }
        });
    }



}
