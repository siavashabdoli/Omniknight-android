package app.arsh.omniknightapp.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import app.arsh.omniknightapp.Omniknight;
import app.arsh.omniknightapp.model.repo.local.DBClient;
import app.arsh.omniknightapp.model.repo.local.entity.Country;
import app.arsh.omniknightapp.presenter.interfaces.MainActivityInterface;
import javax.inject.Inject;

/**
 * Created by arash on 1/2/17.
 */

public class MainActivityPresenter extends BasePresenter {

  private MainActivityInterface viewListener;
  private Context context;
  @Inject DBClient dbClient;

  public MainActivityPresenter(@NonNull MainActivityInterface viewListener,
      @NonNull AppCompatActivity activity) {

    this.viewListener = viewListener;
    this.context = activity;
    ((Omniknight)activity.getApplication()).getDbCompnent().inject(this);

    Country sample = new Country();
    sample.setName("Sweden");
    dbClient.addNewCountry(sample);

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
