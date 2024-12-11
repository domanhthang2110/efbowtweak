package com.yukami.efbowtweak.event;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.logging.LogUtils;
import com.yukami.efbowtweak.EFBowTweak;
import com.yukami.efbowtweak.config.EFBowConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.item.BowItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.joml.Matrix4f;

@Mod.EventBusSubscriber(modid = EFBowTweak.MODID)
public class EFRenderHandEvent {
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void EFonRenderHand(RenderHandEvent event) {
        Minecraft minecraft = Minecraft.getInstance();
        PoseStack poseStack = event.getPoseStack();
        LocalPlayer player = minecraft.player;
        assert player != null;

        // Clone the current transformation matrix
        Matrix4f transform = new Matrix4f(poseStack.last().pose());

        // Check if the player is using a bow and apply transformations
        if (player.isUsingItem() && player.getUseItem().getItem() instanceof BowItem) {
            LogUtils.getLogger().info(String.valueOf(EFBowConfig.bowOffset));
            transform.translate(EFBowConfig.bowOffset, 0.0F, 0.0F); // Adjust hand position
        }

        // Reapply the modified transformation
        poseStack.last().pose().set(transform);
    }
}

