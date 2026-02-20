package com.narxoz.rpg.builder;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.enemy.BasicEnemy;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.loot.LootTable;

import java.util.List;
import java.util.ArrayList;

public class BasicEnemyBuilder implements EnemyBuilder {

    private String name;
    private int health;
    private int damage;
    private int defense;
    private int speed;
    private String element;
    private String aiBehavior;
    private List<Ability> abilities;
    private LootTable lootTable;

    public BasicEnemyBuilder() {
        this.abilities = new ArrayList<>();
        this.element = "NONE";
        this.aiBehavior = "PASSIVE";
    }

    @Override
    public EnemyBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public EnemyBuilder setHealth(int health) {
        this.health = health;
        return this;
    }

    @Override
    public EnemyBuilder setDamage(int damage) {
        this.damage = damage;
        return this;
    }

    @Override
    public EnemyBuilder setDefense(int defense) {
        this.defense = defense;
        return this;
    }

    @Override
    public EnemyBuilder setSpeed(int speed) {
        this.speed = speed;
        return this;
    }

    @Override
    public EnemyBuilder setElement(String element) {
        this.element = element;
        return this;
    }

    @Override
    public EnemyBuilder addAbility(Ability ability) {
        this.abilities.add(ability);
        return this;
    }

    @Override
    public EnemyBuilder setAbilities(List<Ability> abilities) {
        this.abilities = new ArrayList<>(abilities);
        return this;
    }

    @Override
    public EnemyBuilder setLootTable(LootTable loot) {
        this.lootTable = loot;
        return this;
    }

    @Override
    public EnemyBuilder setAI(String aiBehavior) {
        this.aiBehavior = aiBehavior;
        return this;
    }

    @Override
    public EnemyBuilder addPhase(int phaseNumber, int healthThreshold) {
        return this;
    }

    // FACTORY METHOD: build() creates a BasicEnemy.
    // This is the concrete factory method — it decides WHICH product to create.
    @Override
    public Enemy build() {
        if (name == null || name.isEmpty()) {
            throw new IllegalStateException("Enemy name is required!");
        }
        if (health <= 0) {
            throw new IllegalStateException("Enemy health must be positive!");
        }

        BasicEnemy enemy = new BasicEnemy(name, health, damage, defense, speed);
        enemy.setElement(element);
        enemy.setAI(aiBehavior);
        for (Ability a : abilities) {
            enemy.addAbility(a);
        }
        if (lootTable != null) {
            enemy.setLootTable(lootTable);
        }

        reset();
        return enemy;
    }

    private void reset() {
        this.name = null;
        this.health = 0;
        this.damage = 0;
        this.defense = 0;
        this.speed = 0;
        this.element = "NONE";
        this.aiBehavior = "PASSIVE";
        this.abilities = new ArrayList<>();
        this.lootTable = null;
    }
}
