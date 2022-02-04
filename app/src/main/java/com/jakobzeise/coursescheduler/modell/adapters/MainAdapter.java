package com.jakobzeise.coursescheduler.modell.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.jakobzeise.coursescheduler.R;
import com.jakobzeise.coursescheduler.modell.database.AppDatabase;
import com.jakobzeise.coursescheduler.modell.dataclasses.Type;
import com.jakobzeise.coursescheduler.view.lists.AssessmentListActivity;
import com.jakobzeise.coursescheduler.view.lists.CourseListActivity;
import com.jakobzeise.coursescheduler.view.lists.MentorListActivity;
import com.jakobzeise.coursescheduler.view.lists.TermListActivity;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private final Type[] localDataSet;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewNumber, textViewHeading;
        private final ImageView imageViewIcon;

        public ViewHolder(View view) {
            super(view);

            textViewNumber = (TextView) view.findViewById(R.id.textViewNumber);
            textViewHeading = (TextView) view.findViewById(R.id.textViewHeading);
            imageViewIcon = (ImageView) view.findViewById(R.id.imageViewIcon);
        }

        public TextView getTextViewHeading() {
            return textViewHeading;
        }

        public TextView getTextViewNumber() {
            return textViewNumber;
        }

        public ImageView getImageViewIcon() {
            return imageViewIcon;
        }
    }

    public MainAdapter(Type[] dataSet) {
        localDataSet = dataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.main_row_item, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        AppDatabase db = Room.databaseBuilder(viewHolder.itemView.getContext(),
                AppDatabase.class, "app_database").allowMainThreadQueries().build();

        db.termDao().getAll().size();

        viewHolder.getTextViewHeading().setText(localDataSet[position].getName());

        viewHolder.getImageViewIcon().setBackgroundResource(localDataSet[position].getIcon());
        switch (localDataSet[position].getName()) {
            case "Terms": {
                viewHolder.getTextViewNumber().setText(String.valueOf(db.termDao().getAll().size()));
                viewHolder.imageViewIcon.setOnClickListener(v ->
                        viewHolder.imageViewIcon.getContext().startActivity(new Intent(viewHolder.imageViewIcon.getContext(), TermListActivity.class)));
            }
            break;
            case "Course": {
                viewHolder.getTextViewNumber().setText(String.valueOf(db.courseDao().getAll().size()));
                viewHolder.imageViewIcon.setOnClickListener(v ->
                        viewHolder.imageViewIcon.getContext().startActivity(new Intent(viewHolder.imageViewIcon.getContext(), CourseListActivity.class)));
            }
            break;
            case "Assessment": {
                viewHolder.getTextViewNumber().setText(String.valueOf(db.assessDao().getAll().size()));
                viewHolder.imageViewIcon.setOnClickListener(v ->
                        viewHolder.imageViewIcon.getContext().startActivity(new Intent(viewHolder.imageViewIcon.getContext(), AssessmentListActivity.class)));
            }
            break;
            case "Mentor": {
                viewHolder.getTextViewNumber().setText(String.valueOf(db.mentorDao().getAll().size()));
                viewHolder.imageViewIcon.setOnClickListener(v ->
                        viewHolder.imageViewIcon.getContext().startActivity(new Intent(viewHolder.imageViewIcon.getContext(), MentorListActivity.class)));
            }
            break;
            default:
                throw new IllegalStateException("Unexpected value: " + localDataSet[position].getName());
        }
    }

    @Override
    public int getItemCount() {
        return localDataSet.length;
    }
}
