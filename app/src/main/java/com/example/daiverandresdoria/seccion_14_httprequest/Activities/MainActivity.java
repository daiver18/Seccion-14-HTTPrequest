package com.example.daiverandresdoria.seccion_14_httprequest.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.daiverandresdoria.seccion_14_httprequest.API.API;
import com.example.daiverandresdoria.seccion_14_httprequest.API.APIservice.WeatherService;
import com.example.daiverandresdoria.seccion_14_httprequest.Modelos.City;
import com.example.daiverandresdoria.seccion_14_httprequest.R;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private TextView description,temp;
    private EditText inputCity;
    private ImageView weatherIcon;
    private Button searchTemp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("HTTP");
        instance();

        searchTemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String codeCity = inputCity.getText().toString().trim();

                WeatherService service = API.getAPI().create(WeatherService.class);
                Call<City> cityCall = service.getcity("Colombia,CO",API.API_KEY,"metric");
                cityCall.enqueue(new Callback<City>() {
                    @Override
                    public void onResponse(Call<City> call, Response<City> response) {
                        City city = response.body();
                        description.setText(city.getDescription());
                        temp.setTextSize(city.getTemp());
                        Picasso.get().load(API.BASE_URL_ICON+city.getIcon()+API.EXTENCION_ICON).fit().into(weatherIcon);
                    }
                    @Override
                    public void onFailure(Call<City> call, Throwable t) {
                        Toast.makeText(MainActivity.this,"error",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }

    private void instance(){
        inputCity = findViewById(R.id.inputCity);
        weatherIcon = findViewById(R.id.weatherIcon);
        description = findViewById(R.id.description);
        temp = findViewById(R.id.temp);
        searchTemp = findViewById(R.id.searchTemp);
    }
}
