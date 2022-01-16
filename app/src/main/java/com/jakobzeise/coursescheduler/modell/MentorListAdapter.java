package com.jakobzeise.coursescheduler.modell;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.jakobzeise.coursescheduler.R;

public class MentorListAdapter extends RecyclerView.Adapter<MentorListAdapter.ViewHolder> {

    private Mentor[] localDataSet;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewEmail, textViewMentorName;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            textViewEmail = (TextView) view.findViewById(R.id.textViewCourseDate);
            textViewMentorName = (TextView) view.findViewById(R.id.textViewCourseName);
        }

        public TextView getTextViewEmail() {
            return textViewEmail;
        }

        public TextView getTextViewMentorName() {
            return textViewMentorName;
        }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     *                by RecyclerView.
     */
    public MentorListAdapter(Mentor[] dataSet) {
        localDataSet = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.mentor_item_row, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.getTextViewMentorName().setText(localDataSet[position].name);
        viewHolder.getTextViewEmail().setText(localDataSet[position].email);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.length;
    }
}

