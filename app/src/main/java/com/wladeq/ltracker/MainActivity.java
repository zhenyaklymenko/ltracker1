package com.wladeq.ltracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;

public class MainActivity extends AppCompatActivity {

    private final static int LOGIN_PERMISSION=1000;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==LOGIN_PERMISSION){
            startNewActivity(resultCode);
        }
    }

    private void startNewActivity(int resultCode) {
        if(resultCode==RESULT_OK){
            Intent intent = new Intent (this,ListOfTracks.class);
            startActivity(intent);
            finish();
        }
        else{
            Toast.makeText(this,"Login failed", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnLogin = findViewById(R.id.btnSingIn);
        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivityForResult(
                        AuthUI.getInstance().createSignInIntentBuilder()
                        .setAllowNewEmailAccounts(false).build(),LOGIN_PERMISSION);
            }
        });
    }

    public void contact(View view) {
        Intent intent = new Intent (this,ContactUsActivity.class);
        startActivity(intent);
    }
}
