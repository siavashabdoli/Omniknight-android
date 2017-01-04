package app.arsh.omniknightapp.miscellaneous;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by arash on 9/27/16.
 */
public class ActivityUtil {
    private Activity activity;

    public ActivityUtil(Activity activity) {
        this.activity = activity;
    }

    public ActivityUtil changeActivity(Class destination){
        this.activity.startActivity(new Intent(activity, destination));
        return this;
    }

    public ActivityUtil changeActivityWithFinish(Class destination){
        this.activity.startActivity(new Intent(activity, destination));
        activity.finish();
        return this;
    }
}
