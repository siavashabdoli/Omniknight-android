package app.arsh.omniknightapp.model.repo.remote;

import app.arsh.omniknightapp.model.entity.Weather;
import app.arsh.omniknightapp.model.repo.local.entity.Country;
import app.arsh.omniknightapp.model.repo.remote.service.CountryService;
import app.arsh.omniknightapp.model.repo.remote.service.WeatherService;
import java.util.List;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by arash on 1/3/17.
 */

public class RESTClient {

  public static final String COUNTRY_SERVICE_BASE_URLL = "https://restcountries.eu/rest/v1/";
  public static final String COUNTRY_SERVICE_BASE_URLL_NON_SECURE = "http://restcountries.eu/rest/v1/";
  public static final String WEATHER_SERVICE_BASE_URLL_NON_SECURE = "http://api.openweathermap.org/data/2.5/";
  public static final String WEATHER_APPID = "ecc2f746cac057791aaea881badf6fe8";

  private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

  private Retrofit getRetrofitObject(String base){
    return new Retrofit
        .Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(base)
        .client(httpClient.build())
        .build();
  }

  public Call<List<Country>> getAllCountriesService(){

    return getRetrofitObject(COUNTRY_SERVICE_BASE_URLL)
        .create(CountryService.class)
        .countryList();
  }

  public Call<List<Country>> getCountryDetailService(String countryName, boolean fullName){

    return getRetrofitObject(COUNTRY_SERVICE_BASE_URLL)
        .create(CountryService.class)
        .countryDetail(countryName, fullName);
  }

  public Call<Weather> getWeatherWithCountry(Country country){
    return getRetrofitObject(WEATHER_SERVICE_BASE_URLL_NON_SECURE)
        .create(WeatherService.class)
        .getWeatherForCountry(country.getCapital()+country.getAlpha2Code(), WEATHER_APPID);
  }


}
