package com.salon.cattocdi.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CheckedTextView;

import com.salon.cattocdi.R;
import com.salon.cattocdi.utils.Model;

import java.util.ArrayList;
import java.util.List;

public class SuggestServiceCardAdapter extends RecyclerView.Adapter<SuggestServiceCardAdapter.ViewHolder> {

    private List<Model> items = new ArrayList<>();
    public SuggestServiceCardAdapter() {
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutForItem = R.layout.recycle_view_service;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layoutForItem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        if (items == null) {
            return 0;
        }
        return items.size();
    }

    public void loadItems(List<Model> listServices) {
        this.items = listServices;
        notifyDataSetChanged();
    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        CheckedTextView mCheckedTextView;

        ViewHolder(View itemView) {
            super(itemView);
            mCheckedTextView = itemView.findViewById(R.id.checked_text_view);
            itemView.setOnClickListener(this);
        }

        void bind(int position) {
            // check the state of the model
            if (!items.get(position).getChecked()) {
                mCheckedTextView.setChecked(false);}
            else {
                mCheckedTextView.setChecked(true);
            }
            //mCheckedTextView.setText(String.valueOf(items.get(position).getItem()));

            mCheckedTextView.setText(items.get(position).getItem());
        }

        @Override
        public void onClick(View v) {
            int adapterPosition = getAdapterPosition();
            if (!items.get(adapterPosition).getChecked()) {
                mCheckedTextView.setChecked(true);
                items.get(adapterPosition).setChecked(true);
            }
            else  {
                mCheckedTextView.setChecked(false);
                items.get(adapterPosition).setChecked(false);
            }
        }

    }
}
