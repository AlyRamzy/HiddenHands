package com.example.aly.hiddenhands.fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aly.hiddenhands.R;
import com.example.aly.hiddenhands.adapters.PatientPagerAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class PatientHomePage extends Fragment {
    private ViewPager viewPager;
    private PatientPagerAdapter viewPagerAdapter;
    private TabLayout tabLayout;


    public PatientHomePage() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_patient_home_page, container, false);
        viewPager = (ViewPager)rootView. findViewById(R.id.pager);
        viewPagerAdapter = new PatientPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout = (TabLayout)rootView. findViewById(R.id.tab);
        tabLayout.setupWithViewPager(viewPager);
        return rootView;
    }

}
