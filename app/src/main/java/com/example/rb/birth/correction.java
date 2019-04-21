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

public class correction extends AppCompatActivity {
    ListView list;
    List<correction_model> l;
    FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();
    DatabaseReference md = FirebaseDatabase.getInstance().getReference().child("users").child("correction");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_correction);
        list = findViewById(R.id.list_view_hospital);
        l = new ArrayList<>();
    }

    @Override
    protected void onStart() {
        super.onStart();
        md.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                l.clear();
                for (DataSnapshot mysnapshot : dataSnapshot.getChildren()) {
                    correction_model model = mysnapshot.getValue(correction_model.class);
                    l.add(model);

                }
                correction_list_adapter adapter = new correction_list_adapter(correction.this, l);
                list.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(correction.this, "error", Toast.LENGTH_LONG).show();
            }
        });
    }
}
