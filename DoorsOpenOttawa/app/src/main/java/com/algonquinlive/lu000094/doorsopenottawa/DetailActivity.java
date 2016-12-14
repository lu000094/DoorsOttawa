package com.algonquinlive.lu000094.doorsopenottawa;

import android.app.Activity;
import android.location.Address;
import android.location.Geocoder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.algonquinlive.lu000094.doorsopenottawa.model.Building;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;

import java.io.IOException;
import java.util.List;

public class DetailActivity extends Activity {

    private Building building;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        building = (Building) getIntent().getSerializableExtra(MainActivity.BUILDING_EXTRA);
        TextView tv = (TextView) findViewById(R.id.textViewName);
        tv.setText(building.getName());
        tv = (TextView) findViewById(R.id.textViewDescription);
        tv.setText(building.getDescription());
        tv = (TextView) findViewById(R.id.textViewOpenHours);
        StringBuilder sb = new StringBuilder();
        sb.append("Open hours:\n");
        for (int i = 0; i < building.getOpenHours().size(); i++) {
            sb.append(" - " + building.getOpenHours().get(i) + "\n");
        }
        tv.setText(sb.toString());

        // Gets the MapView from the XML layout and creates it
        MapView mapView = (MapView) findViewById(R.id.mapView);

        mapView.onCreate(savedInstanceState);
        mapView.onResume(); //without this, map showed but was empty

        // Gets to GoogleMap from the MapView and does initialization stuff
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                googleMap.getUiSettings().setMyLocationButtonEnabled(false);

                MapsInitializer.initialize(DetailActivity.this);

                // Updates the location and zoom of the MapView
                LatLng latLng = getLocationFromAddress(building.getAddress());

                if(latLng == null){
                    latLng = new LatLng(0, 0);
                }
                // Show the current location in Google Map
                googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));

                // Zoom in the Google Map
                googleMap.animateCamera(CameraUpdateFactory.zoomTo(17));
            }
        });
    }

    public LatLng getLocationFromAddress(String strAddress){
        Geocoder coder = new Geocoder(this);
        List<Address> address;
        LatLng p1 = null;

        try {
            address = coder.getFromLocationName(strAddress,5);
            if (address==null || address.size() <= 0) {
                return null;
            }
            Address location=address.get(0);

            p1 = new LatLng((double) (location.getLatitude() * 1E6),
                    (double) (location.getLongitude() * 1E6));

            return p1;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return p1;
    }
}
