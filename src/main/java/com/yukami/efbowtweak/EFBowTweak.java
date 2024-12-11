package com.yukami.efbowtweak;

import com.yukami.efbowtweak.config.EFBowConfig;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(EFBowTweak.MODID)
public class EFBowTweak
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "efbowtweak";
    public EFBowTweak(FMLJavaModLoadingContext context)
    {
        context.registerConfig(ModConfig.Type.CLIENT, EFBowConfig.CONFIG, "efbowtweak.toml");
    }
}
