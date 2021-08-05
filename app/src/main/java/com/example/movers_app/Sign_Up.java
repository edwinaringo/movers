package com.example.movers_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Sign_Up extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;

    @BindView(R.id.LoginHiTextView)
    TextView mLoginHiTextView;
    @BindView(R.id.LoginPleaseLoginTextView)
    TextView mLoginPleaseLoginTextView;
    @BindView(R.id.LoginNameTextView)
    TextView mLoginNameTextView;
    @BindView(R.id.nameEditText)
    EditText mNameEditText;
    @BindView(R.id.LoginEmailTextView)
    TextView mLoginEmailTextView;
    @BindView(R.id.EmailEditText)
    EditText mEmailEditText;
    @BindView(R.id.LoginPasswordTextView)
    TextView mLoginPasswordTextView;
    @BindView(R.id.LoginPasswordEditText)
    EditText mLoginPasswordEditText;
    @BindView(R.id.LoginConfirmPasswordTextView)
    TextView mLoginConfirmPasswordTextView;
    @BindView(R.id.ConfirmPasswordEditText)
    EditText mConfirmPasswordEditText;
    @BindView(R.id.signUpButton)
    Button mSignUpButton;
    @BindView(R.id.LoginTextView)
    TextView mLoginTextView;
    @BindView(R.id.FirebaseProgressBar)
    ProgressBar mFirebaseProgressBar;
    @BindView(R.id.LoadingTextView)
    TextView mLoadingTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();

//        ButterKnife.bind(this);

        //validate user inputs when login button clicked
//        mCreateUserButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mSignUpButton) {
            accountSignUp();
        }
    }

    private void accountSignUp() {
        //validations
        String name = mLoginNameTextView.getText().toString().trim();
        String email = mEmailEditText.getText().toString().trim();
        String password = mLoginPasswordEditText.getText().toString().trim();

        if (name.isEmpty()) {
            mNameEditText.setError("Name is required");
            mNameEditText.requestFocus();
            return;
        }
        if (email.isEmpty()) {
            mEmailEditText.setError("Email is required");
            mEmailEditText.requestFocus();
            return;
        }


        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            mLoginNameTextView.setError("Please enter a valid address");
            mEmailEditText.requestFocus();
            return;


        }


        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            mLoginEmailTextView.setError("Please enter a valid address");
            mEmailEditText.requestFocus();
            return;
        }
        if (password.isEmpty()) {
            mLoginPasswordEditText.setError("Password is required");
            mLoginPasswordEditText.requestFocus();
            return;
        }
        if (password.length() < 6) {
            mLoginPasswordEditText.setError("Minimum password character required is six");
            mLoginPasswordEditText.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            User user = new User(name, email);

                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        Toast.makeText(Sign_Up.this, "User has been registered", Toast.LENGTH_SHORT).show();
                                    }else{
                                        Toast.makeText(Sign_Up.this, "Failed to register user", Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });
                        }else {
                            Toast.makeText(Sign_Up.this, "Failed to register user", Toast.LENGTH_SHORT).show();
                        }

                    }
                });

    }
}
//nav to new activity







