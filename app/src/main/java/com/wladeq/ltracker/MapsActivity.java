package com.wladeq.ltracker;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.sql.Timestamp;

//Ten klas wyświetła mapę i nagrywa lokację ucznia
//punkty są zapisywane do bazy danych
//przycisk 'Finish' kończy nagrywanie

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener {

    private GoogleMap mMap;
    private GoogleApiClient mGoogleApiClient;
    private int i=1;
    private int startMarker;
    private LatLng lastLoc = null;
    private String insNum;
    private long timest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            checkLocationPermission();
        }
        //Data i timestamp
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        timest = timestamp.getTime();

        //Find where we should show the map
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //Get Uid of current instructor
        InstructorChoose a = new InstructorChoose();
        insNum = a.getChoice();

        //Dostaje email i Uid bieżącego usera
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String studentUid = user != null ? user.getUid() : null;
        String userEmail = user != null ? user.getEmail() : null;
        int Role = 0;

        //If current client is new - store his data in Firebase
        FirebaseDatabase database4 = FirebaseDatabase.getInstance();
        DatabaseReference myRef4 = database4.getReference("users/" + studentUid + "/email");
        myRef4.setValue(userEmail);

        FirebaseDatabase database5 = FirebaseDatabase.getInstance();
        DatabaseReference myRef5 = database5.getReference("users/" + studentUid + "/role");
        myRef5.setValue(Role);

        FirebaseDatabase database6 = FirebaseDatabase.getInstance();
        DatabaseReference myRef6 = database6.getReference("users/" + studentUid + "/uid");
        myRef6.setValue(studentUid);

        //Write instructor to FireBase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("tracks/" + insNum + timest + "/instructorUid");
        myRef.setValue(insNum);

        //Write student to Firebase
        FirebaseDatabase database9 = FirebaseDatabase.getInstance();
        DatabaseReference myRef9 = database9.getReference("tracks/" + insNum + timest + "/studentUid");
        myRef9.setValue(studentUid);

        //Write timestamp to Firebase
        FirebaseDatabase database2 = FirebaseDatabase.getInstance();
        DatabaseReference myRef2 = database2.getReference("tracks/" + insNum + timest + "/timestamp");
        myRef2.setValue(timest);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        //Typ mapy
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        //Uprawnienia lokacji
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                buildGoogleApiClient();
                mMap.setMyLocationEnabled(true);
            }
        }
        else {
            buildGoogleApiClient();
            mMap.setMyLocationEnabled(true);
        }
    }
    private synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        mGoogleApiClient.connect();
    }

    @Override
    public void onConnected(Bundle bundle) {
        //Określamy czas, przez który aplikacja ma sprawdzać lokalizację
        LocationRequest mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(1000);
        mLocationRequest.setFastestInterval(1000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
        }
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onLocationChanged(Location location) {

        //Place current location marker
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());

        //Place start marker
        if (startMarker==0) {
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(latLng);
            markerOptions.title("Start position");
            markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
            Marker mCurrLocationMarker = mMap.addMarker(markerOptions);
            startMarker++;
        }
        //Jeżeli nie ma poprzedniej lokacji, to ustawiamy marker startowy i ustawiamy bieżącą
        // jako poprzedią
        if (lastLoc != null) {
            PolylineOptions pLineOptions = new PolylineOptions()
                    .clickable(true)
                    .add(lastLoc)
                    .add(latLng)
                    .color(Color.GREEN);
            Polyline polyline = mMap.addPolyline(pLineOptions);
            lastLoc = latLng;
        } else {
            lastLoc = latLng;
        }
        startMarker++;

        //move map camera
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15));

        //Save dots to firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef1 = database.getReference("tracks/" + insNum + timest +  "/points/" + i++);
        myRef1.setValue(latLng);

    }
    private static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;
    private void checkLocationPermission(){
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Asking user if explanation is needed
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                // Prompt the user once explanation has been shown

                ActivityCompat.requestPermissions(this,
                        new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);
            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);
            }
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String permissions[], @NonNull int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted. Do the
                    // contacts-related task you need to do.
                    if (ContextCompat.checkSelfPermission(this,
                            Manifest.permission.ACCESS_FINE_LOCATION)
                            == PackageManager.PERMISSION_GRANTED) {
                        if (mGoogleApiClient == null) {
                            buildGoogleApiClient();
                        }
                        mMap.setMyLocationEnabled(true);

                    }
                } else {
                    // Permission denied, Disable the functionality that depends on this permission.
                    Toast.makeText(this, "permission denied", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    public void finishRec(View view) {
        FinishRaceDialog a = new FinishRaceDialog();
        a.show(getSupportFragmentManager(), "Instructor choice");
    }

}

