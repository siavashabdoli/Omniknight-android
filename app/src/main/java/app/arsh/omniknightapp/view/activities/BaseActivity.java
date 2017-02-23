package app.arsh.omniknightapp.view.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import app.arsh.omniknightapp.presenter.BasePresenter;

/**
 * Created by Siavash on 2/12/17.
 */

public class BaseActivity<T extends BasePresenter> extends AppCompatActivity {
    private T presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.viewDetached();
    }

    public T getPresenter(){
        return presenter;
    }
}
