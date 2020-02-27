package com.example.androidpopups.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class FluDialogFragment extends DialogFragment {

    private String[] flues = {"Vanilla Flu", "Corona", "Spanish Flu", "Sars"};
    private DialogInterface.OnClickListener itemSelectHandler = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            Toast.makeText(getActivity(), "Happy infecting! " + flues[which]+".", Toast.LENGTH_LONG).show();
        }
    };


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("Choose your flu");
        builder.setItems(flues, itemSelectHandler);
        builder.setNegativeButton(android.R.string.cancel, null);

        return builder.create();

    }
}
