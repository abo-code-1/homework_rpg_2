package com.narxoz.rpg.combat.ice;

import com.narxoz.rpg.combat.Ability;

public class Blizzard implements Ability {

    private String name;
    private int damage;
    private String description;

    public Blizzard() {
        this.name = "Blizzard";
        this.damage = 250;
        this.description = "Summons a devastating blizzard, dealing massive AoE ice damage and freezing all targets";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Ability clone() {
        Blizzard copy = new Blizzard();
        copy.name = this.name;
        copy.damage = this.damage;
        copy.description = this.description;
        return copy;
    }
}
