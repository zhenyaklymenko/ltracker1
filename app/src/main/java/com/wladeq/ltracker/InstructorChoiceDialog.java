package com.wladeq.ltracker;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;


public class InstructorChoiceDialog extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.dialog_choose_instructor);
        builder.setItems(R.array.instructors, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                if (which == 0){
                    InstructorChoose a = new InstructorChoose();
                    a.ins1();
                } if (which ==1){
                    InstructorChoose a = new InstructorChoose();
                    a.ins2();
                } else {
                    InstructorChoose a = new InstructorChoose();
                    a.ins3();
                }

            }
        });
        return builder.create();
    }}
