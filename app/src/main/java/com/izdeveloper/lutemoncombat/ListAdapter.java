package com.izdeveloper.lutemoncombat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ViewHolder> {
    private Context context;
    private ArrayList<Lutemon> lutemons;

    public ListAdapter(Context context, ArrayList<Lutemon> lutemons) {
        this.context = context;
        this.lutemons = lutemons;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.display_lutemon_home_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Lutemon lutemon = lutemons.get(position);

        holder.imgBurn.setImageResource(lutemon.getAvatar());
        String nameNcolor = lutemon.getName() + " (" + lutemon.getColor() + ")";
        holder.txtNameBurn.setText(nameNcolor);
        holder.txtAttackBurn.setText("Attack: " + lutemon.getAttack());
        holder.txtDefenseBurn.setText("Defense: " + lutemon.getDefense());
        holder.txtMaxHPBurn.setText("MaxHP: " + lutemon.getHP());
        holder.txtXPBurn.setText("XP: " + lutemon.getExperinse());


        holder.imgDelete.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                lutemons.remove(position);
                Storage.getSingle().removeLutemon(lutemon);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, lutemons.size());

            }
        });

        holder.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                holder.imgSave.setVisibility(View.VISIBLE);
                holder.txtEditName.setVisibility(View.VISIBLE);

                holder.imgSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String newName = holder.txtEditName.getText().toString();
                        lutemon.setName(newName);
                        notifyItemChanged(position);

                        holder.txtEditName.setVisibility(View.GONE);
                        holder.imgSave.setVisibility(View.GONE);
                    }
                });

            }
        });

        //set Lutemons avatars
        if (lutemon.getAvatar() >= 0 && lutemon.getAvatar() <= 7) {
            switch (lutemons.get(position).getAvatar()) {
                case 0:
                    holder.imgBurn.setImageResource(R.drawable.av1);
                    break;

                case 1:
                    holder.imgBurn.setImageResource(R.drawable.av2);
                    break;

                case 2:
                    holder.imgBurn.setImageResource(R.drawable.av3);
                    break;

                case 3:
                    holder.imgBurn.setImageResource(R.drawable.av4);
                    break;

                case 4:
                    holder.imgBurn.setImageResource(R.drawable.av5);
                    break;

                case 5:
                    holder.imgBurn.setImageResource(R.drawable.av6);
                    break;

                case 6:
                    holder.imgBurn.setImageResource(R.drawable.av7);
                    break;

                case 7:
                    holder.imgBurn.setImageResource(R.drawable.av8);
                    break;

                default:
                    holder.imgBurn.setImageResource(R.drawable.avdef);
                    break;
            }
        }
    }

    @Override
    public int getItemCount() {
        return lutemons.size();
    }
}