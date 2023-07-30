package com.izdeveloper.lutemoncombat.MoveRecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.izdeveloper.lutemoncombat.Lutemon;
import com.izdeveloper.lutemoncombat.R;

import java.util.ArrayList;

public class MoveListAdapter extends RecyclerView.Adapter<MoveViewHolder> {
    private Context context;
    private ArrayList<Lutemon> lutemons;
    private ArrayList<Lutemon> selectedLutemons;

    public MoveListAdapter(Context context, ArrayList<Lutemon> lutemons) {
        this.context = context;
        this.lutemons = lutemons;
        this.selectedLutemons = new ArrayList<>();
    }

    @NonNull
    @Override
    public MoveViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.checkbox_single_recycler, parent, false);
        return new MoveViewHolder(itemView);
    }

    //Catch Lutemons that are selected in Checkboxes
    @Override
    public void onBindViewHolder(@NonNull MoveViewHolder holder, int position) {
        holder.chbLutemon.setChecked(false);
        Lutemon lutemon = lutemons.get(position);

        holder.txtLutNameBurner.setText(lutemon.getName());


        holder.chbLutemon.setOnCheckedChangeListener((buttonView, isChecked) -> {
            lutemon.setSelected(isChecked);

            if (isChecked) {

                selectedLutemons.add(lutemon);
            }
        });
    }

    public void clearSelectedLutemons() {
        selectedLutemons.clear();
        notifyDataSetChanged();
    }
    public ArrayList<Lutemon> getSelectedLutemons() {
        return selectedLutemons;
    }


    @Override
    public int getItemCount() {
        return lutemons.size();
    }
}
