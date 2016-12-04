package app.arsh.omniknightapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import com.jakewharton.rxbinding.view.RxView;
import java.util.ArrayList;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    TextView textView = (TextView) findViewById(R.id.textView);
    RxView.clicks(textView).subscribe(t -> showMessage());

    CacheManager cacheManager = new CacheManager();
    cacheManager.addToCache(" Hello Wordl", "");
    cacheManager.addToCache(" Hello Word2", this);
  }

  public void showMessage() {
    Toast.makeText(getApplicationContext(), "Hello World!", Toast.LENGTH_LONG).show();
    Observable
        .just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        .filter(integer -> integer % 2 == 0)
        .map(this::multiple)
        .takeUntil(integer -> integer.length() > 0)
        .subscribeOn(Schedulers.computation())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(System.out::println);

    Observable
        .just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        .map(String::valueOf)
        .forEach(this::addToArray);
  }

  public String multiple(int input) {
    return "Number is :"+input;
  }

  public <I extends String> void addToArray(I item) {
    System.out.print(item);
  }

  public int print() {

    return 0;
  }
}
