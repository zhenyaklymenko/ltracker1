package com.wladeq.ltracker;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.os.Bundle;

/**
 * Created by VladyslavIgnatenko on 05.02.2018.
 */

public class DialogFr extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.dialog_fire_missiles)
                .setItems(R.array.colors_array, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        switch (which){
                            case(0):
                              {
                                InstructorChoose ins = new InstructorChoose();
                                ins.ins1();
                              }
                              break;
                            case(1):
                            {
                                InstructorChoose ins = new InstructorChoose();
                                ins.ins2();
                            }
                            break;
                            case(2):
                            {InstructorChoose ins = new InstructorChoose();
                                ins.ins3();
                            }
                            break;
                        }

                    }
                });
        return builder.create();
    }}
