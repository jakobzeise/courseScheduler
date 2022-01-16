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
import com.jakobzeise.coursescheduler.modell.TermListAdapter;

import java.util.Date;

public class TermListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_list);

        Button addTermButton = findViewById(R.id.buttonAddMentor);
        RecyclerView recyclerView = findViewById(R.id.recyclerViewTerms);

        // TODO: 15.01.22 Implement Database
        getTermsFromDatabase();
        Term[] terms = new Term[]{
                new Term("Sample Term 1", new Date(2022 - 1900, 1, 1), new Date(2022 - 1900, 1, 10)),
                new Term("Sample Term 2", new Date(2022 - 1900, 1, 20), new Date(2022 - 1900, 1, 30)),
                new Term("Sample Term 3", new Date(2022 - 1900, 2, 1), new Date(2022 - 1900, 1, 30)),

        };

        TermListAdapter termListAdapter = new TermListAdapter(terms);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(termListAdapter);

        addTermButton.setOnClickListener(v -> {
            startActivity(new Intent(this, AddTermActivity.class));
        });
    }

    public Term[] getTermsFromDatabase() {
        return new Term[]{};
    }
}