package com.jakobzeise.coursescheduler.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.jakobzeise.coursescheduler.R;
import com.jakobzeise.coursescheduler.modell.Mentor;
import com.jakobzeise.coursescheduler.modell.MentorAdapter;
import com.jakobzeise.coursescheduler.modell.Term;
import com.jakobzeise.coursescheduler.modell.TermAdapter;

import java.util.Date;

public class MentorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mentor);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewMentors);
        Mentor[] mentors = new Mentor[]{
                new Mentor("Angelina Mentor", "Angelina@web.de"),
                new Mentor("Thalia Mentor", "Thalia@web.de"),
                new Mentor("Spagone Mentor", "Spagone@web.de"),
                new Mentor("Spaghetti Mentor", "Spaghetti@web.de"),
                new Mentor("Antonio Mentor", "Antonio@web.de"),
        };

        MentorAdapter mentorAdapter = new MentorAdapter(mentors);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mentorAdapter);
    }
}