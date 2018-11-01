package com.salon.cattocdi.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.salon.cattocdi.R;
import com.salon.cattocdi.models.Comment;
import com.salon.cattocdi.utils.MyContants;

import java.sql.Timestamp;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentViewHolder>{


    @NonNull
    @Override
    public CommentViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.comment_card_view, viewGroup, false);
        return new CommentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentViewHolder holder, int i) {
        Comment comment = MyContants.COMMENTS[i];
        holder.rbRating.setRating(comment.getRating());
        holder.tvName.setText(comment.getCustomerName());
        holder.tvContent.setText(comment.getContent());
        holder.tvDate.setText(comment.getDate().getDate() + "/" + comment.getDate().getMonth() + "/" + comment.getDate().getYear());
    }

    @Override
    public int getItemCount() {
        return MyContants.COMMENTS.length;
    }

    public class CommentViewHolder extends RecyclerView.ViewHolder{

        public CardView item;
        public TextView tvName, tvContent, tvDate;
        public RatingBar rbRating;

        public CommentViewHolder(@NonNull View itemView) {
            super(itemView);
            this.item = (CardView) itemView;
            this.tvName = itemView.findViewById(R.id.comment_name);
            this.tvContent = itemView.findViewById(R.id.comment_content);
            this.tvDate = itemView.findViewById(R.id.comment_date);
            this.rbRating = itemView.findViewById(R.id.comment_rb);
        }
    }
}
