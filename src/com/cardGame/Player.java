package com.cardGame;

/**
 * Player class object consists of playerId as a primary function which is a unique constraint
 *
 * @author Vivek S. Bharadwaj
 */
class Player {

    /**
     * Holds the player_id of the player
     */
    private Long playerId;

    public Long getPlayerId() {
        return playerId;
    }

    public Player(Long playerId) {
        this.playerId = playerId;
    }

    @Override
    public String toString() {
        return "Player [playerId=" + playerId + "]";
    }

}
