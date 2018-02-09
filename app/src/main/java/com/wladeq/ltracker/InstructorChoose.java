package com.wladeq.ltracker;
import android.support.v7.app.AppCompatActivity;


// class, which takes the choice of user and returns it  later
public class InstructorChoose extends AppCompatActivity{
    static String choice;
    public String getChoice() {
        return choice;
    }
    public void setChoice(String choice) {
        InstructorChoose.choice = choice;
    }
}
