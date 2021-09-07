package com.example.amiibojavaretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Adapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Amiibo> amiiboList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerview);
        amiiboList=new ArrayList<>();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://amiiboapi.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AmiiboApi amiiboApi= retrofit.create(AmiiboApi.class);
        Call<JSONResponse> call=amiiboApi.getAmiibo();
        call.enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {
                JSONResponse jsonResponse=response.body();
                amiiboList=new ArrayList<>(Arrays.asList(jsonResponse.getAmiibo()));
                PutDataIntoRecyclerView(amiiboList);
            }

            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {

            }
        });



    }

    private void PutDataIntoRecyclerView(List<Amiibo> amiiboList) {
        Adaptery adaptery= new  Adaptery (this,amiiboList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adaptery);
    }
}