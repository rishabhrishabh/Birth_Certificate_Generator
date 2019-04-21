package com.example.rb.birth;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class mo_registered extends AppCompatActivity {
    ListView list;
    List<register_model> l;
    FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser() ;

    DatabaseReference md= FirebaseDatabase.getInstance().getReference().child("users").child("register");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mo_registered);
        list=findViewById(R.id.list_view_hospital);
        l=new ArrayList<>();
    }

    @Override
    protected void onStart() {
        super.onStart();
        md.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                l.clear();
                for(DataSnapshot mysnapshot:dataSnapshot.getChildren())
                {
                    register_model model=mysnapshot.getValue(register_model.class);
                    l.add(model);

                }
                register_list_adapter adapter=new register_list_adapter(mo_registered.this,l);
                list.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(mo_registered.this,"error",Toast.LENGTH_LONG).show();
            }
        });
    }
}
