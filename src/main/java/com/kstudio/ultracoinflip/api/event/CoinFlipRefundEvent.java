package com.kstudio.ultracoinflip.api.event;

import java.util.UUID;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class CoinFlipRefundEvent extends Event {

    private static final HandlerList HANDLERS = new HandlerList();

    private final UUID gameId;
    private final UUID refundedTo;
    private final String currencyId;
    private final double amount;
    private final String reason;

    public CoinFlipRefundEvent(UUID gameId, UUID refundedTo, String currencyId,
                               double amount, String reason) {
        this.gameId = gameId;
        this.refundedTo = refundedTo;
        this.currencyId = currencyId;
        this.amount = amount;
        this.reason = reason;
    }

    public UUID getGameId() {
        return gameId;
    }

    public UUID getRefundedTo() {
        return refundedTo;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public double getAmount() {
        return amount;
    }

    public String getReason() {
        return reason;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}
