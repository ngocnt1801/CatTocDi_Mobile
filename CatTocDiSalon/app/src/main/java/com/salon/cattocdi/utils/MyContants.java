package com.salon.cattocdi.utils;

import com.salon.cattocdi.R;
import com.salon.cattocdi.models.Salon;

public class MyContants {
   public static final String PHONE_TEST = "0123456789";
   public static final String PASSWORD_TEST = "123";
   public static final int RV_ITEM_VOUCHER = 1;
   public static final int RV_ITEM_NEW = 2;
   public static final int RV_ITEM_NORMAL = 3;
   public static final int[] SALON_IMAGE_IDS = {
           R.drawable.salon1,
           R.drawable.salon2,
           R.drawable.salon3,
           R.drawable.salon4,
           R.drawable.salon5,
           R.drawable.salon6,
           R.drawable.salon7,
           R.drawable.salon8,
           R.drawable.salon9,
           R.drawable.salon10,

   };
   public static final int[] SALON_MODELS_IDS = {
           R.drawable.salon_model_1,
           R.drawable.salon_model_2,
           R.drawable.salon_model_3,
           R.drawable.salon_model_4,
           R.drawable.salon_model_5,
           R.drawable.salon_model_6,
           R.drawable.salon_model_7,
   };

   public static final Salon[] SALONS = {
           new Salon().setName("Beautiful Hair").setRatingNumber(4.5f).setDiscount(30).setFull(false),
           new Salon().setName("Hair Style").setRatingNumber(4f).setDiscount(20).setFull(false),
           new Salon().setName("Nhung").setRatingNumber(4.8f).setDiscount(50).setFull(false),
           new Salon().setName("Phước An").setRatingNumber(4.6f).setDiscount(40).setFull(true),
           new Salon().setName("Thảo Tây").setRatingNumber(4f).setDiscount(30).setFull(false),
           new Salon().setName("Quốc An").setRatingNumber(4.2f).setDiscount(50).setFull(false),
           new Salon().setName("Tây Hòa").setRatingNumber(4.7f).setDiscount(60).setFull(true)
   };
   
}
