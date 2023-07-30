package com.izdeveloper.lutemoncombat.LutemonColors;

import com.izdeveloper.lutemoncombat.Lutemon;

public class White extends Lutemon {
    public White(String name, int avatar) {
        super(name, "White", 5, 4, 0, 20, 20, avatar);
    }
    @Override
    public void increaseXP(int xp) {
        super.increaseXP(xp);
        this.attack += xp;
    }
}
