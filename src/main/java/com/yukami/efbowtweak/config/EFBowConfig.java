package com.yukami.efbowtweak.config;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

import java.util.Arrays;
import java.util.List;

@Mod.EventBusSubscriber(modid = "efbowtweak", bus = Mod.EventBusSubscriber.Bus.MOD)
public class EFBowConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    // Define the config values
    public static ForgeConfigSpec.DoubleValue BOW_OFFSET;  // Double value for bow offset

    // The config spec will be built in the static block
    public static final ForgeConfigSpec CONFIG;

    static {
        // Push to "General Settings" category
        BUILDER.push("General Settings");

        // Define the bow offset setting with a comment and range
        BOW_OFFSET = BUILDER
                .comment("Adjust the bow offset, positive values move the bow to the right and vice versa. Default value is 0.1")
                .defineInRange("bowOffset", 0.1, -10.0, 10.0);  // Default value is 0.1, range between -10.0 and 10.0

        // Pop the category
        BUILDER.pop();

        CONFIG = BUILDER.build();
    }

    public static float bowOffset;
    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        bowOffset = BOW_OFFSET.get().floatValue();
    }
    // The config values can now be accessed directly
    // For example, you can access bowOffset as follows:
    // double currentBowOffset = EFBowConfig.bowOffset.get();
}
