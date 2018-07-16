package com.example.dixitjain.webapplication;

import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Authentication {

    private FirebaseAuth mAuth = FirebaseAuth.getInstance();


    protected  void  customEmail (){

    }

    protected void signUp (String email, String password){

      /*  mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(  new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){

                    Log.d(TAG, "Account created");
                    //FirebaseUser user = mAuth.getCurrentUser();
                } else {

                    Log.w(TAG, "Enter Details", task.getException());

                }

            }
        });
*/

    }



}
