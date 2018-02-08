package com.wladeq.ltracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


//Ten klas opisuje ekran, który się wyświetła po zalogowaniu
//Pozwałą wybrać instruktora, zacząć nagrywanie jazdy i wylogować się

public class AfterLoginActivity extends AppCompatActivity {

    //Ta funkcja wyświetła xml layout 'activity_after_login'
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login);
    }

    //Ta funkcja zaczyna nagrywanie (przycisk)
    public void letsStart(View view) {
        Intent intent = new Intent (this,MapsActivity.class);
        startActivity(intent);
    }

    //Ta funkcja wylogowuje bieżącego użytkownika (przycisk)
    public void logout(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    //Ta funkcja pozwala na wybranie instruktora (przycisk)
    public void instructorChoiceDialog(View view) {
        InstructorChoiceDialog a = new InstructorChoiceDialog();
        a.show(getSupportFragmentManager(), "Instructor choice");
    }
}