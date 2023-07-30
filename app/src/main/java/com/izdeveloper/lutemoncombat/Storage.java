package com.izdeveloper.lutemoncombat;

import java.util.ArrayList;


//HomeStorage (primary). Singleton storage.
public class Storage {
    private static Storage Storage;
    private ArrayList<Lutemon> HomeLutemons;

    private Storage() {
        HomeLutemons = new ArrayList<>();
    }

    public static Storage getSingle() {
        if (Storage == null) {
            Storage = new Storage();

        }

        return Storage;
    }

    public void addLutemon(Lutemon lutemon) {
        HomeLutemons.add(lutemon);

    }
    public void addLutemons(ArrayList<Lutemon> lutemons) {
        HomeLutemons.addAll(lutemons);
    }

    public ArrayList<Lutemon> listLutemons() {
        return new ArrayList<>(HomeLutemons);
    }

    public void removeLutemon(Lutemon lutemon) {
        HomeLutemons.remove(lutemon);
    }
    public void clearLutemons() {
        HomeLutemons.clear();
    }

}