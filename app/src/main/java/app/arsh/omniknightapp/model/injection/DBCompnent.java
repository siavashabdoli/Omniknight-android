package app.arsh.omniknightapp.model.injection;

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

  Context context();

  void inject(MainActivityPresenter presenter);
}
