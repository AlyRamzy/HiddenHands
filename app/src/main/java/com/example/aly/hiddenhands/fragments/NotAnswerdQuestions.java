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
public class NotAnswerdQuestions extends Fragment {


    public NotAnswerdQuestions() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_not_answerd_questions, container, false);
        return view;
    }

}
