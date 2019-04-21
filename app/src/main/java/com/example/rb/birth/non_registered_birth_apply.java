package com.example.rb.birth;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class non_registered_birth_apply extends AppCompatActivity {
    StorageReference mstorage;
    ImageView proof;
    FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser() ;

    DatabaseReference md= FirebaseDatabase.getInstance().getReference().child("users").child("nonregister").child(currentFirebaseUser.getUid());
    Uri uri;
    EditText e1,e2,e3,e4,e5,e6,e7,e8;
    private  final static int GALLERY_INTENT=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_non_registered_birth_apply);
        mstorage= FirebaseStorage.getInstance().getReference();
        Button b=findViewById(R.id.upload);
        proof=findViewById(R.id.proof);
        e1=findViewById(R.id.name);
        e2=findViewById(R.id.father);
        e3=findViewById(R.id.mother);


        e4=findViewById(R.id.date);
        e5=findViewById(R.id.place);
        e6=findViewById(R.id.phone);
        e7=findViewById(R.id.adress);
        e8=findViewById(R.id.district);
        Button post=findViewById(R.id.button);
        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=e1.getText().toString().trim();
                String s2=e2.getText().toString().trim();
                String s3=e3.getText().toString().trim();
                String s4=e4.getText().toString().trim();
                String s5=e5.getText().toString().trim();
                String s6=e6.getText().toString().trim();
                String s7=e7.getText().toString().trim();
                String s8=e8.getText().toString().trim();
                md.child("name").setValue(s1);
                md.child("father").setValue(s2);
                md.child("mother").setValue(s3);
                md.child("date").setValue(s4);
                md.child("place").setValue(s5);
                md.child("phone").setValue(s6);
                md.child("adress").setValue(s7);
                md.child("district").setValue(s8);
                finish();

                Intent intent=new Intent(non_registered_birth_apply.this,non_registered_user_final.class);
                startActivity(intent);
            }
        });


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
            Picasso.get().load(uri).into(proof);
            StorageReference filepath=mstorage.child("nonregister").child(currentFirebaseUser.getEmail()).child(uri.getLastPathSegment());
            filepath.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Toast.makeText(non_registered_birth_apply.this,"upload done",Toast.LENGTH_LONG).show();
                }
            });
        }
    }






    }
