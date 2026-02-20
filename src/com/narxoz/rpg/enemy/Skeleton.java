package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;

public class Skeleton extends AbstractEnemy {

    public Skeleton(String name) {
        super();
        this.name = name;
        this.health = 80;
        this.damage = 20;
        this.defense = 10;
        this.speed = 20;
        this.aiBehavior = "DEFENSIVE";
    }

    @Override
    public void displayInfo() {
        System.out.println("=== " + name + " (Skeleton) ===");
        System.out.println("Health: " + health + " | Damage: " + damage
                + " | Defense: " + defense + " | Speed: " + speed);
        System.out.println("Element: " + element);
        System.out.println("AI: " + aiBehavior);
        System.out.println("Abilities (" + abilities.size() + "):");
        for (Ability a : abilities) {
            System.out.println("  - " + a.getName() + " (Dmg: " + a.getDamage() + ") - " + a.getDescription());
        }
        if (lootTable != null) {
            System.out.println("Loot: " + lootTable.getLootInfo());
        }
    }

    @Override
    public Enemy clone() {
        Skeleton copy = new Skeleton(this.name);
        copyBaseFields(copy);
        return copy;
    }
}
