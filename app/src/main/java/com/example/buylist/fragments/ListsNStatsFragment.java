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

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ListsNStatsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListsNStatsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListsNStatsFragment newInstance(String param1, String param2) {
        ListsNStatsFragment fragment = new ListsNStatsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
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