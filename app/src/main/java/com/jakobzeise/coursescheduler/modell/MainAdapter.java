package com.jakobzeise.coursescheduler.modell;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.jakobzeise.coursescheduler.R;
import com.jakobzeise.coursescheduler.view.AssessmentListActivity;
import com.jakobzeise.coursescheduler.view.CourseListActivity;
import com.jakobzeise.coursescheduler.view.MentorListActivity;
import com.jakobzeise.coursescheduler.view.TermListActivity;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private Type[] localDataSet;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewNumber, textViewHeading;
        private final ImageView imageViewIcon;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

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

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     *                by RecyclerView.
     */
    public MainAdapter(Type[] dataSet) {
        localDataSet = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.main_row_item, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.getTextViewHeading().setText(localDataSet[position].name);
        viewHolder.getTextViewNumber().setText(String.valueOf(localDataSet[position].numberOfItems));
        viewHolder.getImageViewIcon().setBackgroundResource(localDataSet[position].icon);
        switch (localDataSet[position].name) {
            case "Terms": {
                viewHolder.imageViewIcon.setOnClickListener(v -> viewHolder.imageViewIcon.getContext().startActivity(new Intent(viewHolder.imageViewIcon.getContext(), TermListActivity.class)));
            }
            break;
            case "Course": {
                viewHolder.imageViewIcon.setOnClickListener(v -> viewHolder.imageViewIcon.getContext().startActivity(new Intent(viewHolder.imageViewIcon.getContext(), CourseListActivity.class)));
            }
            break;
            case "Assessment": {
                viewHolder.imageViewIcon.setOnClickListener(v -> viewHolder.imageViewIcon.getContext().startActivity(new Intent(viewHolder.imageViewIcon.getContext(), AssessmentListActivity.class)));
            }
            break;
            case "Mentor": {
                viewHolder.imageViewIcon.setOnClickListener(v -> viewHolder.imageViewIcon.getContext().startActivity(new Intent(viewHolder.imageViewIcon.getContext(), MentorListActivity.class)));
            }
            break;
            default:
                throw new IllegalStateException("Unexpected value: " + localDataSet[position].name);
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.length;
    }
}
