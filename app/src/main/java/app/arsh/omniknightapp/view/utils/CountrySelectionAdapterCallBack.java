package app.arsh.omniknightapp.view.utils;

import android.support.v7.app.AppCompatActivity;
import app.arsh.omniknightapp.model.repo.local.entity.Country;
import app.arsh.omniknightapp.presenter.CountrySelectionPresenter;
import app.arsh.omniknightapp.view.activities.MainActivity;
import rx.Observer;

/**
 * Created by arash on 1/29/17.
 */

public class CountrySelectionAdapterCallBack<T extends Country> {

  private CountrySelectionPresenter presenter;
  private AppCompatActivity activity;

  public CountrySelectionAdapterCallBack<T> setPresenter(CountrySelectionPresenter presenter, AppCompatActivity appCompatActivity) {
    this.presenter = presenter;
    this.activity = appCompatActivity;
    return this;
  }
  public Observer<Country> getCountryObserver() {
    return countryObserver;
  }

  private Observer<Country> countryObserver = new Observer<Country>() {
    @Override public void onCompleted() {

    }

    @Override public void onError(Throwable e) {

    }

    @Override public void onNext(Country country) {
      ((MainActivity)activity).getPresenter().updateView();
    }
  };
}
