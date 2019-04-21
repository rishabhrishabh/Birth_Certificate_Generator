package com.example.rb.birth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class user_main extends AppCompatActivity {
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
        Intent intent=new Intent(user_main.this,Starting_page.class);
        return true;
    }
    FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser() ;
int s;
String status;
    DatabaseReference md= FirebaseDatabase.getInstance().getReference().child("users").child("register").child(currentFirebaseUser.getUid());
    DatabaseReference md2= FirebaseDatabase.getInstance().getReference().child("users").child("register").child(currentFirebaseUser.getUid()).child("status");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        md2.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                status = dataSnapshot.getValue(String.class);

                //do what you want with the email
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main);
        final Button registered=findViewById(R.id.registered);
        Button non_registered=findViewById(R.id.not_registered);
        Button correction=findViewById(R.id.correction);
        registered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent intent = new Intent(user_main.this, registered_birth_apply.class);
                    startActivity(intent);

            }
        });
        non_registered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(user_main.this,non_registered_birth_apply.class);
                startActivity(intent);
            }
        });
        correction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(user_main.this,correction_birth_apply.class);
                startActivity(intent);
            }
        });
    }
    }

