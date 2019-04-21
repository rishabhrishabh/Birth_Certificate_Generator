package com.example.rb.birth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class mo_login extends AppCompatActivity {
    EditText e1,e2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mo_login);
        e1=findViewById(R.id.id_mo);
        e2=findViewById(R.id.password_mo);
        Button b=findViewById(R.id.submit_mo);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String e0=e1.getText().toString().trim();
                String e1=e2.getText().toString().trim();
                if(e0.equals("mo@gmail.com") && e1.equals("momomo")) {
                    Intent intent = new Intent(mo_login.this, mo_main.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(mo_login.this,"wrong credential",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
