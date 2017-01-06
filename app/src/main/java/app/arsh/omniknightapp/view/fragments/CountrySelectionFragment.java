package app.arsh.omniknightapp.view.fragments;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.arsh.omniknightapp.R;
import app.arsh.omniknightapp.model.repo.local.entity.Country;
import app.arsh.omniknightapp.presenter.CountrySelectionPresenter;
import app.arsh.omniknightapp.presenter.interfaces.CountrySelectionInterface;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CountrySelectionFragment extends DialogFragment implements CountrySelectionInterface {

  private CountrySelectionPresenter presenter;

  @BindView(R.id.loadingCountriesProgressBar) View progressBar;
  @BindView(R.id.countryList) RecyclerView recyclerView;

  Unbinder unbinder;

  public CountrySelectionFragment() {
    // Required empty public constructor
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_country_selection, container, false);
    unbinder = ButterKnife.bind(this, view);

    presenter = new CountrySelectionPresenter((AppCompatActivity) getActivity(), this);
    presenter.onCreateViewFinished();
    return view;
  }

  @Override public void showProgressBar() {
    progressBar.setVisibility(View.VISIBLE);
  }

  @Override public void hideProgressBar() {
    progressBar.setVisibility(View.GONE);
  }

  @Override public void hideShowInternetConnectionProblem(Error error) {

  }

  @Override public void loadCountries(List<Country> countryList) {

  }

  @Override public void onDestroy() {
    super.onDestroy();
    unbinder.unbind();
  }
}
