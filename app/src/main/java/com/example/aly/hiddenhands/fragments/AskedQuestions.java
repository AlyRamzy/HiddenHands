package com.example.aly.hiddenhands.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.aly.hiddenhands.DataStructures.Question;
import com.example.aly.hiddenhands.R;
import com.example.aly.hiddenhands.adapters.AskQuestionAdapter;

import java.sql.Date;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 *
 * 
 */
public class AskedQuestions extends Fragment {

    Date date1;
    public AskedQuestions() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_asked_questions, container, false);
        ListView listview = (ListView) view.findViewById(R.id.patientquestionslist);
        ArrayList<Question> patientQuestionsList = new ArrayList<Question>();
        date1= new Date(1,2,3);
        patientQuestionsList.add(new Question ("this question", "123445", "234556", date1));
        AskQuestionAdapter adapter = new AskQuestionAdapter(getContext(), patientQuestionsList);
        listview.setAdapter(adapter);
        return view;
    }

}
