package app.arsh.omniknightapp.view.fragments;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
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

  @BindView(R.id.countryList) RecyclerView recyclerView;
  @BindView(R.id.cloudProgressView) ImageView cloudImageView;

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

    RotateAnimation anim = new RotateAnimation(0.0f, 360.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);

    //Setup anim with desired properties
    anim.setInterpolator(new LinearInterpolator());
    anim.setRepeatCount(Animation.INFINITE); //Repeat animation indefinitely
    anim.setDuration(1400); //Put desired duration per anim cycle here, in milliseconds

    // Start animating the image
    cloudImageView.startAnimation(anim);
  }

  @Override public void hideProgressBar() {

    cloudImageView.setAnimation(null);
    cloudImageView.setVisibility(View.GONE);
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
