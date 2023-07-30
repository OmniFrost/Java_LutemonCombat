//I learned using Handler to wait here: https://stackoverflow.com/questions/41664409/wait-for-5-seconds

package com.izdeveloper.lutemoncombat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.izdeveloper.lutemoncombat.MoveRecyclerView.MoveListAdapter;

import java.util.ArrayList;

public class TrainingActivity extends AppCompatActivity {

    private MoveListAdapter MLadapter;
    private RecyclerView RV;
    private RadioGroup RG;
    private Handler sleep = new Handler();


    // Train selected Lutemons based on selected training intensity.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);

        RV = findViewById(R.id.rvFighters);
        RV.setLayoutManager(new LinearLayoutManager(this));

        RG = findViewById(R.id.rgIntensity);
        TextView txtSuccess = findViewById(R.id.txtSuccess);

        TrainingStorage trainingStorage = TrainingStorage.getSingle();
        ArrayList<Lutemon> trainingLutemons = trainingStorage.getTrainingLutemons();
        int numberOfItems = trainingLutemons.size();
        System.out.println("Debug(Number of lutemons): " + numberOfItems);

        MLadapter = new MoveListAdapter(this, trainingStorage.getTrainingLutemons());
        RV.setAdapter(MLadapter);

        txtSuccess.setVisibility(View.GONE);
        findViewById(R.id.btnConfirm).setOnClickListener(v -> {
            int selectedId = RG.getCheckedRadioButtonId();
            if (selectedId == -1) {
                return;
            }

            int xp = 1;
            switch (selectedId) {
                case R.id.rbTraining:
                    xp = 1;
                    break;
                case R.id.rbArena:
                    xp = 2;
                    break;
                case R.id.rbHeavy:
                    xp = 3;
                    break;
            }

            ArrayList<Lutemon> selectedLutemons = MLadapter.getSelectedLutemons();

            for (Lutemon i : selectedLutemons) {
                switch (selectedId) {
                    case R.id.rbTraining:
                        i.plusLights();
                        break;
                    case R.id.rbArena:
                        i.plusMediums();
                        break;
                    case R.id.rbHeavy:
                        i.plusHeavies();
                        break;
                }

                i.increaseXP(xp);
            }

            Storage.getSingle().addLutemons(selectedLutemons);

            if (!selectedLutemons.isEmpty()) {
                for (Lutemon lutemon : selectedLutemons) {

                    trainingStorage.removeTrainingLutemon(lutemon);
                }
            }
            selectedLutemons.clear();
            MLadapter.notifyDataSetChanged();
            txtSuccess.setVisibility(View.VISIBLE);

            //Remove the Success text after 1.5 seconds
            sleep.postDelayed(new Runnable() {

                @Override
                public void run() {

                    txtSuccess.setVisibility(View.GONE);
                }
            }, 1500);

        });
    }
}
