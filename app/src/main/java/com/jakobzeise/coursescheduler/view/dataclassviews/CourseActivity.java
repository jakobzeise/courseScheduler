package com.jakobzeise.coursescheduler.view.dataclassviews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.jakobzeise.coursescheduler.R;

public class CourseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
    }
}