package com.example.daiverandresdoria.seccion_14_httprequest.Modelos;

import com.google.gson.annotations.SerializedName;

public class Temperature {
    @SerializedName("temp")
    private Float temperatur;
    private Float pressure;
    private Float humidity;
    @SerializedName("temp_min")
    private Float tempMin;
    @SerializedName("temp_max")
    private Float tempMax;

    public Temperature(){}

    public Temperature(Float temperatur, Float pressure, Float humidity, Float tempMin, Float tempMax) {
        this.temperatur = temperatur;
        this.pressure = pressure;
        this.humidity = humidity;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
    }

    public Float getTemperatur() {
        return temperatur;
    }

    public void setTemperatur(Float temperatur) {
        this.temperatur = temperatur;
    }

    public Float getPressure() {
        return pressure;
    }

    public void setPressure(Float pressure) {
        this.pressure = pressure;
    }

    public Float getHumidity() {
        return humidity;
    }

    public void setHumidity(Float humidity) {
        this.humidity = humidity;
    }

    public Float getTempMin() {
        return tempMin;
    }

    public void setTempMin(Float tempMin) {
        this.tempMin = tempMin;
    }

    public Float getTempMax() {
        return tempMax;
    }

    public void setTempMax(Float tempMax) {
        this.tempMax = tempMax;
    }
}
