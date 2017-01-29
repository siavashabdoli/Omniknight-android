package app.arsh.omniknightapp.presenter;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import app.arsh.omniknightapp.Omniknight;
import app.arsh.omniknightapp.model.entity.Weather;
import app.arsh.omniknightapp.model.repo.local.DBClient;
import app.arsh.omniknightapp.model.repo.local.entity.Country;
import app.arsh.omniknightapp.model.repo.remote.RESTClient;
import app.arsh.omniknightapp.presenter.interfaces.WeatherListInterface;
import app.arsh.omniknightapp.view.activities.MainActivity;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;
import rx.Observer;
import rx.functions.Action1;

/**
 * Created by arash on 1/6/17.
 */

public class WeatherListPresenter extends BasePresenter {

  private WeatherListInterface listener;
  private List<Country> countryList;
  private AppCompatActivity activity;
  @Inject RESTClient client;
  @Inject DBClient dbClient;

  private ArrayList<Country> removableCountries = new ArrayList<>();
  private Observer<Country> countryObserver = new Observer<Country>() {
    @Override public void onCompleted() {

    }

    @Override public void onError(Throwable e) {

    }

    @Override public void onNext(Country country) {
      ((MainActivity)activity).getPresenter().updateView();
    }
  };

  private Action1 presenterReadyCallback;

  public WeatherListPresenter(AppCompatActivity activity, WeatherListInterface listener, List<Country> countryList) {
    this.activity = activity;
    this.listener = listener;
    this.countryList = countryList;
    ((Omniknight)activity.getApplication()).getAppComponent().inject(this);
    dbClient.setCountryChangeObserver(countryObserver);

  }

  public Action1 getPresenterReadyCallback() {
    return presenterReadyCallback;
  }

  public void setPresenterReadyCallback(Action1 presenterReady) {
    this.presenterReadyCallback = presenterReady;
  }

  @Override protected void setupView() {

  }

  @Override protected void showErrorView() {
    listener.showError(new Error());
  }

  @Override protected void showProgressView() {

  }

  @Override public void onCreateViewFinished() {

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

        }
      });
    }
  }

  public void recyclerViewEnterEditMode() {
    listener.recyclerViewEnterEditMode();
  }

  public void recyclerViewExitEditMode() {
    dbClient.removeCountryList(removableCountries);
    listener.recyclerViewExitEditMode();
  }

  public void addItemToRemoveList(Weather weather) {
    removableCountries.add(weather.getCountry());
  }
}
