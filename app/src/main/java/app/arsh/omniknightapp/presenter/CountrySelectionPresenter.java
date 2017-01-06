package app.arsh.omniknightapp.presenter;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import app.arsh.omniknightapp.Omniknight;
import app.arsh.omniknightapp.model.repo.local.DBClient;
import app.arsh.omniknightapp.model.repo.local.entity.Country;
import app.arsh.omniknightapp.presenter.interfaces.CountrySelectionInterface;
import app.arsh.omniknightapp.view.activities.MainActivity;
import java.util.List;
import javax.inject.Inject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by arash on 1/5/17.
 */

public class CountrySelectionPresenter extends BasePresenter {

  private CountrySelectionInterface listener;
  private AppCompatActivity activity;
  @Inject Call<List<Country>> getCountries;
  @Inject DBClient dbClient;

  public CountrySelectionPresenter(@NonNull AppCompatActivity activity, CountrySelectionInterface listener) {
    this.activity = activity;
    this.listener = listener;
    ((Omniknight) activity.getApplication()).getAppComponent().inject(this);

  }

  @Override public void onCreateViewFinished() {

    getCountries.enqueue(new Callback<List<Country>>() {
      @Override public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {
        Log.d(getClass().getSimpleName(), "onResponse: "+response.toString());
        listener.hideProgressBar();
        listener.setupRecyclerView();
        listener.loadCountries(response.body());
      }

      @Override public void onFailure(Call<List<Country>> call, Throwable t) {
        Log.d(getClass().getSimpleName(), "onFailure: "+t.getLocalizedMessage());
        listener.hideProgressBar();
      }
    });
    listener.showProgressBar();
  }

  @Override protected void setupView() {

  }

  @Override protected void showErrorView() {

  }

  @Override protected void showProgressView() {

  }

  public void countrySelected(Country o) {
    dbClient.addNewCountry(o);
    listener.dismissSelf();
    ((MainActivity)activity).getPresenter().updateView();
  }
}
