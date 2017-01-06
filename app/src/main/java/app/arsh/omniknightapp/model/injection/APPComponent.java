package app.arsh.omniknightapp.model.injection;

import android.app.Application;
import android.content.Context;
import app.arsh.omniknightapp.presenter.CountrySelectionPresenter;
import app.arsh.omniknightapp.presenter.MainActivityPresenter;
import app.arsh.omniknightapp.presenter.WeatherListPresenter;
import dagger.Component;
import javax.inject.Singleton;

/**
 * Created by arash on 1/4/17.
 */

@Singleton
@Component(modules = {DBModule.class,NetModule.class})
public interface APPComponent {

  Application application();

  void inject(MainActivityPresenter presenter);
  void inject(CountrySelectionPresenter presenter);
  void inject(WeatherListPresenter presenter);
}
