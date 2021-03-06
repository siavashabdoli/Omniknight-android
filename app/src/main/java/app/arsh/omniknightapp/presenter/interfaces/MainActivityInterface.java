package app.arsh.omniknightapp.presenter.interfaces;

import app.arsh.omniknightapp.model.repo.local.entity.Country;
import java.util.List;

/**
 * Created by arash on 1/2/17.
 */

public interface MainActivityInterface {

  void loadCities(List<Country> countryList);
  void loadNoCityView();

  void showNoInternetConnection();

  void loadCountrySelectionFragment();
  void registerListeners();
  void unregisterListeners();

  void enterEditMode();
  void exitEditMode();

  void confirmDeletingItems();

  void noCountryWarning();

  void showSearchBar();
  void hideSearchBar();
}
