package dev.vatuu.kyoob.client.cutscene;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Packet;
import net.minecraft.world.World;

public class CutsceneCameraEntity extends Entity {

    private static final EntityType<CutsceneCameraEntity> TYPE = FabricEntityTypeBuilder.<CutsceneCameraEntity>create().build();

    public CutsceneCameraEntity(World world) {
        super(TYPE, world);
    }

    public CutsceneCameraEntity(World world, double x, double y, double z, float pitch, float yaw) {
        this(world);
        setPos(x, y, z);
        prevX = x;
        prevY = y;
        prevZ = z;
        setRotation(pitch, yaw);
        prevPitch = pitch;
        prevYaw = yaw;
    }

    @Override
    protected void initDataTracker() {

    }

    @Override
    protected void readCustomDataFromTag(CompoundTag tag) {

    }

    @Override
    protected void writeCustomDataToTag(CompoundTag tag) {

    }

    @Override
    public Packet<?> createSpawnPacket() {
        return null;
    }

}
