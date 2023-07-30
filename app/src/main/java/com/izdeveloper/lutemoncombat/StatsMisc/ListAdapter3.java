package com.izdeveloper.lutemoncombat.StatsMisc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.izdeveloper.lutemoncombat.Lutemon;
import com.izdeveloper.lutemoncombat.R;

import java.util.ArrayList;

public class ListAdapter3 extends RecyclerView.Adapter<ViewHolder3> {
private Context context;
private ArrayList<Lutemon> lutemons;

public ListAdapter3(Context context, ArrayList<Lutemon> lutemons) {
    this.context = context;
    this.lutemons = lutemons;
    }

    @NonNull
    @Override
    public ViewHolder3 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder3(LayoutInflater.from(context).inflate(R.layout.stats_training_display_lutemon, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder3 holder, int position) {
        Lutemon lutemon = lutemons.get(position);

        holder.imgB.setImageResource(lutemon.getAvatar());
        String nameNcolor = lutemon.getName() + " (" + lutemon.getColor() + ")";
        holder.txtN.setText(nameNcolor);
        holder.txtLights.setText("Light trainings: " + lutemon.getLights());
        holder.txtMediums.setText("Medium trainings: " + lutemon.getMediums());
        holder.txtHeavies.setText("Heavy trainings: " + lutemon.getHeavies());

        //Set avatars (Same as in ListAdapter2)
        if (lutemon.getAvatar() >= 0 && lutemon.getAvatar() <= 7) {

            switch (lutemons.get(position).getAvatar()) {
                case 0:
                    holder.imgB.setImageResource(R.drawable.av1);
                    break;

                case 1:
                    holder.imgB.setImageResource(R.drawable.av2);
                    break;

                case 2:
                    holder.imgB.setImageResource(R.drawable.av3);
                    break;

                case 3:
                    holder.imgB.setImageResource(R.drawable.av4);
                    break;

                case 4:
                    holder.imgB.setImageResource(R.drawable.av5);
                    break;

                case 5:
                    holder.imgB.setImageResource(R.drawable.av6);
                    break;

                case 6:
                    holder.imgB.setImageResource(R.drawable.av7);
                    break;

                case 7:
                    holder.imgB.setImageResource(R.drawable.av8);
                    break;

                default:
                    holder.imgB.setImageResource(R.drawable.avdef);
                    break;
            }
        }
    }

    @Override
    public int getItemCount() {
        return lutemons.size();
    }
}
