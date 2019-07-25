package com.example.aly.hiddenhands.DataStructures;

/**
 * Created by Nour Ahmed on 7/25/2019.
 */

public class Doctor extends User {
    private int nationalId;
    private String photoURL;

    public Doctor(int age, char gender, String username, int type, int nationalId, String photoURL) {
        super(age, gender, username, type);
        this.nationalId = nationalId;
        this.photoURL = photoURL;
    }

    public void setNationalId(int nationalId) {
        this.nationalId = nationalId;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public int getNationalId() {
        return nationalId;
    }

    public String getPhotoURL() {
        return photoURL;
    }
}
