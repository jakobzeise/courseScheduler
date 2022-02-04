package com.jakobzeise.coursescheduler.modell.adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.jakobzeise.coursescheduler.R;
import com.jakobzeise.coursescheduler.modell.dataclasses.Mentor;

public class MentorListAdapter extends RecyclerView.Adapter<MentorListAdapter.ViewHolder> {

    private final Mentor[] localDataSet;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewEmail, textViewMentorName;

        public ViewHolder(View view) {
            super(view);

            textViewEmail = (TextView) view.findViewById(R.id.textViewCourseDate);
            textViewMentorName = (TextView) view.findViewById(R.id.textViewTermName);
        }

        public TextView getTextViewEmail() {
            return textViewEmail;
        }

        public TextView getTextViewMentorName() {
            return textViewMentorName;
        }
    }

    public MentorListAdapter(Mentor[] dataSet) {
        localDataSet = dataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.mentor_item_row, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        viewHolder.getTextViewMentorName().setText(localDataSet[position].getName());
        viewHolder.getTextViewEmail().setText(localDataSet[position].getEmail());
    }

    @Override
    public int getItemCount() {
        return localDataSet.length;
    }
}

