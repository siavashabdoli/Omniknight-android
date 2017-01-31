package app.arsh.omniknightapp.presenter;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import app.arsh.omniknightapp.Omniknight;
import app.arsh.omniknightapp.model.conductor.Conductor;
import app.arsh.omniknightapp.model.repo.local.DBClient;
import app.arsh.omniknightapp.model.repo.local.entity.Country;
import app.arsh.omniknightapp.model.repo.remote.RESTClient;
import app.arsh.omniknightapp.presenter.interfaces.CountrySelectionInterface;
import app.arsh.omniknightapp.view.utils.CountrySelectionAdapterCallBack;
import java.util.List;
import javax.inject.Inject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by arash on 1/5/17.
 */

public class CountrySelectionPresenter extends BasePresenter {

  private static final String TAG = CountrySelectionPresenter.class.getSimpleName();
  private CountrySelectionInterface listener;
  private Call<List<Country>> countryService;
  @Inject RESTClient client;
  @Inject DBClient dbClient;
  @Inject Conductor conductor;

  public CountrySelectionPresenter(@NonNull AppCompatActivity activity, CountrySelectionInterface listener) {
    this.listener = listener;
    ((Omniknight) activity.getApplication()).getAppComponent().inject(this);
    dbClient.setCountryChangeObserver(new CountrySelectionAdapterCallBack<>().
        getCountryObserver(activity));

  }

  @Override public void onCreateViewFinished() {

    conductor.addPresenter(this);
    countryService = client.getAllCountriesService();
    countryService.enqueue(new Callback<List<Country>>() {
      @Override public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {
        if (!call.isCanceled()) {
          Log.d(TAG, "onResponse: " + response.toString());
          listener.hideProgressBar();
          listener.setupRecyclerView();
          listener.loadCountries(response.body());
        }
      }

      @Override public void onFailure(Call<List<Country>> call, Throwable t) {
        if (!call.isCanceled()) {
          Log.d(TAG, "onFailure: " + t.getLocalizedMessage());
          listener.hideProgressBar();
          listener.toastErrorHappened();
          listener.dismissSelf();
        }
      }
    });
    listener.showProgressBar();
  }

  @Override protected void setupView() {

  }

  public void countrySelected(Country o) {
    dbClient.addNewCountry(o);
    listener.dismissSelf();
  }

  public void dismissed() {
    if (countryService != null) countryService.cancel();
    dbClient = null;
    client = null;
  }
}
