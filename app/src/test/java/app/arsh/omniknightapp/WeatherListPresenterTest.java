package app.arsh.omniknightapp;

import app.arsh.omniknightapp.presenter.WeatherListPresenter;
import app.arsh.omniknightapp.presenter.interfaces.WeatherListInterface;
import app.arsh.omniknightapp.view.activities.MainActivity;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

/**
 * Created by arash on 1/19/17.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 23)
public class WeatherListPresenterTest {

  private WeatherListInterface listener;
  private MainActivity mainActivity;
  private WeatherListPresenter presenter;
}
