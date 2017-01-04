package app.arsh.omniknightapp.model.injection;

import android.app.Application;
import android.content.Context;
import app.arsh.omniknightapp.model.repo.local.DBClient;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Created by arash on 1/4/17.
 */

@Module
public class DBModule {

  private final Application application;

  public DBModule (Application application) {
    this.application = application;
  }

  @Provides
  public Application application() {
    return application;
  }

  @Provides
  @Singleton
  DBClient getDataBase(Application application) {
    return new DBClient(application);
  }
}
