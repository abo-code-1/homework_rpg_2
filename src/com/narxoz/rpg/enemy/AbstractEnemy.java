package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;

import java.util.List;
import java.util.ArrayList;

public abstract class AbstractEnemy implements Enemy {

    protected String name;
    protected int health;
    protected int damage;
    protected int defense;
    protected int speed;
    protected String element;
    protected String aiBehavior;
    protected List<Ability> abilities;
    protected LootTable lootTable;

    protected AbstractEnemy() {
        this.element = "NONE";
        this.aiBehavior = "PASSIVE";
        this.abilities = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public int getDefense() {
        return defense;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public String getElement() {
        return element;
    }

    @Override
    public List<Ability> getAbilities() {
        return abilities;
    }

    @Override
    public LootTable getLootTable() {
        return lootTable;
    }

    @Override
    public String getAI() {
        return aiBehavior;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setElement(String element) {
        this.element = element;
    }

    @Override
    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }

    @Override
    public void setLootTable(LootTable lootTable) {
        this.lootTable = lootTable;
    }

    @Override
    public void setAI(String aiBehavior) {
        this.aiBehavior = aiBehavior;
    }

    @Override
    public void addAbility(Ability ability) {
        this.abilities.add(ability);
    }

    @Override
    public void multiplyStats(double multiplier) {
        this.health = (int) (this.health * multiplier);
        this.damage = (int) (this.damage * multiplier);
        this.defense = (int) (this.defense * multiplier);
        this.speed = (int) (this.speed * multiplier);
    }

    protected List<Ability> deepCopyAbilities() {
        List<Ability> copied = new ArrayList<>();
        for (Ability a : this.abilities) {
            copied.add(a.clone());
        }
        return copied;
    }

    protected void copyBaseFields(AbstractEnemy target) {
        target.name = this.name;
        target.health = this.health;
        target.damage = this.damage;
        target.defense = this.defense;
        target.speed = this.speed;
        target.element = this.element;
        target.aiBehavior = this.aiBehavior;
        target.abilities = deepCopyAbilities();
        target.lootTable = this.lootTable != null ? this.lootTable.clone() : null;
    }

    @Override
    public abstract Enemy clone();

    @Override
    public abstract void displayInfo();
}
