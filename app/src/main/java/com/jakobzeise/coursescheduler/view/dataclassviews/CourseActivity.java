package com.jakobzeise.coursescheduler.view.dataclassviews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.jakobzeise.coursescheduler.R;
import com.jakobzeise.coursescheduler.modell.adapters.CourseListAdapter;
import com.jakobzeise.coursescheduler.modell.converters.CourseConverter;
import com.jakobzeise.coursescheduler.modell.database.AppDatabase;
import com.jakobzeise.coursescheduler.modell.dataclasses.Course;
import com.jakobzeise.coursescheduler.view.lists.CourseListActivity;

import java.text.SimpleDateFormat;
import java.util.List;

public class CourseActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "app_database").allowMainThreadQueries().build();


        TextView textViewCourseName = (TextView) findViewById(R.id.textViewCourseName);
        TextView textViewStartDateCourse = (TextView) findViewById(R.id.textViewStartDateCourse);
        TextView textViewEndDateCourse = (TextView) findViewById(R.id.textViewEndDateCourse);
        Button buttonDeleteCourse = (Button) findViewById(R.id.buttonDeleteCourse);
        Button buttonAddMentor = (Button) findViewById(R.id.buttonCoursesAddMentors);
        Button addCourses = (Button) findViewById(R.id.buttonCoursesAddAssessments);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerViewListOfAssessmentsInCourse);

        long courseId = CourseListAdapter.staticCourseId;
        Course course = db.courseDao().selectById((int)courseId);

        addCourses.setOnClickListener(v -> {
            Course[] courses = db.courseDao().getAll().toArray(new Course[0]);

            CourseListAdapter courseListAdapter = new CourseListAdapter(courses);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(courseListAdapter);
        });

//        if(course.getAssessmentList() == null){
//
//        }
//        else {
//            List<Course> courses = CourseConverter.getObjectFromString(term.getCourseList());
//            CourseListAdapter courseListAdapter = new CourseListAdapter(courses.toArray(new Course[0]));
//            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
//            recyclerView.setLayoutManager(layoutManager);
//            recyclerView.setItemAnimator(new DefaultItemAnimator());
//            recyclerView.setAdapter(courseListAdapter);
//        }



        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM-dd-yyyy");

        textViewCourseName.setText(course.getTitle());
        textViewStartDateCourse.setText("StartDate: \n" + simpleDateFormat.format(course.getStartDate()));
        textViewEndDateCourse.setText("EndDate: \n" + simpleDateFormat.format(course.getEndDate()));
        buttonDeleteCourse.setOnClickListener(v ->{
            db.courseDao().delete(course);
            startActivity(new Intent(this, CourseListActivity.class));
                }

        );

        buttonAddMentor.setOnClickListener(v ->
                startActivity(new Intent(this, MainActivity.class))
        );


    }
}