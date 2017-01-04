package app.arsh.omniknightapp.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import app.arsh.omniknightapp.Omniknight;
import app.arsh.omniknightapp.model.entity.Country;
import app.arsh.omniknightapp.model.repo.local.DBClient;
import app.arsh.omniknightapp.presenter.interfaces.MainActivityInterface;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by arash on 1/2/17.
 */

public class MainActivityPresenter extends BasePresenter {

  private MainActivityInterface viewListener;
  private Context context;
  @Inject DBClient dbClient;

  public MainActivityPresenter(@NonNull MainActivityInterface viewListener,@NonNull
      AppCompatActivity activity) {

    this.viewListener = viewListener;
    this.context = activity;
    ((Omniknight)activity.getApplication()).getDbCompnent().inject(this);

    List<Country> c = dbClient.getAvailableCountries();

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
