package com.salon.cattocdi.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.salon.cattocdi.R;
import com.salon.cattocdi.SalonAppointmentActivity;
import com.salon.cattocdi.SalonDetailActivity;
import com.salon.cattocdi.utils.MyContants;

import static com.salon.cattocdi.utils.MyContants.RV_ITEM_NORMAL;
import static com.salon.cattocdi.utils.MyContants.RV_ITEM_VOUCHER;
import static com.salon.cattocdi.utils.MyContants.SALONS;

public class SalonAdapter extends RecyclerView.Adapter<SalonAdapter.MyCardViewHolder> {

    private int type;
    private Context context;
    private boolean isFavorite = false;

    public SalonAdapter(int type, Context context) {
        this.context = context;
        this.type = type;
    }

    public SalonAdapter(boolean isFavorite, int type, Context context) {
        this.context = context;
        this.type = type;
        this.isFavorite = isFavorite;
    }

    @NonNull
    @Override
    public MyCardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView;
        if (type == MyContants.RV_ITEM_NORMAL) {
            itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycle_view_item_salon_rating, viewGroup, false);
        } else if (type == RV_ITEM_VOUCHER) {
            itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycle_view_item_salon_voucher, viewGroup, false);
        } else{
            itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycle_view_item_salon_rating, viewGroup, false);
        }
        return new MyCardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyCardViewHolder myCardViewHolder, final int i) {

//        myCardViewHolder.salonRatingBar.setRating(4.6f);
        if (type == RV_ITEM_NORMAL) {
            myCardViewHolder.salonTitle.setText(MyContants.SalonList.get(i).getName());
            myCardViewHolder.salonAddress.setText(MyContants.SalonList.get(i).getAddress());
            myCardViewHolder.tvDiscount.setText(MyContants.SalonList.get(i).getDiscount() + "% OFF");
            myCardViewHolder.salonRatingBar.setRating(MyContants.SalonList.get(i).getRatingNumber());
            if(myCardViewHolder.salonReviewsAmount != null){
                myCardViewHolder.salonReviewsAmount.setText("("+MyContants.SalonList.get(i).getReviewsAmount()+")");
            }
        }

        myCardViewHolder.salonImage.setBackgroundResource(MyContants.SALON_IMAGE_IDS[i]);


        myCardViewHolder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SalonDetailActivity.class);
                Bundle options = ActivityOptionsCompat.makeScaleUpAnimation(
                        myCardViewHolder.item, 0, 0, myCardViewHolder.item.getWidth(), myCardViewHolder.item.getHeight()).toBundle();
                intent.putExtra("salon_id", i);
                ActivityCompat.startActivity(context, intent, options);

            }
        });
        if (type == RV_ITEM_NORMAL) {

            Button btnBook;
            btnBook = myCardViewHolder.item.findViewById(R.id.btn_book_service);
            btnBook.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, SalonAppointmentActivity.class);
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return MyContants.SalonList.size();
    }

    public class MyCardViewHolder extends RecyclerView.ViewHolder {

        public View salonImage;
        public TextView salonTitle, salonAddress, salonReviewsAmount;
        public RatingBar salonRatingBar;
        public CardView item;
        public ImageView icFavorite;
        public TextView tvDiscount;


        public MyCardViewHolder(@NonNull View itemView) {
            super(itemView);
            salonTitle = itemView.findViewById(R.id.fg_home_rv_item_title_tv);
            salonAddress = itemView.findViewById(R.id.fg_home_rv_item_address_tv);
            salonReviewsAmount = itemView.findViewById(R.id.fg_home_rv_item_amount_review_tv);
            salonRatingBar = itemView.findViewById(R.id.fg_home_rv_item_rb);
            salonImage = itemView.findViewById(R.id.fg_home_rv_item_img);
            icFavorite = itemView.findViewById(R.id.fg_home_rv_item_favorite_ic);
            tvDiscount = itemView.findViewById(R.id.rv_discount);
            item = (CardView) itemView;
        }
    }
}
