package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;

import java.util.Map;
import java.util.HashMap;

public class BossEnemy extends AbstractEnemy {

    private Map<Integer, Integer> phases;
    private boolean canFly;
    private boolean hasBreathAttack;
    private int wingspan;

    public BossEnemy(String name, int health, int damage, int defense, int speed) {
        super();
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.defense = defense;
        this.speed = speed;
        this.phases = new HashMap<>();
    }

    public Map<Integer, Integer> getPhases() {
        return phases;
    }

    public void addPhase(int phaseNumber, int healthThreshold) {
        this.phases.put(phaseNumber, healthThreshold);
    }

    public boolean canFly() {
        return canFly;
    }

    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
    }

    public boolean hasBreathAttack() {
        return hasBreathAttack;
    }

    public void setHasBreathAttack(boolean hasBreathAttack) {
        this.hasBreathAttack = hasBreathAttack;
    }

    public int getWingspan() {
        return wingspan;
    }

    public void setWingspan(int wingspan) {
        this.wingspan = wingspan;
    }

    @Override
    public void displayInfo() {
        System.out.println("=== " + name + " (Boss Enemy) ===");
        System.out.println("Health: " + health + " | Damage: " + damage
                + " | Defense: " + defense + " | Speed: " + speed);
        System.out.println("Element: " + element);
        System.out.println("AI: " + aiBehavior);
        System.out.println("Abilities (" + abilities.size() + "):");
        for (Ability a : abilities) {
            System.out.println("  - " + a.getName() + " (Dmg: " + a.getDamage() + ") - " + a.getDescription());
        }
        if (!phases.isEmpty()) {
            System.out.println("Boss Phases: " + phases.size());
            for (Map.Entry<Integer, Integer> phase : phases.entrySet()) {
                System.out.println("  Phase " + phase.getKey()
                        + ": triggers at " + phase.getValue() + " HP");
            }
        }
        if (canFly || hasBreathAttack || wingspan > 0) {
            System.out.println("Can Fly: " + canFly
                    + " | Breath Attack: " + hasBreathAttack
                    + " | Wingspan: " + wingspan);
        }
        if (lootTable != null) {
            System.out.println("Loot: " + lootTable.getLootInfo());
        }
    }

    @Override
    public Enemy clone() {
        BossEnemy copy = new BossEnemy(this.name, this.health, this.damage, this.defense, this.speed);
        copyBaseFields(copy);
        copy.phases = new HashMap<>(this.phases);
        copy.canFly = this.canFly;
        copy.hasBreathAttack = this.hasBreathAttack;
        copy.wingspan = this.wingspan;
        return copy;
    }
}
