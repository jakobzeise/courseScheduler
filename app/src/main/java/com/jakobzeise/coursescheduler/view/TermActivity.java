package com.jakobzeise.coursescheduler.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.jakobzeise.coursescheduler.R;
import com.jakobzeise.coursescheduler.modell.Term;
import com.jakobzeise.coursescheduler.modell.TermAdapter;

import java.util.Date;

public class TermActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms);

        Button addTermButton = findViewById(R.id.buttonAddTerm);
        RecyclerView recyclerView = findViewById(R.id.recyclerViewTerms);
        Term[] terms = new Term[]{
                new Term("Sample Term 1", new Date(2022-1900, 1, 1), new Date(2022-1900, 1, 10)),
                new Term("Sample Term 2", new Date(2022-1900, 1, 20), new Date(2022-1900, 1, 30)),
                new Term("Sample Term 3", new Date(2022-1900, 2, 1), new Date(2022-1900, 1, 30)),

        };

        TermAdapter termAdapter = new TermAdapter(terms);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(termAdapter);

        addTermButton.setOnClickListener(v ->{
            startActivity(new Intent(this, AddTerm.class));
        });
    }
}