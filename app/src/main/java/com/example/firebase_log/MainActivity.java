package com.example.firebase_log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    public EditText emailId,password;
    Button btnSignUp;
    TextView tvSignIn;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFirebaseAuth = FirebaseAuth.getInstance();
        emailId = findViewById(R.id.editText);
        password = findViewById(R.id.editText2);
        btnSignUp =  findViewById(R.id.button);
        tvSignIn =  findViewById(R.id.textView);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailId.getText().toString();
                String pwd = password.getText().toString();
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference(mFirebaseAuth.getUid());
                myRef.setValue("Hello, World!");
                if (email.isEmpty()){
                    emailId.setError("Please Enter email ID");
                    emailId.requestFocus();
                }else if (pwd.isEmpty()){
                    password.setError("Please Enter your password");
                    password.requestFocus();
                }
                else if (email.isEmpty() && pwd.isEmpty()){
                    Toast.makeText(MainActivity.this,"Fields are Empty!",Toast.LENGTH_SHORT);
                }
                else if (!email.isEmpty() && pwd.isEmpty()){
                    mFirebaseAuth.createUserWithEmailAndPassword(email,pwd).addOnCompleteListener(MainActivity.this, new OnCompleteListener<com.google.firebase.auth.AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<com.google.firebase.auth.AuthResult > task) {
                         if (!task.isSuccessful()){
                             Toast.makeText(MainActivity.this,"Sign Up Unsuccessful Please Try Again",Toast.LENGTH_SHORT);

                         }else{
                             startActivity(new Intent(MainActivity.this,HomeActivity.class));
                         }
                        }
                    });
                }else {
                    Toast.makeText(MainActivity.this,"Error Occurred",Toast.LENGTH_SHORT);

                }
            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("message");
                myRef.setValue("Hello, World!");
                Toast.makeText(MainActivity.this, "data added", Toast.LENGTH_SHORT).show();
//                Intent i = new Intent(MainActivity.this,LoginActivity.class);
//                startActivity(i);
            }
        });
        }
    }

