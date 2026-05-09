package com.kstudio.ultracoinflip.api.event;

import com.kstudio.ultracoinflip.api.game.GameSide;
import java.util.UUID;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class CoinFlipCreateEvent extends Event {

    private static final HandlerList HANDLERS = new HandlerList();

    private final UUID gameId;
    private final UUID host;
    private final double betAmount;
    private final String currencyId;
    private final GameSide side;

    public CoinFlipCreateEvent(UUID gameId, UUID host, double betAmount,
                               String currencyId, GameSide side) {
        this.gameId = gameId;
        this.host = host;
        this.betAmount = betAmount;
        this.currencyId = currencyId;
        this.side = side;
    }

    public UUID getGameId() {
        return gameId;
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
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}
