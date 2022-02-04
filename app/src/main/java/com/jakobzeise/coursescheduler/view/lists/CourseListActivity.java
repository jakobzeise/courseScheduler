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
import com.jakobzeise.coursescheduler.modell.dataclasses.Assessment;
import com.jakobzeise.coursescheduler.modell.converters.AssessmentConverter;
import com.jakobzeise.coursescheduler.modell.dataclasses.Course;
import com.jakobzeise.coursescheduler.modell.adapters.CourseListAdapter;
import com.jakobzeise.coursescheduler.modell.converters.DateConverter;
import com.jakobzeise.coursescheduler.modell.dataclasses.Mentor;
import com.jakobzeise.coursescheduler.modell.dataclasses.Term;
import com.jakobzeise.coursescheduler.view.adds.AddCourseActivity;
import com.jakobzeise.coursescheduler.view.adds.AddMentorActivity;
import com.jakobzeise.coursescheduler.view.adds.AddTermActivity;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class CourseListActivity extends AppCompatActivity {

    Assessment[] assessments;
    Mentor[] mentors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);


        Button addCourseButton = findViewById(R.id.buttonAddCourse);
        RecyclerView recyclerView = findViewById(R.id.recyclerViewCourses);

        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "app_database").allowMainThreadQueries().build();

        List<Course> courses = db.courseDao().getAll();

        CourseListAdapter courseListAdapter = new CourseListAdapter(courses.toArray(new Course[0]));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(courseListAdapter);


        addCourseButton.setOnClickListener(v ->
                startActivity(new Intent(this, AddCourseActivity.class))
        );


    }

}