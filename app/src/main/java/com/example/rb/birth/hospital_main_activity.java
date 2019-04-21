package com.example.rb.birth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class hospital_main_activity extends AppCompatActivity {
    FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser() ;

    DatabaseReference md= FirebaseDatabase.getInstance().getReference().child("hospitals").child(currentFirebaseUser.getUid());
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflator=getMenuInflater();
        inflator.inflate(R.menu.menu,menu);



        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        FirebaseAuth.getInstance().signOut();
        finish();
        Intent intent=new Intent(hospital_main_activity.this,Starting_page.class);
        return true;
    }
 EditText e1,e2,e3,e4,e5,e6,e7,e8,e0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_main_activity);
        e0=findViewById(R.id.rn);
        e1=findViewById(R.id.name);
         e2=findViewById(R.id.father);
         e3=findViewById(R.id.mother);
         e4=findViewById(R.id.sex);
         e5=findViewById(R.id.date);
         e6=findViewById(R.id.place);
         e7=findViewById(R.id.phone);
         e8=findViewById(R.id.adress);







        Button b=findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s0=e0.getText().toString().trim();
                String s1=e1.getText().toString().trim();
                String s2=e2.getText().toString().trim();
                String s3=e3.getText().toString().trim();
                String s4=e4.getText().toString().trim();
                String s5=e5.getText().toString().trim();
                String s6=e6.getText().toString().trim();
                String s7=e7.getText().toString().trim();
                String s8=e8.getText().toString().trim();
                md.child("registration_no").setValue(s0);
                md.child("name").setValue(s1);
                md.child("father").setValue(s2);
                md.child("mother").setValue(s3);
                md.child("sex").setValue(s4);
                md.child("date").setValue(s5);
                md.child("place").setValue(s6);
                md.child("phone").setValue(s7);
                md.child("adress").setValue(s8);
                finish();
                Intent intent=new Intent(hospital_main_activity.this,hospital_final.class);
                startActivity(intent);
            }
        });
    }
    }

