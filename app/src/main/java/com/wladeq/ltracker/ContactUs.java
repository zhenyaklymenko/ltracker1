package com.wladeq.ltracker;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class ContactUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
    }

    public void call() {
        Intent i = new Intent(Intent.ACTION_DIAL);
        String p = "tel:" + getString(R.string.tel);
        i.setData(Uri.parse(p));
        startActivity(i);
    }

    public void sendEmail() {
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto","ltrackerteam@email.com", null));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Podziękowanie");
        intent.putExtra(Intent.EXTRA_TEXT,"Dziękuję bardzo za taką przepiękną appkę!!");
        startActivity(Intent.createChooser(intent, "Choose an Email client :"));
    }

    public void back() {
        Intent intent = new Intent (this,MainActivity.class);
        startActivity(intent);
    }

    public void map() {
        String uri = "http://maps.google.com/maps?daddr=" + 51.737557 + "," + 19.466653;
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        startActivity(intent);
    }

    public void web() {
        Uri uri = Uri.parse("http://igorsmyrnov.pl/tracker");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);

    }

    public void facebook() {
        Uri uri = Uri.parse("http://facebook.com");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}
