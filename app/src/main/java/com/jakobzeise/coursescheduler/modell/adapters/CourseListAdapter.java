package com.jakobzeise.coursescheduler.modell.adapters;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jakobzeise.coursescheduler.R;
import com.jakobzeise.coursescheduler.modell.dataclasses.Course;
import com.jakobzeise.coursescheduler.view.dataclassviews.CourseActivity;

import java.text.SimpleDateFormat;


public class CourseListAdapter extends RecyclerView.Adapter<CourseListAdapter.ViewHolder> {

    public static long staticCourseId;
    private final Course[] localDataSet;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewCourseName, textViewCourseDate;
        private final ImageButton imageButtonEditCourse;

        public ViewHolder(View view) {
            super(view);

            imageButtonEditCourse = (ImageButton) view.findViewById(R.id.editCourseItem);
            textViewCourseDate = (TextView) view.findViewById(R.id.textViewCourseItemDate);
            textViewCourseName = (TextView) view.findViewById(R.id.textViewCourseItemName);
        }

        public TextView getTextViewCourseName() {
            return textViewCourseName;
        }

        public TextView getTextViewCourseDate() {
            return textViewCourseDate;
        }

        public ImageButton getImageButtonEditCourse() {
            return imageButtonEditCourse;
        }


    }

    public CourseListAdapter(Course[] dataSet) {
        localDataSet = dataSet;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.course_item_row, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        @SuppressLint("SimpleDateFormat") SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM-dd-yyyy");

        String courseDate = simpleDateFormat.format(localDataSet[position].getStartDate())
                + " to " + simpleDateFormat.format(localDataSet[position].getEndDate());

        viewHolder.getTextViewCourseDate().setText(courseDate);
        viewHolder.getTextViewCourseName().setText(localDataSet[position].getTitle());

        viewHolder.getImageButtonEditCourse().setOnClickListener(v -> {
            CourseListAdapter.staticCourseId = localDataSet[position].getId();
            viewHolder.itemView.getContext().startActivity(new Intent(viewHolder.itemView.getContext(), CourseActivity.class));

        });

    }


    @Override
    public int getItemCount() {
        return localDataSet.length;
    }
}

