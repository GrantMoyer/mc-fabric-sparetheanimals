package com.grantmoyer.sparetheanimals;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.minecraft.item.Items;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.ConstantLootTableRange;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.UniformLootTableRange;
import net.minecraft.util.Identifier;

public class SpareTheAnimals implements ModInitializer
{
    private static final Identifier ZOMBIE_LOOT_TABLE_ID = new Identifier("minecraft", "entities/zombie");
    private static final Identifier SKELETON_LOOT_TABLE_ID = new Identifier("minecraft", "entities/skeleton");

    @Override
    public void onInitialize() {
        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, supplier, setter) -> {
            LootPoolEntry entry = null;
            if (ZOMBIE_LOOT_TABLE_ID.equals(id)) {
                entry = ItemEntry.builder(Items.LEATHER)
                    .apply(SetCountLootFunction.builder(UniformLootTableRange.between(0, 1)))
                    .build();
            }
            else if (SKELETON_LOOT_TABLE_ID.equals(id)) {
                entry = ItemEntry.builder(Items.FEATHER)
                    .apply(SetCountLootFunction.builder(UniformLootTableRange.between(0, 2)))
                    .build();
            }
            if (entry != null) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                    .rolls(ConstantLootTableRange.create(1))
                    .withEntry(entry);
                supplier.withPool(poolBuilder.build());
            }
        });

        System.out.println("SpareTheAnimals loaded");
    }
}
