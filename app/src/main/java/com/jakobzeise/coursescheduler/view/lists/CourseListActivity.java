package com.jakobzeise.coursescheduler.view.lists;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.jakobzeise.coursescheduler.R;
import com.jakobzeise.coursescheduler.modell.dataclasses.Assessment;
import com.jakobzeise.coursescheduler.modell.converters.AssessmentConverter;
import com.jakobzeise.coursescheduler.modell.dataclasses.Course;
import com.jakobzeise.coursescheduler.modell.adapters.CourseListAdapter;
import com.jakobzeise.coursescheduler.modell.converters.DateConverter;
import com.jakobzeise.coursescheduler.modell.dataclasses.Mentor;
import com.jakobzeise.coursescheduler.view.adds.AddMentorActivity;

import java.util.Arrays;
import java.util.Date;

public class CourseListActivity extends AppCompatActivity {

    Course[] courses;
    Assessment[] assessments;
    Mentor[] mentors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);


        Button addCourseButton = findViewById(R.id.buttonAddCourse);
        RecyclerView recyclerView = findViewById(R.id.recyclerViewCourses);

        // TODO: 15.01.22 Implement Database
        getMentorsFromDatabase();
        mentors = new Mentor[]{
                new Mentor("Angelina Mentor", "Angelina@web.de", "000000"),
                new Mentor("Thalia Mentor", "Thalia@web.de", "000000"),
                new Mentor("Spagone Mentor", "Spagone@web.de", "000000"),
                new Mentor("Spaghetti Mentor", "Spaghetti@web.de", "000000"),
                new Mentor("Antonio Mentor", "Antonio@web.de", "000000"),
        };

        // TODO: 16.01.22 Implement Database
        getAssessmentsFromDatabase();
        assessments = new Assessment[]{
                new Assessment(
                        "A",
                        "Very Good",
                        "Not so Good",
                        "Sample Assessment 1",
                        DateConverter.fromDate(new Date(2022 - 1900, 1, 10))
                ),
                new Assessment(
                        "A",
                        "Very Good",
                        "Not so Good",
                        "Sample Assessment 2",
                        DateConverter.fromDate(new Date(2022 - 1900, 1, 10))
                ),
                new Assessment(
                        "A",
                        "Very Good",
                        "Not so Good",
                        "Sample Assessment 3",
                        DateConverter.fromDate(new Date(2022 - 1900, 1, 10))
                ),
                new Assessment(
                        "A",
                        "Very Good",
                        "Not so Good",
                        "Sample Assessment 4",
                        DateConverter.fromDate(new Date(2022 - 1900, 1, 10))
                )

        };



        // TODO: 16.01.22 Implement Database
        getCoursesFromDatabase();
        courses = new Course[]{
                new Course(
                        "Sample Course 1",
                        DateConverter.fromDate(new Date(2022 - 1900, 1, 15)),
                        DateConverter.fromDate(new Date(2022 - 1900, 1, 15)),
                        "in Progress",
                        mentors[3].getId(),
                        AssessmentConverter.stringFromObject(Arrays.asList(assessments)),
                        "note1"
                )

        };

        CourseListAdapter courseListAdapter = new CourseListAdapter(courses);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(courseListAdapter);

        addCourseButton.setOnClickListener(v ->
                startActivity(new Intent(this, AddMentorActivity.class))
        );


    }

    public Course[] getCoursesFromDatabase() {
        return new Course[]{};
    }

    public Mentor[] getMentorsFromDatabase() {
        return new Mentor[]{};
    }

    public Assessment[] getAssessmentsFromDatabase() {
        return new Assessment[]{};
    }
}