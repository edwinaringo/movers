package com.example.movers_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MoversLogIn extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @BindView(R.id.LoginEmailAddressEditText) EditText mLoginEmailAddressEditText;
    @BindView(R.id.LoginPasswordEditText) EditText mLoginPasswordEditText;
    @BindView(R.id.LoginForgotPasswordTextView) TextView mLoginForgotPasswordTextView;
    @BindView(R.id.LoginButton) Button mLoginButton;
    @BindView(R.id.LoginSignupTextView) TextView mLoginSignupTextView;
    ProgressBar mProgressBar2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        mProgressBar2 = (ProgressBar) findViewById(R.id.progressBar2);

        mAuth = FirebaseAuth.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user2 = firebaseAuth.getCurrentUser();
                String id = mAuth.getCurrentUser().getUid();
                if (user2 != null) {


                    Intent intent = new Intent(MoversLogIn.this,HouseActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra("username", id);
                    Log.i("id",id);
                    startActivity(intent);
                    finish();
                }
            }
        };


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

        showProgressBar();

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            hideProgressBar();

                            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();




                            String id = mAuth.getCurrentUser().getUid();
                            String email = mAuth.getCurrentUser().getEmail();
                            FirebaseDatabase database = FirebaseDatabase.getInstance();
                            DatabaseReference username = database.getReference("User").child(id).child("name");

                            if (user.isEmailVerified()) {

                                Intent intent =new Intent (MoversLogIn.this, MoverAccount.class);
//                                String[] userInfo={id,email};
                                intent.putExtra("companyEmail", email);

                                Log.i("email",email);

                                startActivity(intent);


                            }else{
                                user.sendEmailVerification();
                                Toast.makeText(MoversLogIn.this, "Check your email to verify your account", Toast.LENGTH_SHORT).show();
                                hideProgressBar();
                            }
                        }else{
                            Toast.makeText(MoversLogIn.this, "Failed to login! Please try again", Toast.LENGTH_SHORT).show();
                            hideProgressBar();
                        }

                    }
                });
    }
    private void showProgressBar() {
        mProgressBar2.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        mProgressBar2.setVisibility(View.GONE);
    }

//    @Override
//    public void onStart() {
//        super.onStart();
//        mAuth.addAuthStateListener(mAuthListener);
//    }
//
//    @Override
//    public void onStop() {
//        super.onStop();
//        if (mAuthListener != null) {
//            mAuth.removeAuthStateListener(mAuthListener);
//        }
//    }
}