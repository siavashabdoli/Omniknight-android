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
import app.arsh.omniknightapp.view.adapters.InsetDivider;
import app.arsh.omniknightapp.view.adapters.WeatherAdapter;
import app.arsh.omniknightapp.view.utils.ViewUtils;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import java.util.ArrayList;
import java.util.List;
import rx.functions.Action1;

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

  private Action1 presenterReadyCallback;

  public WeatherListFragment() {
    // Required empty public constructor
  }

  public WeatherListFragment setPresenterReadyCallback(Action1 presenterReady) {
    this.presenterReadyCallback = presenterReady;
    return this;
  }

  public WeatherListPresenter getPresenter() {
    return presenter;
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

    View view = inflater.inflate(R.layout.fragment_city_list, container, false);
    unbinder = ButterKnife.bind(this, view);

    if (countryList == null || countryList.size() == 0) {
      displayNoCityAvailableImages();
    } else {
      hideNoCityAvailableImages();
      weatherList.setItemAnimator(new DefaultItemAnimator());
      weatherList.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
      weatherList.addItemDecoration(getItemDecorator());

      adapter = new WeatherAdapter(weathersList, null);
      weatherList.setAdapter(adapter);
    }

    presenter = new WeatherListPresenter((AppCompatActivity) getActivity(), this, countryList);
    presenter.setPresenterReadyCallback(presenterReadyCallback);
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
    adapter.notifyDataSetChanged();
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

  @Override public void recyclerViewEnterEditMode() {
    adapter.setEditMode(true);
    adapter.notifyDataSetChanged();
  }

  @Override public void recyclerViewExitEditMode() {
    adapter.setEditMode(false);
    adapter.notifyDataSetChanged();
  }

  private void displayNoCityAvailableImages() {
    imageViewNoCountry.setVisibility(View.VISIBLE);
    noCountryTextView.setVisibility(View.VISIBLE);
    cloudImageView.setVisibility(View.VISIBLE);
  }

  private void hideNoCityAvailableImages() {
    imageViewNoCountry.setVisibility(View.GONE);
    noCountryTextView.setVisibility(View.GONE);
    cloudImageView.setVisibility(View.GONE);
    weatherList.setVisibility(View.VISIBLE);
  }

  private InsetDivider getItemDecorator() {
    return new InsetDivider.Builder(getActivity())
        .orientation(InsetDivider.VERTICAL_LIST)
        .dividerHeight(16)
        .color(getResources().getColor(R.color.white))
        .insets(4, 0)
        .overlay(true)
        .build();
  }
}
