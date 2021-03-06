package app.arsh.omniknightapp.view.activities;

import android.Manifest;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import app.arsh.omniknightapp.R;
import app.arsh.omniknightapp.model.LocationManager;
import app.arsh.omniknightapp.model.repo.local.entity.Country;
import app.arsh.omniknightapp.presenter.MainActivityPresenter;
import app.arsh.omniknightapp.presenter.WeatherListPresenter;
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
import rx.functions.Action1;

public class MainActivity extends AppCompatActivity implements MainActivityInterface {

  @BindView(R.id.fab)              FloatingActionButton fab;
  @BindView(R.id.pointerImageView) ImageView pointerImageView;
  @BindView(R.id.toolbar) Toolbar toolbar;
  @BindView(R.id.searchBarEditText) EditText searchBar;

  private MainActivityPresenter presenter;
  private LocationManager locationManager;
  private WeatherListFragment weatherFragment;

  private Action1 presenterReady = callback -> {
    if ((Boolean) callback) {
      presenter.setWeatherListPresenterReady();
    }
  };

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    toolbar.setTitle(getString(R.string.weather));
    setSupportActionBar(toolbar);
    presenter = new MainActivityPresenter(this, this);

    RxView.clicks(fab)
        .subscribe(t ->
            fabClicked());

    presenter.onCreateViewFinished();
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the main_menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main_menu, menu);

    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    presenter.onOptionsItemSelected(item);
    return super.onOptionsItemSelected(item);
  }

  @Override public void loadCities(List<Country> countryList) {
    weatherFragment = new WeatherListFragment()
        .setCountryList(countryList)
        .setPresenterReadyCallback(presenterReady);

    ViewUtils.addFragment(getSupportFragmentManager()
        , weatherFragment
        , R.id.content_frame);
    pointerImageView.setVisibility(View.GONE);
  }

  @Override public void loadNoCityView() {
    weatherFragment = new WeatherListFragment()
        .setCountryList(null)
        .setPresenterReadyCallback(presenterReady);
    ViewUtils.addFragment(getSupportFragmentManager()
        ,weatherFragment
        , R.id.content_frame);

    pointerImageView.setAnimation(ViewUtils.BackForwardAnimate(100));
  }

  @Override public void showNoInternetConnection() {
    Toast.makeText(getApplicationContext(),
        getString(R.string.no_internet), Toast.LENGTH_LONG).show();
  }

  @Override public void loadCountrySelectionFragment() {
    CountrySelectionFragment countrySelection = new CountrySelectionFragment();
    countrySelection.show(getFragmentManager(), countrySelection.getClass().getSimpleName());
  }

  @Override public void registerListeners() {
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
  }

  @Override public void unregisterListeners() {
    if (locationManager != null) {
      locationManager.removeListener();
    }
  }

  @Override public void enterEditMode() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
      MenuItem menuItem = toolbar.getMenu().getItem(0);
      menuItem.setIcon(getDrawable(R.drawable.close_circle));
    }
  }

  @Override public void exitEditMode() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
      MenuItem menuItem = toolbar.getMenu().getItem(0);
      menuItem.setIcon(getDrawable(R.drawable.tooltip_edit));
    }
  }

  @Override public void confirmDeletingItems() {

    WeakReference<WeatherListPresenter> weakReference = new WeakReference<>(weatherFragment.getPresenter());

    new AlertDialog.Builder(this)
        .setTitle("Remove")
        .setMessage("Confirm deleting countries?")
        .setPositiveButton("Confirm", (dialogInterface, i) -> {
          weakReference.get().removeSelectedCountries();
        })
        .setNegativeButton("Cancel", (dialogInterface, i) -> {

        })
        .show();
  }

  @Override public void noCountryWarning() {
    Toast.makeText(getApplicationContext(), getApplicationContext().getString(R.string.no_country_to_edit), Toast.LENGTH_SHORT).show();
  }

  @Override public void showSearchBar() {
    searchBar.setVisibility(View.VISIBLE);
  }

  @Override public void hideSearchBar() {
    searchBar.setVisibility(View.GONE);
  }

  private void fabClicked() {
    presenter.fabButtonClicked();
  }

  public MainActivityPresenter getPresenter() {
    return presenter;
  }

}
