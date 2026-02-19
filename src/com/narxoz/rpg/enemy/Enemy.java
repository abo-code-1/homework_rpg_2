package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;

import java.util.List;

public interface Enemy {

    String getName();

    int getHealth();

    int getDamage();

    int getDefense();

    int getSpeed();

    String getElement();

    List<Ability> getAbilities();

    LootTable getLootTable();

    void displayInfo();

    void multiplyStats(double multiplier);

    void addAbility(Ability ability);

    void setElement(String element);

    void setName(String name);

    void setAbilities(List<Ability> abilities);

    void setLootTable(LootTable lootTable);

    void setAI(String aiBehavior);

    String getAI();

    Enemy clone();
}
