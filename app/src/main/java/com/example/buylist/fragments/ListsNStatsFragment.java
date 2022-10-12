package com.example.buylist.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.buylist.R;
import com.example.buylist.adapters.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListsNStatsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListsNStatsFragment extends Fragment {

    ViewPager viewPager;
    TabLayout tabLayout;
    ViewPagerAdapter viewPagerAdapter;
    BuylistFragment buylistFragment;
    StatisticsFragment statisticsFragment;

    public ListsNStatsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lists_n_stats, container, false);

        buylistFragment = new BuylistFragment();
        statisticsFragment = new StatisticsFragment();

        viewPager = view.findViewById(R.id.viewPagerMain);
        tabLayout = view.findViewById(R.id.tabMain);

        tabLayout.setupWithViewPager(viewPager);
        viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager(), 0);
        viewPagerAdapter.addFragment(buylistFragment,"Buylists");
        viewPagerAdapter.addFragment(statisticsFragment,"Statistics");
        viewPager.setAdapter(viewPagerAdapter);




        // Inflate the layout for this fragment
        return view;
    }
}