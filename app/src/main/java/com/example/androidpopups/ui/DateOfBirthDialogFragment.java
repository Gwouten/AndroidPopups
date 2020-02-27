package com.example.androidpopups.ui;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;

public class DateOfBirthDialogFragment extends DialogFragment {

    private Calendar calendar;
    private Context mContext;

    private DatePickerDialog.OnDateSetListener dateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int day) {
            calendar.set(year, month, day);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            String dateAsText = simpleDateFormat.format(calendar.getTime());
            Toast.makeText(getActivity(), dateAsText, Toast.LENGTH_LONG).show();
        }
    };

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try{
            mContext = context;
        }catch (RuntimeException re){
            throw new RuntimeException("Can only be opened in an zctivity.");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        calendar = Calendar.getInstance(Locale.getDefault());

        int year  = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day   = calendar.get(Calendar.DATE);

        return new DatePickerDialog(mContext, dateListener, year, month, day);

    }
}
