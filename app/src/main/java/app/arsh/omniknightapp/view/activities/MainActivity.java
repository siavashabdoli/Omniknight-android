package app.arsh.omniknightapp.view.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import app.arsh.omniknightapp.R;
import app.arsh.omniknightapp.presenter.MainActivityPresenter;
import app.arsh.omniknightapp.presenter.interfaces.MainActivityInterface;
import app.arsh.omniknightapp.view.utils.ViewUtils;
import app.arsh.omniknightapp.view.fragments.CityListFragment;

public class MainActivity extends AppCompatActivity implements MainActivityInterface {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    //TextView textView = (TextView) findViewById(R.id.textView);
    //RxView.clicks(textView).subscribe(t -> textView.setText("Hello Unit test!"));

    new MainActivityPresenter(this, this);
  } 

  @Override public void loadCities() {
    ViewUtils.addFragment(getSupportFragmentManager(),new CityListFragment(), R.id.content_frame);
  }

  @Override public void loadNoCityView() {

  }

  @Override public void loadErrorView() {

  }

}
