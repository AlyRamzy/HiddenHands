package com.example.aly.hiddenhands.fragments;


import android.content.res.Resources;
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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.aly.hiddenhands.DataStructures.Doctor;
import com.example.aly.hiddenhands.DataStructures.Patient;
import com.example.aly.hiddenhands.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignupDoctor extends Fragment {
    // UI references.
    private AutoCompleteTextView mEmailView;
    private AutoCompleteTextView mAgeView;
    private AutoCompleteTextView mNationalIDView;
    private EditText mPasswordView;
    private AutoCompleteTextView mUserNameView;
    private TextInputLayout mUserNmaeAuto;
    private TextInputLayout mNationalIDAuto;
    private TextInputLayout mEmailAuto;
    private TextInputLayout mAgeAuto;
    private TextInputLayout mPasswordAuto;
    private Button mCreateAccountButton;
    private RadioGroup mRadioGroup;
    private RadioButton mRadioButtonMale;
    private RadioButton mRadioButtonFemale;
    FirebaseAuth firebaseAuth;
    ProgressBar progressBar;


    public SignupDoctor() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_signup_doctor, container, false);
        //initialize Firebase
        firebaseAuth= FirebaseAuth.getInstance();
        //Bind UI references
        mUserNameView = (AutoCompleteTextView)rootView.findViewById(R.id.doctor_name);
        mUserNmaeAuto = (TextInputLayout)rootView.findViewById(R.id.doctor_name_auto);
        progressBar=(ProgressBar)rootView.findViewById(R.id.progress_doctor);
        progressBar.setVisibility(View.GONE);
        mCreateAccountButton = (Button)rootView.findViewById(R.id.create_account_doctor_button);
        mEmailView = (AutoCompleteTextView)rootView.findViewById(R.id.email_doctor);
        mPasswordView = (EditText)rootView.findViewById(R.id.password_doctor);
        mEmailAuto = (TextInputLayout) rootView.findViewById(R.id.email_auto_doctor);
        mPasswordAuto =(TextInputLayout)rootView.findViewById(R.id.password_auto_doctor);
        mNationalIDAuto=(TextInputLayout)rootView.findViewById(R.id.nationalid_auto_doctor);
        mNationalIDView=(AutoCompleteTextView) rootView.findViewById(R.id.nationalid_doctor);
        mAgeView=(AutoCompleteTextView)rootView.findViewById(R.id.age_doctor);
        mAgeAuto=(TextInputLayout)rootView.findViewById(R.id.age_auto_doctor);
        mRadioGroup=(RadioGroup)rootView.findViewById(R.id.radio_doctor);
        mRadioButtonMale=(RadioButton)rootView.findViewById(R.id.male);
        mRadioButtonFemale=(RadioButton)rootView.findViewById(R.id.female);

        mCreateAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPasswordAuto.setError(null);
                mAgeAuto.setError(null);
                mEmailAuto.setError(null);
                mNationalIDAuto.setError(null);
                mUserNmaeAuto.setError(null);
                String password = mPasswordView.getText().toString();
                String age = mAgeView.getText().toString();
                String email = mEmailView.getText().toString();
                final String userName = mUserNameView.getText().toString();
                final String gender;
                String nationalID=mNationalIDView.getText().toString();
                if(!email.contains("@")){
                    mEmailAuto.setError("Invalid Email Adress");
                    return;

                }
                if(password.length()<8){
                    mPasswordAuto.setError("Password have to be more than 8 char");
                    return;
                }
                if(userName.length()<=3 || userName.length()>=20){
                    mUserNmaeAuto.setError("Username have to be more than 3 and less than 20 char");
                    return;
                }
                if(age.isEmpty()){
                    mAgeAuto.setError("Please Insert Age");
                    return;
                }

                int userAge= 20;
                try {
                    userAge=Integer.parseInt(age);

                } catch (Resources.NotFoundException e) {
                    e.printStackTrace();
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                if(userAge<5||userAge>110){
                    mAgeAuto.setError("Invalid Age ");
                    return;
                }
                if(nationalID.length()<14){
                    mNationalIDAuto.setError("Invalid National ID");
                    return;
                }
                if (mRadioGroup.getCheckedRadioButtonId() == -1)
                {
                    Toast.makeText(getContext(),"Please Choose Gender",Toast.LENGTH_SHORT).show();
                    return;
                    // no radio buttons are checked
                }
                if(mRadioButtonFemale.isSelected()){
                    gender="Female";

                }else{
                    gender="Male";
                }

                progressBar.setVisibility(View.VISIBLE);
                firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressBar.setVisibility(View.GONE);
                        if(task.isSuccessful()){
                            Doctor doctor=new Doctor(Integer.parseInt(mAgeView.getText().toString()),gender,userName,2,mNationalIDView.getText().toString(),null);
                            FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(doctor);
                          //  getActivity().onBackPressed();

                        }else{
                            Toast.makeText(getContext(),task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }

                    }
                });







            }
        });
        return rootView;

    }


}
