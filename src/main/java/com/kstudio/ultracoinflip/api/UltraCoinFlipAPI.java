package com.kstudio.ultracoinflip.api;

import com.kstudio.ultracoinflip.api.limit.EarningsLimitInfo;
import com.kstudio.ultracoinflip.api.limit.LimitType;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public interface UltraCoinFlipAPI {

    static UltraCoinFlipAPI get() {
        UltraCoinFlipAPI api = UltraCoinFlipAPIProvider.INSTANCE;
        if (api == null) {
            throw new IllegalStateException(
                "UltraCoinFlipAPI has not been registered yet. "
                + "Declare 'depend: [UltraCoinFlip]' in your plugin.yml.");
        }
        return api;
    }

    String getApiVersion();

    String getPluginVersion();

    int getActiveGameCount();

    Collection<String> getEnabledCurrencyIds();

    Optional<EarningsLimitInfo> getEarningsLimit(UUID player, String currencyId, LimitType type);
}
