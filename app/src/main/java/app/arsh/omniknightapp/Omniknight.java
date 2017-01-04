package app.arsh.omniknightapp;

import android.app.Application;
import app.arsh.omniknightapp.model.injection.DBCompnent;
import app.arsh.omniknightapp.model.injection.DBModule;
import app.arsh.omniknightapp.model.injection.DaggerDBCompnent;
import app.arsh.omniknightapp.model.repo.local.entity.DaoSession;

/**
 * Created by arash on 1/4/17.
 */

public class Omniknight extends Application {

  private DBCompnent dbCompnent;
  private DaoSession daoSession;

  @Override public void onCreate() {
    super.onCreate();

    dbCompnent = DaggerDBCompnent
        .builder()
        .dBModule(new DBModule(this))
        .build();

  }

  public DBCompnent getDbCompnent() {
    return dbCompnent;
  }
}
