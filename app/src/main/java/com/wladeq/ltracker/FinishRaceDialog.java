package com.wladeq.ltracker;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

//this class describes popup, which comes after pressing "finish" button

public class FinishRaceDialog extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        //using class "Builder" to build pop-up construction
        //taking ready to use "Alert Dialog" construction

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Do you want to finish race?")
                .setPositiveButton("Finish", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        //closing current class if user wants to stop recording

                        System.exit(0);
                    }
                })

                //closing popup if user presses "cancel"
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });

        // creating "AlertDialog" and returning it where it was called
        return builder.create();
    }
}
