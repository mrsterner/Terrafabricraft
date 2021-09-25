package malek.terrafabricraft.common.registry;

import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistryV3;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentInitializer;
import dev.onyxstudios.cca.api.v3.entity.RespawnCopyStrategy;
import dev.onyxstudios.cca.api.v3.item.ItemComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.item.ItemComponentInitializer;
import dev.onyxstudios.cca.api.v3.world.WorldComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.world.WorldComponentInitializer;
import malek.terrafabricraft.TerraFabriCraft;
import malek.terrafabricraft.common.component.*;
import net.minecraft.block.Block;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class TFCComponents implements EntityComponentInitializer, WorldComponentInitializer, ItemComponentInitializer {
    public static final ComponentKey<HealthComponent> HEALTH_COMPONENT = ComponentRegistryV3.INSTANCE.getOrCreate(new Identifier(TerraFabriCraft.MODID, "health"), HealthComponent.class);
    public static final ComponentKey<HungerComponent> HUNGER_COMPONENT = ComponentRegistryV3.INSTANCE.getOrCreate(new Identifier(TerraFabriCraft.MODID, "hunger"), HungerComponent.class);
    public static final ComponentKey<ThirstComponent> THIRST_COMPONENT = ComponentRegistryV3.INSTANCE.getOrCreate(new Identifier(TerraFabriCraft.MODID, "thirst"), ThirstComponent.class);

    public static final ComponentKey<ProficiencyComponent> PROFICIENCY_COMPONENT = ComponentRegistryV3.INSTANCE.getOrCreate(new Identifier(TerraFabriCraft.MODID, "proficiency"), ProficiencyComponent.class);

    public static final ComponentKey<DecayComponent> DECAY_COMPONENT = ComponentRegistryV3.INSTANCE.getOrCreate(new Identifier(TerraFabriCraft.MODID, "decay"), DecayComponent.class);


    @Override
    public void registerEntityComponentFactories(EntityComponentFactoryRegistry registry) {
        registry.beginRegistration(LivingEntity.class, HEALTH_COMPONENT).impl(HealthComponent.class).respawnStrategy(RespawnCopyStrategy.LOSSLESS_ONLY).end(HealthComponent::new);
        registry.beginRegistration(PlayerEntity.class, HUNGER_COMPONENT).impl(HungerComponent.class).respawnStrategy(RespawnCopyStrategy.LOSSLESS_ONLY).end(HungerComponent::new);
        registry.beginRegistration(PlayerEntity.class, THIRST_COMPONENT).impl(ThirstComponent.class).respawnStrategy(RespawnCopyStrategy.LOSSLESS_ONLY).end(ThirstComponent::new);

        registry.beginRegistration(PlayerEntity.class, PROFICIENCY_COMPONENT).impl(ProficiencyComponent.class).respawnStrategy(RespawnCopyStrategy.ALWAYS_COPY).end(ProficiencyComponent::new);
    }

    @Override
    public void registerWorldComponentFactories(WorldComponentFactoryRegistry registry) {

    }

    @Override
    public void registerItemComponentFactories(ItemComponentFactoryRegistry registry) {
        //registry.register(item -> item instanceof TFCFood, DECAY_COMPONENT, DecayComponent::new);
        registry.register(item -> item instanceof TFCFood, DECAY_COMPONENT, DecayComponent::new);
        /*
        for(Item item : TFCObjects.ITEMS.keySet()) {
            if(item instanceof TFCFood) {

                registry.register(item -> item instanceof TFCFood, DECAY_COMPONENT, (stack) -> new DecayComponent());
            }
        }

         */


    }
}
