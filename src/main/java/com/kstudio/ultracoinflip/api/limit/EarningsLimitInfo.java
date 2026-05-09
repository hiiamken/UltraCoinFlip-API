package com.kstudio.ultracoinflip.api.limit;

import java.util.UUID;

public final class EarningsLimitInfo {

    private final UUID player;
    private final String currencyId;
    private final LimitType type;
    private final LimitPeriod period;
    private final boolean enabled;
    private final double cap;
    private final double used;
    private final long resetAtEpochMillis;

    public EarningsLimitInfo(UUID player, String currencyId, LimitType type,
                             LimitPeriod period, boolean enabled,
                             double cap, double used, long resetAtEpochMillis) {
        this.player = player;
        this.currencyId = currencyId;
        this.type = type;
        this.period = period;
        this.enabled = enabled;
        this.cap = cap;
        this.used = used;
        this.resetAtEpochMillis = resetAtEpochMillis;
    }

    public UUID getPlayer() {
        return player;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public LimitType getType() {
        return type;
    }

    public LimitPeriod getPeriod() {
        return period;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public double getCap() {
        return cap;
    }

    public double getUsed() {
        return used;
    }

    public double getRemaining() {
        double remaining = cap - used;
        return remaining < 0 ? 0 : remaining;
    }

    public double getUsedFraction() {
        if (cap <= 0) return 0d;
        double f = used / cap;
        if (f < 0) return 0d;
        if (f > 1) return 1d;
        return f;
    }

    public long getResetAtEpochMillis() {
        return resetAtEpochMillis;
    }
}
