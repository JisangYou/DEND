package com.example.a365mc_inno1.facecheckgame.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.example.a365mc_inno1.facecheckgame.R;
import com.example.a365mc_inno1.facecheckgame.fragment.test1;
import com.example.a365mc_inno1.facecheckgame.fragment.test2;
import com.example.a365mc_inno1.facecheckgame.fragment.test3;
import com.example.a365mc_inno1.facecheckgame.model.Staff;
import com.example.a365mc_inno1.facecheckgame.util.Constant;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    AHBottomNavigation bottomNavigation;
    List<Staff> staffList;
    List<Integer> tempRandom;
    Fragment fra_test1, fra_test2, fra_test3;
    Bundle bundle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDummyDB();
        initFragment();
        setBottomNavigation();


    }

    private void setBottomNavigation() {
        bottomNavigation = findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fra_test1).commit();


        // Add items <<< created items (R.string.TITLE, R.drawable.ICON_IMG, R.color.NAVIGATION_BAR_BACKGROUND_COLOR)
        bottomNavigation.addItem(new AHBottomNavigationItem("find face", R.drawable.ic_launcher_foreground, R.color.colorPrimary));
        bottomNavigation.addItem(new AHBottomNavigationItem("test2", R.drawable.ic_launcher_foreground, R.color.colorAccent));
        bottomNavigation.addItem(new AHBottomNavigationItem("mine game", R.drawable.ic_launcher_foreground, R.color.colorBottomNavigationInactive));

//        // Set Navigation Icon & Background Colors
        bottomNavigation.setColoredModeColors(getResources().getColor(R.color.colorPrimary), getResources().getColor(R.color.colorBottomNavigationInactive));
        bottomNavigation.setDefaultBackgroundColor(Color.parseColor("#ffffff"));

        // Change colors
//        bottomNavigation.setAccentColor(getResources().getColor(R.color.IcActive));
//        bottomNavigation.setInactiveColor(getResources().getColor(R.color.IcInactive));

        // Force to tint the drawable (useful for font with icon for example)
        bottomNavigation.setForceTint(true);

        // Display color under navigation bar (API 21+)
        bottomNavigation.setTranslucentNavigationEnabled(true);

        // Manage titles (SHOW_WHEN_ACTIVE, ALWAYS_SHOW, ALWAYS_HIDE)
        bottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);

        // Use colored navigation with circle reveal effect
        bottomNavigation.setColored(true);

        // Customize notification (title, background, typeface)
//        bottomNavigation.setNotificationBackgroundColor(getResources().getColor(R.color.colorBottomNavigationInactive));

        bottomNavigation.setCurrentItem(0);
        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                switch (position) {
                    case 0:
                        if (wasSelected) {
                            return false;
                        } else {
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fra_test1).commit();

                            return true;
                        }


                    case 1:
                        if (wasSelected) {
                            return false;
                        } else
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fra_test2).commit();

                        return true;
                    case 2:
                        if (wasSelected) {
                            return false;
                        } else
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fra_test3).commit();


                        return true;

                }
                return false;
            }
        });

    }

    private void initFragment() {

        bundle = new Bundle();
        bundle.putParcelableArrayList(Constant.DYMMY_DATA, (ArrayList<? extends Parcelable>) staffList);
        fra_test1 = new test1();
        fra_test1.setArguments(bundle);
        fra_test2 = new test2();
        fra_test2.setArguments(bundle);
        fra_test3 = new test3();
        fra_test3.setArguments(bundle);

    }

    private void initDummyDB() {

        staffList = new ArrayList<>();
        staffList.add(new Staff("둘리", R.drawable.dooli, 0, "남","innovation"));
        staffList.add(new Staff("도우너", R.drawable.dounet, 1, "여","marketing"));
        staffList.add(new Staff("마이클", R.drawable.michel, 2, "남","finance"));
        staffList.add(new Staff("꼴뚜기", R.drawable.ggolddugi, 3, "여","marketing"));
        staffList.add(new Staff("고길동", R.drawable.gogildong, 4, "남","innovation"));
        staffList.add(new Staff("희동이", R.drawable.heedong, 5, "여","executive"));

    }


}
