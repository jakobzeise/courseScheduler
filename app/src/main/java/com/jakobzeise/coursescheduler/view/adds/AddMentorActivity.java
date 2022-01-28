package com.jakobzeise.coursescheduler.view.adds;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.jakobzeise.coursescheduler.R;
import com.jakobzeise.coursescheduler.view.dataclassviews.MainActivity;

public class AddMentorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_mentor);

        Button addMentor = (Button) findViewById(R.id.buttonAddNewMentor);
        EditText editTextMentorName = (EditText) findViewById(R.id.editTextMentorName);
        EditText editTextMentorEmail = (EditText) findViewById(R.id.editTextMentorEmail);

        addMentor.setOnClickListener(v -> {
            // TODO: 15.01.22 Implement Database
            addMentorToDatabase(
                    editTextMentorName.getText().toString(),
                    editTextMentorEmail.getText().toString()
            );
            startActivity(new Intent(this, MainActivity.class));
        });


    }

    public void addMentorToDatabase(String name, String email) {

    }
}