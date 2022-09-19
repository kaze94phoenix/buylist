package com.example.buylist;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Gravity;

import com.example.buylist.adapters.ViewPagerAdapter;
import com.example.buylist.fragments.BuylistFragment;
import com.example.buylist.fragments.StatisticsFragment;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabLayout;
    ViewPagerAdapter viewPagerAdapter;
    BuylistFragment buylistFragment;
    StatisticsFragment statisticsFragment;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbarMain);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.mainView);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();




        buylistFragment = new BuylistFragment();
        statisticsFragment = new StatisticsFragment();

        viewPager = findViewById(R.id.viewPagerMain);
        tabLayout = findViewById(R.id.tabMain);

        tabLayout.setupWithViewPager(viewPager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), 0);
        viewPagerAdapter.addFragment(buylistFragment,"Buylists");
        viewPagerAdapter.addFragment(statisticsFragment,"Statistics");
        viewPager.setAdapter(viewPagerAdapter);

    }

    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START);
        else
            super.onBackPressed();

    }
}