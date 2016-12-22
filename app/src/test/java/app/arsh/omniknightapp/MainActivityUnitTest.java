package app.arsh.omniknightapp;

import android.widget.TextView;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;

/**
 * Created by arash on 12/23/16.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 23)
public class MainActivityUnitTest {
  @Test
  public void clickingButton_shouldChangeResultsViewText() throws Exception {
    MainActivity activity = Robolectric.setupActivity(MainActivity.class);

    TextView results = (TextView) activity.findViewById(R.id.textView);

    results.performClick();
    assertEquals(results.getText().toString(), "Hello Unit test!");
  }
}

