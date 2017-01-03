package app.arsh.omniknightapp.view.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

/**
 * Created by arash on 1/2/17.
 */

public class ViewUtils {

  public static void addFragment(FragmentManager fragmentManager, Fragment newFragment, int resourceId) {
    fragmentManager
        .beginTransaction()
        .replace(resourceId, newFragment)
        .commit();
    fragmentManager.executePendingTransactions();
  }

  public static void changeFragment(FragmentManager fragmentManager, Fragment newFragment, int resourceId) {
    fragmentManager
        .beginTransaction()
        .replace(resourceId, newFragment)
        .addToBackStack(null)
        .commit();
    fragmentManager.executePendingTransactions();
  }
}
