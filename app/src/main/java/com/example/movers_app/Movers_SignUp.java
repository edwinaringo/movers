package com.example.movers_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Movers_SignUp extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;
    private EditText editTextFullName, editTextEmail, editTextPassword;
    private Button signUp;

    String[] moverInfo = new String[6];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movers_sign_up);

        mAuth = FirebaseAuth.getInstance();

        signUp = (Button) findViewById(R.id.signUp);
        signUp.setOnClickListener(this);


        editTextFullName = (EditText) findViewById(R.id.fullName);
        editTextEmail = (EditText) findViewById(R.id.email);
        editTextPassword = (EditText) findViewById(R.id.password);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.signUp:
                moverSignUp();
                break;
        }

    }

    private void moverSignUp() {
        String email = editTextEmail.getText().toString().trim();
        String name = editTextFullName.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (name.isEmpty()) {
            editTextFullName.setError("Full name is required");
            editTextFullName.requestFocus();
            return;
        }

        if (email.isEmpty()) {
            editTextEmail.setError("Email is required");
            editTextEmail.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextEmail.setError("Please provide valid email");
            editTextEmail.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            editTextPassword.setError("Password is required");
            editTextPassword.requestFocus();
            return;
        }

        if (password.length()< 6) {
            editTextPassword.setError("Minimum password length is 6 characters");
            editTextPassword.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){
                            User user = new User(name, email);


                            FirebaseDatabase.getInstance().getReference("Mover")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()) {
                                        Toast.makeText(Movers_SignUp.this, "Sign Up is successful", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(Movers_SignUp.this,Movers.class);
                                        moverInfo[0]= name;
                                        moverInfo[1]= email;
                                        intent.putExtra("moverInfo",moverInfo);
                                        startActivity(intent);
                                    }else{
                                        Toast.makeText(Movers_SignUp.this, "Failed to Sign Up. Try again", Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });
                        }else{
                            Toast.makeText(Movers_SignUp.this, "Failed to Sign Up. Try again", Toast.LENGTH_SHORT).show();
                        }

                    }
                });

    }
}