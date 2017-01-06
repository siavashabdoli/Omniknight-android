package app.arsh.omniknightapp.view.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;

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

  public static RotateAnimation RotateAnimation(int duration) {
    RotateAnimation
        anim = new RotateAnimation(0.0f, 360.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);

    //Setup anim with desired properties
    anim.setInterpolator(new LinearInterpolator());
    anim.setRepeatCount(Animation.INFINITE); //Repeat animation indefinitely
    anim.setDuration(duration); //Put desired duration per anim cycle here, in milliseconds

    return anim;
  }
}
