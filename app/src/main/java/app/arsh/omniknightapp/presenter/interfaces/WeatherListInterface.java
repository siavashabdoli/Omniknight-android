package app.arsh.omniknightapp.presenter.interfaces;

import app.arsh.omniknightapp.model.entity.Weather;

/**
 * Created by arash on 1/6/17.
 */

public interface WeatherListInterface {

  void loadWeatherList(Weather weather);
  void showProgress();
  void dismissProgress();
  void showError(Error error);

  void recyclerViewEnterEditMode();
  void recyclerViewExitEditMode();
}
