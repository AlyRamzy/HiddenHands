package com.example.aly.hiddenhands.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.view.LayoutInflater;

import com.example.aly.hiddenhands.DataStructures.Question;
import com.example.aly.hiddenhands.R;

import android.widget.ImageView;
import android.widget.TextView;

import java.time.LocalTime;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Mohamed Fekry on 2019-07-26.
 */

public class AskQuestionAdapter extends ArrayAdapter {
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view=convertView;
        if(view==null) {
            view= LayoutInflater.from(getContext()).inflate(R.layout.question_listview_item,parent,false);
        }

        Question current= (Question) getItem(position);
        TextView patientQuestionContent =(TextView) view.findViewById(R.id.patientquestion);
        String content = current.getContent();
        patientQuestionContent.setText(content);

        TextView patientQuestionDate =(TextView) view.findViewById(R.id.questiondate);
        Date date = current.getQuestionDate();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String strDate = dateFormat.format(date);
        patientQuestionDate.setText(dateFormat.format(date) );
/*
        TextView patientQuestionTime =(TextView) view.findViewById(R.id.questiontime);
        LocalTime time = current.getQuestionTime();
        patientQuestionTime.setText(time.toString());
*/
        ImageView answeredOrNot =(ImageView) view.findViewById(R.id.answeredcheck);
        boolean check = current.getAnswered();
        if (current.getAnswered()== true) {
            answeredOrNot.setImageResource(R.drawable.right);
        }
        answeredOrNot.setImageResource(R.drawable.wrong);



        return view; // to be removed
    }

    public AskQuestionAdapter(@NonNull Context context,  @NonNull List<Question> objects) {
        super(context,0, objects);
    }
}
