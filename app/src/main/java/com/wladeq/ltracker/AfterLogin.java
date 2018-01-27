package com.wladeq.ltracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AfterLogin extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_po_login);
    }
//12
    public void qwe(View view) {
        Intent intent = new Intent (this,MapsActivity.class);
        startActivity(intent);
    }
}