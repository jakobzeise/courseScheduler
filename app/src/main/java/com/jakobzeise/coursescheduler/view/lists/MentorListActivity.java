package com.jakobzeise.coursescheduler.view.lists;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.jakobzeise.coursescheduler.R;
import com.jakobzeise.coursescheduler.modell.dataclasses.Mentor;
import com.jakobzeise.coursescheduler.modell.adapters.MentorListAdapter;
import com.jakobzeise.coursescheduler.view.adds.AddMentorActivity;

public class MentorListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mentor_list);

        Button buttonAddMentor = (Button) findViewById(R.id.buttonAddTerm);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewMentors);

        // TODO: 15.01.22 Implement Database
        getMentorsFromDatabase();
        Mentor[] mentors = new Mentor[]{
                new Mentor("Angelina Mentor", "Angelina@web.de", "000000"),
                new Mentor("Thalia Mentor", "Thalia@web.de", "000000"),
                new Mentor("Spagone Mentor", "Spagone@web.de", "000000"),
                new Mentor("Spaghetti Mentor", "Spaghetti@web.de", "000000"),
                new Mentor("Antonio Mentor", "Antonio@web.de", "000000"),
        };

        MentorListAdapter mentorListAdapter = new MentorListAdapter(mentors);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mentorListAdapter);

        buttonAddMentor.setOnClickListener(v ->
                startActivity(new Intent(this, AddMentorActivity.class))
        );

    }

    public Mentor[] getMentorsFromDatabase() {
        return new Mentor[]{};
    }
}