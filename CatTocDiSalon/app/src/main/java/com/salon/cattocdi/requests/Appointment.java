package com.salon.cattocdi.requests;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface Appointment {

    @GET("api/appointment")
    Call<List<Appointment>> getAllAppointment(@Header("Authorization") String auth);

}
