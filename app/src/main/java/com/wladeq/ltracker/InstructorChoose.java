package com.wladeq.ltracker;
import android.support.v7.app.AppCompatActivity;

public class InstructorChoose extends AppCompatActivity{

    private static int swit4;

    public InstructorChoose(){

    }

    public void ins1(){
         swit4 = 0;
    }

    public void ins2(){
        swit4 = 1;
    }

    public void ins3(){
        swit4 = 2;
    }

    public  String backer(){
        if (swit4 == 0) {
            return "ucBNQA1WR3SM5fUgNdniVumm67r2";
        } else if (swit4 == 1){
            return "3AFbHnKxUkV5xuFlmBWZ57C0RcS2";
        } else return "8uuQvE4UofbkHdBarenVGlY7IkR2";

}
}
