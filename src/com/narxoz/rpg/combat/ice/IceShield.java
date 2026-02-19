package com.narxoz.rpg.combat.ice;

import com.narxoz.rpg.combat.Ability;

public class IceShield implements Ability {

    private String name;
    private int damage;
    private String description;

    public IceShield() {
        this.name = "Ice Shield";
        this.damage = 20;
        this.description = "Encases the caster in a layer of ice, absorbing damage and freezing attackers";
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
        IceShield copy = new IceShield();
        copy.name = this.name;
        copy.damage = this.damage;
        copy.description = this.description;
        return copy;
    }
}
