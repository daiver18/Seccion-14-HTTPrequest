package com.example.daiverandresdoria.seccion_14_httprequest.API;

import com.example.daiverandresdoria.seccion_14_httprequest.Modelos.City;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class API {
    public static final String BASE_URL = "https://api.openweathermap.org/data/2.5/";
    private static Retrofit retrofit = null;
    public static final String API_KEY = "5a41c56a87719feab186130bf27e3985";


    public static Retrofit getAPI(){
        if (retrofit == null){

            GsonBuilder builder = new GsonBuilder();
            builder.registerTypeAdapter(City.class,new deserializador());

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(builder.create()))
                    .build();
        }
        return retrofit;
    }
}
