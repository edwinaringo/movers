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

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;


    @BindView(R.id.LoginEmailAddressEditText) EditText mLoginEmailAddressEditText;
    @BindView(R.id.LoginPasswordEditText) EditText mLoginPasswordEditText;
    @BindView(R.id.LoginForgotPasswordTextView) TextView mLoginForgotPasswordTextView;
    @BindView(R.id.LoginButton) Button mLoginButton;
    @BindView(R.id.LoginSignupTextView) TextView mLoginSignupTextView;
    //progress bar
    @BindView(R.id.firebaseProgressBar) ProgressBar mSignInProgressBar;
    @BindView(R.id.loadingTextView) TextView mLoadingSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        mAuth = FirebaseAuth.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user2 = firebaseAuth.getCurrentUser();
                String id = mAuth.getCurrentUser().getUid();
                if (user2 != null) {


                    Intent intent = new Intent(LoginActivity.this,MovingOrdersActivity.class);
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
        mLoginSignupTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,Sign_Up.class));
            }
        });
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

        //show progress bar
        showProgressBar();

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();




                            String id = mAuth.getCurrentUser().getUid();
                            String email = mAuth.getCurrentUser().getEmail();
//                            String name =mAuth.getCurrentUser().getDisplayName();
                            FirebaseDatabase database = FirebaseDatabase.getInstance();
                            DatabaseReference username = database.getReference("User").child(id).child("name");

                            if (user.isEmailVerified()) {

//                                Intent intent =new Intent (LoginActivity.this, HouseActivity.class);
                                Intent intent =new Intent (LoginActivity.this, HomeActivity.class);

                                String[] userInfo={id,email};
                                intent.putExtra("userinfo", userInfo);
//                                intent.putExtra("username",id);





                                Log.i("user", id);
                                Log.i("user", email);
//                              Log.i("user",name);
                                Log.i("user",username.toString());
                                startActivity(intent);


                            }else{
                                user.sendEmailVerification();
                                Toast.makeText(LoginActivity.this, "Check your email to verify your account", Toast.LENGTH_SHORT).show();
                                hideProgressBar();
                            }
                        }else{
                            Toast.makeText(LoginActivity.this, "Failed to login! Please try again", Toast.LENGTH_SHORT).show();
                            hideProgressBar();
                        }
                        hideProgressBar();
                    }
                });
    }
//set visibility on progress bar
    private void showProgressBar() {
        mSignInProgressBar.setVisibility(View.VISIBLE);
        mLoadingSignUp.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        mSignInProgressBar.setVisibility(View.GONE);
        mLoadingSignUp.setVisibility(View.GONE);
    }
}