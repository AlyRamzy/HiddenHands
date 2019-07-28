package com.example.aly.hiddenhands.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.aly.hiddenhands.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * A simple {@link Fragment} subclass.
 */
public class Login extends Fragment {
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private TextInputLayout mEmailAuto;
    private TextInputLayout mPasswordAuto;
    private Button mLoginButton;
    ProgressBar progressBar;
    FirebaseAuth firebaseAuth;



    public Login() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_login, container, false);

        //initialize Firebase
        firebaseAuth=FirebaseAuth.getInstance();
        //UI Refrence

        mEmailView = (AutoCompleteTextView)rootView.findViewById(R.id.email);
        mPasswordView = (EditText)rootView.findViewById(R.id.password);
        mEmailAuto = (TextInputLayout) rootView.findViewById(R.id.email_auto);
        mPasswordAuto =(TextInputLayout)rootView.findViewById(R.id.password_auto);
        mLoginButton=(Button)rootView.findViewById(R.id.login_button);
        progressBar=(ProgressBar)rootView.findViewById(R.id.progress_login);
        progressBar.setVisibility(View.GONE);
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPasswordAuto.setError(null);
                mEmailAuto.setError(null);
                String password = mPasswordView.getText().toString();
                String email = mEmailView.getText().toString();
                if(!email.contains("@")){
                    mEmailAuto.setError("Invalid Email Adress");
                    return;

                }
                if(password.length()<8){
                    mPasswordAuto.setError("Invalid Password");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);
                firebaseAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(View.GONE);
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                //    getActivity().onBackPressed();



                                } else {
                                    Toast.makeText(getContext(),task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                                    // If sign in fails, display a message to the user.

                                }

                                // ...
                            }
                        });

            }
        });

        return rootView;
    }

}
