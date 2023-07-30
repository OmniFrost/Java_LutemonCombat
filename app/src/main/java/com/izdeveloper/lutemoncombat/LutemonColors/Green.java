package com.izdeveloper.lutemoncombat.LutemonColors;

import com.izdeveloper.lutemoncombat.Lutemon;

public class Green extends Lutemon {
    public Green(String name, int avatar) {
        super(name, "Green", 6, 3, 0, 19, 19, avatar);
    }
    @Override
    public void increaseXP(int xp) {
        super.increaseXP(xp);
        this.attack += xp;
    }
}
