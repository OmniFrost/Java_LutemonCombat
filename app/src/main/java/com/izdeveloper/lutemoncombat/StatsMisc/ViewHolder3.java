package com.izdeveloper.lutemoncombat.StatsMisc;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.izdeveloper.lutemoncombat.R;

public class ViewHolder3 extends RecyclerView.ViewHolder {
    ImageView imgB;
    TextView txtN, txtLights, txtMediums, txtHeavies;

    public ViewHolder3(@NonNull View itemView) {
        super(itemView);

        imgB = itemView.findViewById(R.id.imgDef1);

        txtN = itemView.findViewById(R.id.txtN);
        txtLights = itemView.findViewById(R.id.txtAttack);
        txtMediums = itemView.findViewById(R.id.txtDef);
        txtHeavies = itemView.findViewById((R.id.txtMaxHP));

    }
}
