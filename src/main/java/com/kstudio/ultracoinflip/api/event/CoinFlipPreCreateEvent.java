package com.kstudio.ultracoinflip.api.event;

import com.kstudio.ultracoinflip.api.game.GameSide;
import java.util.UUID;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class CoinFlipPreCreateEvent extends Event implements Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();

    private final UUID host;
    private final double betAmount;
    private final String currencyId;
    private final GameSide side;
    private boolean cancelled;

    public CoinFlipPreCreateEvent(UUID host, double betAmount, String currencyId, GameSide side) {
        this.host = host;
        this.betAmount = betAmount;
        this.currencyId = currencyId;
        this.side = side;
    }

    public UUID getHost() {
        return host;
    }

    public double getBetAmount() {
        return betAmount;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public GameSide getSide() {
        return side;
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
