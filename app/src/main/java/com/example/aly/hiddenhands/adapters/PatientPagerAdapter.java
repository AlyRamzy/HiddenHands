package com.example.aly.hiddenhands.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.aly.hiddenhands.MainActivity;
import com.example.aly.hiddenhands.fragments.About;
import com.example.aly.hiddenhands.fragments.AskedQuestions;
import com.example.aly.hiddenhands.fragments.HowToUse;
import com.example.aly.hiddenhands.fragments.Notifications;

/**
 * Created by Aly on 7/12/2019.
 */

public class PatientPagerAdapter extends FragmentPagerAdapter {
    public static final int numberOfPages=2;

    AskedQuestions mAskedQuestionsFragment;
    Notifications mNotificationsFragment;

    public PatientPagerAdapter(FragmentManager fm) {
        super(fm);

        mNotificationsFragment=new Notifications();
        mAskedQuestionsFragment=new AskedQuestions();


    }
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return mNotificationsFragment;

            case 1:
                return mAskedQuestionsFragment;
                default:
                    return mNotificationsFragment;
        }

    }

    @Override
    public int getCount() {
        return numberOfPages;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Notifications";
            case 1:
                return "Asked Questions";
                default:
                    return "Notifications";
        }
    }
}
