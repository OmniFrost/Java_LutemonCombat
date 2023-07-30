package com.izdeveloper.lutemoncombat.MoveRecyclerView;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.izdeveloper.lutemoncombat.R;

public class MoveViewHolder extends RecyclerView.ViewHolder {

    public CheckBox chbLutemon;
    public TextView txtLutNameBurner;

    public MoveViewHolder(@NonNull View itemView) {
        super(itemView);

        chbLutemon = itemView.findViewById(R.id.chbLutemon);
        chbLutemon.setChecked(false);

        txtLutNameBurner = itemView.findViewById(R.id.txtLutNameBurner);
    }
}
