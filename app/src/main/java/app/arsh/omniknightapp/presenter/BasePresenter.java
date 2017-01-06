package app.arsh.omniknightapp.presenter;

/**
 * Created by arash on 1/2/17.
 */

public abstract class BasePresenter {

  protected abstract void setupView();
  protected abstract void showErrorView();
  protected abstract void showProgressView();
  public abstract void onCreateViewFinished();
}
