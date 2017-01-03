package app.arsh.omniknightapp;

import app.arsh.omniknightapp.presenter.MainActivityPresenter;
import app.arsh.omniknightapp.presenter.interfaces.MainActivityInterface;
import app.arsh.omniknightapp.view.activities.MainActivity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

/**
 * Created by arash on 1/3/17.
 */

@RunWith(MockitoJUnitRunner.class)
public class MainActivityPresenterUnitTest {

  @Mock MainActivityInterface mainActivityInterface;
  @Mock MainActivity mainActivity;
  private MainActivityPresenter presenter;

  @Test
  public void testConstructorCallingLoadCities() {
    presenter = new MainActivityPresenter(mainActivityInterface, mainActivity);
    verify(mainActivityInterface).loadCities();
  }
}
