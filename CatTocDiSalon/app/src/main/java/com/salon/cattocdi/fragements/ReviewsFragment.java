package com.salon.cattocdi.fragements;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.salon.cattocdi.R;
import com.salon.cattocdi.adapters.CommentAdapter;
import com.salon.cattocdi.models.Salon;
import com.salon.cattocdi.utils.MyContants;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the

 * to handle interaction events.
 */
public class ReviewsFragment extends Fragment {

    private int salonId;
    private RatingBar tvRatingNumber;
    private TextView tvTotalReviews;
    private RecyclerView rvComments;


    public ReviewsFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public ReviewsFragment(int salonId) {
        this.salonId = salonId;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reviews, container, false);

        Salon salon = MyContants.SALONS[salonId];

        tvRatingNumber = view.findViewById(R.id.fg_reviews_sum);
        tvRatingNumber.setRating(salon.getRatingNumber());

        tvTotalReviews = view.findViewById(R.id.salon_detail_total_reviews_tv);
        tvTotalReviews.setText(salon.getReviewsAmount() + " Đánh giá");

        rvComments = view.findViewById(R.id.salon_detail_comment_rv);
        ViewCompat.setNestedScrollingEnabled(rvComments, false);
        rvComments.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        rvComments.setAdapter(new CommentAdapter());

        return view;
    }


}
