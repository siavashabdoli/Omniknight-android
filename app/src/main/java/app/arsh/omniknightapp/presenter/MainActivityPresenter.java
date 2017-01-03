package app.arsh.omniknightapp.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import app.arsh.omniknightapp.presenter.interfaces.MainActivityInterface;

/**
 * Created by arash on 1/2/17.
 */

public class MainActivityPresenter<T extends Context> extends BasePresenter {

  private MainActivityInterface viewListener;
  private Context context;

  public <T extends Context> MainActivityPresenter(@NonNull MainActivityInterface viewListener,@NonNull  T activity) {
    this.viewListener = viewListener;
    this.context = activity;

    setupView();
  }

  @Override public void setupView() {
    viewListener.loadCities();
  }

  @Override public void showErrorView() {

  }

  @Override public void showProgressView() {

  }
}
