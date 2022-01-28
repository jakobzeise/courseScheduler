package com.jakobzeise.coursescheduler.view.adds;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import com.jakobzeise.coursescheduler.R;
import com.jakobzeise.coursescheduler.modell.database.AppDatabase;
import com.jakobzeise.coursescheduler.modell.converters.DateConverter;
import com.jakobzeise.coursescheduler.modell.dataclasses.Term;
import com.jakobzeise.coursescheduler.view.dataclassviews.MainActivity;

import java.util.Date;

public class AddTermActivity extends AppCompatActivity {

    int counter = 0;
    TextView textViewInstruction;
    EditText editTextTermName;
    CalendarView calendarViewTerm;
    Button buttonNext;

    long startDate, endDate;
    String termName;
    long curDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_term);

        textViewInstruction = findViewById(R.id.textViewAddTermInstructions);
        editTextTermName = (EditText) findViewById(R.id.editTextTermName);
        calendarViewTerm = (CalendarView) findViewById(R.id.calendarViewTerm);
        buttonNext = (Button) findViewById(R.id.buttonNextAddTerm);

        calendarViewTerm.setOnDateChangeListener((view, year, month, dayOfMonth)
                -> curDate = DateConverter.fromDate(new Date(year - 1900, month, dayOfMonth)));

        buttonNext.setOnClickListener(v -> {
            switch (counter) {
                case 0:
                    startDate = curDate;
                    textViewInstruction.setText("Select End Date of the Term");
                    break;
                case 1:
                    endDate = curDate;
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
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "app_database").allowMainThreadQueries().build();

        db.termDao().insertAll(new Term(termName, startDate, endDate));
    }
}