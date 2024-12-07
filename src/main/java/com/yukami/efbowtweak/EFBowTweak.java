package com.yukami.efbowtweak;

import com.yukami.efbowtweak.event.EFRenderHandEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.common.Mod;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(EFBowTweak.MODID)
public class EFBowTweak
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "efbowtweak";
    public EFBowTweak()
    {
        // Register the FlyingEvent class on the MinecraftForge event bus
        MinecraftForge.EVENT_BUS.register(EFRenderHandEvent.class);
    }
}
