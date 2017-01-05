package app.arsh.omniknightapp.view.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import app.arsh.omniknightapp.R;
import app.arsh.omniknightapp.model.repo.local.entity.Country;
import app.arsh.omniknightapp.presenter.MainActivityPresenter;
import app.arsh.omniknightapp.presenter.interfaces.MainActivityInterface;
import app.arsh.omniknightapp.view.fragments.CountrySelectionFragment;
import app.arsh.omniknightapp.view.utils.ViewUtils;
import app.arsh.omniknightapp.view.fragments.CityListFragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.jakewharton.rxbinding.view.RxView;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainActivityInterface {

  @BindView(R.id.fab) FloatingActionButton fab;
  private MainActivityPresenter presenter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    presenter = new MainActivityPresenter(this, this);

    RxView.clicks(fab)
        .subscribe(t ->
            fabClicked());

    presenter.viewOnCreateFinished();
  } 

  @Override public void loadCities(List<Country> countryList) {
    ViewUtils.addFragment(getSupportFragmentManager()
        ,new CityListFragment().setCountryList(countryList)
        , R.id.content_frame);
  }

  @Override public void loadNoCityView() {
    ViewUtils.addFragment(getSupportFragmentManager()
        ,new CityListFragment().setCountryList(null)
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

}
