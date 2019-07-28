package com.example.aly.hiddenhands.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.aly.hiddenhands.fragments.AskedQuestions;
import com.example.aly.hiddenhands.fragments.Chats;
import com.example.aly.hiddenhands.fragments.NotAnswerdQuestions;
import com.example.aly.hiddenhands.fragments.Sessions;

/**
 * Created by Aly on 7/26/2019.
 */

public class DoctorPagerAdapter  extends FragmentPagerAdapter {
    public static final int numberOfPages=4;

    AskedQuestions mAskedQuestionsFragment;
    NotAnswerdQuestions mNotAnswerdQuestions;
    Chats mChats;
    Sessions mSessions;


    public DoctorPagerAdapter(FragmentManager fm) {
        super(fm);

        mChats=new Chats();
        mSessions=new Sessions();
        mAskedQuestionsFragment=new AskedQuestions();
        mNotAnswerdQuestions=new NotAnswerdQuestions();


    }
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return mSessions;

            case 1:
                return mAskedQuestionsFragment;
            case 2:
                return mNotAnswerdQuestions;
            case 3:
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
                return "Not Answerd Questions";
            case 3:
                return "Chats";
            default:
                return "Notifications";
        }
    }
}
