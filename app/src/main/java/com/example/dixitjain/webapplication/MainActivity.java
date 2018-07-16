package com.example.dixitjain.webapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {


    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        // EditTextViews
        final EditText emailAddress = findViewById(R.id.emailText);
        final EditText password = findViewById(R.id.passwordText);

        //  Image Button
        ImageButton logIn  = findViewById(R.id.loginButton);
        ImageButton signUp = findViewById(R.id.signUp);




        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = emailAddress.getText().toString();
                String pass = password.getText().toString();

                if ( email.isEmpty() || pass.isEmpty()){

                    Toast.makeText(getApplicationContext(), "Fill in all the details", Toast.LENGTH_LONG).show();

                }else{

                    mAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()){

                                Toast.makeText(getApplicationContext(),
                                        "Successfully Logged In", Toast.LENGTH_LONG).show();

                            }else {

                                Toast.makeText(getApplicationContext(),
                                        "Email ID and  Password Do Not Match", Toast.LENGTH_LONG).show();


                            }
                        }
                    });
                }

            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this, signup.class));
            }
        });


    }
}
