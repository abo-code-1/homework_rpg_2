package com.narxoz.rpg.loot;

import java.util.List;
import java.util.ArrayList;

public class FireLootTable implements LootTable {

    private List<String> items;
    private int goldDrop;
    private int experienceDrop;

    public FireLootTable() {
        this.items = new ArrayList<>();
        this.items.add("Fire Gem");
        this.items.add("Dragon Scale");
        this.items.add("Flame Rune");
        this.goldDrop = 500;
        this.experienceDrop = 1200;
    }

    @Override
    public List<String> getItems() {
        return items;
    }

    @Override
    public int getGoldDrop() {
        return goldDrop;
    }

    @Override
    public int getExperienceDrop() {
        return experienceDrop;
    }

    @Override
    public String getLootInfo() {
        return "Fire Loot: " + items + " | Gold: " + goldDrop + " | XP: " + experienceDrop;
    }

    @Override
    public LootTable clone() {
        FireLootTable copy = new FireLootTable();
        copy.items = new ArrayList<>(this.items);
        copy.goldDrop = this.goldDrop;
        copy.experienceDrop = this.experienceDrop;
        return copy;
    }
}
