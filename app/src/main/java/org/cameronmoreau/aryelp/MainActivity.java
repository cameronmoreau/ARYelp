package org.cameronmoreau.aryelp;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.wikitude.architect.ArchitectView;
import com.wikitude.architect.StartupConfiguration;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    LocationManager locationManager;
    ArchitectView architectView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Log.d("TEST", "App started");

        this.architectView = (ArchitectView) this.findViewById(R.id.architectView);

        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                Log.d("TEST", "Location Changed " + location.toString());
                architectView.setLocation(
                        location.getLatitude(),
                        location.getLongitude(),
                        location.getAltitude(),
                        location.getAccuracy()
                );

                locationManager.removeUpdates(this);
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        });

        final StartupConfiguration config = new StartupConfiguration("upzgG77j3lK1CsHwXs0LyJGvC3GvMl3LhjHujsPXOoMwSwZ+XSUwVGCpE3HmQrnROuNrHZvpx0qfDP17WOV6XcioQAf7U2P8c4ENo6WdiyAEiPKm4eE9bbefO4KXVMjxiQrXGC7j5DeZ2bY96vM4yu8rVyx7KgbT9J7p+nVlFeFTYWx0ZWRfX3UKFpCrA92Xm7THDgpfQRu75S/lqehohDU2U2WNpU8p4eu2uh40BFARdaXz6eHvjcIC3OIdU8a4k8AQN3+pzwMk1cTkTLbLf/b9CYOTpPkY7S5O90dnrzpyD4ifimEHF0Ei2ycceEUI2szz4QhdoCpEyti1B6Uzq/g7I3u8CRtNDq2ZT42nnDMf8pH5E3Z4Qad9HzRZBZgGQCwOQM0Tv4iVrywLv3X+8BqGOR9sKvmRiQ37VbmoQayLu3/l92vTBi+AiYxdqhFQ1ZHA5L8pghwuftvSYeQ0h9CvX1mboRWknzBWSZchXDDR2lLStTgXUGIsBMNLR9RDuWKqa1EjDdLGyymGwlEZGAqDXZFujC8Nwa9jJDzj1I5QZ69RtRAPHR1LxzOlISelBRWloE3kb/JNcBJ5R6R+7TMArCgkOhl34NXlpYNXAxVoTPgJwm+bKPc0Vdla5UC7Zvj6CA0SbTNBItly2SwH00LgcTuFYIBkJ/yRm3NcD4Q=");
        this.architectView.onCreate(config);

    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        this.architectView.onPostCreate();
        try {
            this.architectView.load("file:///android_asset/pois/index.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        architectView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        architectView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        architectView.onDestroy();
    }

    void requestPermissions() {

    }
}
