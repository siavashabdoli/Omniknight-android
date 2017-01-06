package app.arsh.omniknightapp.view.fragments;

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
import android.widget.TextView;
import app.arsh.omniknightapp.R;
import app.arsh.omniknightapp.model.entity.Weather;
import app.arsh.omniknightapp.model.repo.local.entity.Country;
import app.arsh.omniknightapp.presenter.WeatherListPresenter;
import app.arsh.omniknightapp.presenter.interfaces.WeatherListInterface;
import app.arsh.omniknightapp.view.adapters.CountriesAdapter;
import app.arsh.omniknightapp.view.adapters.WeatherAdapter;
import app.arsh.omniknightapp.view.utils.ViewUtils;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class WeatherListFragment extends Fragment implements WeatherListInterface {

  private List<Country> countryList;
  private List<Weather> weathersList = new ArrayList<>();

  private Unbinder unbinder;
  @BindView(R.id.imageViewNoCountry) ImageView imageViewNoCountry;
  @BindView(R.id.noCountryTextView) TextView noCountryTextView;
  @BindView(R.id.cloudImageView) ImageView cloudImageView;
  @BindView(R.id.weatherList) RecyclerView weatherList;
  private WeatherListPresenter presenter;
  private WeatherAdapter adapter;

  public WeatherListFragment() {
    // Required empty public constructor
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

    View view = inflater.inflate(R.layout.fragment_city_list, container, false);
    unbinder = ButterKnife.bind(this, view);

    if (countryList == null || countryList.size() == 0) {
      imageViewNoCountry.setVisibility(View.VISIBLE);
      noCountryTextView.setVisibility(View.VISIBLE);
      cloudImageView.setVisibility(View.VISIBLE);
    } else {
      imageViewNoCountry.setVisibility(View.GONE);
      noCountryTextView.setVisibility(View.GONE);
      cloudImageView.setVisibility(View.GONE);
      weatherList.setVisibility(View.VISIBLE);
      weatherList.setItemAnimator(new DefaultItemAnimator());
      weatherList.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
      adapter = new WeatherAdapter(weathersList, null);
      weatherList.setAdapter(adapter);
    }


    presenter = new WeatherListPresenter((AppCompatActivity) getActivity(), this, countryList);
    presenter.onCreateViewFinished();
    return view;
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    unbinder.unbind();
  }

  public WeatherListFragment setCountryList(List<Country> countryList) {
    this.countryList = countryList;
    return this;
  }

  @Override public void loadWeatherList(Weather weather) {
    adapter.addWeather(weather);
  }

  @Override public void showProgress() {
    imageViewNoCountry.setVisibility(View.VISIBLE);
    ViewUtils.RotateAnimation(1400);
  }

  @Override public void dismissProgress() {
    imageViewNoCountry.setAnimation(null);
    imageViewNoCountry.setVisibility(View.GONE);
  }

  @Override public void showError(Error error) {
    imageViewNoCountry.setVisibility(View.GONE);
  }

  @Override public void showNoInternetConnection() {

  }
}
