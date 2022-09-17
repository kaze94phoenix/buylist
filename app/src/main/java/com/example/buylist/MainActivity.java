package com.example.buylist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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
}