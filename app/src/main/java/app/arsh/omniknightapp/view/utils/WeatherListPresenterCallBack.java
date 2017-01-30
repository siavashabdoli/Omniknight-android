package app.arsh.omniknightapp.view.utils;

import android.support.v7.app.AppCompatActivity;
import app.arsh.omniknightapp.model.repo.local.entity.Country;
import app.arsh.omniknightapp.view.activities.MainActivity;
import rx.Observer;

/**
 * Created by arash on 1/30/17.
 */

public class WeatherListPresenterCallBack {

  private AppCompatActivity activity;



  private Observer<Country> countryObserver = new Observer<Country>() {
    @Override public void onCompleted() {

    }

    @Override public void onError(Throwable e) {

    }

    @Override public void onNext(Country country) {
      ((MainActivity)activity).getPresenter().updateView();
    }
  };

  public WeatherListPresenterCallBack(AppCompatActivity activity) {
    this.activity = activity;
  }

  public Observer<Country> getCountryObserver() {
    return countryObserver;
  }
}
