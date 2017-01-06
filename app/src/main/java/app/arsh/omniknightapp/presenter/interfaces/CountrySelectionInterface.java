package app.arsh.omniknightapp.presenter.interfaces;

import app.arsh.omniknightapp.model.repo.local.entity.Country;
import java.util.List;

/**
 * Created by arash on 1/5/17.
 */

public interface CountrySelectionInterface {

  public void showProgressBar();
  public void hideProgressBar();
  public void hideShowInternetConnectionProblem(Error error);
  public void loadCountries(List<Country> countryList);
}
