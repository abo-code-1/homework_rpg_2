package com.narxoz.rpg;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.enemy.Goblin;
import com.narxoz.rpg.enemy.Skeleton;
import com.narxoz.rpg.factory.EnemyComponentFactory;
import com.narxoz.rpg.factory.FireComponentFactory;
import com.narxoz.rpg.factory.IceComponentFactory;
import com.narxoz.rpg.factory.ShadowComponentFactory;
import com.narxoz.rpg.builder.BasicEnemyBuilder;
import com.narxoz.rpg.builder.BossEnemyBuilder;
import com.narxoz.rpg.director.EnemyDirector;
import com.narxoz.rpg.prototype.EnemyRegistry;
import com.narxoz.rpg.loot.LootTable;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== RPG Enemy System - Creational Patterns Capstone ===\n");

        System.out.println("PART 1: ABSTRACT FACTORY - Themed Components");

        EnemyComponentFactory fireFactory = new FireComponentFactory();
        EnemyComponentFactory iceFactory = new IceComponentFactory();
        EnemyComponentFactory shadowFactory = new ShadowComponentFactory();

        System.out.println("--- Fire Component Factory ---");
        displayFactoryComponents(fireFactory, "Fire");

        System.out.println("--- Ice Component Factory ---");
        displayFactoryComponents(iceFactory, "Ice");

        System.out.println("--- Shadow Component Factory ---");
        displayFactoryComponents(shadowFactory, "Shadow");




        System.out.println("PART 2: BUILDER - Complex Enemy Construction");


        System.out.println("--- Building a basic enemy with BasicEnemyBuilder (fluent interface) ---");
        Enemy fireWarrior = new BasicEnemyBuilder()
                .setName("Fire Warrior")
                .setHealth(500)
                .setDamage(45)
                .setDefense(20)
                .setSpeed(30)
                .setElement("FIRE")
                .setAbilities(fireFactory.createAbilities())
                .setLootTable(fireFactory.createLootTable())
                .setAI(fireFactory.createAIBehavior())
                .build();
        fireWarrior.displayInfo();
        System.out.println();

        System.out.println("--- Building a boss enemy with BossEnemyBuilder (fluent interface) ---");
        Enemy ancientDragon = new BossEnemyBuilder()
                .setName("Ancient Fire Dragon")
                .setHealth(50000)
                .setDamage(500)
                .setDefense(200)
                .setSpeed(50)
                .setElement("FIRE")
                .setAbilities(fireFactory.createAbilities())
                .setLootTable(fireFactory.createLootTable())
                .setAI(fireFactory.createAIBehavior())
                .addPhase(1, 50000)
                .addPhase(2, 30000)
                .addPhase(3, 15000)
                .build();
        ancientDragon.displayInfo();
        System.out.println();

        System.out.println("--- Director creating preset enemies with IceComponentFactory ---");
        EnemyDirector bossDirector = new EnemyDirector(new BossEnemyBuilder());
        Enemy iceRaidBoss = bossDirector.createRaidBoss(iceFactory);
        iceRaidBoss.displayInfo();
        System.out.println();

        EnemyDirector basicDirector = new EnemyDirector(new BasicEnemyBuilder());
        Enemy iceMinion = basicDirector.createMinion(iceFactory);
        iceMinion.displayInfo();
        System.out.println();




        System.out.println("PART 3: PROTOTYPE - Enemy Cloning & Variants");

        EnemyRegistry registry = new EnemyRegistry();

        Goblin baseGoblin = new Goblin("Goblin");
        Skeleton baseSkeleton = new Skeleton("Skeleton");

        Enemy baseDragon = new BossEnemyBuilder()
                .setName("Dragon")
                .setHealth(30000)
                .setDamage(350)
                .setDefense(150)
                .setSpeed(45)
                .addPhase(1, 30000)
                .addPhase(2, 15000)
                .build();

        registry.registerTemplate("goblin", baseGoblin);
        registry.registerTemplate("skeleton", baseSkeleton);
        registry.registerTemplate("dragon", baseDragon);

        System.out.println("Registered templates: " + registry.listTemplates());
        System.out.println();

        System.out.println("--- Goblin Difficulty Variants (cloned from template) ---");
        Enemy eliteGoblin = registry.createFromTemplate("goblin");
        eliteGoblin.setName("Elite Goblin");
        eliteGoblin.multiplyStats(2.0);
        eliteGoblin.displayInfo();
        System.out.println();

        Enemy championGoblin = registry.createFromTemplate("goblin");
        championGoblin.setName("Champion Goblin");
        championGoblin.multiplyStats(5.0);
        championGoblin.setAbilities(fireFactory.createAbilities());
        championGoblin.displayInfo();
        System.out.println();

        Enemy goblinKing = registry.createFromTemplate("goblin");
        goblinKing.setName("Goblin King");
        goblinKing.multiplyStats(10.0);
        goblinKing.setAbilities(shadowFactory.createAbilities());
        goblinKing.setLootTable(shadowFactory.createLootTable());
        goblinKing.displayInfo();
        System.out.println();

        System.out.println("--- Dragon Elemental Variants (cloned from template) ---");
        Enemy fireDragon = registry.createFromTemplate("dragon");
        fireDragon.setName("Fire Dragon");
        fireDragon.setElement("FIRE");
        fireDragon.setAbilities(fireFactory.createAbilities());
        fireDragon.setLootTable(fireFactory.createLootTable());
        fireDragon.setAI(fireFactory.createAIBehavior());
        fireDragon.displayInfo();
        System.out.println();

        Enemy iceDragon = registry.createFromTemplate("dragon");
        iceDragon.setName("Ice Dragon");
        iceDragon.setElement("ICE");
        iceDragon.setAbilities(iceFactory.createAbilities());
        iceDragon.setLootTable(iceFactory.createLootTable());
        iceDragon.setAI(iceFactory.createAIBehavior());
        iceDragon.displayInfo();
        System.out.println();

        Enemy shadowDragon = registry.createFromTemplate("dragon");
        shadowDragon.setName("Shadow Dragon");
        shadowDragon.setElement("SHADOW");
        shadowDragon.setAbilities(shadowFactory.createAbilities());
        shadowDragon.setLootTable(shadowFactory.createLootTable());
        shadowDragon.setAI(shadowFactory.createAIBehavior());
        shadowDragon.displayInfo();
        System.out.println();

        System.out.println("--- Skeleton Variants (cloned from template) ---");
        Enemy skeletonWarrior = registry.createFromTemplate("skeleton");
        skeletonWarrior.setName("Skeleton Warrior");
        skeletonWarrior.multiplyStats(3.0);
        skeletonWarrior.setAbilities(iceFactory.createAbilities());
        skeletonWarrior.displayInfo();
        System.out.println();

        Enemy skeletonMage = registry.createFromTemplate("skeleton");
        skeletonMage.setName("Skeleton Mage");
        skeletonMage.multiplyStats(2.0);
        skeletonMage.setElement("SHADOW");
        skeletonMage.setAbilities(shadowFactory.createAbilities());
        skeletonMage.setLootTable(shadowFactory.createLootTable());
        skeletonMage.displayInfo();
        System.out.println();

        System.out.println("--- Deep Copy Verification ---");
        Enemy clonedGoblin = registry.createFromTemplate("goblin");
        clonedGoblin.setName("Modified Clone");
        clonedGoblin.multiplyStats(99.0);
        clonedGoblin.setAbilities(fireFactory.createAbilities());

        System.out.println("Cloned goblin after modification:");
        System.out.println("  Name: " + clonedGoblin.getName() + " | Health: " + clonedGoblin.getHealth()
                + " | Abilities: " + clonedGoblin.getAbilities().size());
        System.out.println("Original goblin template (should be UNCHANGED):");
        System.out.println("  Name: " + baseGoblin.getName() + " | Health: " + baseGoblin.getHealth()
                + " | Abilities: " + baseGoblin.getAbilities().size());
        System.out.println();

        System.out.println("PART 4: ALL PATTERNS WORKING TOGETHER");

        EnemyComponentFactory demonFactory = new ShadowComponentFactory();

        Enemy demonLord = new BossEnemyBuilder()
                .setName("Demon Lord")
                .setHealth(80000)
                .setDamage(800)
                .setDefense(400)
                .setSpeed(55)
                .setElement("SHADOW")
                .setAbilities(demonFactory.createAbilities())
                .setLootTable(demonFactory.createLootTable())
                .setAI(demonFactory.createAIBehavior())
                .addPhase(1, 80000)
                .addPhase(2, 50000)
                .addPhase(3, 20000)
                .build();
        demonLord.displayInfo();
        System.out.println();

        registry.registerTemplate("demon-lord", demonLord);

        Enemy greaterDemon = registry.createFromTemplate("demon-lord");
        greaterDemon.setName("Greater Demon");
        greaterDemon.multiplyStats(0.5);
        greaterDemon.displayInfo();
        System.out.println();

        Enemy archDemon = registry.createFromTemplate("demon-lord");
        archDemon.setName("Arch Demon");
        archDemon.multiplyStats(2.0);
        archDemon.displayInfo();
        System.out.println();

        Enemy demonOverlord = registry.createFromTemplate("demon-lord");
        demonOverlord.setName("Demon Overlord");
        demonOverlord.multiplyStats(5.0);
        demonOverlord.displayInfo();
        System.out.println();

        System.out.println("\n=== Demo Complete ===");
    }

    private static void displayFactoryComponents(EnemyComponentFactory factory, String themeName) {
        List<Ability> abilities = factory.createAbilities();
        LootTable loot = factory.createLootTable();
        String ai = factory.createAIBehavior();

        System.out.println("Theme: " + themeName);
        System.out.println("AI Behavior: " + ai);
        System.out.println("Abilities:");
        for (Ability a : abilities) {
            System.out.println("  - " + a.getName() + " (Dmg: " + a.getDamage() + ") - " + a.getDescription());
        }
        System.out.println("Loot: " + loot.getLootInfo());
        System.out.println();
    }
}
