package com.salon.cattocdi.models;

import com.google.android.gms.maps.model.LatLng;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class Salon implements Serializable {
    @SerializedName("SalonId")
    private int salonId;
    @SerializedName("SalonName")
    private String name;
    @SerializedName("Address")
    private String address;
    private String phone;
    private String email;
    @SerializedName("RatingAvarage")
    private float ratingNumber;
    private boolean full;
    private int discount;
    private String imageUrl;
    @SerializedName("ReviewCount")
    private int reviewsAmount;
    private Timestamp startTime;
    @SerializedName("lattitude")
    private double latitude;
    @SerializedName("longtitude")
    private double longtitude;
    private List<Category> categories;
    @SerializedName("Services")
    private List<Service> services;
    private List<DayWorkingHour> workingHours;
    @SerializedName("Reviews")
    private List<Comment> reviews;
    @SerializedName("Promotion")
    private List<Promotion> promotions;
    private List<CloseDate> closeDates;
    private List<DateSlot> dateSlots;


    public Salon() {
    }

    public int getSalonId() {
        return salonId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getRatingNumber() {
        return ratingNumber;
    }

    public void setRatingNumber(float ratingNumber) {
        this.ratingNumber = ratingNumber;
    }

    public boolean isFull() {
        return full;
    }

    public void setFull(boolean full) {
        this.full = full;
    }

    public int getDiscount() {
        if (promotions == null){
            return 0;
        }

        for (Promotion promotion :
                promotions) {

            if(Calendar.getInstance().getTimeInMillis() >= promotion.getStartPeriod().getTime()
                    && Calendar.getInstance().getTimeInMillis() <= promotion.getEndPeriod().getTime()){
                return promotion.getDiscount();
            }

        }

        return 0;

    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getReviewsAmount() {
        return reviewsAmount;
    }

    public void setReviewsAmount(int reviewsAmount) {
        this.reviewsAmount = reviewsAmount;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(double longtitude) {
        this.longtitude = longtitude;
    }

    public List<Category> getCategories() {
        HashMap<Integer, Category> tmp = new HashMap<>();
        for (Service service : services) {
            Integer categoryId = service.getCategoryId();
            if (tmp.get(categoryId) == null) {
                Category category = new Category(service.getCategoryId(), service.getCategoryName());
                category.setServices(new ArrayList<Service>());
                category.getServices().add(service);
                tmp.put(categoryId, category);
            } else {
                tmp.get(categoryId).getServices().add(service);
            }

            categories = new ArrayList<Category>(tmp.values());

        }
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<DayWorkingHour> getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(List<DayWorkingHour> workingHours) {
        this.workingHours = workingHours;
    }

    public LatLng getLatLng() {
        return new LatLng(latitude, longtitude);
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public List<Comment> getReviews() {
        return reviews;
    }

    public void setReviews(List<Comment> reviews) {
        this.reviews = reviews;
    }

    public List<Promotion> getPromotions() {
        return promotions;
    }

    public void setPromotions(List<Promotion> promotions) {
        this.promotions = promotions;
    }

    public List<CloseDate> getCloseDates() {
        return closeDates;
    }

    public void setCloseDates(List<CloseDate> closeDates) {
        this.closeDates = closeDates;
    }

    public List<DateSlot> getDateSlots() {
        return dateSlots;
    }

    public void setDateSlots(List<DateSlot> dateSlots) {
        this.dateSlots = dateSlots;
    }

    public class DayWorkingHour {
        private int dayInWeek;
        private float startHour;
        private float endHour;
        private boolean open;

        public DayWorkingHour(int dayInWeek, float startHour, float endHour, boolean open) {
            this.dayInWeek = dayInWeek;
            this.startHour = startHour;
            this.endHour = endHour;
            this.open = open;
        }
    }
}
