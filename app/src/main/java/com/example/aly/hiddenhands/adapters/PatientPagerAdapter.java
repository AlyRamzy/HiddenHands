package com.example.aly.hiddenhands.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.aly.hiddenhands.fragments.AskedQuestions;
import com.example.aly.hiddenhands.fragments.Chats;
import com.example.aly.hiddenhands.fragments.Sessions;

/**
 * Created by Aly on 7/12/2019.
 */

public class PatientPagerAdapter extends FragmentPagerAdapter {
    public static final int numberOfPages=3;

    AskedQuestions mAskedQuestionsFragment;
    Chats mChats;
    Sessions mSessions;

    public PatientPagerAdapter(FragmentManager fm) {
        super(fm);

      mChats=new Chats();
      mSessions=new Sessions();
      mAskedQuestionsFragment=new AskedQuestions();


    }
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return mSessions;

            case 1:
                return mAskedQuestionsFragment;
            case 2:
                return mChats;
                default:
                    return mSessions;
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
                return "Sessions";
            case 1:
                return "Asked Questions";
            case 2:
                return "Chats";
                default:
                    return "Notifications";
        }
    }
}
