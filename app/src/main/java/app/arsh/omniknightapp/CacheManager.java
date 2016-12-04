package app.arsh.omniknightapp;

import android.util.ArrayMap;
import android.util.Log;

/**
 * Created by arash on 12/4/16.
 */

public class CacheManager<T> {

  ArrayMap<String, T> cache = new ArrayMap<>();

  public void addToCache(String keyObject,T valueObject) {
    cache.put(keyObject, valueObject);
    Log.i("", "addToCache: ");
  }
}
