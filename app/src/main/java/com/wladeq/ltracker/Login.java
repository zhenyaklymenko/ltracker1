package com.wladeq.ltracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
// this class describes login screen
// allows to proceed to "contuct us" screen or to "login" screen


public class Login extends AppCompatActivity {

    // giving permissions
    private final static int LOGIN_PERMISSION=1000;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        //checking if we received permission to login
        if(requestCode==LOGIN_PERMISSION){
            startNewActivity(resultCode);
        }
    }


    //if client login is successful, show "AfterLoginActivity" screen
    private void startNewActivity(int resultCode) {

        // checking if login is successful
        if(resultCode==RESULT_OK){

            //setting which screen to show next after login
            Intent intent = new Intent (this,AfterLoginActivity.class);

            //running class with set up settings
            startActivity(intent);

            //closing login process
            finish();
        }
        else{

            // showing message "login failed" if login is not successful

            Toast.makeText(this,"Login failed", Toast.LENGTH_SHORT).show();
        }
    }


    // starting authentication process after click on button
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //finding button
        Button btnLogin = findViewById(R.id.btnSingIn);


        //describing what button should do
        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivityForResult(

                        //authentication is realised with the help of google services
                        AuthUI.getInstance().createSignInIntentBuilder()
                                .setAllowNewEmailAccounts(false).build(),LOGIN_PERMISSION);
            }
        });
    }

    // button which gives us ability to proceed to "contact us" screen
    public void contact(View view) {
        Intent intent = new Intent (this,ContactUsActivity.class);
        startActivity(intent);
    }
}