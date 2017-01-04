package app.arsh.omniknightapp.view.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;
import app.arsh.omniknightapp.R;
import app.arsh.omniknightapp.model.repo.local.entity.Country;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CityListFragment extends Fragment {

  private List<Country> countryList;

  private Unbinder unbinder;
  @BindView(R.id.imageViewNoCountry) ImageView imageViewNoCountry;
  @BindView(R.id.noCountryTextView) TextView noCountryTextView;


  public CityListFragment() {
    // Required empty public constructor
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

    View view = inflater.inflate(R.layout.fragment_city_list, container, false);
    unbinder = ButterKnife.bind(this, view);

    if (countryList == null || countryList.size() == 0) {
      imageViewNoCountry.setVisibility(View.VISIBLE);
      noCountryTextView.setVisibility(View.VISIBLE);
    } else {
      imageViewNoCountry.setVisibility(View.GONE);
      noCountryTextView.setVisibility(View.GONE);
    }

    return view;
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    unbinder.unbind();
  }

  public CityListFragment setCountryList(List<Country> countryList) {
    this.countryList = countryList;
    return this;
  }
}
