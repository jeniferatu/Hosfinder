package com.hospitalfinder.hosfinder;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, LocationListener {

    private GoogleMap mMap;
    private LatLng latLngGj = new LatLng(-6.730303, 108.554839);
    private LatLng latLngPc = new LatLng(-6.713455, 108.567239);
    private LatLng latLngCc = new LatLng(-6.737919, 108.549684);
    private LatLng latLngAd = new LatLng(-6.724060, 108.569004);
    private LatLng latLngPu = new LatLng(-6.746648, 108.562696);
    private LatLng latLngBl = new LatLng(-6.752551, 108.549955);
    private LatLng latLngSk = new LatLng(-6.708857, 108.559734);
    private LatLng latLngBa = new LatLng(-6.747577, 108.534030);
    private LatLng latLngBm = new LatLng(-6.742967, 108.539832);
    private LatLng latLngCb = new LatLng(-6.734228, 108.539278);


    private LatLng latLngMu = new LatLng(-6.708846, 108.551269);
    private LatLng latLngSb = new LatLng(-6.756797, 108.469670);
    private LatLng latLngPt = new LatLng(-6.683628, 108.552136);
    private LatLng latLngMp = new LatLng(-6.701541, 108.481268);
    private LatLng latLngKh = new LatLng(-6.707388, 108.433485);
    private LocationManager mLocationManager = null;
    private String provider = null;
    private Marker mCurrentPosition = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        if (isProviderAvailable() && (provider != null)) {
            locateCurrentPosition();
        }
    }

    private void locateCurrentPosition() {

        int status = getPackageManager().checkPermission(android.Manifest.permission.ACCESS_COARSE_LOCATION,
                getPackageName());

        if (status == PackageManager.PERMISSION_GRANTED) {
            Location location = mLocationManager.getLastKnownLocation(provider);
            updateWithNewLocation(location);
            //  mLocationManager.addGpsStatusListener(this);
            long minTime = 5000;// ms
            float minDist = 5.0f;// meter
            mLocationManager.requestLocationUpdates(provider, minTime, minDist,
                    this);
        }
    }


    private boolean isProviderAvailable() {
        mLocationManager = (LocationManager) getSystemService(
                Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_COARSE);
        criteria.setAltitudeRequired(false);
        criteria.setBearingRequired(false);
        criteria.setCostAllowed(true);
        criteria.setPowerRequirement(Criteria.POWER_LOW);

        provider = mLocationManager.getBestProvider(criteria, true);
        if (mLocationManager
                .isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
            provider = LocationManager.NETWORK_PROVIDER;

            return true;
        }

        if (mLocationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            provider = LocationManager.GPS_PROVIDER;
            return true;
        }

        if (provider != null) {
            return true;
        }
        return false;
    }

    private void updateWithNewLocation(Location location) {

        if (location != null && provider != null) {
            double lng = location.getLongitude();
            double lat = location.getLatitude();

            addBoundaryToCurrentPosition(lat, lng);

            CameraPosition camPosition = new CameraPosition.Builder()
                    .target(new LatLng(lat, lng)).zoom(10f).build();

            if (mMap != null)
                mMap.animateCamera(CameraUpdateFactory

                        .newCameraPosition(camPosition));
        } else {
            Log.d("Location error", "Something went wrong");
        }
    }


    private void addBoundaryToCurrentPosition(double lat, double lang) {

        MarkerOptions mMarkerOptions = new MarkerOptions();
        mMarkerOptions.position(new LatLng(lat, lang));
        mMarkerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
        mMarkerOptions.title("Posisi Anda");
        mMarkerOptions.anchor(0.5f, 0.5f);

        CircleOptions mOptions = new CircleOptions()
                .center(new LatLng(lat, lang)).radius(10000)
                .strokeColor(0x110000FF).strokeWidth(1).fillColor(0x110000FF);
        mMap.addCircle(mOptions);
        if (mCurrentPosition != null)
            mCurrentPosition.remove();
        mCurrentPosition = mMap.addMarker(mMarkerOptions);
        mMap.addMarker(new MarkerOptions()
                .position(latLngGj)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker))
                .title("RSUD Gunung Jati"));

        mMap.addMarker(new MarkerOptions()
                .position(latLngPc)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker))
                .title("RSU Pelabuhan Cirebon"));


        mMap.addMarker(new MarkerOptions()
                .position(latLngCc)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker))
                .title("Rumah Sakit Tingkat III Ciremai"));

        mMap.addMarker(new MarkerOptions()
                .position(latLngAd)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker))
                .title("RSB Panti Abdi Dharma"));

        mMap.addMarker(new MarkerOptions()
                .position(latLngPu)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker))
                .title("RSB Putera Bahagia"));

        mMap.addMarker(new MarkerOptions()
                .position(latLngBl)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker))
                .title("RSU Budi Luhur"));

        mMap.addMarker(new MarkerOptions()
                .position(latLngSk)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker))
                .title("RSU Sumber Kasih"));

        mMap.addMarker(new MarkerOptions()
                .position(latLngBa)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker))
                .title("RSK Bedah Budi Asta"));

        mMap.addMarker(new MarkerOptions()
                .position(latLngBm)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker))
                .title("RSK Bedah Medimas "));

        mMap.addMarker(new MarkerOptions()
                .position(latLngCb)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker))
                .title("RSIA Cahaya Bunda "));



        mMap.addMarker(new MarkerOptions()
                .position(latLngMu)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker))
                .title("RSU Muhammadiyah"));

        mMap.addMarker(new MarkerOptions()
                .position(latLngSb)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker))
                .title("RS Sumber Hurip"));

        mMap.addMarker(new MarkerOptions()
                .position(latLngPt)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker))
                .title("RS Pertamina"));


        mMap.addMarker(new MarkerOptions()
                .position(latLngMp)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker))
                .title("RS Mitra Plumbon"));

        mMap.addMarker(new MarkerOptions()
                .position(latLngKh)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker))
                .title("RSIA Khalishah"));

    }


    @Override
    public void onLocationChanged(Location location) {

        updateWithNewLocation(location);
    }

    @Override
    public void onProviderDisabled(String provider) {

        updateWithNewLocation(null);
    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        switch (status) {
            case LocationProvider.OUT_OF_SERVICE:
                break;
            case LocationProvider.TEMPORARILY_UNAVAILABLE:
                break;
            case LocationProvider.AVAILABLE:
                break;
        }
    }
}