package app.arsh.omniknightapp.model.conductor;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import app.arsh.omniknightapp.presenter.BasePresenter;
import app.arsh.omniknightapp.presenter.MainActivityPresenter;
import app.arsh.omniknightapp.view.utils.GeneralUtils;
import java.util.HashMap;

/**
 * Created by arash on 1/31/17.
 */
public class Conductor<T extends BasePresenter> implements Application.ActivityLifecycleCallbacks {

  private static Conductor ourInstance = new Conductor();
  private HashMap<String, T> presenterContainer = new HashMap<>();
  private ConductorActivityLifeCycleListener activityListener;
  private AppCompatActivity activity;
  public static Conductor getInstance() {
    return ourInstance;
  }

  private Conductor() {
  }

  public void setCurrentActivity(AppCompatActivity appCompatActivity) {
    this.activity = appCompatActivity;
    this.activity.getApplication().registerActivityLifecycleCallbacks(this);
  }

  public void addPresenter(T presenter) {
    this.presenterContainer.put(presenter.getClass().getSimpleName(), presenter);
  }

  public T getPresenter(Class classType) {
    return this.presenterContainer.get(classType.getSimpleName());
  }

  public Boolean connectionAvailable() {
    if (GeneralUtils.isNetworkAvailable(activity)) {
      return true;
    }
    else {
      ((MainActivityPresenter)getPresenter(MainActivityPresenter.class)).showNoInternetConnection();
      return false;
    }
  }

  @Override public void onActivityCreated(Activity activity, Bundle bundle) {
    if (activityListener != null) {
      activityListener.activityStateChanged(ActivityLifeCycle.onActivityCreated);
    }
  }

  @Override public void onActivityStarted(Activity activity) {
    if (activityListener != null) {
      activityListener.activityStateChanged(ActivityLifeCycle.onActivityStarted);
    }
  }

  @Override public void onActivityResumed(Activity activity) {
    if (activityListener != null) {
      activityListener.activityStateChanged(ActivityLifeCycle.onActivityResumed);
    }
  }

  @Override public void onActivityPaused(Activity activity) {
    if (activityListener != null) {
      activityListener.activityStateChanged(ActivityLifeCycle.onActivityPaused);
    }
  }

  @Override public void onActivityStopped(Activity activity) {
    if (activityListener != null) {
      activity.getApplication().unregisterActivityLifecycleCallbacks(this);
      activityListener.activityStateChanged(ActivityLifeCycle.onActivityStopped);
    }
  }

  @Override public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    if (activityListener != null) {
      activityListener.activityStateChanged(ActivityLifeCycle.onActivitySaveInstanceState);
    }
  }

  @Override public void onActivityDestroyed(Activity activity) {
    if (activityListener != null) {
      activityListener.activityStateChanged(ActivityLifeCycle.onActivityDestroyed);
    }
  }
}
