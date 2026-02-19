package com.narxoz.rpg.combat.shadow;

import com.narxoz.rpg.combat.Ability;

public class Vanish implements Ability {

    private String name;
    private int damage;
    private String description;

    public Vanish() {
        this.name = "Vanish";
        this.damage = 0;
        this.description = "Fades into the shadows, becoming invisible and evading all attacks for a short duration";
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
        Vanish copy = new Vanish();
        copy.name = this.name;
        copy.damage = this.damage;
        copy.description = this.description;
        return copy;
    }
}
