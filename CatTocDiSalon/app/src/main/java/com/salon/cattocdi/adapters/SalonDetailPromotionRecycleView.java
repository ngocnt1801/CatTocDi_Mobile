package com.salon.cattocdi.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.salon.cattocdi.R;

public class SalonDetailPromotionRecycleView extends RecyclerView.Adapter<SalonDetailPromotionRecycleView.PromotionViewHolder>{

    @NonNull
    @Override
    public PromotionViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_salon_detail_promotion_recycle_view, viewGroup, false);
        return new PromotionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PromotionViewHolder promotionViewHolder, int i) {

    }
    @Override
    public int getItemCount() {
        return 1;
    }

    public class PromotionViewHolder extends RecyclerView.ViewHolder{
        public View item;
        public PromotionViewHolder(@NonNull View itemView) {
            super(itemView);
            this.item = itemView;
        }
    }
}
