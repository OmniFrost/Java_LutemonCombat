package com.izdeveloper.lutemoncombat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


// Allows switching between screens
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToBarracks(View view) {
        Intent newIntent = new Intent(this, BarracksActivity.class);

        startActivity(newIntent);
    }

    public void goToTraining(View view) {
        Intent newIntent = new Intent(this, TrainingActivity.class);

        startActivity(newIntent);
    }

    public void goToArena(View view) {
        Intent newIntent = new Intent(this, ArenaActivity.class);

        startActivity(newIntent);
    }

    public void goToStatistics(View view) {
        Intent newIntent = new Intent(this, StatisticsActivity.class);

        startActivity(newIntent);
    }
}
