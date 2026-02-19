package com.narxoz.rpg.loot;

import java.util.List;
import java.util.ArrayList;

public class ShadowLootTable implements LootTable {

    private List<String> items;
    private int goldDrop;
    private int experienceDrop;

    public ShadowLootTable() {
        this.items = new ArrayList<>();
        this.items.add("Shadow Gem");
        this.items.add("Dark Essence");
        this.items.add("Shadow Rune");
        this.goldDrop = 550;
        this.experienceDrop = 1300;
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
        return "Shadow Loot: " + items + " | Gold: " + goldDrop + " | XP: " + experienceDrop;
    }

    @Override
    public LootTable clone() {
        ShadowLootTable copy = new ShadowLootTable();
        copy.items = new ArrayList<>(this.items);
        copy.goldDrop = this.goldDrop;
        copy.experienceDrop = this.experienceDrop;
        return copy;
    }
}
