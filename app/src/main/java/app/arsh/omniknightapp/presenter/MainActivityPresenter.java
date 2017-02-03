package app.arsh.omniknightapp.presenter;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import app.arsh.omniknightapp.Omniknight;
import app.arsh.omniknightapp.R;
import app.arsh.omniknightapp.model.conductor.Conductor;
import app.arsh.omniknightapp.model.repo.local.DBClient;
import app.arsh.omniknightapp.model.repo.local.entity.Country;
import app.arsh.omniknightapp.presenter.interfaces.MainActivityInterface;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by arash on 1/2/17.
 */

public class MainActivityPresenter extends BasePresenter {

  private List<Country> countryList;
  private MainActivityInterface viewListener;
  @Inject DBClient dbClient;
  @Inject Conductor conductor;
  private WeatherListPresenter weatherListPresenter;
  private boolean editMode = false;
  private boolean searchMode = false;

  public void setWeatherListPresenterReady() {
    weatherListPresenter = (WeatherListPresenter) conductor.getPresenter(WeatherListPresenter.class);
  }

  public MainActivityPresenter(@NonNull MainActivityInterface viewListener,
      @NonNull AppCompatActivity activity) {

    this.viewListener = viewListener;
    ((Omniknight)activity.getApplication()).getAppComponent().inject(this);
    conductor.setCurrentActivity(activity);
    conductor.addPresenter(this);
  }

  @Override protected void setupView() {
    viewListener.loadCities(countryList);
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

  public void onOptionsItemSelected(MenuItem menuItem) {
    if (menuItem.getItemId() == R.id.extra) {
      if (countryList.isEmpty()) {
        viewListener.noCountryWarning();
      } else {
        if (weatherListPresenter != null) {
          if (!editMode) {
            weatherListPresenter.recyclerViewEnterEditMode();
            viewListener.enterEditMode();
          } else {
            weatherListPresenter.recyclerViewExitEditMode();
            if (weatherListPresenter.getRemovableCountries().size() > 0) {
              viewListener.confirmDeletingItems();
            }
            viewListener.exitEditMode();
          }
          editMode = !editMode;
        }
      }
    }
    if (menuItem.getItemId() == R.id.search) {
      if (searchMode) {
        viewListener.showSearchBar();
      } else {
        viewListener.hideSearchBar();
      }
      searchMode = !searchMode;
    }
  }

  private void updateData() {
    countryList = dbClient.getCountries();
  }

  public void showNoInternetConnection() {
    viewListener.showNoInternetConnection();
  }
}
