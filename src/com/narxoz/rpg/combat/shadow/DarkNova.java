package com.narxoz.rpg.combat.shadow;

import com.narxoz.rpg.combat.Ability;

public class DarkNova implements Ability {

    private String name;
    private int damage;
    private String description;

    public DarkNova() {
        this.name = "Dark Nova";
        this.damage = 280;
        this.description = "Unleashes an explosion of dark energy, dealing massive AoE shadow damage to all nearby foes";
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
        DarkNova copy = new DarkNova();
        copy.name = this.name;
        copy.damage = this.damage;
        copy.description = this.description;
        return copy;
    }
}
