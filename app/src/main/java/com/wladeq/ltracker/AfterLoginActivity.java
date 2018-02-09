package com.wladeq.ltracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



// this class describes the screen which shows up after login
//it allows to choose instructor, to start recording of drive session and to logout

public class AfterLoginActivity extends AppCompatActivity {


    //function shows xml layout "activity_after_login"
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login);
    }


    // this function starts recording (by pressing a button)
    public void letsStart(View view) {
        Intent intent = new Intent (this,MapsActivity.class);
        startActivity(intent);
    }


    //this function is logging out current user (by pressing a button)
    public void logout(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }


    //this function allows to choose the instructor with a button
    public void instructorChoiceDialog(View view) {
        InstructorChoiceDialog a = new InstructorChoiceDialog();
        a.show(getSupportFragmentManager(), "Instructor choice");
    }
}