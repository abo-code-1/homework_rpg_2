package com.narxoz.rpg.combat.fire;

import com.narxoz.rpg.combat.Ability;

public class MeteorStorm implements Ability {

    private String name;
    private int damage;
    private String description;

    public MeteorStorm() {
        this.name = "Meteor Storm";
        this.damage = 300;
        this.description = "Calls down a devastating rain of meteors, dealing massive AoE fire damage";
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
        MeteorStorm copy = new MeteorStorm();
        copy.name = this.name;
        copy.damage = this.damage;
        copy.description = this.description;
        return copy;
    }
}
