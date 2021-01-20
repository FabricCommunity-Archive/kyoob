package dev.vatuu.kyoob.events;

import dev.vatuu.kyoob.client.cutscene.Cutscene;
import dev.vatuu.kyoob.client.cutscene.CutsceneHandler;
import dev.vatuu.kyoob.client.cutscene.Cutscenes;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.Camera;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.util.TypedActionResult;

public class KyoobEvents {

    public static void init() {
        UseItemCallback.EVENT.register((player, world, hand) -> {
            if (world.isClient()) {
                if (!player.getStackInHand(hand).isEmpty() && player.getStackInHand(hand).getItem() == Items.ACACIA_SAPLING) {
                    if (!CutsceneHandler.isCutsceneRunning())
                        Cutscenes.testScene.startCutscene();
                    else
                        Cutscenes.testScene.stopCutscene();
                }
            }

            return TypedActionResult.success(player.getStackInHand(hand));
        });
    }

}
