package com.izdeveloper.lutemoncombat.StatsMisc;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.izdeveloper.lutemoncombat.R;

public class ViewHolder2 extends RecyclerView.ViewHolder {
        ImageView imgB;
        TextView txtN, txtA, txtD, txtH, txtX, txtW, txtL, txtKD, txtTotalMatches;


        public ViewHolder2(@NonNull View itemView) {
                super(itemView);

                imgB = itemView.findViewById(R.id.imgDef1);

                txtN = itemView.findViewById(R.id.txtN);
                txtA = itemView.findViewById(R.id.txtAttack);
                txtD = itemView.findViewById(R.id.txtDef);
                txtH = itemView.findViewById((R.id.txtMaxHP));
                txtX = itemView.findViewById((R.id.txtXP));
                txtW = itemView.findViewById((R.id.txtW));
                txtL = itemView.findViewById((R.id.txtL));
                txtKD = itemView.findViewById((R.id.txtKD));
                txtTotalMatches = itemView.findViewById((R.id.txtTotalMatches));
        }
}
