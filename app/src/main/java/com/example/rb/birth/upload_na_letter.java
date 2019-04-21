package com.example.rb.birth;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

public class upload_na_letter extends AppCompatActivity {
    private  final static int GALLERY_INTENT=2;
Uri uri;
ImageView iv;
    StorageReference mstorage;
    FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser() ;

    DatabaseReference md= FirebaseDatabase.getInstance().getReference().child("users").child("register").child(currentFirebaseUser.getUid());
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
        Intent intent=new Intent(upload_na_letter.this,Starting_page.class);
        return true;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_na_letter);
        Button b=findViewById(R.id.upload_na);
     iv=findViewById(R.id.na);
        mstorage= FirebaseStorage.getInstance().getReference();
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,GALLERY_INTENT);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==GALLERY_INTENT && resultCode==RESULT_OK)
        {
            uri=data.getData();
            Picasso.get().load(uri).into(iv);
            StorageReference filepath=mstorage.child("nonregister").child(currentFirebaseUser.getEmail()).child("na").child(uri.getLastPathSegment());
            filepath.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Toast.makeText(upload_na_letter.this,"upload done",Toast.LENGTH_LONG).show();
                    finish();
                    Intent intent=new Intent(upload_na_letter.this,non_registered_user_final_last.class);
                    startActivity(intent);
                }
            });
        }


    }
}
