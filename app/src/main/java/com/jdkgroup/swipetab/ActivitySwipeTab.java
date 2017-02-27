package com.jdkgroup.swipetab;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.jdkgroup.tab.R;

public class ActivitySwipeTab extends AppCompatActivity {

    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_tab);

        pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        //initializing toolbar

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("WhatsAppTabs");
        setSupportActionBar(toolbar);
        //initializing tab layout
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        //initializing ViewPager
        viewPager = (ViewPager) findViewById(R.id.view_pager);

        viewPager.setAdapter(pagerAdapter);
        tabLayout.setTabsFromPagerAdapter(pagerAdapter);
        //giving viewPager reference to tablayout so that the viewPager changes when tab is clicked
        tabLayout.setupWithViewPager(viewPager);
        //giving tablayout reference to viewPager so that the tablayout changes when viewPager is scrolled
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
}

class PagerAdapter extends FragmentStatePagerAdapter {
    Fragment fragment = null;

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        //Based upon the position you can call the fragment you need here
        //here i have called the same fragment for all the instances
        fragment = new FragmentText();
        return fragment;
    }


    @Override
    public int getCount() {
        // Returns the number of tabs (If you need 4 tabs change it to 4)
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        //this is where you set texts to your tabs based upon the position
        //positions starts from 0
        if (position == 0) {
            return "CALLS";
        } else if (position == 1) {
            return "CHATS";
        } else if (position == 2) {
            return "CONTACTS";
        }
        return null;
    }
}

