package com.example.dialogdemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    private void showToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    public void onBtn1Clicked(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Exit Application?");
        builder.setMessage("Click yes to exit!");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int id) {
                showToast("Positive Button Clicked");
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int id) {
                showToast("Negative Button Clicked");
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    public void onBtn2Clicked(View view) {
        String[] list = {"Warrior", "Archer", "Wizard"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose your class");
        builder.setItems(list, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int position) {
                Log.i("Dialog", "Position = " + position);
                showToast("name = " + list[position].toString());
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    public void onBtn3Clicked(View view) {
        ProgressDialog dialog = new ProgressDialog(this); // Depricated
        dialog.setCancelable(true);
        dialog.setIndeterminate(true);
        dialog.setTitle("Please Wait...");
        dialog.setMessage("Preparing to download...");
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.show();
    }
    public void onBtn4Clicked(View view) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {
                        // Handle the selected date
                        String selectedDate = selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear;
                        showToast("Selected Date: " + selectedDate);
                    }
                },
                0, 0, 0);

        // Show the DatePickerDialog
        datePickerDialog.show();
    }
    public void onBtn5Clicked(View view) {
        TimePickerDialog timePickerDialog = new TimePickerDialog(
                this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int selectedHour, int selectedMinute) {
                        // Handle the selected time
                        String selectedTime = selectedHour + ":" + selectedMinute;
                        showToast("Selected Time: " + selectedTime);
                    }
                },
                0, 0, true);

        // Show the TimePickerDialog
        timePickerDialog.show();
    }

    public void onBtn6Clicked(View view){
        CustomDialog dialog = new CustomDialog(MainActivity.this);
        dialog.show();
    }
}