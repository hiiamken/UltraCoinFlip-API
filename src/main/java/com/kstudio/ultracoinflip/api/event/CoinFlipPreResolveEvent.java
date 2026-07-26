package com.kstudio.ultracoinflip.api.event;

import java.util.UUID;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

// Observational, not cancellable: the winner is already drawn when this fires, and both stakes are
// held by the plugin, so a veto would either strand the pot or let a listener rig the outcome.
public class CoinFlipPreResolveEvent extends Event {

    private static final HandlerList HANDLERS = new HandlerList();

    private final UUID gameId;
    private final UUID predictedWinner;
    private final UUID predictedLoser;

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
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}
