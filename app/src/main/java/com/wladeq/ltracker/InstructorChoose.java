package com.wladeq.ltracker;
import android.support.v7.app.AppCompatActivity;

//Klas, który dostaje wartość od usera i póżniej ją otdaje
public class InstructorChoose extends AppCompatActivity{
    String choice;
    public String getChoice() {
        return choice;
    }
    public void setChoice(String choice) {
        this.choice = choice;
    }
}
