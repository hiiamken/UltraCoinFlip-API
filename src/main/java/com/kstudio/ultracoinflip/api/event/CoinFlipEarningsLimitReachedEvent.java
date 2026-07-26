package com.kstudio.ultracoinflip.api.event;

import com.kstudio.ultracoinflip.api.limit.EarningsLimitInfo;
import com.kstudio.ultracoinflip.api.limit.LimitPeriod;
import com.kstudio.ultracoinflip.api.limit.LimitType;
import java.util.UUID;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class CoinFlipEarningsLimitReachedEvent extends Event {

    private static final HandlerList HANDLERS = new HandlerList();

    private final UUID player;
    private final String currencyId;
    private final LimitType type;
    private final LimitPeriod period;
    private final double cap;
    private final double used;
    private final long resetAtEpochMillis;

    public CoinFlipEarningsLimitReachedEvent(UUID player, String currencyId,
                                             LimitType type, LimitPeriod period,
                                             double cap, double used) {
        this(player, currencyId, type, period, cap, used, 0L);
    }

    public CoinFlipEarningsLimitReachedEvent(UUID player, String currencyId,
                                             LimitType type, LimitPeriod period,
                                             double cap, double used,
                                             long resetAtEpochMillis) {
        this.player = player;
        this.currencyId = currencyId;
        this.type = type;
        this.period = period;
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

    public double getCap() {
        return cap;
    }

    public double getUsed() {
        return used;
    }

    public long getResetAtEpochMillis() {
        return resetAtEpochMillis;
    }

    public EarningsLimitInfo getInfo() {
        return new EarningsLimitInfo(player, currencyId, type, period, true, cap, used, resetAtEpochMillis);
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}
