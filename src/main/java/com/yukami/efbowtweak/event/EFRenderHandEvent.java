package com.yukami.efbowtweak.event;

import com.mojang.blaze3d.vertex.PoseStack;
import com.yukami.efbowtweak.EFBowTweak;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.item.BowItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = EFBowTweak.MODID)
public class EFRenderHandEvent {
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void EFonRenderHand(RenderHandEvent event) {
        Minecraft minecraft = Minecraft.getInstance();
        PoseStack poseStack = event.getPoseStack();
        LocalPlayer player = minecraft.player;
        poseStack.pushPose();
        assert player != null;
        if (player.isUsingItem() && player.getUseItem().getItem() instanceof BowItem) {
            poseStack.translate(0.1D, 0.0D, 0.0D);
        }
    }
}

