package com.cardGame;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Representation of Deck in the game
 *
 * @author Vivek S. Bharadwaj
 */
class Deck {

    ArrayList<Card> cards = new ArrayList<Card>();

    @Override
    public String toString() {
        return "Deck [cards=" + cards + "]";
    }

    /**
     * Deck is filled with list of cards of type Enum
     */
    public void fillDeck() {

        /* Iterate through each suit and get card details for each value */
        for (int i = 0; i < Card.Suit.getSuitLength(); i++) {
            for (int j = 0; j < Card.Value.getValueLength(); j++) {
                Card card = new Card(Card.Suit.getSuits(i), Card.Value.getValues(j));
                cards.add(card);
            }
        }
    }

    /**
     * This method adds the card
     *
     * @param card card to be added
     */
    public void addCard(Card card) {
        if (cards.size() < 52) {
            cards.add(card);
        } else {
            System.out.println("Maximum limit of Deck reached");
        }
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    /**
     * This method shuffles the card
     */
    public void shuffle() {
        Collections.shuffle(cards);

    }
}
