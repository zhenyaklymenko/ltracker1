package com.wladeq.ltracker;

<<<<<<< HEAD
class InstructorChoose{

    private static int swit4;

    void ins1(){
         swit4 = 0;
    }

    void ins2(){
        swit4 = 1;
    }

    void ins3(){
        swit4 = 2;
    }


/*    public void setSwit4(int swit4){
        this.swit4 = swit4;
    }*/

    String backer(){
        if (swit4 == 0) {
            return "ucBNQA1WR3SM5fUgNdniVumm67r2";
        } else if (swit4 == 1){
            return "3AFbHnKxUkV5xuFlmBWZ57C0RcS2";
        } else return "8uuQvE4UofbkHdBarenVGlY7IkR2";

}
=======

// class, which takes the choice of user and returns it  later
public class InstructorChoose extends AppCompatActivity{
    private static String choice;
    public String getChoice() {
        return choice;
    }
    public void setChoice(String choice) {
        InstructorChoose.choice = choice;
    }
>>>>>>> refs/remotes/origin/master
}
