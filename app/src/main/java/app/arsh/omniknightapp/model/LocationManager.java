package app.arsh.omniknightapp.model;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.widget.Toast;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

/**
 * Created by arash on 1/20/17.
 */

public class LocationManager implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener,
    LocationListener {

  LocationRequest mLocationRequest;
  GoogleApiClient mGoogleApiClient;
  private Activity activity;

  public LocationManager(Activity activity) {
    this.activity = activity;

    buildGoogleApiClient();
  }

  protected synchronized void buildGoogleApiClient() {
    mGoogleApiClient = new GoogleApiClient.Builder(this.activity).addConnectionCallbacks(this)
        .addOnConnectionFailedListener(this)
        .addApi(LocationServices.API)
        .build();
  }

  @Override public void onConnected(Bundle bundle) {

    mLocationRequest = new LocationRequest();
    mLocationRequest.setInterval(10);
    mLocationRequest.setFastestInterval(10);
    mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);

    if (ActivityCompat.checkSelfPermission(this.activity, Manifest.permission.ACCESS_FINE_LOCATION)
        != PackageManager.PERMISSION_GRANTED
        && ActivityCompat.checkSelfPermission(this.activity, Manifest.permission.ACCESS_COARSE_LOCATION)
        != PackageManager.PERMISSION_GRANTED) {

      return;
    }
    LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest,
        this);
  }

  @Override
  public void onConnectionSuspended(int i) {
  }

  @Override
  public void onConnectionFailed(ConnectionResult connectionResult) {
  }

  @Override
  public void onLocationChanged(Location location) {

    Log.d("locationtesting", "accuracy: " + location.getAccuracy() + " lat: " + location.getLatitude() + " lon: " + location.getLongitude());

    Toast.makeText(this.activity,"Location Changed",Toast.LENGTH_SHORT).show();
  }

  public void removeListener() {
    if (mGoogleApiClient.isConnected()) {
      LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
    }
  }
}
