package com.jakobzeise.coursescheduler.view;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.jakobzeise.coursescheduler.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TermActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term);

        TextView textViewTermName = (TextView) findViewById(R.id.textViewCourseName);
        TextView textViewStartDateTerm = (TextView) findViewById(R.id.textViewStartDateTerm);
        TextView textViewEndDateTerm = (TextView) findViewById(R.id.textViewEndDateTerm);
        Button buttonDeleteTerm = (Button) findViewById(R.id.buttonDeleteTerm);
        Button buttonGoHomeTerm = (Button) findViewById(R.id.buttonGoHomeTerm);

        String termName = getIntent().getStringExtra("termName");
        Date startDate = new Date(getIntent().getLongExtra("startDate", 0));
        Date endDate = new Date(getIntent().getLongExtra("endDate", 0));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM-dd-yyyy");

        textViewTermName.setText(termName);
        textViewStartDateTerm.setText("StartDate: \n" + simpleDateFormat.format(startDate));
        textViewEndDateTerm.setText("EndDate: \n" + simpleDateFormat.format(endDate));
        buttonDeleteTerm.setOnClickListener(v ->
                // TODO: 16.01.22 Implement Database
                deleteTermFromDataBase()
        );

        buttonGoHomeTerm.setOnClickListener(v ->
                startActivity(new Intent(this, MainActivity.class))
        );
    }

    public void deleteTermFromDataBase() {

    }
}