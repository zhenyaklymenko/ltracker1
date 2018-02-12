package com.wladeq.ltracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
<<<<<<< HEAD

public class AfterLoginActivity extends AppCompatActivity {
=======
import android.widget.Toast;


// this class describes the screen which shows up after login
//it allows to choose instructor, to start recording of drive session and to logout

public class AfterLoginActivity extends AppCompatActivity {


    //function shows xml layout "activity_after_login"
>>>>>>> refs/remotes/origin/master
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login);
<<<<<<< HEAD
        InstructorChoiceDialog a = new InstructorChoiceDialog();
        a.show(getSupportFragmentManager(), "Instructor choice");
    }

=======
    }


    // this function starts recording (by pressing a button)
>>>>>>> refs/remotes/origin/master
    public void letsStart(View view) {
        Intent intent = new Intent (this,MapsActivity.class);
        startActivity(intent);
    }

<<<<<<< HEAD
    public void logout(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
=======

    //this function is logging out current user (by pressing a button)
    public void logout(View view) {
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }


    //this function allows to choose the instructor with a button
    public void instructorChoiceDialog(View view) {
        InstructorChoiceDialog a = new InstructorChoiceDialog();
        a.show(getSupportFragmentManager(), "Instructor choice");
    }
    @Override
    public void onBackPressed() {
        Toast toast = Toast.makeText(this, "Press 'Logout' to exit", Toast.LENGTH_LONG);
        toast.show();
    }
>>>>>>> refs/remotes/origin/master
}