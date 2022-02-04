package com.jakobzeise.coursescheduler.view.adds;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jakobzeise.coursescheduler.R;
import com.jakobzeise.coursescheduler.modell.database.AppDatabase;
import com.jakobzeise.coursescheduler.modell.dataclasses.Mentor;
import com.jakobzeise.coursescheduler.view.dataclassviews.MainActivity;

public class AddMentorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_mentor);

        Button addMentor = (Button) findViewById(R.id.buttonAddNewMentor);
        EditText editTextMentorName = (EditText) findViewById(R.id.editTextMentorName);
        EditText editTextMentorEmail = (EditText) findViewById(R.id.editTextMentorEmail);
        EditText editTextMentorPhone = (EditText) findViewById(R.id.editTextMentorPhone);

        addMentor.setOnClickListener(v -> {

            if (!editTextMentorEmail.getText().toString().contains("@")) {
                Toast.makeText(this, "please Insert a valid email address", Toast.LENGTH_SHORT).show();
            } else if (editTextMentorPhone.getText().toString().isEmpty()) {
                Toast.makeText(this, "please Insert a valid phone number", Toast.LENGTH_SHORT).show();
            } else if (editTextMentorName.getText().toString().isEmpty()) {
                Toast.makeText(this, "please Insert a valid mentor name", Toast.LENGTH_SHORT).show();
            } else {
                AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                        AppDatabase.class, "app_database").allowMainThreadQueries().build();

                db.mentorDao().insertAll(new Mentor(
                        editTextMentorName.getText().toString(),
                        editTextMentorEmail.getText().toString(),
                        editTextMentorPhone.getText().toString()

                ));

                startActivity(new Intent(this, MainActivity.class));
            }



        });


    }

}