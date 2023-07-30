package com.izdeveloper.lutemoncombat.StatsMisc;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.izdeveloper.lutemoncombat.Fragments.StatsFightsFragment;
import com.izdeveloper.lutemoncombat.Fragments.StatsTrainingsFragment;

public class PagerAdapter2 extends FragmentStateAdapter {

    public PagerAdapter2(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }


    //Either Fighting stats or Training stats in TabLayout
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 1:
                return new StatsTrainingsFragment();

            default:
                return new StatsFightsFragment();
        }
    }


    @Override
    public int getItemCount() {
        return 2;
    }
}

