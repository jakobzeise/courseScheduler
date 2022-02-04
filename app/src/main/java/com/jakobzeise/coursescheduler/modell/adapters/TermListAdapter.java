package com.jakobzeise.coursescheduler.modell.adapters;


import android.annotation.SuppressLint;
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
import com.jakobzeise.coursescheduler.modell.dataclasses.Term;
import com.jakobzeise.coursescheduler.view.dataclassviews.TermActivity;

import java.text.SimpleDateFormat;


public class TermListAdapter extends RecyclerView.Adapter<TermListAdapter.ViewHolder> {

    public static long badIdTerm;
    private final Term[] localDataSet;
    OnTermItemClickListener listener;
    Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewTermName, textViewTermDate;
        private final ImageButton imageButtonEdit;

        public ViewHolder(View view) {
            super(view);

            imageButtonEdit = (ImageButton) view.findViewById(R.id.editCourseItem);
            textViewTermDate = (TextView) view.findViewById(R.id.textViewCourseDate);
            textViewTermName = (TextView) view.findViewById(R.id.textViewTermName);

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

    public TermListAdapter(Term[] dataSet, OnTermItemClickListener listener, Context context) {
        localDataSet = dataSet;
        this.listener = listener;
        this.context = context;
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

        @SuppressLint("SimpleDateFormat") SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM-dd-yyyy");
        String termDate = simpleDateFormat.format(localDataSet[position].getStartDate())
                + " to " + simpleDateFormat.format(localDataSet[position].getEndDate());
        viewHolder.getTextViewTermDate().setText(termDate);
        viewHolder.getTextViewTermName().setText(localDataSet[position].getName());
        viewHolder.getImageButtonEdit().setOnClickListener(v -> {
            listener.onClick(localDataSet[position].getId(), viewHolder.getImageButtonEdit().getContext());
            badIdTerm = localDataSet[position].getId();

            Intent intent = new Intent(viewHolder.getImageButtonEdit().getContext(), TermActivity.class);
            viewHolder.getImageButtonEdit().getContext().startActivity(intent);

        });

    }

    @Override
    public int getItemCount() {
        return localDataSet.length;
    }

    public interface OnTermItemClickListener{
        void onClick(long termId, Context context);
    }
}

