package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;

import java.util.Map;

public class DragonBoss extends BossEnemy {

    public DragonBoss(String name) {
        super(name, 50000, 500, 200, 50);
        this.element = "FIRE";
        this.aiBehavior = "AGGRESSIVE";
        setCanFly(true);
        setHasBreathAttack(true);
        setWingspan(20);
        addPhase(1, 50000);
        addPhase(2, 30000);
        addPhase(3, 15000);
    }

    @Override
    public void displayInfo() {
        System.out.println("=== " + name + " (Dragon Boss) ===");
        System.out.println("Health: " + health + " | Damage: " + damage
                + " | Defense: " + defense + " | Speed: " + speed);
        System.out.println("Element: " + element);
        System.out.println("AI: " + aiBehavior);
        System.out.println("Abilities (" + abilities.size() + "):");
        for (Ability a : abilities) {
            System.out.println("  - " + a.getName() + " (Dmg: " + a.getDamage() + ") - " + a.getDescription());
        }
        Map<Integer, Integer> phases = getPhases();
        System.out.println("Boss Phases: " + phases.size());
        for (Map.Entry<Integer, Integer> phase : phases.entrySet()) {
            System.out.println("  Phase " + phase.getKey()
                    + ": triggers at " + phase.getValue() + " HP");
        }
        System.out.println("Can Fly: " + canFly()
                + " | Breath Attack: " + hasBreathAttack()
                + " | Wingspan: " + getWingspan());
        if (lootTable != null) {
            System.out.println("Loot: " + lootTable.getLootInfo());
        }
    }

    @Override
    public Enemy clone() {
        DragonBoss copy = new DragonBoss(this.name);
        copyBaseFields(copy);
        copy.getPhases().clear();
        for (Map.Entry<Integer, Integer> entry : getPhases().entrySet()) {
            copy.addPhase(entry.getKey(), entry.getValue());
        }
        copy.setCanFly(this.canFly());
        copy.setHasBreathAttack(this.hasBreathAttack());
        copy.setWingspan(this.getWingspan());
        return copy;
    }
}
