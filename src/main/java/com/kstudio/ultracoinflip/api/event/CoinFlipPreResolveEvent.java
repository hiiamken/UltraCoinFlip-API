package com.kstudio.ultracoinflip.api.event;

import java.util.UUID;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class CoinFlipPreResolveEvent extends Event implements Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();

    private final UUID gameId;
    private final UUID predictedWinner;
    private final UUID predictedLoser;
    private boolean cancelled;

    public CoinFlipPreResolveEvent(UUID gameId, UUID predictedWinner, UUID predictedLoser) {
        this.gameId = gameId;
        this.predictedWinner = predictedWinner;
        this.predictedLoser = predictedLoser;
    }

    public UUID getGameId() {
        return gameId;
    }

    public UUID getPredictedWinner() {
        return predictedWinner;
    }

    public UUID getPredictedLoser() {
        return predictedLoser;
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
