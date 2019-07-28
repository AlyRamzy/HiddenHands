package com.example.aly.hiddenhands.fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aly.hiddenhands.R;
import com.example.aly.hiddenhands.adapters.DoctorPagerAdapter;
import com.example.aly.hiddenhands.adapters.PatientPagerAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class DoctorHomePage extends Fragment {
    private ViewPager viewPager;
    private DoctorPagerAdapter viewPagerAdapter;
    private TabLayout tabLayout;




    public DoctorHomePage() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_doctor_home_page, container, false);
        viewPager = (ViewPager)rootView. findViewById(R.id.pager);
        viewPagerAdapter = new DoctorPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout = (TabLayout)rootView. findViewById(R.id.tab);
        tabLayout.setupWithViewPager(viewPager);
        return rootView;
    }

}
