package com.izdeveloper.lutemoncombat.LutemonColors;


import com.izdeveloper.lutemoncombat.Lutemon;

public class Orange extends Lutemon {
    public Orange(String name, int avatar) {
        super(name, "Orange", 8, 1, 0, 17, 17, avatar);
    }
    @Override
    public void increaseXP(int xp) {
        super.increaseXP(xp);
        this.attack += xp;
    }
}