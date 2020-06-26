package com.cardGame;

/**
 * Representation of card holding enums of values and suit
 *
 * @author  Vivek S. Bharadwaj
 */
public class Card {

	/**
	 * Value representation as enum
	 */
	public enum Value {
		ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;

		public static Value getValues(int index) {
			Value[] values = Value.values();
			return values[index];
		}

		public static int getValueLength() {
			return Value.values().length;
		}
	}

	/**
	 * Suit representation as ENUM
	 */
	public enum Suit {
		DIAMOND, CLUB, HEART, SPADE,;

		public static Suit getSuits(int index) {
			Suit[] suits = Suit.values();
			return suits[index];
		}

		public static int getSuitLength() {
			return Suit.values().length;
		}
	}

	private Value value;
	private Suit suit;

	public Card(Suit suit, Value value) {
		this.suit = suit;
		this.value = value;

	}

	public Value getValue() {
		return value;
	}

	public Suit getSuit() {
		return suit;
	}

	@Override
	public String toString() {
		return this.suit + "_" + this.value;
	}

}
