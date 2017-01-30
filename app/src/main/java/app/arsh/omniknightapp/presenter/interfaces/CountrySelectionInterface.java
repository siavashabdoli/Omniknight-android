package app.arsh.omniknightapp.presenter.interfaces;

import app.arsh.omniknightapp.model.repo.local.entity.Country;
import java.util.List;

/**
 * Created by arash on 1/5/17.
 */

public interface CountrySelectionInterface {

  void showProgressBar();
  void hideProgressBar();
  void loadCountries(List<Country> countryList);
  void setupRecyclerView();
  void dismissSelf();

  void toastErrorHappened();
}
