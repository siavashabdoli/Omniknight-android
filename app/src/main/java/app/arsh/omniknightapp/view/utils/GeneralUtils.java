package app.arsh.omniknightapp.view.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by arash on 9/27/16.
 */
public class GeneralUtils {
    public static boolean isValidEmail(String email) {
        if (email.equals("name@email.com")){
            return true;
        }else{
            return false;
        }
    }

    public static boolean isNetworkAvailable(Context context) {

        if (context == null){
            return false;
        }

        return getNetworkInfo(context);
    }

    private static boolean getNetworkInfo(Context context){
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager == null) return false;

        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected() && networkInfo.isAvailable();
    }
}
