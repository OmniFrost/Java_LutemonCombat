package com.izdeveloper.lutemoncombat;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {
    ImageView imgBurn, imgDelete, imgEdit, imgSave;
    TextView txtNameBurn, txtAttackBurn, txtDefenseBurn, txtMaxHPBurn, txtXPBurn, txtEditName;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        imgBurn = itemView.findViewById(R.id.imgDef1);

        txtNameBurn = itemView.findViewById(R.id.txtN);
        txtAttackBurn = itemView.findViewById(R.id.txtAttack);
        txtDefenseBurn = itemView.findViewById(R.id.txtDef);
        txtMaxHPBurn = itemView.findViewById((R.id.txtMaxHP));
        txtXPBurn = itemView.findViewById((R.id.txtXP));
        txtEditName = itemView.findViewById((R.id.txtEditName));

        imgDelete = itemView.findViewById((R.id.imgDelete));
        imgEdit = itemView.findViewById((R.id.imgEdit));
        imgSave = itemView.findViewById((R.id.imgSave));
    }
}
