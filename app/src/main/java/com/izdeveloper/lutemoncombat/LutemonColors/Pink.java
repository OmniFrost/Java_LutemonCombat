package com.izdeveloper.lutemoncombat.LutemonColors;

import com.izdeveloper.lutemoncombat.Lutemon;

public class Pink extends Lutemon {
    public Pink(String name, int avatar) {
        super(name, "Pink", 7, 2, 0, 18, 18, avatar);
    }
    @Override
    public void increaseXP(int xp) {
        super.increaseXP(xp);
        this.attack += xp;
    }
}