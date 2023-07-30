package com.izdeveloper.lutemoncombat.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.izdeveloper.lutemoncombat.ListAdapter;
import com.izdeveloper.lutemoncombat.R;
import com.izdeveloper.lutemoncombat.Storage;


public class ListFragment extends Fragment {

    private RecyclerView RV;
    private ListAdapter LA;
    private Storage lutemons;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lutemons = Storage.getSingle();
        LA = new ListAdapter(getContext(), lutemons.listLutemons());

    }

    //Reload the user list with new changes
    @Override
    public void onResume() {
        super.onResume();
        LA = new ListAdapter(getContext(), lutemons.listLutemons());
        RV.setAdapter(LA);
        LA.notifyDataSetChanged();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        RV = view.findViewById(R.id.RV);
        RV.setLayoutManager(new LinearLayoutManager(getContext()));
        RV.setAdapter(LA);

        return view;
    }
}
