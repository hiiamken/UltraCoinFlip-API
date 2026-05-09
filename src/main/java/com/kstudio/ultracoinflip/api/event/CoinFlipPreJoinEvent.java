package com.kstudio.ultracoinflip.api.event;

import java.util.UUID;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class CoinFlipPreJoinEvent extends Event implements Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();

    private final UUID gameId;
    private final UUID joiner;
    private boolean cancelled;

    public CoinFlipPreJoinEvent(UUID gameId, UUID joiner) {
        this.gameId = gameId;
        this.joiner = joiner;
    }

    public UUID getGameId() {
        return gameId;
    }

    public UUID getJoiner() {
        return joiner;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}
