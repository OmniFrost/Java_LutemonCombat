package com.izdeveloper.lutemoncombat;

import java.util.ArrayList;

public class ArenaStorage {
    private static ArenaStorage single;
    private ArrayList<Lutemon> arenaLutemons;

    private ArenaStorage() {
        arenaLutemons = new ArrayList<>();
    }

    public static ArenaStorage getSingle() {
        if (single == null) {
            single = new ArenaStorage();
        }
        return single;
    }

    public void removeArenaLutemon(Lutemon lutemon) {
        arenaLutemons.remove(lutemon);
    }

    public ArrayList<Lutemon> getArenaLutemons() {
        return arenaLutemons;
    }

    public void addArenaLutemons(ArrayList<Lutemon> arenaLutemonsToAdd) {
        this.arenaLutemons.addAll(arenaLutemonsToAdd);

    }
}