package com.example.aly.hiddenhands.DataStructures;

/**
 * Created by Nour Ahmed on 7/25/2019.
 */

public class Doctor extends User {
    private String nationalId;
    private String photoURL;

    public Doctor(int age, String gender, String username, int type, String nationalId, String photoURL) {
        super(age, gender, username, type);
        this.nationalId = nationalId;
        this.photoURL = photoURL;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public String getNationalId() {
        return nationalId;
    }

    public String getPhotoURL() {
        return photoURL;
    }
}
