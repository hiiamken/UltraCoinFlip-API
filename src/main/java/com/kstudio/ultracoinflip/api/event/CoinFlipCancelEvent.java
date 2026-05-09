package com.kstudio.ultracoinflip.api.event;

import java.util.UUID;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class CoinFlipCancelEvent extends Event {

    private static final HandlerList HANDLERS = new HandlerList();

    private final UUID gameId;
    private final UUID cancelledBy;
    private final String reason;

    public CoinFlipCancelEvent(UUID gameId, UUID cancelledBy, String reason) {
        this.gameId = gameId;
        this.cancelledBy = cancelledBy;
        this.reason = reason;
    }

    public UUID getGameId() {
        return gameId;
    }

    public UUID getCancelledBy() {
        return cancelledBy;
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
