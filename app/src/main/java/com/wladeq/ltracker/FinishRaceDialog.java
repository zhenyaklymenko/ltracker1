package com.wladeq.ltracker;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
//Ten klas opisuje popup, który jest wyświetłany, gdy user wciska
// przycisk 'Finish'

public class FinishRaceDialog extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // Korzystamy z klasu 'Builder' żeby zbudować konstrukcję popup-u
        // bierzemy gotową kontrukcję 'AlertDialog'
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Do you want to finish race?")
                .setPositiveButton("Finish", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //Jeżeli zatwierdza, że chce zakończyć nagrywanie,
                        //zamykamy bieżący klas (nagrywanie się zatrzymuje)
                        System.exit(0);
                    }
                })
                //Jeżeli user wciska 'Cancel', zamykamy popup
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });
        // Tworzymy 'AlertDialog' i zwracamy go w miejscie, gdzie został wywolany
        return builder.create();
    }
}
