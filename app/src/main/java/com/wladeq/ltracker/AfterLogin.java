package com.wladeq.ltracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AfterLogin extends AppCompatActivity {

    private ExpandableListView listView;
    private ExpandeblaListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String,List<String>> listHash;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_po_login);
        listView = (ExpandableListView) findViewById(R.id.ExView);
        initData();
        listAdapter= new ExpandeblaListAdapter(this,listDataHeader,listHash);
        listView.setAdapter(listAdapter);
    }

    public void startRide(View view) {
        Intent intent = new Intent (this,MapsActivity.class);
        startActivity(intent);
    }

    private void initData() {
        listDataHeader = new ArrayList<>();
        listHash = new HashMap<>();

        listDataHeader.add("Date, time of the first ride");
        listDataHeader.add("Date, time of the second ride");
        listDataHeader.add("Date, time of the third ride");
        listDataHeader.add("Date, time of the fourth ride");

        List<String> firstR = new ArrayList<>();
        firstR.add("Start point, time");
        firstR.add("Middle points, time");
        firstR.add("End point, time");

        List<String> secondR = new ArrayList<>();
        secondR.add("Start point, time");
        secondR.add("Middle points, time");
        secondR.add("End point, time");

        List<String> thirdR = new ArrayList<>();
        thirdR.add("Start point, time");
        thirdR.add("Middle points, time");
        thirdR.add("End point, time");

        List<String> fourthR = new ArrayList<>();
        fourthR.add("Start point, time");
        fourthR.add("Middle points, time");
        fourthR.add("End point, time");

        listHash.put(listDataHeader.get(0),firstR);
        listHash.put(listDataHeader.get(1),secondR);
        listHash.put(listDataHeader.get(2),thirdR);
        listHash.put(listDataHeader.get(3),fourthR);
    }
}