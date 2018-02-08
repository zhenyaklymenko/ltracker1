package com.wladeq.ltracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;

//Ten klas opisuje początkowy ekran logowania
//Pozwała na przejście do ekranu 'Contact us' albo do procesu logowania się

public class MainActivity extends AppCompatActivity {
    //Określiamy wartość uprawnień
    private final static int LOGIN_PERMISSION=1000;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //Sprawdzamy czy dostaliśmy pozwolenie od systemu komórki na wyświetlenie logowania
        if(requestCode==LOGIN_PERMISSION){
            startNewActivity(resultCode);
        }
    }

    //Jeżeli klient się zalogował poprawnie, to wyświetłamy ekran 'AfterLoginActivity'
    private void startNewActivity(int resultCode) {
        //Sprawdzamy, czy logowanie się udało
        if(resultCode==RESULT_OK){
            //Ustawiamy, jaki klas ma się wyświetlić po zalogowaniu
            Intent intent = new Intent (this,AfterLoginActivity.class);
            //Uruchomiamy ustawiony klas
            startActivity(intent);
            //Zamykamy process logowania
            finish();
        }
        else{
            //Jeżeli logowanie jest nie udane, to na krótko pokazujemy komunikat 'Login failed'

            Toast.makeText(this,"Login failed", Toast.LENGTH_SHORT).show();
        }
    }

    //Ta funkcja zaczyna proces autenfikacji po kliknięciu przycisku
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Szukamy przycisk
        Button btnLogin = findViewById(R.id.btnSingIn);

        //Określiamy funkjonalność przycisku
        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivityForResult(
                        //Autentyfikacja jest realizowana za pomocą serwisów google
                        AuthUI.getInstance().createSignInIntentBuilder()
                                .setAllowNewEmailAccounts(false).build(),LOGIN_PERMISSION);
            }
        });
    }
    //Przycisk umorzliwiający przejscie do ekranu 'Contact us'
    public void contact(View view) {
        Intent intent = new Intent (this,ContactUsActivity.class);
        startActivity(intent);
    }
}