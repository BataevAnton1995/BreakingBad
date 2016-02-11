package com.breakingbad.data.managers.network.api;

import java.util.Map;

import retrofit.Call;
import retrofit.http.Field;
import retrofit.http.FieldMap;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

public interface RegAccount {
    @FormUrlEncoded
    @POST("user/registration")
    Call<Object> data(@Field("") String status,@FieldMap Map<String,String> map);
}
