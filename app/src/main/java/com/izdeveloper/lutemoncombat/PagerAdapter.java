package com.izdeveloper.lutemoncombat;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.izdeveloper.lutemoncombat.Fragments.AddFragment;
import com.izdeveloper.lutemoncombat.Fragments.ListFragment;
import com.izdeveloper.lutemoncombat.Fragments.MoveFragment;

public class PagerAdapter extends FragmentStateAdapter {
    public PagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    //Used in TabLayout switching between tabs
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 1:
                return new ListFragment();
            case 2:
                return new MoveFragment();
            default:
                return new AddFragment();
        }
    }


    @Override
    public int getItemCount() {
        return 3;
    }
}
