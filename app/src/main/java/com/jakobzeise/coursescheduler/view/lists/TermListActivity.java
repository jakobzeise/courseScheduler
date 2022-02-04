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
import com.jakobzeise.coursescheduler.modell.database.AppDatabase;
import com.jakobzeise.coursescheduler.modell.dataclasses.Term;
import com.jakobzeise.coursescheduler.modell.adapters.TermListAdapter;
import com.jakobzeise.coursescheduler.view.adds.AddTermActivity;

import java.util.List;

public class TermListActivity extends AppCompatActivity {


    TermListAdapter.OnTermItemClickListener mListener = (termId, context) -> {};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_list);

        Button addTermButton = findViewById(R.id.buttonAddTerm);
        RecyclerView recyclerView = findViewById(R.id.recyclerViewTerms);


        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "app_database").allowMainThreadQueries().build();

        List<Term> terms = db.termDao().getAll();

        TermListAdapter termListAdapter = new TermListAdapter(terms.toArray(new Term[0]), mListener, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(termListAdapter);

        addTermButton.setOnClickListener(v -> {
            startActivity(new Intent(this, AddTermActivity.class));
        });
    }

}