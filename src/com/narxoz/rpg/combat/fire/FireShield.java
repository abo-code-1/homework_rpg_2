package com.narxoz.rpg.combat.fire;

import com.narxoz.rpg.combat.Ability;

public class FireShield implements Ability {

    private String name;
    private int damage;
    private String description;

    public FireShield() {
        this.name = "Fire Shield";
        this.damage = 30;
        this.description = "Surrounds the caster in a blazing shield, reflecting damage to attackers";
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
        FireShield copy = new FireShield();
        copy.name = this.name;
        copy.damage = this.damage;
        copy.description = this.description;
        return copy;
    }
}
