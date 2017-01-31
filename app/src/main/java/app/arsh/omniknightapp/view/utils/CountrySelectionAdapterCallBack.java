package app.arsh.omniknightapp.view.utils;

import android.support.v7.app.AppCompatActivity;
import app.arsh.omniknightapp.model.repo.local.entity.Country;
import app.arsh.omniknightapp.presenter.CountrySelectionPresenter;
import app.arsh.omniknightapp.view.activities.MainActivity;
import javax.inject.Inject;
import rx.Observer;

/**
 * Created by arash on 1/29/17.
 */

public class CountrySelectionAdapterCallBack<T extends Country> {


  public Observer<Country> getCountryObserver(AppCompatActivity activity) {
    return new Observer<Country>() {
      @Override public void onCompleted() {

      }

      @Override public void onError(Throwable e) {

      }

      @Override public void onNext(Country country) {
        ((MainActivity)activity).getPresenter().updateView();
      }
    };
  }

}
