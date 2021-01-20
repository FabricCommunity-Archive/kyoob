package dev.vatuu.kyoob.client.cutscene;

public class CutsceneHandler {

    private static boolean cutsceneRunning;
    private static Cutscene cutscene;

    public static boolean isCutsceneRunning() {
        return cutsceneRunning;
    }

    public static void setCutsceneRunning(boolean cutsceneRunning) {
        CutsceneHandler.cutsceneRunning = cutsceneRunning;
    }

    public static void setCutscene(Cutscene cutscene) {
        CutsceneHandler.cutscene = cutscene;
    }

    public static Cutscene getCutscene() {
        return cutscene;
    }

}
