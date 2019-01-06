package com.example.lifeyoung.umrt;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        private boolean loadFragment(Fragment fragment) {
            if (fragment != null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fl_container, fragment)
                        .commit();
                return true;
            }
            return false;
        }

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_jadwal:
                    fragment = new JadwalFragment();
                    break;
                case R.id.navigation_realtime:
                    fragment = new RealtimeFragment();
                    break;
                case R.id.navigation_maps:
                    fragment = new MapsFragment();
                    break;
                case R.id.navigation_info:
                    fragment = new InfoFragment();
                    break;
            }
            return loadFragment(fragment);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        loadFragment(new JadwalFragment());
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}



//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//        Fragment fragment = null;
//        switch (menuItem.getItemId()) {
//            case R.id.home_menu:
//                fragment = new JadwalFragment();
//                break;
//            case R.id.search_menu:
//                fragment = new RealtimeFragment();
//                break;
//            case R.id.favorite_menu:
//                fragment = new MapsFragment();
//                break;
//            case R.id.account_menu:
//                fragment = new InfoFragment();
//                break;
//        }
//        return loadFragment(fragment);
//    }
//}

