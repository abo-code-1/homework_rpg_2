package com.narxoz.rpg.director;

import com.narxoz.rpg.builder.EnemyBuilder;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.factory.EnemyComponentFactory;

// FACTORY METHOD: The Director delegates enemy creation to the Builder.
// It calls builder.build() polymorphically — the Director does not know
// whether it's using a BasicEnemyBuilder or BossEnemyBuilder.
// This is Factory Method delegation: the Director defines WHAT to build,
// the Builder decides HOW to build and WHICH concrete type to return.
public class EnemyDirector {

    private EnemyBuilder builder;

    public EnemyDirector(EnemyBuilder builder) {
        this.builder = builder;
    }

    public void setBuilder(EnemyBuilder builder) {
        this.builder = builder;
    }

    public Enemy createMinion(EnemyComponentFactory factory) {
        return builder
                .setName("Minion")
                .setHealth(200)
                .setDamage(20)
                .setDefense(5)
                .setSpeed(30)
                .setAbilities(factory.createAbilities())
                .setLootTable(factory.createLootTable())
                .setAI(factory.createAIBehavior())
                .build();
    }

    public Enemy createElite(EnemyComponentFactory factory) {
        return builder
                .setName("Elite")
                .setHealth(1500)
                .setDamage(80)
                .setDefense(40)
                .setSpeed(45)
                .setAbilities(factory.createAbilities())
                .setLootTable(factory.createLootTable())
                .setAI(factory.createAIBehavior())
                .build();
    }

    public Enemy createMiniBoss(EnemyComponentFactory factory) {
        return builder
                .setName("Mini Boss")
                .setHealth(10000)
                .setDamage(250)
                .setDefense(120)
                .setSpeed(35)
                .setAbilities(factory.createAbilities())
                .setLootTable(factory.createLootTable())
                .setAI(factory.createAIBehavior())
                .addPhase(1, 10000)
                .addPhase(2, 5000)
                .build();
    }

    public Enemy createRaidBoss(EnemyComponentFactory factory) {
        return builder
                .setName("Raid Boss")
                .setHealth(100000)
                .setDamage(1000)
                .setDefense(500)
                .setSpeed(40)
                .setAbilities(factory.createAbilities())
                .setLootTable(factory.createLootTable())
                .setAI(factory.createAIBehavior())
                .addPhase(1, 100000)
                .addPhase(2, 60000)
                .addPhase(3, 30000)
                .build();
    }
}
