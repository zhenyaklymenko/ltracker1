package com.wladeq.ltracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ListOfTracks extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login);
        DialogFr a = new DialogFr();
        a.show(getSupportFragmentManager(), "Instructor choice");
    }

    public void letsStart(View view) {
        Intent intent = new Intent (this,MapsActivity.class);
        startActivity(intent);
    }

    public void logout(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}