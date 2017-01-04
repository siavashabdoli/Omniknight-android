package app.arsh.omniknightapp.model.injection;

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

  private final Context context;

  public DBModule (Context context) {
    this.context = context;
  }

  @Provides
  public Context context() {
    return context;
  }

  @Provides
  @Singleton
  DBClient getRealm(Context context) {
    return new DBClient(context);
  }
}
