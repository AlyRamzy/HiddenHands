package com.example.aly.hiddenhands.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aly.hiddenhands.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignupDoctor extends Fragment {


    public SignupDoctor() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_signup_doctor, container, false);
    }


}
