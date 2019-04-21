package com.example.rb.birth;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class registered_user_final extends AppCompatActivity {
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
        Intent intent=new Intent(registered_user_final.this,Starting_page.class);
        return true;
    }
    FirebaseStorage storage;
    StorageReference storagereference;
    TextView link;
    SharedPreferences sd;
    String email_project;
    StorageReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registered_user_final);
        storage=FirebaseStorage.getInstance();
        storagereference=FirebaseStorage.getInstance().getReference();
   link=findViewById(R.id.link);
   ref=storagereference.child("register/hey@gmail.com/Screenshot (1).png");
   ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
       @Override
       public void onSuccess(Uri uri) {
       String r=uri.toString();
           link.setMovementMethod(LinkMovementMethod.getInstance());
       link.setText(r);
           link.setLinksClickable(true);
       }
   }).addOnFailureListener(new OnFailureListener() {
       @Override
       public void onFailure(@NonNull Exception e) {
          Toast.makeText(registered_user_final.this,"failed",Toast.LENGTH_LONG).show();
       }
   });


    }
}
