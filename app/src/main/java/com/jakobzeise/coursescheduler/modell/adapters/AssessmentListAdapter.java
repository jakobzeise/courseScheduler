package com.jakobzeise.coursescheduler.modell.adapters;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jakobzeise.coursescheduler.R;
import com.jakobzeise.coursescheduler.modell.dataclasses.Assessment;
import com.jakobzeise.coursescheduler.view.dataclassviews.AssessmentActivity;
import com.jakobzeise.coursescheduler.view.dataclassviews.TermActivity;

public class AssessmentListAdapter extends RecyclerView.Adapter<AssessmentListAdapter.ViewHolder> {

    public static long staticTermId;
    private final Assessment[] localDataSet;
    Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewAssessmentEndDate, textViewAssessmentName;
        private final ImageButton imageButtonEdit;

        public ViewHolder(View view) {
            super(view);

            imageButtonEdit = (ImageButton) view.findViewById(R.id.editAssessmentItem);
            textViewAssessmentEndDate = (TextView) view.findViewById(R.id.textViewCourseItemDate);
            textViewAssessmentName = (TextView) view.findViewById(R.id.textViewAssessmentItemName);

        }

        public ImageButton getImageButtonEdit() {
            return imageButtonEdit;
        }

        public TextView getTextViewAssessmentEndDate(){
            return textViewAssessmentEndDate;
        }

        public TextView getTextViewAssessmentName(){
            return textViewAssessmentName;
        }

    }

    public AssessmentListAdapter(Assessment[] dataSet) {
        localDataSet = dataSet;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.term_item_row, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {


        viewHolder.getImageButtonEdit().setOnClickListener(v -> {
            staticTermId = localDataSet[position].getId();

            viewHolder.itemView.getContext().startActivity(
                    new Intent(viewHolder.itemView.getContext(), AssessmentActivity.class)
            );

        });

    }

    @Override
    public int getItemCount() {
        return localDataSet.length;
    }


}

