package com.example.aly.hiddenhands.DataStructures;

import java.util.Date;


/**
 * Created by Nour Ahmed on 7/25/2019.
 */

public class Question {
    private String content;
    private String patientId;
    private String doctorId;
    private String answercontent;
    private boolean answered;
    private Date questionDate;
    //private LocalTime questionTime;

    public Question(String content, String patientId, String doctorId, String answercontent, Date questionDate) {
        this.content = content;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.answercontent = answercontent;
        this.questionDate = questionDate;
        //this.questionTime = questionTime;
        this.answered=false;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getContent() {
        return content;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setAnswered() {answered = true; }

    public boolean getAnswered () { return answered; }

    public void setQuestionDate ( Date date) { questionDate= date; }

    public Date getQuestionDate () { return questionDate; }

    public void setQuestionAnswer ( String ansr) { answercontent=ansr; }

    public String getQuestionAnswer () { return String.valueOf(answercontent); }
/*
    public void setQuestionTime () { questionTime= LocalTime.now(); }

    public LocalTime getQuestionTime () { return questionTime;} */


}
