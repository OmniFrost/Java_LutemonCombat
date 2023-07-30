package com.izdeveloper.lutemoncombat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.izdeveloper.lutemoncombat.MoveRecyclerView.MoveListAdapter;

import java.util.ArrayList;
import java.util.Random;

public class ArenaActivity extends AppCompatActivity {

    private RecyclerView rvArena;
    private MoveListAdapter MLadapter;
    private TextView txtFightScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arena);

        rvArena = findViewById(R.id.rvFighters);
        rvArena.setLayoutManager(new LinearLayoutManager(this));
        txtFightScreen = findViewById(R.id.txtFightScreen);

        ArenaStorage arenaStorage = ArenaStorage.getSingle();

        MLadapter = new MoveListAdapter(this, arenaStorage.getArenaLutemons());
        rvArena.setAdapter(MLadapter);

        Button btnStartFight = findViewById(R.id.btnStartFight);

        btnStartFight.setOnClickListener(v -> {
            ArrayList<Lutemon> selectedLutemons = MLadapter.getSelectedLutemons();

            if (selectedLutemons.size() == 2) {
                Lutemon subzero = selectedLutemons.get(0);
                Lutemon scorpion = selectedLutemons.get(1);

                fightAlgorithm(subzero, scorpion);

                //Set both fighters to full HP!!!
                subzero.setFullHP();
                scorpion.setFullHP();

                Storage homeStorage = Storage.getSingle();
                homeStorage.addLutemon(subzero);
                homeStorage.addLutemon(scorpion);

                arenaStorage.removeArenaLutemon(subzero);
                arenaStorage.removeArenaLutemon(scorpion);


                //Clear selected Lutemons from MoveListAdapter in order to prevent consecutive fights of same Lutemons and their dublication
                MLadapter.clearSelectedLutemons();
            }
        });
    }

    //First part of figthing algorithm with several randomized effects (Starting Lutemon, Critical hits and randomized damage)
    private void fightAlgorithm(Lutemon subzero, Lutemon scorpion) {

        Lutemon survivor;

        boolean isSubzeroFirst = new Random().nextBoolean();

        StringBuilder fightLog = new StringBuilder();

        while (subzero.getHP() > 0 && scorpion.getHP() > 0) {

            fightLog.append(subzero.getId() + ": " + subzero.getName() + " att: " + subzero.getAttack() +
                    "; def: " + subzero.getDefense() + "; exp:" + subzero.getExperinse() +
                    "; health: " + subzero.getHP() + "/" + subzero.getMaxHP() + "\n");

            fightLog.append(scorpion.getId() + ": " + scorpion.getName() + " att: " + scorpion.getAttack() +
                    "; def: " + scorpion.getDefense() + "; exp:" + scorpion.getExperinse() +
                    "; health: " + scorpion.getHP() + "/" + scorpion.getMaxHP() + "\n");

            if (isSubzeroFirst == true) {

                scorpion.defend(subzero);

                fightLog.append(subzero.getName() + " attacks " + scorpion.getName() + "\n");

                if (0 < scorpion.getHP()) {
                    fightLog.append(scorpion.getName() + " managed to escape death." + "\n");
                } else {
                    fightLog.append(scorpion.getName() + " gets killed." + "\n");
                }

            } else {

                subzero.defend(scorpion);

                fightLog.append(scorpion.getName() + " attacks " + subzero.getName() + "\n");

                if (0 < subzero.getHP()) {
                    fightLog.append(subzero.getName() + " managed to escape death." + "\n");

                } else {
                    fightLog.append(subzero.getName() + " gets killed." + "\n");
                }
            }

            isSubzeroFirst = !isSubzeroFirst;
        }

        if (subzero.getHP() > 0) {
            survivor = subzero;
            subzero.plusWins();
            scorpion.plusLosses();

        } else {
            survivor = scorpion;
            scorpion.plusWins();
            subzero.plusLosses();
        }

        survivor.increaseXP(1);
        scorpion.plusMatches();
        subzero.plusMatches();
        fightLog.append("The battle is over.");

        txtFightScreen.setText(fightLog.toString());
    }



}