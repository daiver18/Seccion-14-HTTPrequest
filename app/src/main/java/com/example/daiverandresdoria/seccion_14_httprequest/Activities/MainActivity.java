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

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView description,temp;
    private EditText inputCity;
    private ImageView weatherIcon;
    private Button searchTemp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("HTTP");
        setUI();
        searchTemp.setOnClickListener(this);

    }
    private void setUI(){
        inputCity = findViewById(R.id.inputCity);
        weatherIcon = findViewById(R.id.weatherIcon);
        description = findViewById(R.id.description);
        temp = findViewById(R.id.Textviewtemp);
        searchTemp = findViewById(R.id.searchTemp);
    }
    
    @Override
    public void onClick(View v) {
        String codeCity = inputCity.getText().toString().trim();
        if (codeCity != null && !codeCity.isEmpty()){
            WeatherService service = API.getAPI().create(WeatherService.class);
            Call<City> cityCall = service.getcity(codeCity,API.API_KEY,"metric","es");
            cityCall.enqueue(new Callback<City>() {
                @Override
                public void onResponse(Call<City> call, Response<City> response) {
                    City city = response.body();
                    setInfo(city);
                }
                @Override
                public void onFailure(Call<City> call, Throwable t) {
                    Toast.makeText(MainActivity.this,"error",Toast.LENGTH_SHORT).show();
                }
            });
        }else {
            Toast.makeText(MainActivity.this,"Please input a valid city",Toast.LENGTH_SHORT).show();
        }
    }

    private void setInfo(City city){
        description.setText(city.getDescription());
        temp.setText(city.getTemp()+"C°");
        Picasso.get().load(API.BASE_URL_ICON+city.getIcon()+API.EXTENCION_ICON).placeholder(R.mipmap.weather).fit().into(weatherIcon);
    }
}
