package app.arsh.omniknightapp.model.injection;

import android.app.Application;
import android.content.Context;
import app.arsh.omniknightapp.presenter.MainActivityPresenter;
import dagger.Component;
import javax.inject.Singleton;

/**
 * Created by arash on 1/4/17.
 */

@Singleton
@Component(modules = {DBModule.class})
public interface DBCompnent {

  Application application();

  void inject(MainActivityPresenter presenter);
}
