package app.arsh.omniknightapp.view.activities;

import android.Manifest;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import app.arsh.omniknightapp.R;
import app.arsh.omniknightapp.model.LocationManager;
import app.arsh.omniknightapp.model.repo.local.entity.Country;
import app.arsh.omniknightapp.presenter.MainActivityPresenter;
import app.arsh.omniknightapp.presenter.interfaces.MainActivityInterface;
import app.arsh.omniknightapp.view.fragments.WeatherListFragment;
import app.arsh.omniknightapp.view.fragments.CountrySelectionFragment;
import app.arsh.omniknightapp.view.utils.ViewUtils;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.jakewharton.rxbinding.view.RxView;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;
import java.lang.ref.WeakReference;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainActivityInterface {

  @BindView(R.id.fab) FloatingActionButton fab;

  private MainActivityPresenter presenter;
  private LocationManager locationManager;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    WeakReference<MainActivity> weakReference = new WeakReference<>(this);
    Dexter.withActivity(this)
        .withPermission(Manifest.permission.ACCESS_COARSE_LOCATION)
        .withListener(new PermissionListener() {
          @Override public void onPermissionGranted(PermissionGrantedResponse response) {
            locationManager = new LocationManager(weakReference.get());
          }
          @Override public void onPermissionDenied(PermissionDeniedResponse response) {

          }
          @Override public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {

          }
        }).check();
    presenter = new MainActivityPresenter(this, this);

    RxView.clicks(fab)
        .subscribe(t ->
            fabClicked());

    presenter.viewOnCreateFinished();
  }

  @Override protected void onPause() {
    super.onPause();
    if (locationManager != null) {
      locationManager.removeListener();
    }
  }

  @Override public void loadCities(List<Country> countryList) {
    ViewUtils.addFragment(getSupportFragmentManager()
        ,new WeatherListFragment().setCountryList(countryList)
        , R.id.content_frame);
  }

  @Override public void loadNoCityView() {
    ViewUtils.addFragment(getSupportFragmentManager()
        ,new WeatherListFragment().setCountryList(null)
        , R.id.content_frame);
  }

  @Override public void loadErrorView() {

  }

  @Override public void loadCountrySelectionFragment() {
    CountrySelectionFragment countrySelection = new CountrySelectionFragment();
    countrySelection.show(getFragmentManager(), countrySelection.getClass().getSimpleName());
  }

  private void fabClicked() {
    presenter.fabButtonClicked();
  }

  public MainActivityPresenter getPresenter() {
    return presenter;
  }

}
