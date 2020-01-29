package com.example.firebase_log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity {
    public EditText emailId,password;
    Button btnSignIn;
    TextView tvSignIn;
//    FirebaseAuth mFirebaseAuth;
    FirebaseDatabase database;
//    private FirebaseAuth.AuthStateListener mAuthStateListner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        mFirebaseAuth = FirebaseAuth.getInstance();
        emailId = findViewById(R.id.editText);
        password = findViewById(R.id.editText2);
        btnSignIn =  findViewById(R.id.button2);
        tvSignIn =  findViewById(R.id.textView);

//     mAuthStateListner = new FirebaseAuth.AuthStateListener() {
//         @Override
//         public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
//             FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
//             if(mFirebaseUser != null){
//                 Toast.makeText(LoginActivity.this,"You are logged in",Toast.LENGTH_SHORT).show();
//                 Intent i = new Intent(LoginActivity.this,HomeActivity.class);
//                 startActivity(i);
//
//         }else{
//                 Toast.makeText(LoginActivity.this,"Please log in",Toast.LENGTH_SHORT).show();
//
//             }
//             }
//     };

     btnSignIn.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             String email = emailId.getText().toString();
             String pwd = password.getText().toString();
             DatabaseReference myRef = database.getReference("message");
             myRef.setValue("Hello, World!");
             Toast.makeText(LoginActivity.this, "Data added", Toast.LENGTH_SHORT).show();
             if (email.isEmpty()) {
                 emailId.setError("Please Enter email ID");
                 emailId.requestFocus();
             }else if (pwd.isEmpty()){
                 password.setError("Please Enter your password");
                 password.requestFocus();
             }
//             else if (email.isEmpty() && pwd.isEmpty()){
//                 Toast.makeText(LoginActivity.this,"Fields are Empty!",Toast.LENGTH_SHORT);
//             }
//             else if (!email.isEmpty() && pwd.isEmpty()){
//                 mFirebaseAuth.signInWithEmailAndPassword(email,pwd).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<com.google.firebase.auth.AuthResult>() {
//                     @Override
//                     public void onComplete(@NonNull Task<com.google.firebase.auth.AuthResult> task) {
//                         if (!task.isSuccessful()) {
//                             Toast.makeText(LoginActivity.this, "Log in Error !", Toast.LENGTH_SHORT);
//
//                         } else {
//                             Intent intToHome = new Intent(LoginActivity.this, HomeActivity.class);
//                             startActivity(intToHome);
//                         }
//                     }
//                 });
//                     }
             else {

                 Toast.makeText(LoginActivity.this,"Error Occurred",Toast.LENGTH_SHORT);

             }

         }
     });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intSignIn = new Intent(LoginActivity.this,HomeActivity.class);
//                startActivity(intSignIn);
                DatabaseReference myRef = database.getReference("message");
                myRef.setValue("Hello, World!");
                Toast.makeText(LoginActivity.this,"Error Occurred",Toast.LENGTH_SHORT);

            }
         });
     }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        mFirebaseAuth.addAuthStateListener(mAuthStateListner);
//    }
}

