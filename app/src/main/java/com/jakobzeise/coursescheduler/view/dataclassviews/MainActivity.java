package com.jakobzeise.coursescheduler.view.dataclassviews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.jakobzeise.coursescheduler.R;
import com.jakobzeise.coursescheduler.modell.adapters.MainAdapter;
import com.jakobzeise.coursescheduler.modell.dataclasses.Type;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.mainRecycler);

        Type[] types = new Type[]{
                new Type(R.drawable.terms, "Terms", 0),
                new Type(R.drawable.course, "Course", 0),
                new Type(R.drawable.assessment, "Assessment", 0),
                new Type(R.drawable.mentor, "Mentor", 0)
        };



        MainAdapter mainAdapter = new MainAdapter(types);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mainAdapter);


    }
}