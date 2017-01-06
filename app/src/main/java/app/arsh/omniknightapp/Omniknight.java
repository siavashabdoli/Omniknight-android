package app.arsh.omniknightapp;

import android.app.Application;
import app.arsh.omniknightapp.model.injection.APPComponent;
import app.arsh.omniknightapp.model.injection.DBModule;
import app.arsh.omniknightapp.model.injection.DaggerAPPComponent;
import app.arsh.omniknightapp.model.injection.NetModule;
import app.arsh.omniknightapp.model.repo.local.entity.DaoSession;

/**
 * Created by arash on 1/4/17.
 */

public class Omniknight extends Application {

  private APPComponent dbComponent;

  private DaoSession daoSession;
  @Override public void onCreate() {
    super.onCreate();

    dbComponent = DaggerAPPComponent
        .builder()
        .dBModule(new DBModule(this))
        .netModule(new NetModule())
        .build();


  }

  public APPComponent getAppComponent() {
    return dbComponent;
  }

}
