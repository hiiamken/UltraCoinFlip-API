package com.kstudio.ultracoinflip.api.event;

import com.kstudio.ultracoinflip.api.game.GameSide;
import java.util.UUID;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class CoinFlipFinishEvent extends Event {

    private static final HandlerList HANDLERS = new HandlerList();

    private final UUID gameId;
    private final UUID winner;
    private final UUID loser;
    private final String currencyId;
    private final double payout;
    private final double tax;
    private final double betAmount;
    private final GameSide winningSide;
    private final boolean houseGame;

    public CoinFlipFinishEvent(UUID gameId, UUID winner, UUID loser,
                               String currencyId, double payout, double tax) {
        this(gameId, winner, loser, currencyId, payout, tax, 0d, GameSide.UNSPECIFIED, false);
    }

    public CoinFlipFinishEvent(UUID gameId, UUID winner, UUID loser,
                               String currencyId, double payout, double tax,
                               double betAmount, GameSide winningSide, boolean houseGame) {
        this.gameId = gameId;
        this.winner = winner;
        this.loser = loser;
        this.currencyId = currencyId;
        this.payout = payout;
        this.tax = tax;
        this.betAmount = betAmount;
        this.winningSide = winningSide == null ? GameSide.UNSPECIFIED : winningSide;
        this.houseGame = houseGame;
    }

    public UUID getGameId() {
        return gameId;
    }

    public UUID getWinner() {
        return winner;
    }

    public UUID getLoser() {
        return loser;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public double getPayout() {
        return payout;
    }

    public double getTax() {
        return tax;
    }

    public double getBetAmount() {
        return betAmount;
    }

    public GameSide getWinningSide() {
        return winningSide;
    }

    public boolean isHouseGame() {
        return houseGame;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}
