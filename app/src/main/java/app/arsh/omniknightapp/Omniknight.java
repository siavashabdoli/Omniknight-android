package app.arsh.omniknightapp;

import android.app.Application;
import app.arsh.omniknightapp.model.injection.DBCompnent;
import app.arsh.omniknightapp.model.injection.DBModule;
import app.arsh.omniknightapp.model.injection.DaggerDBCompnent;
import app.arsh.omniknightapp.model.injection.DaggerNetComponent;
import app.arsh.omniknightapp.model.injection.NetComponent;
import app.arsh.omniknightapp.model.injection.NetModule;
import app.arsh.omniknightapp.model.repo.local.entity.DaoSession;

/**
 * Created by arash on 1/4/17.
 */

public class Omniknight extends Application {

  private DBCompnent dbCompnent;
  private NetComponent netCompnent;

  private DaoSession daoSession;
  @Override public void onCreate() {
    super.onCreate();

    dbCompnent = DaggerDBCompnent
        .builder()
        .dBModule(new DBModule(this))
        .build();

    netCompnent = DaggerNetComponent
        .builder()
        .netModule(new NetModule())
        .build();

  }

  public DBCompnent getDbCompnent() {
    return dbCompnent;
  }

  public NetComponent getNetCompnent() {
    return netCompnent;
  }
}
