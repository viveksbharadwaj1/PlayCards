package com.cardGame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * This class consisting players and deck which provides the functionality related to game
 *
 * @author Vivek S. Bharadwaj
 */
public class Game {

    /**
     * This Map consists of PlayerId as Key and Card as value.Each Player is
     * associated with one of the card
     */
    private Map<Long, Card> playerCard = new HashMap();

    /**
     * {@link Deck} of object
     */
    private Deck deck = new Deck();

    /**
     * Holds the status of the game
     */
    private boolean isStartGame = false;

    /**
     * List consists of Player Details.It is used to add or remove Player from the
     * list entry
     */
    private ArrayList<Player> players = new ArrayList();

    /**
     * This method is to initially get a deck of cards.
     */
    public void setUpGame() {
        this.deck = new Deck();
        deck.fillDeck();
        shuffleCards();
    }

    /**
     * This method Adds player to the Player list considering conditions like duplicate value,invalid Id format
     *
     * @param playerId player_id to be added
     */
    public void addPlayer(final Long playerId) {
        if (!isStartGame) {
            if (playerId >= 0) {
                for (Player duplicate : players) {
                    if (playerId.equals(duplicate.getPlayerId())) {
                        System.out.println("Player Id already exsits enter different player Id");
                        return;
                    }
                }
                Player player = new Player(playerId);
                players.add(player);
                System.out.println("Player Added");

            } else {
                System.out.println("Invalid player id ");
            }
        } else {
            System.out.println("Game is already can not add the player");
        }
    }

    /**
     * Removes the specified element from the List of Players on checking if Player
     * exists on the list
     */
    public void removePlayer(final Long playerId) {
        for (Player pl : players) {
            if (pl.getPlayerId().equals(playerId)) {
                players.remove(pl);
                System.out.println("Player Removed");
                return;
            }
        }
        System.out.println("The provided playerId doesn't exist");
    }

    /**
     * Method to shuffle the deck of Cards
     */

    public void shuffleCards() {
        if (!isStartGame) {
            deck.shuffle();
        } else
            System.out.println("Game is already started cards can not be shuffled");
    }

    /**
     * Prints the Deck and size of deck
     */

    public void showDeck() {
        System.out.println(deck.toString());
        System.out.println("Deck Size " + deck.getCards().size());
    }

    /**
     * Method to distribute each player with a card
     */

    public void drawCard() {
        if (!isStartGame) {
            players.forEach(player -> {
                playerCard.put(player.getPlayerId(), deck.getCards().remove(deck.getCards().size() - 1));
            });
        } else {
            System.out.println("Game is already started cards can not be drawn");
        }
    }

    /**
     * Method to check conditions of Player count and start the game
     **/

    public void startGame() {
        if (players.size() == 0) {
            System.out.println("No player added.Cannot start game.Add player to start game");
        } else if (players.size() == 1) {
            System.out.println("Game cannot start with one player add one more player");
        } else {
            drawCard();
            System.out.println("Game started!!");
            isStartGame = true;

        }
    }

    /**
     * Prints details of each player associated with card
     */
    public void showCard() {
        System.out.println(playerCard.toString());

    }

    /**
     * This method finds out and prints the winner with card name
     **/
    public void findWinner() {
        if (isStartGame) {
            Map.Entry<Long, Card> tempFirstEntry = playerCard.entrySet().iterator().next();
            Map.Entry<Long, Card> highestEntry = playerCard.entrySet().iterator().next();
            playerCard.remove(highestEntry.getKey());

            Map<Long, Card> resultMap = new HashMap<>();
            for (Map.Entry<Long, Card> entry : playerCard.entrySet()) {
                if (entry.getValue().getValue().ordinal() >= highestEntry.getValue().getValue().ordinal()) {
                    highestEntry = entry;
                    resultMap.put(highestEntry.getKey(), highestEntry.getValue());
                }
            }
            playerCard.put(tempFirstEntry.getKey(), tempFirstEntry.getValue());

            if (resultMap.size() == 0 || resultMap.size() == 1) {
                System.out.println("Winner player_id = " + highestEntry.getKey() + " with card  " + highestEntry.getValue());
            } else {
                Map.Entry<Long, Card> resultEntry = resultMap.entrySet().iterator().next();
                for (Map.Entry<Long, Card> entry : resultMap.entrySet()) {
                    if (entry.getValue().getSuit().ordinal() > resultEntry.getValue().getSuit().ordinal()) {
                        resultEntry = entry;
                    }
                }
                System.out.println("Winner player_id = " + resultEntry.getKey() + "With Card = " + resultEntry.getValue());
            }
        } else
            System.out.println("Game is not started winner can not be decided");

    }

    /**
     * To set the game back to initial state. Call deck object and add all returning
     * cards.Nullify the playerCard Map and initializes the map.
     */
    public void finishGame() {
        playerCard.forEach((playerId, card) -> {
            deck.addCard(card);
        });
        playerCard = null;
        playerCard = new HashMap();
        isStartGame = false;

    }
}
