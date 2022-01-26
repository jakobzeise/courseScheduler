package com.jakobzeise.coursescheduler.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Button;

import com.jakobzeise.coursescheduler.R;
import com.jakobzeise.coursescheduler.modell.AppDatabase;
import com.jakobzeise.coursescheduler.modell.DateConverter;
import com.jakobzeise.coursescheduler.modell.Term;
import com.jakobzeise.coursescheduler.modell.TermListAdapter;

import java.util.Date;
import java.util.List;

public class TermListActivity extends AppCompatActivity {

    public final String TAG = "databaseCheck";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_list);

        Button addTermButton = findViewById(R.id.buttonAddMentor);
        RecyclerView recyclerView = findViewById(R.id.recyclerViewTerms);

        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "app_database").build();

        Term[] terms1 = new Term[]{
                new Term("Sample Term 1", DateConverter.fromDate(new Date(2022 - 1900, 1, 1)), DateConverter.fromDate(new Date(2022 - 1900, 1, 10))),
                new Term("Sample Term 2", DateConverter.fromDate(new Date(2022 - 1900, 1, 1)), DateConverter.fromDate(new Date(2022 - 1900, 1, 10))),
                new Term("Sample Term 3", DateConverter.fromDate(new Date(2022 - 1900, 1, 1)), DateConverter.fromDate(new Date(2022 - 1900, 1, 10))),
                new Term("Sample Term 4", DateConverter.fromDate(new Date(2022 - 1900, 1, 1)), DateConverter.fromDate(new Date(2022 - 1900, 1, 10))),
        };


        // Get a handler that can be used to post to the main thread
        Handler mainHandler = new Handler(Looper.getMainLooper());

        // This is your code
        Runnable myRunnable = () -> {

            db.courseSchedulerDao().insertAll(terms1);
            Log.d(TAG, "onCreate: " + db.courseSchedulerDao().getAll());



        };
        mainHandler.post(myRunnable);







//        TermListAdapter termListAdapter = new TermListAdapter(terms);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        recyclerView.setAdapter(termListAdapter);

        addTermButton.setOnClickListener(v -> {
            startActivity(new Intent(this, AddTermActivity.class));
        });
    }

    public Term[] getTermsFromDatabase() {
        return new Term[]{};
    }
}