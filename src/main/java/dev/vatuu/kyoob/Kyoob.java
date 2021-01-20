package dev.vatuu.kyoob;

import dev.vatuu.kyoob.events.KyoobEvents;
import net.fabricmc.api.ModInitializer;

public class Kyoob implements ModInitializer {
    @Override
    public void onInitialize() {
        KyoobEvents.init();
    }
}
