package com.salon.cattocdi.requests;

import com.salon.cattocdi.models.Account;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AccountApi {
    @POST("/token")
    Call<String> login(@Body Account account);
}
