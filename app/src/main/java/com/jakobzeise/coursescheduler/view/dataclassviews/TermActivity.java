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
import android.widget.Toast;

import com.jakobzeise.coursescheduler.R;
import com.jakobzeise.coursescheduler.modell.adapters.CourseListAdapter;
import com.jakobzeise.coursescheduler.modell.adapters.TermListAdapter;
import com.jakobzeise.coursescheduler.modell.converters.CourseConverter;
import com.jakobzeise.coursescheduler.modell.database.AppDatabase;
import com.jakobzeise.coursescheduler.modell.dataclasses.Course;
import com.jakobzeise.coursescheduler.modell.dataclasses.Term;

import java.text.SimpleDateFormat;
import java.util.List;

public class TermActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term);

        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "app_database").allowMainThreadQueries().build();


        TextView textViewTermName = (TextView) findViewById(R.id.textViewTermName);
        TextView textViewStartDateTerm = (TextView) findViewById(R.id.textViewStartDateTerm);
        TextView textViewEndDateTerm = (TextView) findViewById(R.id.textViewEndDateTerm);
        Button buttonDeleteTerm = (Button) findViewById(R.id.buttonDeleteTerm);
        Button buttonGoHomeTerm = (Button) findViewById(R.id.buttonTermGoHome);
        Button addCourses = (Button) findViewById(R.id.buttonTermAddCourses);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerViewListOfCoursesInTerm);

        long termId = TermListAdapter.staticTermId;
        Term term = db.termDao().selectById((int)termId);

        addCourses.setOnClickListener(v -> {
            Course[] courses = CourseConverter.getObjectFromString(term.getCourseList()).toArray(new Course[0]);

            CourseListAdapter courseListAdapter = new CourseListAdapter(courses);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(courseListAdapter);
        });

        if (term.getCourseList() == null) {

        } else {
            List<Course> courses = CourseConverter.getObjectFromString(term.getCourseList());
            CourseListAdapter courseListAdapter = new CourseListAdapter(courses.toArray(new Course[0]));
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(courseListAdapter);
        }


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM-dd-yyyy");

        textViewTermName.setText(term.getName());
        textViewStartDateTerm.setText("StartDate: \n" + simpleDateFormat.format(term.getStartDate()));
        textViewEndDateTerm.setText("EndDate: \n" + simpleDateFormat.format(term.getEndDate()));
        buttonDeleteTerm.setOnClickListener(v -> {
            if (term.getCourseList() != null && !term.getCourseList().isEmpty()){
                Toast.makeText(this, "There are Courses assigned to this course", Toast.LENGTH_SHORT).show();
            }
                    db.termDao().delete(term);
                    Toast.makeText(this, "Term Deleted", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(this, MainActivity.class));
                }

        );

        buttonGoHomeTerm.setOnClickListener(v ->
                startActivity(new Intent(this, MainActivity.class))
        );


    }
}