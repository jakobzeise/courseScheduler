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
import com.jakobzeise.coursescheduler.modell.adapters.AssessmentListAdapter;
import com.jakobzeise.coursescheduler.modell.database.AppDatabase;
import com.jakobzeise.coursescheduler.modell.dataclasses.Assessment;
import com.jakobzeise.coursescheduler.view.adds.AddAssessmentActivity;

import java.util.List;

public class AssessmentListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assessment_list);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerViewAssessments);
        Button addAssessment = (Button) findViewById(R.id.buttonAddAssessment);

        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "app_database").allowMainThreadQueries().build();


        List<Assessment> assessments = db.assessDao().getAll();

        AssessmentListAdapter assessmentListAdapter = new AssessmentListAdapter(assessments.toArray(new Assessment[0]));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(assessmentListAdapter);

        addAssessment.setOnClickListener(v -> startActivity(new Intent(this, AddAssessmentActivity.class)));



    }
}