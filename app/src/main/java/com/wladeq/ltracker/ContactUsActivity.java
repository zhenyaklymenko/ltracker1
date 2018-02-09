package com.wladeq.ltracker;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import bolts.AppLinks;



//This class describes functioning of "contuct us" screen
//allows to call to developers, send mail
//proceed to our website, facebook page
//allows to show the way to developers location by using app's navigation


public class ContactUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
    }


    //call to our office
    public void call(View view) {
        Intent i = new Intent(Intent.ACTION_DIAL);
        String p = "tel:" + getString(R.string.tel);
        i.setData(Uri.parse(p));
        startActivity(i);
    }


    //send e-mail to us
    public void sendEmail(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto","ltrackerteam@email.com", null));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
        intent.putExtra(Intent.EXTRA_TEXT,"Body");
        startActivity(Intent.createChooser(intent, "Choose an Email client :"));
    }


    //logout and go back to login screen
    public void backToLogin(View view) {
        Intent intent = new Intent (this,MainActivity.class);
        startActivity(intent);
    }


    //navigation to our office
    public void getDirectionToUs(View view) {
        String uri = "http://maps.google.com/maps?daddr=" + 51.737557 + "," + 19.466653;
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        startActivity(intent);
    }


    //link to our website
    public void redirectWebsite(View view) {
        Uri uri = Uri.parse("http://igorsmyrnov.pl/tracker");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }


    //link to our facebook page
    public void redirectFB(View view) {
        Uri uri = Uri.parse("http://facebook.com");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}
