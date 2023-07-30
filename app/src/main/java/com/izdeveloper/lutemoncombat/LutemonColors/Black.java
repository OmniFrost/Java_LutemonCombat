package com.izdeveloper.lutemoncombat.LutemonColors;

import com.izdeveloper.lutemoncombat.Lutemon;

public class Black extends Lutemon {
    public Black(String name, int avatar) {
        super(name, "Black", 9, 0, 0, 16, 16, avatar);
    }
    @Override
    public void increaseXP(int xp) {
        super.increaseXP(xp);
        this.attack += xp;
    }

}