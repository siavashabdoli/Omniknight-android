package app.arsh.omniknightapp.presenter;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;
import app.arsh.omniknightapp.Omniknight;
import app.arsh.omniknightapp.R;
import app.arsh.omniknightapp.model.repo.local.DBClient;
import app.arsh.omniknightapp.model.repo.local.entity.Country;
import app.arsh.omniknightapp.model.repo.remote.RESTClient;
import app.arsh.omniknightapp.presenter.interfaces.CountrySelectionInterface;
import app.arsh.omniknightapp.view.activities.MainActivity;
import java.util.List;
import javax.inject.Inject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observer;

/**
 * Created by arash on 1/5/17.
 */

public class CountrySelectionPresenter extends BasePresenter {

  private static final String TAG = CountrySelectionPresenter.class.getSimpleName();
  private CountrySelectionInterface listener;
  private AppCompatActivity activity;
  @Inject RESTClient client;
  @Inject DBClient dbClient;
  private Observer<Country> countryObserver = new Observer<Country>() {
    @Override public void onCompleted() {

    }

    @Override public void onError(Throwable e) {

    }

    @Override public void onNext(Country country) {
      ((MainActivity)activity).getPresenter().updateView();
    }
  };

  public CountrySelectionPresenter(@NonNull AppCompatActivity activity, CountrySelectionInterface listener) {
    this.activity = activity;
    this.listener = listener;
    ((Omniknight) activity.getApplication()).getAppComponent().inject(this);
    dbClient.setCountryChangeObserver(countryObserver);

  }

  @Override public void onCreateViewFinished() {

    client.getAllCountriesService().enqueue(new Callback<List<Country>>() {
      @Override public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {
        Log.d(TAG, "onResponse: "+response.toString());
        listener.hideProgressBar();
        listener.setupRecyclerView();
        listener.loadCountries(response.body());
      }

      @Override public void onFailure(Call<List<Country>> call, Throwable t) {
        Log.d(TAG, "onFailure: "+t.getLocalizedMessage());
        listener.hideProgressBar();
        listener.dismissSelf();
        Toast.makeText(activity, activity.getString(R.string.error), Toast.LENGTH_LONG).show();
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
  }
}
