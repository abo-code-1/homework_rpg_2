package com.narxoz.rpg.combat.ice;

import com.narxoz.rpg.combat.Ability;

public class FrostBreath implements Ability {

    private String name;
    private int damage;
    private String description;

    public FrostBreath() {
        this.name = "Frost Breath";
        this.damage = 100;
        this.description = "Exhales a freezing blast of ice, dealing damage and slowing enemies";
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
        FrostBreath copy = new FrostBreath();
        copy.name = this.name;
        copy.damage = this.damage;
        copy.description = this.description;
        return copy;
    }
}
