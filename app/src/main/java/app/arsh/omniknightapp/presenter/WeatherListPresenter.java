package app.arsh.omniknightapp.presenter;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import app.arsh.omniknightapp.Omniknight;
import app.arsh.omniknightapp.model.conductor.Conductor;
import app.arsh.omniknightapp.model.entity.Weather;
import app.arsh.omniknightapp.model.repo.local.DBClient;
import app.arsh.omniknightapp.model.repo.local.entity.Country;
import app.arsh.omniknightapp.model.repo.remote.RESTClient;
import app.arsh.omniknightapp.presenter.interfaces.WeatherListInterface;
import app.arsh.omniknightapp.view.utils.WeatherListPresenterCallBack;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;
import rx.functions.Action1;

/**
 * Created by arash on 1/6/17.
 */

public class WeatherListPresenter extends BasePresenter {

  private WeatherListInterface listener;
  private List<Country> countryList;
  @Inject RESTClient client;
  @Inject DBClient dbClient;
  @Inject Conductor conductor;
  private ArrayList<Country> removableCountries = new ArrayList<>();
  private Action1 presenterReadyCallback;

  public WeatherListPresenter(AppCompatActivity activity, WeatherListInterface listener, List<Country> countryList) {
    this.listener = listener;
    this.countryList = countryList;
    ((Omniknight)activity.getApplication()).getAppComponent().inject(this);
    dbClient.setCountryChangeObserver(new WeatherListPresenterCallBack()
        .getCountryObserver(activity));

  }

  public ArrayList<Country> getRemovableCountries() {
    return removableCountries;
  }

  private Action1 getPresenterReadyCallback() {
    return presenterReadyCallback;
  }

  public void setPresenterReadyCallback(Action1 presenterReady) {
    this.presenterReadyCallback = presenterReady;
  }

  @Override protected void setupView() {

  }

  @Override public void onCreateViewFinished() {

    conductor.addPresenter(this);
    listener.showProgress();

    Observable.just(true).subscribe(getPresenterReadyCallback(), err -> {
      Log.v(getClass().getSimpleName(), err.getLocalizedMessage());
    });

    if (countryList == null) {
      return;
    }
    for (Country country : countryList) {
      client.getWeatherWithCountry(country).enqueue(new Callback<Weather>() {
        @Override public void onResponse(Call<Weather> call, Response<Weather> response) {
          listener.loadWeatherList(response.body().setCountry(country));
          listener.dismissProgress();
        }

        @Override public void onFailure(Call<Weather> call, Throwable t) {
          listener.showError(new Error(t.getLocalizedMessage()));
        }
      });
    }
  }

  public void recyclerViewEnterEditMode() {
    listener.recyclerViewEnterEditMode();
  }

  public void recyclerViewExitEditMode() {
    listener.recyclerViewExitEditMode();
  }

  public void removeSelectedCountries() {
    dbClient.removeCountryList(removableCountries);
  }

  public void addItemToRemoveList(Weather weather) {
    removableCountries.add(weather.getCountry());
  }
}
