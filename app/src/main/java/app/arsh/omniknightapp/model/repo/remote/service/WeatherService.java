package app.arsh.omniknightapp.model.repo.remote.service;

import app.arsh.omniknightapp.model.entity.Weather;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by arash on 10/25/16.
 */

public interface WeatherService {

    @GET("weather")
    Call<Weather> getWeatherForCountry(@Query("q") String countryName, @Query("appid") String appId);
}
