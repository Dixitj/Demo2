package com.example.dixitjain.webapplication;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signup extends AppCompatActivity {


    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mAuth = FirebaseAuth.getInstance();

        // EditTexts
        final EditText emailText2 = findViewById(R.id.email2text);
        final EditText password1 = findViewById(R.id.password1);
        final EditText password2 = findViewById(R.id.password2);

        // Buttons
        Button signUp = findViewById(R.id.signupbutton);


        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String code1 = password1.getText().toString();
                String code2 = password2.getText().toString();
                String email = emailText2.getText().toString();

                if (!code1.equals(code2)){

                    Toast.makeText(getApplicationContext(),
                            "Email Id is Empty or Password do not match", Toast.LENGTH_LONG).show();

                }else if (email.isEmpty()){

                    System.out.println("Nothing is hapening now");

                } else{

                    mAuth.createUserWithEmailAndPassword( email, code1).addOnCompleteListener(signup.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){

                                Toast.makeText(getApplicationContext(),
                                        "User Created", Toast.LENGTH_LONG).show();

                            }else {

                                Toast.makeText( getApplicationContext(),
                                        "User Already exist" , Toast.LENGTH_LONG).show();
                            }

                        }
                    });

                }
            }
        });



    }

}
