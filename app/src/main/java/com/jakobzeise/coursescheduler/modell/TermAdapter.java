package com.jakobzeise.coursescheduler.modell;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.jakobzeise.coursescheduler.R;

import java.text.SimpleDateFormat;


public class TermAdapter extends RecyclerView.Adapter<TermAdapter.ViewHolder> {

    private Term[] localDataSet;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewTermName, textViewTermDate;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            textViewTermDate = (TextView) view.findViewById(R.id.textViewEmail);
            textViewTermName = (TextView) view.findViewById(R.id.textViewMentorName);
        }

        public TextView getTextViewTermDate() {
            return textViewTermDate;
        }

        public TextView getTextViewTermName() {
            return textViewTermName;
        }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView.
     */
    public TermAdapter(Term[] dataSet) {
        localDataSet = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.terms_item_row, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM-dd-yyyy");
        String termDate = simpleDateFormat.format(localDataSet[position].startDate)
                + " to " + simpleDateFormat.format(localDataSet[position].endDate);
        viewHolder.getTextViewTermDate().setText(termDate);
        viewHolder.getTextViewTermName().setText(localDataSet[position].name);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.length;
    }
}

