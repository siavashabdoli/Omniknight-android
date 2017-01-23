package app.arsh.omniknightapp.presenter;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import app.arsh.omniknightapp.Omniknight;
import app.arsh.omniknightapp.model.repo.local.DBClient;
import app.arsh.omniknightapp.model.repo.local.entity.Country;
import app.arsh.omniknightapp.presenter.interfaces.MainActivityInterface;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by arash on 1/2/17.
 */

public class MainActivityPresenter extends BasePresenter
    implements Application.ActivityLifecycleCallbacks {

  private List<Country> countryList;
  private MainActivityInterface viewListener;
  private Context context;
  @Inject DBClient dbClient;

  public MainActivityPresenter(@NonNull MainActivityInterface viewListener,
      @NonNull AppCompatActivity activity) {

    this.viewListener = viewListener;
    this.context = activity;
    ((Omniknight)activity.getApplication()).getAppComponent().inject(this);
    activity.getApplication().registerActivityLifecycleCallbacks(this);
  }

  @Override protected void setupView() {
    viewListener.loadCities(countryList);
  }

  @Override protected void showErrorView() {

  }

  @Override protected void showProgressView() {

  }

  @Override public void onCreateViewFinished() {
    updateData();
    if (countryList.size() == 0) {
      viewListener.loadNoCityView();
    } else {
      setupView();
    }
  }

  public DBClient getDbClient() {
    return dbClient;
  }


  public void fabButtonClicked() {
    viewListener.loadCountrySelectionFragment();
  }

  public void updateView() {
    updateData();
    if (countryList.size() == 0) {
      viewListener.loadNoCityView();
    } else {
      setupView();
    }
  }

  private void updateData() {
    countryList = dbClient.getCountries();
  }

  @Override public void onActivityCreated(Activity activity, Bundle bundle) {

  }

  @Override public void onActivityStarted(Activity activity) {

  }

  @Override public void onActivityResumed(Activity activity) {
    viewListener.registerListeners();
  }

  @Override public void onActivityPaused(Activity activity) {
    viewListener.unregisterListeners();
  }

  @Override public void onActivityStopped(Activity activity) {

  }

  @Override public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

  }

  @Override public void onActivityDestroyed(Activity activity) {

  }
}
