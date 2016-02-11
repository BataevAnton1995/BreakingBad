package com.breakingbad.data.managers.network.api;

import java.util.Map;

import retrofit.Call;
import retrofit.http.Field;
import retrofit.http.FieldMap;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;


public interface Registration {
    @FormUrlEncoded
    @POST("/registration")
    Call<Object> regData(@Field ("") String status,@FieldMap Map<String,String> map);
}
