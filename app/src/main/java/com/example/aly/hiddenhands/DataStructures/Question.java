package com.example.aly.hiddenhands.DataStructures;

/**
 * Created by Nour Ahmed on 7/25/2019.
 */

public class Question {
    private String content;
    private String patientId;
    private String doctorId;

    public Question(String content, String patientId, String doctorId) {
        this.content = content;
        this.patientId = patientId;
        this.doctorId = doctorId;
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
}
