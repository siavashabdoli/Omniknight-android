package app.arsh.omniknightapp.view.utils;

import app.arsh.omniknightapp.model.entity.Weather;
import app.arsh.omniknightapp.presenter.WeatherListPresenter;
import rx.Observer;
/**
 * Created by arash on 1/29/17.
 */

public class WeatherAdapterCallBack<T extends Weather> {

  private WeatherListPresenter presenter;

  public WeatherAdapterCallBack<T> setPresenter(WeatherListPresenter presenter) {
    this.presenter = presenter;
    return this;
  }
  public Observer<Weather> getClickedWeather() {
    return clickedWeather;
  }

  private Observer<app.arsh.omniknightapp.model.entity.Weather>
      clickedWeather = new Observer<Weather>() {
    @Override public void onCompleted() {

    }

    @Override public void onError(Throwable e) {

    }

    @Override public void onNext(Weather weather) {

    }
  };

  private Observer<Weather> checkBoxChangedWeather = new Observer<Weather>() {
    @Override public void onCompleted() {

    }

    @Override public void onError(Throwable e) {

    }

    @Override public void onNext(Weather weather) {
      presenter.addItemToRemoveList(weather);
    }
  };

  public Observer<Weather> getCheckBoxChangedWeather() {
    return checkBoxChangedWeather;
  }
}
