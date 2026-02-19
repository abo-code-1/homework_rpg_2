package com.narxoz.rpg.combat.shadow;

import com.narxoz.rpg.combat.Ability;

public class ShadowStrike implements Ability {

    private String name;
    private int damage;
    private String description;

    public ShadowStrike() {
        this.name = "Shadow Strike";
        this.damage = 150;
        this.description = "Strikes from the shadows with lethal precision, dealing high single-target damage and blinding the target";
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
        ShadowStrike copy = new ShadowStrike();
        copy.name = this.name;
        copy.damage = this.damage;
        copy.description = this.description;
        return copy;
    }
}
