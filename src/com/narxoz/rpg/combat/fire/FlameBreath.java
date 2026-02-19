package com.narxoz.rpg.combat.fire;

import com.narxoz.rpg.combat.Ability;

public class FlameBreath implements Ability {

    private String name;
    private int damage;
    private String description;

    public FlameBreath() {
        this.name = "Flame Breath";
        this.damage = 120;
        this.description = "Unleashes a cone of scorching flames, dealing AoE fire damage and applying burn";
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
        FlameBreath copy = new FlameBreath();
        copy.name = this.name;
        copy.damage = this.damage;
        copy.description = this.description;
        return copy;
    }
}
