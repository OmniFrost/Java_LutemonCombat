package com.izdeveloper.lutemoncombat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class BarracksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barracks);

        TabLayout tabsSpace = findViewById(R.id.UpperTabs);
        ViewPager2 fragmentSpace = findViewById(R.id.ScrollableFragment);

        PagerAdapter tabAdapter = new PagerAdapter(this);
        fragmentSpace.setAdapter(tabAdapter);

        tabsSpace.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                fragmentSpace.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        fragmentSpace.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabsSpace.getTabAt(position).select();
            }
        });
    }
}