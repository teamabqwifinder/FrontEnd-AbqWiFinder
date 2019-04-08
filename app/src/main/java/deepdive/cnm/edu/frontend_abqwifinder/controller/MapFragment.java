package deepdive.cnm.edu.frontend_abqwifinder.controller;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import deepdive.cnm.edu.frontend_abqwifinder.R;

public class MapFragment extends Fragment implements OnMapReadyCallback {

  GoogleMap mGoogleMap;
  MapView mMapView;
  View mView;

  public MapFragment() {

  }

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    //Inflate the layout for this fragment.
    mView = inflater.inflate(R.layout.fragment_map, container, false);
    return mView;
  }

  @Override
  public void onViewCreated(android.view.View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

//    mMapView = (MapView) mView.findViewById(R.id.map);
    if(mMapView != null) {
      mMapView.onCreate(null);
      mMapView.onResume();
      mMapView.getMapAsync(this);

    }

  }

  @Override
  public void onMapReady(GoogleMap googleMap) {

    MapsInitializer.initialize(getContext());
    googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

    googleMap.addMarker(new MarkerOptions().position(new LatLng
        (40.689247, -74.044502)).title("Statue of Liberty")
        .snippet("I hope to go there someday"));

    CameraPosition Liberty = CameraPosition.builder().target(new LatLng
        (40.689247, -74.044502)).zoom(16).bearing(0).tilt(45).build();

    googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(Liberty));


  }
}
