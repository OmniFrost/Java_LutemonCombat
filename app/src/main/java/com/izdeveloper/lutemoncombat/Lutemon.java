package com.izdeveloper.lutemoncombat;


import java.io.Serializable;
import java.util.Random;

public class Lutemon implements Serializable {
    protected String name, color;
    protected int attack, defense, experinse, HP, maxHP, id, avatar, wins, losses, matches, lights, mediums, heavies;
    private static int idCounter = 1;
    private boolean isSelected;

    public Lutemon(String name, String color, int attack, int defense, int experinse, int HP, int maxHP, int avatar) {
        this.name = name;
        this.color = color;
        this.attack = attack;
        this.defense = defense;
        this.experinse = experinse;
        this.HP = HP;
        this.maxHP = maxHP;
        this.id = idCounter++;
        this.avatar = avatar;
        isSelected = false;
        this.wins = 0;
        this.losses = 0;
        this.lights = 0;
        this.mediums = 0;
        this.heavies = 0;
        this.matches = 0;
    }

    public int getLights() {
        return lights;
    }

    public int getMediums() {
        return mediums;
    }

    public int getHeavies() {
        return heavies;
    }

    public int getMatches() {
        return matches;
    }

    public void plusHeavies() {
        heavies++;
    }
    public void plusMediums() {
        mediums++;
    }
    public void plusLights() {
        lights++;
    }
    public void plusWins() {
        wins++;
    }

    public void plusLosses() {
        losses++;
    }
    public void plusMatches() {
        matches++;
    }
    public double getKD() {
        if (losses == 0) {
            return wins;
        } else {
            return (double) wins / losses;
        }
    }
    public int getWins() {
        return wins;
    }
    public int getLosses() {
        return losses;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getExperinse() {
        return experinse;
    }

    public int getHP() {
        return HP;
    }

    public void setFullHP() {
        this.HP = this.maxHP;
    }
    public int getMaxHP() {
        return maxHP;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getAvatar() {
        return avatar;
    }
    public void setSelected(boolean selected) {
        isSelected = selected;
    }
    public void increaseXP(int xp) {
        experinse += xp;
    }

    //Second part of fighting algorithm, gets the attacking Lutemon as a parameter
    public void defend(Lutemon attacker) {
        int dmg;
        double rand;
        int nonCrit = attacker.getAttack() - this.defense;
        Random randomGenerator = new Random();
        rand = randomGenerator.nextDouble();
        boolean isCrit = rand <= 0.2;

        if (nonCrit > 0) {
            dmg = nonCrit;
        } else {
            dmg = 0;
        }
        double dmgMultiplyer, multiplied = 0.0;

        if (isCrit) {
            dmgMultiplyer = 2.0;
            multiplied = nonCrit * dmgMultiplyer;
        } else {
            dmgMultiplyer = 0.7 + randomGenerator.nextDouble() * 0.5;
            multiplied = nonCrit * dmgMultiplyer;
        }
        dmg = (int) Math.round(multiplied);

        this.HP = HP - dmg;

        //Set Lutemon to beginning state after death
        if (this.HP <= 0) {
            this.experinse = 0;
            switch (color) {
                case "Black":
                    this.attack = 9;
                    break;
                case "Green":
                    this.attack = 6;
                    break;
                case "Orange":
                    this.attack = 8;
                    break;
                case "Pink":
                    this.attack = 7;
                    break;
                case "White":
                    this.attack = 5;
                    break;

            }
        }
    }
}
