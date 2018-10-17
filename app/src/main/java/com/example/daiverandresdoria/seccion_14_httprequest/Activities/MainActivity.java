package com.example.daiverandresdoria.seccion_14_httprequest.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.example.daiverandresdoria.seccion_14_httprequest.API.API;
import com.example.daiverandresdoria.seccion_14_httprequest.API.APIservice.WeatherService;
import com.example.daiverandresdoria.seccion_14_httprequest.Modelos.City;
import com.example.daiverandresdoria.seccion_14_httprequest.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private TextView textweather;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("HTTP");
        textweather = findViewById(R.id.textWeather);

        WeatherService service = API.getAPI().create(WeatherService.class);
        Call<City> cityCall = service.getcitycelsius("Colombia,CO",API.API_KEY,"metric");

        cityCall.enqueue(new Callback<City>() {
            @Override
            public void onResponse(Call<City> call, Response<City> response) {
                City city = response.body();
                textweather.setText(city.getName()+"---"+city.getId());
            }

            @Override
            public void onFailure(Call<City> call, Throwable t) {
                Toast.makeText(MainActivity.this,"error",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
