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
import com.salon.cattocdi.TestTabActivity;
import com.salon.cattocdi.utils.MyContants;

import static com.salon.cattocdi.utils.MyContants.RV_ITEM_NORMAL;
import static com.salon.cattocdi.utils.MyContants.RV_ITEM_VOUCHER;

public class TestRecycleViewAdapter extends RecyclerView.Adapter<TestRecycleViewAdapter.MyCardViewHolder> {

    private int type;
    private Context context;


    private boolean isFavorite = false;
    /*public static final int TYPE_RATING = 1;
    public static int TYPE_VOUCHER = 2;
    public static int TYPE_NEW = 3;*/

    public TestRecycleViewAdapter(int type, Context context) {
        this.context = context;
        this.type = type;
    }

    public TestRecycleViewAdapter(boolean isFavorite, int type, Context context) {
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
        } else if (type == MyContants.RV_ITEM_NEW) {
            itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycle_view_item_salon_new, viewGroup, false);
        } else {
            itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycle_view_item_salon_new, viewGroup, false);
        }
        return new MyCardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyCardViewHolder myCardViewHolder, int i) {

//        myCardViewHolder.salonRatingBar.setRating(4.6f);
        if(myCardViewHolder.salonTitle != null && myCardViewHolder.salonAddress != null && myCardViewHolder.tvDiscount != null){
            myCardViewHolder.salonTitle.setText("Cửa hàng " + (i + 1));
            //myCardViewHolder.salonReviewsAmount.setText("(" + (i * 10) + ")");
            if (i == 0){
                myCardViewHolder.salonAddress.setText(i + i + 1 + " Trường Chinh,Q.12");
                //myCardViewHolder.tvDistance.setText("0.2km");
            }if(i == 1){
                myCardViewHolder.salonAddress.setText(i + i + i + " Phan Văn Trị,Q.12");
                //myCardViewHolder.tvDistance.setText("0.4km");
            }if(i == 2){
                myCardViewHolder.salonTitle.setText("Beautiful Hair");
                //myCardViewHolder.tvDistance.setText("0.5km");
            }
            if (i == 3){
                myCardViewHolder.salonAddress.setText(i + i + i + " Cây Trâm,Q.12");
                //myCardViewHolder.tvDistance.setText("0.7km");
            }
            if (i == 4){
                myCardViewHolder.salonAddress.setText(i + i + i + " Sư Vạn Hạnh,Q.10");
               // myCardViewHolder.tvDistance.setText("0.8km");
            }
            if (i == 5){
                myCardViewHolder.salonAddress.setText(i + i + i + " Quang Trung,Q.12");
            }
            if (i == 6){
                myCardViewHolder.salonAddress.setText(i + i + i + " Trường Chinh,Q.12");
            }
            if (i == 7){
                myCardViewHolder.salonAddress.setText(i + i + i + " Lê Quí Đôn,Q.12");
            }
            if (i == 8){
                myCardViewHolder.salonAddress.setText(i + i + i + " Nguyễn Kiệm,Q.12");
               // myCardViewHolder.tvDistance.setText("1.2km");
            }
            if (i == 9){
                myCardViewHolder.salonAddress.setText(i + i + i + " Quang Trung,Q.12");
                //myCardViewHolder.tvDistance.setText("1.4km");
            }

            myCardViewHolder.tvDiscount.setText((((i + 1) * 5) + 15) + " % OFF");
        }
        if(type == RV_ITEM_NORMAL){
            if (i == 0){

                myCardViewHolder.tvDistance.setText("0.2km");
            }if(i == 1){

                myCardViewHolder.tvDistance.setText("0.4km");
            }if(i == 2){

                myCardViewHolder.tvDistance.setText("0.5km");
            }
            if (i == 3){

                myCardViewHolder.tvDistance.setText("0.7km");
            }
            if (i == 4){

                 myCardViewHolder.tvDistance.setText("0.8km");
            }
            if (i == 5){

            }
            if (i == 8){

                 myCardViewHolder.tvDistance.setText("1.2km");
            }
            if (i == 9){

                myCardViewHolder.tvDistance.setText("1.4km");
            }
        }

        myCardViewHolder.salonImage.setBackgroundResource(MyContants.SALON_IMAGE_IDS[i]);


        myCardViewHolder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SalonDetailActivity.class);
                Bundle options = ActivityOptionsCompat.makeScaleUpAnimation(
                        myCardViewHolder.item, 0, 0, myCardViewHolder.item.getWidth(), myCardViewHolder.item.getHeight()).toBundle();
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
      /* myCardViewHolder.btnBook.setOnClickListener(new View.OnClickListener() {
          @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SalonAppointmentActivity.class);
                context.startActivity(intent);
            }
        });*/


        if (isFavorite) {
            myCardViewHolder.icFavorite.setImageResource(R.drawable.ic_favorite_fill);
        }
        if (myCardViewHolder.icFavorite != null) {
            myCardViewHolder.icFavorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (myCardViewHolder.icFavorite.getDrawable().getConstantState().equals(context.getDrawable(R.drawable.ic_favorite_border).getConstantState())) {
                        myCardViewHolder.icFavorite.setImageResource(R.drawable.ic_favorite_fill);
                    } else {
                        myCardViewHolder.icFavorite.setImageResource(R.drawable.ic_favorite_border);
                    }
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class MyCardViewHolder extends RecyclerView.ViewHolder {

        public View salonImage;
        public TextView salonTitle, salonAddress, salonReviewsAmount;
        public RatingBar salonRatingBar;
        public RelativeLayout searchService;
        public CardView item;
        public ImageView icFavorite;
        public TextView tvDiscount;
        public TextView tvDistance;
        //public Button btnBook;


        public MyCardViewHolder(@NonNull View itemView) {
            super(itemView);
//            salonImage = itemView.findViewById(R.id.fg_home_rv_item_img);
            salonTitle = itemView.findViewById(R.id.fg_home_rv_item_title_tv);
            salonAddress = itemView.findViewById(R.id.fg_home_rv_item_address_tv);
            salonReviewsAmount = itemView.findViewById(R.id.fg_home_rv_item_amount_review_tv);
            salonRatingBar = itemView.findViewById(R.id.fg_home_rv_item_rb);
            salonImage = itemView.findViewById(R.id.fg_home_rv_item_img);
            tvDistance = itemView.findViewById(R.id.fg_home_rv_item_time_tv);
            icFavorite = itemView.findViewById(R.id.fg_home_rv_item_favorite_ic);
            tvDiscount = itemView.findViewById(R.id.rv_discount);
            //btnBook = itemView.findViewById(R.id.btn_book_service);
            item = (CardView) itemView;
        }
    }
}
