package dev.vatuu.kyoob.client.mixin;

import dev.vatuu.kyoob.client.cutscene.CutsceneHandler;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.GameRenderer;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public class GameRendererMixin {
    @Final
    @Shadow
    private MinecraftClient client;

    @Final
    @Shadow
    private Camera camera;

    @Inject(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/GameRenderer;renderWorld(FJLnet/minecraft/client/util/math/MatrixStack;)V"))
    public void renderCutscene(float tickDelta, long startTime, boolean tick, CallbackInfo callbackInfo) {
        if (CutsceneHandler.getCutscene() != null) {
            if (!CutsceneHandler.isCutsceneRunning()) {
                CutsceneHandler.setCutsceneRunning(true);
            }

            CutsceneHandler.getCutscene().update(client.player, camera, tickDelta);
        } else {
            CutsceneHandler.setCutsceneRunning(false);
        }
    }
}
