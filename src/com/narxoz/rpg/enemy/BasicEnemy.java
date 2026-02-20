package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;

public class BasicEnemy extends AbstractEnemy {

    public BasicEnemy(String name, int health, int damage, int defense, int speed) {
        super();
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.defense = defense;
        this.speed = speed;
    }

    @Override
    public void displayInfo() {
        System.out.println("=== " + name + " (Basic Enemy) ===");
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
        BasicEnemy copy = new BasicEnemy(this.name, this.health, this.damage, this.defense, this.speed);
        copyBaseFields(copy);
        return copy;
    }
}
