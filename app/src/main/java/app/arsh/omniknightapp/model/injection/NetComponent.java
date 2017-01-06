package app.arsh.omniknightapp.model.injection;

import app.arsh.omniknightapp.presenter.CountrySelectionPresenter;
import dagger.Component;
import javax.inject.Singleton;

/**
 * Created by arash on 1/6/17.
 */

@Singleton
@Component(modules = {NetModule.class})
public interface NetComponent {
  void inject(CountrySelectionPresenter presenter);
}
