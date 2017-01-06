package app.arsh.omniknightapp;

import app.arsh.omniknightapp.presenter.MainActivityPresenter;
import app.arsh.omniknightapp.presenter.interfaces.MainActivityInterface;
import app.arsh.omniknightapp.view.activities.MainActivity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.mockito.Mockito.verify;

/**
 * Created by arash on 1/3/17.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 23, manifest = "/src/main/AndroidManifest.xml")
public class MainActivityPresenterUnitTest {

  MainActivityInterface mainActivityInterface;
  MainActivity mainActivity;
  private MainActivityPresenter presenter;

  @Test
  public void testConstructor() {
    mainActivityInterface = Mockito.mock(MainActivityInterface.class);
    mainActivity = Robolectric.setupActivity(MainActivity.class);
    presenter = new MainActivityPresenter(mainActivityInterface, mainActivity);

    presenter.viewOnCreateFinished();
    if (presenter.getDbClient().getCountries().size() == 0) verify(mainActivityInterface).loadNoCityView();
    else verify(mainActivityInterface).loadCities(presenter.getDbClient().getCountries());
  }

  @Test
  public void fabButtonClickedEvent() {
    mainActivityInterface = Mockito.mock(MainActivityInterface.class);
    mainActivity = Robolectric.setupActivity(MainActivity.class);

    presenter = new MainActivityPresenter(mainActivityInterface, mainActivity);

    mainActivity.findViewById(R.id.fab).performClick();
    presenter.fabButtonClicked();
    verify(mainActivityInterface).loadCountrySelectionFragment();

  }
}
