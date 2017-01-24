package app.arsh.omniknightapp.view.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;

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
        mAnimation = new RotateAnimation(0.0f, 360.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);

    //Setup anim with desired properties
    mAnimation.setInterpolator(new LinearInterpolator());
    mAnimation.setRepeatCount(Animation.INFINITE); //Repeat animation indefinitely
    mAnimation.setDuration(duration); //Put desired duration per anim cycle here, in milliseconds

    return mAnimation;
  }

  public static TranslateAnimation BackForwardAnimate(int duration) {
    TranslateAnimation mAnimation = new TranslateAnimation(
        TranslateAnimation.ABSOLUTE, 0f,
        TranslateAnimation.ABSOLUTE, 20f,
        TranslateAnimation.ABSOLUTE, 0f,
        TranslateAnimation.ABSOLUTE, 0f);
    mAnimation.setDuration(100);
    mAnimation.setRepeatCount(-1);
    mAnimation.setRepeatMode(Animation.REVERSE);
    mAnimation.setInterpolator(new LinearInterpolator());
    return mAnimation;
  }
}
