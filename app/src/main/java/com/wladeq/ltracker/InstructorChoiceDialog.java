package com.wladeq.ltracker;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

//Ten klas tworzy popup na którym musimy wybrac instruktora
public class InstructorChoiceDialog extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //Ustawiamy tytul naszego popup-u
        builder.setTitle(R.string.dialog_choose_instructor);
        //Idenfikujemy, co zostało wybrane
        builder.setItems(R.array.instructors, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                //Wczytuje wybur ucznia i wpisuje go do innego klasu
                if (which == 0){
                    InstructorChoose a = new InstructorChoose();
                    a.setChoice("ucBNQA1WR3SM5fUgNdniVumm67r2");
                } if (which ==1){
                    InstructorChoose a = new InstructorChoose();
                    a.setChoice("3AFbHnKxUkV5xuFlmBWZ57C0RcS2");
                } else {
                    InstructorChoose a = new InstructorChoose();
                    a.setChoice("8uuQvE4UofbkHdBarenVGlY7IkR2");
                }

            }
        });
        return builder.create();
    }}
