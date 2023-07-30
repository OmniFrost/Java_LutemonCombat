package com.izdeveloper.lutemoncombat;

import java.util.ArrayList;

public class TrainingStorage {
    private static TrainingStorage single;
    private ArrayList<Lutemon> trainingLutemons;

    private TrainingStorage() {
        trainingLutemons = new ArrayList<>();
    }

    public static TrainingStorage getSingle() {
        if (single == null) {
            single = new TrainingStorage();
        }
        return single;
    }

    public void removeTrainingLutemon(Lutemon lutemon) {
        trainingLutemons.remove(lutemon);
    }

    public ArrayList<Lutemon> getTrainingLutemons() {
        return trainingLutemons;
    }

    public void addTrainingLutemons(ArrayList<Lutemon> trainingLutemonsToAdd) {

        this.trainingLutemons.addAll(trainingLutemonsToAdd);
    }
}

