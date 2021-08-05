package com.example.movers_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth mAuth;

    @BindView(R.id.LoginEmailAddressEditText) EditText mLoginEmailAddressEditText;
    @BindView(R.id.LoginPasswordEditText) EditText mLoginPasswordEditText;
    @BindView(R.id.LoginForgotPasswordTextView) TextView mLoginForgotPasswordTextView;
    @BindView(R.id.LoginButton) Button mLoginButton;
    @BindView(R.id.LoginSignupTextView) TextView mLoginSignupTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        ButterKnife.bind(this);

        //validate user inputs when login button clicked
        mLoginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v==mLoginButton){
            accountLogin();
        }
    }

    private void accountLogin() {
        //validations
        String email = mLoginEmailAddressEditText.getText().toString().trim();
        String password = mLoginPasswordEditText.getText().toString().trim();

        if (email.isEmpty()){
            mLoginEmailAddressEditText.setError("Email is required");
            mLoginEmailAddressEditText.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            mLoginEmailAddressEditText.setError("Please enter a valid address");
            mLoginEmailAddressEditText.requestFocus();
            return;
        }
        if (password.isEmpty()){
            mLoginPasswordEditText.setError("Password is required");
            mLoginPasswordEditText.requestFocus();
            return;
        }
        if (password.length() < 6){
            mLoginPasswordEditText.setError("Minimum password character required is six");
            mLoginPasswordEditText.requestFocus();
            return;
        }

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                            if (user.isEmailVerified()) {
                                startActivity(new Intent (LoginActivity.this, HouseActivity.class));
                            }else{
                                user.sendEmailVerification();
                                Toast.makeText(LoginActivity.this, "Check your email to verify your account", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(LoginActivity.this, "Failed to login! Please try again", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
    }
}