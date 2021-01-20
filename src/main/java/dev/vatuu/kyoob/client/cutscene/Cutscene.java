package dev.vatuu.kyoob.client.cutscene;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.Camera;
import net.minecraft.entity.player.PlayerEntity;

public abstract class Cutscene {

    private MinecraftClient client;
    private float lastCameraYOriginal;
    private CutsceneCameraEntity cameraEntity;
    
    public Cutscene() {
        this.client = MinecraftClient.getInstance();
    }

    public void startCutscene() {
        if (CutsceneHandler.isCutsceneRunning())
            CutsceneHandler.getCutscene().stopCutscene();

        client.options.hudHidden = true;
        CutsceneHandler.setCutscene(this);

        lastCameraYOriginal = client.gameRenderer.getCamera().lastCameraY;

        PlayerEntity playerEntity = client.player;
        cameraEntity = new CutsceneCameraEntity(client.world, playerEntity.getX(), playerEntity.getY() + playerEntity.getEyeHeight(playerEntity.getPose()), playerEntity.getZ(), 0, 0);
        
        client.setCameraEntity(cameraEntity);
    }

    public void stopCutscene() {
        client.options.hudHidden = false;
        CutsceneHandler.setCutscene(null);

        client.setCameraEntity(client.player);
        client.gameRenderer.getCamera().lastCameraY = lastCameraYOriginal;
    }

    public CutsceneCameraEntity getCameraEntity() {
        return cameraEntity;
    }

    public abstract void update(PlayerEntity playerEntity, Camera camera, float tickDelta);

}
