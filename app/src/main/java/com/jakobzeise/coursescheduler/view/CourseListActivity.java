package com.jakobzeise.coursescheduler.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.jakobzeise.coursescheduler.R;
import com.jakobzeise.coursescheduler.modell.Assessment;
import com.jakobzeise.coursescheduler.modell.Course;
import com.jakobzeise.coursescheduler.modell.CourseListAdapter;
import com.jakobzeise.coursescheduler.modell.Mentor;
import com.jakobzeise.coursescheduler.modell.MentorListAdapter;

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
                        new Date(2022 - 1900, 1, 10)
                ),
                new Assessment(
                        "A",
                        "Very Good",
                        "Not so Good",
                        "Sample Assessment 2",
                        new Date(2022 - 1900, 1, 10)
                ),
                new Assessment(
                        "A",
                        "Very Good",
                        "Not so Good",
                        "Sample Assessment 3",
                        new Date(2022 - 1900, 1, 10)
                ),
                new Assessment(
                        "A",
                        "Very Good",
                        "Not so Good",
                        "Sample Assessment 4",
                        new Date(2022 - 1900, 1, 10)
                )

        };


        // TODO: 16.01.22 Implement Database
        getCoursesFromDatabase();
        courses = new Course[]{
                new Course(
                        "Sample Course 1",
                        new Date(2022 - 1900, 1, 15),
                        new Date(2022 - 1900, 5, 15),
                        "in Progress",
                        mentors[3],
                        assessments,
                        new String[]{"I hate this course lol"}
                ),
                new Course(
                        "Sample Course 2",
                        new Date(2022 - 1900, 1, 15),
                        new Date(2022 - 1900, 5, 15),
                        "in Progress",
                        mentors[3],
                        assessments,
                        new String[]{"I hate this course lol"}
                ),
                new Course(
                        "Sample Course 3",
                        new Date(2022 - 1900, 1, 15),
                        new Date(2022 - 1900, 5, 15),
                        "in Progress",
                        mentors[3],
                        assessments,
                        new String[]{"I hate this course lol"}
                ),
                new Course(
                        "Sample Course 4",
                        new Date(2022 - 1900, 1, 15),
                        new Date(2022 - 1900, 5, 15),
                        "in Progress",
                        mentors[3],
                        assessments,
                        new String[]{"I hate this course lol"}
                ),
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