package com.kstudio.ultracoinflip.api.event;

import java.util.UUID;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class CoinFlipJoinEvent extends Event {

    private static final HandlerList HANDLERS = new HandlerList();

    private final UUID gameId;
    private final UUID joiner;

    public CoinFlipJoinEvent(UUID gameId, UUID joiner) {
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
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}
