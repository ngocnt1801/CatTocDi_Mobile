package com.salon.cattocdi.requests;

import com.salon.cattocdi.models.Account;
import com.salon.cattocdi.models.Customer;
import com.salon.cattocdi.models.ResponseMessage;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface AccountApi {
    @FormUrlEncoded
    @POST("login")
    Call<Customer> login(@Field("username") String username, @Field("password") String password, @Field("grant_type") String grantType);

    @FormUrlEncoded
    @POST("api/Account/Register")
    Call<ResponseMessage> register(@Field("username") String username,
                                   @Field("password") String password,
                                   @Field("gender") boolean gender,
                                   @Field("name") String name,
                                   @Field("phone") String phone);
}
