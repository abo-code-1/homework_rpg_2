package com.narxoz.rpg.builder;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.enemy.BossEnemy;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.loot.LootTable;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class BossEnemyBuilder implements EnemyBuilder {

    private String name;
    private int health;
    private int damage;
    private int defense;
    private int speed;
    private String element;
    private String aiBehavior;
    private List<Ability> abilities;
    private Map<Integer, Integer> phases;
    private LootTable lootTable;
    private boolean canFly;
    private boolean hasBreathAttack;
    private int wingspan;

    public BossEnemyBuilder() {
        this.abilities = new ArrayList<>();
        this.phases = new HashMap<>();
        this.element = "NONE";
        this.aiBehavior = "AGGRESSIVE";
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
        this.phases.put(phaseNumber, healthThreshold);
        return this;
    }

    public BossEnemyBuilder setCanFly(boolean canFly) {
        this.canFly = canFly;
        return this;
    }

    public BossEnemyBuilder setHasBreathAttack(boolean hasBreathAttack) {
        this.hasBreathAttack = hasBreathAttack;
        return this;
    }

    public BossEnemyBuilder setWingspan(int wingspan) {
        this.wingspan = wingspan;
        return this;
    }

    // FACTORY METHOD: build() creates a BossEnemy.
    // Different from BasicEnemyBuilder.build() which creates BasicEnemy.
    // The Director calls build() polymorphically without knowing which concrete type is returned.
    @Override
    public Enemy build() {
        if (name == null || name.isEmpty()) {
            throw new IllegalStateException("Boss name is required!");
        }
        if (health <= 0) {
            throw new IllegalStateException("Boss health must be positive!");
        }

        BossEnemy boss = new BossEnemy(name, health, damage, defense, speed);
        boss.setElement(element);
        boss.setAI(aiBehavior);
        for (Ability a : abilities) {
            boss.addAbility(a);
        }
        for (Map.Entry<Integer, Integer> phase : phases.entrySet()) {
            boss.addPhase(phase.getKey(), phase.getValue());
        }
        if (lootTable != null) {
            boss.setLootTable(lootTable);
        }
        boss.setCanFly(canFly);
        boss.setHasBreathAttack(hasBreathAttack);
        boss.setWingspan(wingspan);

        reset();
        return boss;
    }

    private void reset() {
        this.name = null;
        this.health = 0;
        this.damage = 0;
        this.defense = 0;
        this.speed = 0;
        this.element = "NONE";
        this.aiBehavior = "AGGRESSIVE";
        this.abilities = new ArrayList<>();
        this.phases = new HashMap<>();
        this.lootTable = null;
        this.canFly = false;
        this.hasBreathAttack = false;
        this.wingspan = 0;
    }
}
