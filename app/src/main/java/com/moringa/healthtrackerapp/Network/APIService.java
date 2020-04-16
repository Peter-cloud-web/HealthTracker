package com.moringa.healthtrackerapp.Network;

import com.moringa.healthtrackerapp.Models.Register;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIService {
    @POST("/register")
    @FormUrlEncoded
    Call<Register>save(@Field("email")String email,
                       @Field("adres")String adres,
                       @Field("first_name")String first_name,
                       @Field("last_name")String last_name,
                       @Field("username")String username,
                       @Field("role")String role,
                       @Field("password")String password,
                       @Field("contact")String contact,
                       @Field("confirmed_password")String confirmed_password);
}
