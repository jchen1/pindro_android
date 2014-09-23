package pindro.pindro.fragments;

import android.app.Activity;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SearchView;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

import pindro.pindro.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MyMapFragment.OnMyMapFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MyMapFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class MyMapFragment extends Fragment {

    private MapView mMapView;
    private GoogleMap mMap;

    private OnMyMapFragmentInteractionListener mListener;

    public static MyMapFragment newInstance() {
        MyMapFragment fragment = new MyMapFragment();
        return fragment;
    }
    public MyMapFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_my_map, container, false);

        // Set up the UI settings for the GoogleMap
        mMapView = (MapView) v.findViewById(R.id.mapview);
        mMapView.onCreate(savedInstanceState);

        mMap = mMapView.getMap();
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(false);
        mMap.getUiSettings().setRotateGesturesEnabled(false);
        mMap.getUiSettings().setTiltGesturesEnabled(false);
        mMap.setMyLocationEnabled(true);

        // Hide the MyLocation button, but keep it programatically clickable for our own button
        final View button = ((View) mMapView.findViewById(1).getParent()).findViewById(2);
        button.setVisibility(View.GONE);

        ImageButton locationButton = (ImageButton) v.findViewById(R.id.my_location_button);
        locationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button.performClick();
            }
        });

        MapsInitializer.initialize(this.getActivity());
        mMap.animateCamera(getCenterLocationCameraUpdate());

        // By default, only clicking the search icon will activate the search feature.
        // The following code lets the entire SearchView activate it.
        final SearchView sv = (SearchView) v.findViewById(R.id.map_searchview);
        sv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sv.setIconified(false);
                sv.requestFocus();
            }
        });

        return v;

    }

    CameraUpdate getCenterLocationCameraUpdate() {
        LocationManager service = (LocationManager)getActivity().getSystemService(getActivity().LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        String provider = service.getBestProvider(criteria, false);
        Location location = service.getLastKnownLocation(provider);
        // Location lat-lng
        LatLng loc = new LatLng(location.getLatitude(), location.getLongitude());

        // Location accuracy diameter (in meters)
        float accuracy = location.getAccuracy() * 2;

        // Screen measurements
        DisplayMetrics metrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);
        // Use min(width, height) (to properly fit the screen
        int screenSize = Math.min(metrics.widthPixels, metrics.heightPixels);

        // Equators length
        long equator = 40075004;

        // The meters per pixel required to show the whole area the user might be located in
        double requiredMpp = accuracy/screenSize;

        // Calculate the zoom level
        double zoomLevel = Math.min(((Math.log(equator / (256 * requiredMpp))) / Math.log(2)) + 1, 18);

        return CameraUpdateFactory.newLatLngZoom(loc, (float)(zoomLevel));
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onNavDrawerButton(View view) {
        if (mListener != null) {
            mListener.onNavDrawerButton();
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnMyMapFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onResume() {
        mMapView.onResume();
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnMyMapFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onNavDrawerButton();
    }

}
