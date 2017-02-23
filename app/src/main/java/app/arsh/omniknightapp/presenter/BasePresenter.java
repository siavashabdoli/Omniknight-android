package app.arsh.omniknightapp.presenter;

import android.support.annotation.CallSuper;

/**
 * Created by arash on 1/2/17.
 */

public abstract class BasePresenter {
  private boolean viewAttached;
  protected abstract void setupView();
  @CallSuper
  public void onCreateViewFinished(){
   viewAttached = true;
  }
  public void viewDetached(){
    viewAttached = false;
  }

  public boolean isViewAttached() {
    return viewAttached;
  }
}
