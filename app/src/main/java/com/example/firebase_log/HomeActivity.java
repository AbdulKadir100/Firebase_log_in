package com.example.firebase_log;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {

     Button btnlogOut;
     FirebaseAuth  mFirebaseAuth;
     private  FirebaseAuth.AuthStateListener  mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnlogOut = findViewById(R.id.LogOut);

        btnlogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intoMain = new Intent(HomeActivity.this, MainActivity.class);

            }
        });

    }
}
