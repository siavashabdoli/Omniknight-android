package app.arsh.omniknightapp.presenter;

import android.support.v7.app.AppCompatActivity;
import app.arsh.omniknightapp.Omniknight;
import app.arsh.omniknightapp.model.entity.Weather;
import app.arsh.omniknightapp.model.repo.local.entity.Country;
import app.arsh.omniknightapp.model.repo.remote.RESTClient;
import app.arsh.omniknightapp.presenter.interfaces.WeatherListInterface;
import java.util.List;
import javax.inject.Inject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by arash on 1/6/17.
 */

public class WeatherListPresenter extends BasePresenter {

  private WeatherListInterface listener;
  private List<Country> countryList;
  private AppCompatActivity activity;
  @Inject RESTClient client;

  public WeatherListPresenter(AppCompatActivity activity, WeatherListInterface listener, List<Country> countryList) {
    this.activity = activity;
    this.listener = listener;
    this.countryList = countryList;
    ((Omniknight)activity.getApplication()).getAppComponent().inject(this);

  }

  @Override protected void setupView() {

  }

  @Override protected void showErrorView() {

  }

  @Override protected void showProgressView() {

  }

  @Override public void onCreateViewFinished() {

    listener.showProgress();
    for (Country country : countryList) {
      client.getWeatherWithCountry(country).enqueue(new Callback<Weather>() {
        @Override public void onResponse(Call<Weather> call, Response<Weather> response) {
          listener.loadWeatherList(response.body());
          listener.dismissProgress();
        }

        @Override public void onFailure(Call<Weather> call, Throwable t) {

        }
      });
    }
  }
}
