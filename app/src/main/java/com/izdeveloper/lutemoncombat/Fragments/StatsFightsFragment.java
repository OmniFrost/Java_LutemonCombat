package com.izdeveloper.lutemoncombat.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.izdeveloper.lutemoncombat.R;
import com.izdeveloper.lutemoncombat.StatsMisc.ListAdapter2;
import com.izdeveloper.lutemoncombat.Storage;

public class StatsFightsFragment extends Fragment {

    private RecyclerView rvFights;
    private ListAdapter2 LA2;
    private Storage lutemons;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lutemons = Storage.getSingle();
        LA2 = new ListAdapter2(getContext(), lutemons.listLutemons());

    }

    //Update the adapter to display correct values
    @Override
    public void onResume() {
        super.onResume();
        LA2 = new ListAdapter2(getContext(), lutemons.listLutemons());
        rvFights.setAdapter(LA2);
        LA2.notifyDataSetChanged();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stats_fights, container, false);

        rvFights = view.findViewById(R.id.rvFights);
        rvFights.setLayoutManager(new LinearLayoutManager(getContext()));
        rvFights.setAdapter(LA2);

        return view;
    }
}
