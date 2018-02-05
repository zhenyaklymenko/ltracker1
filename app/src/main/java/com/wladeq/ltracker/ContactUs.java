package com.wladeq.ltracker;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ContactUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
    }

    public void call(View view) {
        Intent i = new Intent(Intent.ACTION_DIAL);
        String p = "tel:" + getString(R.string.tel);
        i.setData(Uri.parse(p));
        startActivity(i);
    }
    public void sendEmail(View view) {
        String a = "Podziękowanie";
        String b = "Dziękuję bardzo za taką przepiękną appkę!!";
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto","ltrackerteam@email.com", null));
        intent.putExtra(Intent.EXTRA_SUBJECT, a);
        intent.putExtra(Intent.EXTRA_TEXT, b);
        startActivity(Intent.createChooser(intent, "Choose an Email client :"));
    }
}
