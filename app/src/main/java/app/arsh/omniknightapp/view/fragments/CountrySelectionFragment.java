package app.arsh.omniknightapp.view.fragments;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import app.arsh.omniknightapp.R;
import app.arsh.omniknightapp.model.repo.local.entity.Country;
import app.arsh.omniknightapp.presenter.CountrySelectionPresenter;
import app.arsh.omniknightapp.presenter.interfaces.CountrySelectionInterface;
import app.arsh.omniknightapp.view.adapters.CountriesAdapter;
import app.arsh.omniknightapp.view.utils.ViewUtils;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import java.util.List;
import rx.Observer;

/**
 * A simple {@link Fragment} subclass.
 */
public class CountrySelectionFragment extends DialogFragment implements CountrySelectionInterface {

  private CountrySelectionPresenter presenter;

  @BindView(R.id.countryList) RecyclerView recyclerView;
  @BindView(R.id.cloudProgressView) ImageView cloudImageView;

  private Observer countrySelected = new Observer<Country>() {
    @Override public void onCompleted() {

    }

    @Override public void onError(Throwable e) {

    }

    @Override public void onNext(Country o) {
      presenter.countrySelected(o);
    }
  };

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

    cloudImageView.startAnimation(ViewUtils.RotateAnimation(1400));
  }

  @Override public void hideProgressBar() {

    cloudImageView.setAnimation(null);
    cloudImageView.setVisibility(View.GONE);
  }

  @Override public void hideShowInternetConnectionProblem(Error error) {

  }

  @Override public void loadCountries(List<Country> countryList) {
    CountriesAdapter countriesAdapter = new CountriesAdapter(countryList, countrySelected);

    recyclerView.setAdapter(countriesAdapter);
  }

  @Override public void setupRecyclerView() {
    recyclerView.setItemAnimator(new DefaultItemAnimator());
    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

  }

  @Override public void dismissSelf() {
    dismiss();
  }

  @Override public void onDestroy() {
    super.onDestroy();
    unbinder.unbind();
  }
}
