package com.example.aly.hiddenhands.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.aly.hiddenhands.DataStructures.Disorders;
import com.example.aly.hiddenhands.R;
import com.example.aly.hiddenhands.adapters.DisordersAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Disorder extends Fragment {


    public Disorder() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_disorder, container, false);
        ArrayList<Disorders> disorders = new ArrayList<Disorders>();
        disorders.add(new Disorders("Depression - الاكتئاب",R.drawable.depression, 0, R.string.dep_description, R.string.dep_symptoms, R.string.dep_treatments));
        disorders.add(new Disorders("ِAutism - التوحد",R.drawable.autism, 0, R.string.aut_description, R.string.aut_symptoms, R.string.aut_treatments));
        disorders.add(new Disorders("Anxiety - القلق",R.drawable.anxiety, 0, R.string.anx_description, R.string.anx_symptoms, R.string.anx_treatments));
        DisordersAdapter mAdapter = new DisordersAdapter(getContext(), disorders);
        ListView list = view.findViewById(R.id.disorder_list_view);
        list.setAdapter(mAdapter);
        return view;
    }

}
