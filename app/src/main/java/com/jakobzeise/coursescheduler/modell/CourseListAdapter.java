package com.jakobzeise.coursescheduler.modell;


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
import com.jakobzeise.coursescheduler.view.TermActivity;

import java.text.SimpleDateFormat;


public class CourseListAdapter extends RecyclerView.Adapter<CourseListAdapter.ViewHolder> {

    private final Course[] localDataSet;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewCourseName, textViewCourseDate;
        private final ImageButton imageButtonEditCourse;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            imageButtonEditCourse = (ImageButton) view.findViewById(R.id.editCourseItem);
            textViewCourseDate = (TextView) view.findViewById(R.id.textViewCourseDate);
            textViewCourseName = (TextView) view.findViewById(R.id.textViewCourseName);
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

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     *                by RecyclerView.
     */
    public CourseListAdapter(Course[] dataSet) {
        localDataSet = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.term_item_row, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        @SuppressLint("SimpleDateFormat") SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM-dd-yyyy");
        String termDate = simpleDateFormat.format(localDataSet[position].startDate)
                + " to " + simpleDateFormat.format(localDataSet[position].endDate);
        viewHolder.getTextViewCourseDate().setText(termDate);
        viewHolder.getTextViewCourseName().setText(localDataSet[position].title);
        viewHolder.getImageButtonEditCourse().setOnClickListener(v -> {
            Intent intent = new Intent(viewHolder.getImageButtonEditCourse().getContext(), TermActivity.class)
                    .putExtra("termName", localDataSet[position].title)
                    .putExtra("startDate", localDataSet[position].startDate)
                    .putExtra("endDate", localDataSet[position].endDate);
            viewHolder.getImageButtonEditCourse().getContext().startActivity(intent);

        });

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.length;
    }
}

