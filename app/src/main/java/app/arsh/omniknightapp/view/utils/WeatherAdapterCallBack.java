package app.arsh.omniknightapp.view.utils;

import app.arsh.omniknightapp.model.entity.Weather;
import app.arsh.omniknightapp.presenter.WeatherListPresenter;
import rx.Observer;
/**
 * Created by arash on 1/29/17.
 */

public class WeatherAdapterCallBack {

  public Observer<Weather> getClickedWeather() {
      return new Observer<Weather>() {
        @Override public void onCompleted() {

        }

        @Override public void onError(Throwable e) {

        }

        @Override public void onNext(Weather weather) {

        }
      };
  }

  public Observer<Weather> getCheckBoxChangedWeather(WeatherListPresenter presenter) {
      return new Observer<Weather>() {
        @Override public void onCompleted() {

        }

        @Override public void onError(Throwable e) {

        }

        @Override public void onNext(Weather weather) {
          presenter.addItemToRemoveList(weather);
        }
      };
  }
}
