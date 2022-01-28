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
import com.jakobzeise.coursescheduler.modell.dataclasses.Term;
import com.jakobzeise.coursescheduler.view.dataclassviews.TermActivity;

import java.text.SimpleDateFormat;


public class TermListAdapter extends RecyclerView.Adapter<TermListAdapter.ViewHolder> {

    private final Term[] localDataSet;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewTermName, textViewTermDate;
        private final ImageButton imageButtonEdit;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            imageButtonEdit = (ImageButton) view.findViewById(R.id.editCourseItem);
            textViewTermDate = (TextView) view.findViewById(R.id.textViewCourseDate);
            textViewTermName = (TextView) view.findViewById(R.id.textViewCourseName);
        }

        public TextView getTextViewTermDate() {
            return textViewTermDate;
        }

        public TextView getTextViewTermName() {
            return textViewTermName;
        }

        public ImageButton getImageButtonEdit() {
            return imageButtonEdit;
        }


    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     *                by RecyclerView.
     */
    public TermListAdapter(Term[] dataSet) {
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
        String termDate = simpleDateFormat.format(localDataSet[position].getStartDate())
                + " to " + simpleDateFormat.format(localDataSet[position].getEndDate());
        viewHolder.getTextViewTermDate().setText(termDate);
        viewHolder.getTextViewTermName().setText(localDataSet[position].getName());
        viewHolder.getImageButtonEdit().setOnClickListener(v -> {
            Intent intent = new Intent(viewHolder.getImageButtonEdit().getContext(), TermActivity.class)
                    .putExtra("termName", localDataSet[position].getName())
                    .putExtra("startDate", localDataSet[position].getStartDate())
                    .putExtra("endDate", localDataSet[position].getEndDate());
            viewHolder.getImageButtonEdit().getContext().startActivity(intent);

        });

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.length;
    }
}

