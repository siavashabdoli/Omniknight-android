package app.arsh.omniknightapp;

import app.arsh.omniknightapp.model.repo.local.entity.Country;
import app.arsh.omniknightapp.presenter.WeatherListPresenter;
import app.arsh.omniknightapp.presenter.interfaces.WeatherListInterface;
import app.arsh.omniknightapp.view.activities.MainActivity;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import rx.Observer;
import rx.functions.Action1;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by arash on 1/19/17.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 23)
public class WeatherListPresenterTest {

  private WeatherListInterface listener;
  private MainActivity mainActivity;
  private WeatherListPresenter presenter;

  @Test
  public void showAndHideProgressViewTest() {
    listener = Mockito.mock(WeatherListInterface.class);
    mainActivity = Robolectric.setupActivity(MainActivity.class);
    List<Country> countries = Arrays.asList(Mockito.mock(Country.class), Mockito.mock(Country.class), Mockito.mock(Country.class));

    presenter = new WeatherListPresenter(mainActivity, listener, countries);
    Action1 observer = Mockito.mock(Action1.class);
    presenter.setPresenterReady(observer);
    presenter.onCreateViewFinished();
    verify(listener).showProgress();
  }

}
