package pindro.pindro.activities;

import android.app.Activity;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;

import pindro.pindro.fragments.MyMapFragment;
import pindro.pindro.fragments.NavigationDrawerFragment;
import pindro.pindro.R;
import pindro.pindro.fragments.RecentPinsFragment;


public class MainActivity extends Activity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks, MyMapFragment.OnMyMapFragmentInteractionListener{

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    private Fragment[] mFragments;
    private static final int FRAGMENT_MAP_POSITION = 0;
    private static final int FRAGMENT_FRIENDS_POSITION = 1;
    private static final int FRAGMENT_RECENTS_POSITION = 2;
    private static final int FRAGMENT_SETTINGS_POSITION = 3;
    private static final int FRAGMENTS_SIZE = 4;

    private GoogleMap mGoogleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mFragments = new Fragment[FRAGMENTS_SIZE];
        mFragments[FRAGMENT_MAP_POSITION] = MyMapFragment.newInstance();
        mFragments[FRAGMENT_FRIENDS_POSITION] = PlaceholderFragment.newInstance(FRAGMENT_FRIENDS_POSITION);
        mFragments[FRAGMENT_RECENTS_POSITION] = RecentPinsFragment.newInstance();
        mFragments[FRAGMENT_SETTINGS_POSITION] = PlaceholderFragment.newInstance(FRAGMENT_SETTINGS_POSITION);

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        for (Fragment f : mFragments) {
            fragmentTransaction.add(R.id.container, f);
        }
        fragmentTransaction.commit();

        setContentView(R.layout.activity_main);


        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.navigation_drawer);

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));

    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        for (Fragment f : mFragments) {
            fragmentTransaction.hide(f);
        }
        fragmentTransaction.show(mFragments[position]).commit();
    }

    public void onSectionAttached(int number) {
        switch (number) {
            // Do something here
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onNavDrawerButton() {

    }

    public void onNavDrawerButton(View view) {
        ((DrawerLayout)(findViewById(R.id.drawer_layout))).openDrawer(Gravity.LEFT);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((MainActivity) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }
    }

}
