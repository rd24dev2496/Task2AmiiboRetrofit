package com.example.amiibojavaretrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AmiiboApi {
    @GET("amiibo/")
    Call<JSONResponse> getAmiibo();
}
