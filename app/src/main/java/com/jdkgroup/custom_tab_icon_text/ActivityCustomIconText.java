package com.jdkgroup.custom_tab_icon_text;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.jdkgroup.materialtab.FragmentText;
import com.jdkgroup.tab.R;

import java.util.ArrayList;
import java.util.List;

public class ActivityCustomIconText extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_tab_icon_text);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
    }

    private void setupTabIcons() {

        View tabOne = (View) LayoutInflater.from(this).inflate(R.layout.custom_tab_icon_text, null);
        AppCompatTextView apptvTabNameOne = tabOne.findViewById(R.id.apptvTabName);
        apptvTabNameOne.setText("One");
        AppCompatImageView appivOne = tabOne.findViewById(R.id.appiv);
        tabLayout.getTabAt(0).setCustomView(appivOne);
        tabLayout.getTabAt(0).setCustomView(apptvTabNameOne);

        View tabTwo = (View) LayoutInflater.from(this).inflate(R.layout.custom_tab_icon_text, null);
        AppCompatTextView apptvTabNameTwo = tabTwo.findViewById(R.id.apptvTabName);
        apptvTabNameTwo.setText("Two");
        AppCompatImageView appivTwo = tabTwo.findViewById(R.id.appiv);
        tabLayout.getTabAt(1).setCustomView(appivTwo);
        tabLayout.getTabAt(1).setCustomView(apptvTabNameTwo);

        View tabThree = (View) LayoutInflater.from(this).inflate(R.layout.custom_tab_icon_text, null);
        AppCompatTextView apptvTabNameThree = tabThree.findViewById(R.id.apptvTabName);
        apptvTabNameThree.setText("Three");
        AppCompatImageView appivThree = tabThree.findViewById(R.id.appiv);
        tabLayout.getTabAt(2).setCustomView(appivThree);
        tabLayout.getTabAt(2).setCustomView(apptvTabNameThree);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new FragmentText(), "ONE");
        adapter.addFrag(new FragmentText(), "TWO");
        adapter.addFrag(new FragmentText(), "THREE");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}