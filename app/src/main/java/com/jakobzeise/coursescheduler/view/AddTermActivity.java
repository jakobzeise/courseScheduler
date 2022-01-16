package com.jakobzeise.coursescheduler.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import com.jakobzeise.coursescheduler.R;

import java.util.Date;

public class AddTermActivity extends AppCompatActivity {

    int counter = 0;
    TextView textViewInstruction;
    EditText editTextTermName;
    CalendarView calendarViewTerm;
    Button buttonNext;

    Date startDate, endDate;
    String termName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_term);

        textViewInstruction = findViewById(R.id.textViewAddTermInstructions);
        editTextTermName = (EditText) findViewById(R.id.editTextTermName);
        calendarViewTerm = (CalendarView) findViewById(R.id.calendarViewTerm);
        buttonNext = (Button) findViewById(R.id.buttonNextAddTerm);

        buttonNext.setOnClickListener(v -> {
            switch (counter) {
                case 0:
                    startDate = new Date(calendarViewTerm.getDate());
                    textViewInstruction.setText("Select End Date of the Term");
                    break;
                case 1:
                    endDate = new Date(calendarViewTerm.getDate());
                    editTextTermName.setVisibility(View.VISIBLE);
                    calendarViewTerm.setVisibility(View.INVISIBLE);
                    textViewInstruction.setText("Insert the Name of the Term");
                    break;
                case 2:
                    termName = editTextTermName.getText().toString();
                    addTermToDatabase();
                    startActivity(new Intent(this, MainActivity.class));
            }
            counter++;
        });


    }

    public void addTermToDatabase() {
        // TODO: 15.01.22 Implement Database
    }
}