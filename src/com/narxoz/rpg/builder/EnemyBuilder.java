package com.narxoz.rpg.builder;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.loot.LootTable;

import java.util.List;

public interface EnemyBuilder {

    EnemyBuilder setName(String name);

    EnemyBuilder setHealth(int health);

    EnemyBuilder setDamage(int damage);

    EnemyBuilder setDefense(int defense);

    EnemyBuilder setSpeed(int speed);

    EnemyBuilder setElement(String element);

    EnemyBuilder addAbility(Ability ability);

    EnemyBuilder setAbilities(List<Ability> abilities);

    EnemyBuilder setLootTable(LootTable loot);

    EnemyBuilder setAI(String aiBehavior);

    EnemyBuilder addPhase(int phaseNumber, int healthThreshold);

    // FACTORY METHOD: build() is the factory method.
    // Different builders (BasicEnemyBuilder, BossEnemyBuilder) override
    // how the Enemy is created — this is Factory Method delegation.
    Enemy build();
}
