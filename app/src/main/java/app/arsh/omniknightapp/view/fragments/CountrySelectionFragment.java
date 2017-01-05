package app.arsh.omniknightapp.view.fragments;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.arsh.omniknightapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CountrySelectionFragment extends DialogFragment {

  public CountrySelectionFragment() {
    // Required empty public constructor
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_country_selection, container, false);


    return view;
  }
}
