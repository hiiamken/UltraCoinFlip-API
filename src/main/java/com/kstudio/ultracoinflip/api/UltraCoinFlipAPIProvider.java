package com.kstudio.ultracoinflip.api;

public final class UltraCoinFlipAPIProvider {

    static volatile UltraCoinFlipAPI INSTANCE;

    private UltraCoinFlipAPIProvider() {}

    public static void register(UltraCoinFlipAPI api) {
        INSTANCE = api;
    }

    public static void unregister() {
        INSTANCE = null;
    }
}
