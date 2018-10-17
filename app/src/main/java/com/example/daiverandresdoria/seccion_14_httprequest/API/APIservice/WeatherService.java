package com.example.daiverandresdoria.seccion_14_httprequest.API.APIservice;

import com.example.daiverandresdoria.seccion_14_httprequest.Modelos.City;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherService {

    @GET("weather")
    Call<City> getcity(@Query("q") String city, @Query("appid")String key);

    @GET("weather")
    Call<City> getcitycelsius(@Query("q") String city, @Query("appid")String key,@Query("units")String value);
}
