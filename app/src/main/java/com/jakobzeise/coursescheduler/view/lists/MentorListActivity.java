package com.jakobzeise.coursescheduler.view.lists;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.jakobzeise.coursescheduler.R;
import com.jakobzeise.coursescheduler.modell.adapters.TermListAdapter;
import com.jakobzeise.coursescheduler.modell.database.AppDatabase;
import com.jakobzeise.coursescheduler.modell.dataclasses.Mentor;
import com.jakobzeise.coursescheduler.modell.adapters.MentorListAdapter;
import com.jakobzeise.coursescheduler.modell.dataclasses.Term;
import com.jakobzeise.coursescheduler.view.adds.AddMentorActivity;

import java.util.List;

public class MentorListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mentor_list);

        Button buttonAddMentor = (Button) findViewById(R.id.buttonAddTerm);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewMentors);

        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "app_database").allowMainThreadQueries().build();

        List<Mentor> mentors = db.mentorDao().getAll();

        MentorListAdapter mentorListAdapter = new MentorListAdapter(mentors.toArray(new Mentor[0]));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mentorListAdapter);

        buttonAddMentor.setOnClickListener(v ->
                startActivity(new Intent(this, AddMentorActivity.class))
        );

    }

}