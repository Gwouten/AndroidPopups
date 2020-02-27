package com.example.androidpopups.ui;


import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.androidpopups.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    private View rootView;

    private View.OnClickListener toastHandler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast toast = Toast.makeText(getContext(), "Quit it!", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.TOP, 0, 0);
            toast.show();
        }
    };

    private View.OnClickListener simpleClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            new SimpleDialogFragment().show(getParentFragmentManager(), "sdf");
        }
    };

    private View.OnClickListener listButtonHandler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            new FluDialogFragment().show(getParentFragmentManager(), "flu");
        }
    };

    private View.OnClickListener dateButtonHandler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            new DateOfBirthDialogFragment().show(getParentFragmentManager(), "DoB");
        }
    };

    private View.OnClickListener snackbarHandler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Snackbar snackbar = Snackbar.make(rootView.findViewById(R.id.frag_container), "Welkom in Get Fritty!", Snackbar.LENGTH_INDEFINITE);
            snackbar.setAction("Jupla", new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            snackbar.setActionTextColor(Color.YELLOW);
            snackbar.show();
        }
    };

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_main, container, false);

        Button btnToast = rootView.findViewById(R.id.btn_toast);
        btnToast.setOnClickListener(toastHandler);

        Button btnSimple = rootView.findViewById(R.id.btn_dialog);
        btnSimple.setOnClickListener(simpleClickListener);

        Button btnList = rootView.findViewById(R.id.btn_list_dialog);
        btnList.setOnClickListener(listButtonHandler);

        Button btnDateOfBirth = rootView.findViewById(R.id.btn_date_of_birth);
        btnDateOfBirth.setOnClickListener(dateButtonHandler);

        FloatingActionButton fabSnackbar = rootView.findViewById(R.id.fab_snackbar);
        fabSnackbar.setOnClickListener(snackbarHandler);

        return rootView;
    }

}
