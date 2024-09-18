/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.james.fennell.javacollectionslabstarter.cards;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author James.Fennell
 * The Deck class represents a deck of cards used in the game.
 * It contains a list of Card objects, and the deck is initialized with all combinations of card values and suits.
 * The deck can be shuffled, and players can draw cards from it during the game.
 * The deck will contain 40 cards (since CardValue ranges from 1 to 10, and there are 4 suits).
 */

public class Deck {
    // List to store all the Card objects that make up the deck.

    List<Card> deck = new ArrayList<>();
    // Constructor for the Deck class that initializes the deck with 40 cards and shuffles them.
    public Deck()
    {
        // Initialize a new ArrayList that will hold Card objects.
        CardSuit[] allSuits = CardSuit.values();
        CardValue[] allValues = CardValue.values();
        // Nested loops to create every combination of CardSuit and CardValue.
        for(CardSuit suit : allSuits)
        {

            // The inner loop iterates over each possible CardValue (1 to 10).
                for(CardValue value : allValues)
                {
                    Card currentCard = new Card(value, suit);
                    deck.add(currentCard);
                    // Create a new Card object with the current value and suit, then add it to the deck.
                }

        }

        // After adding all the cards (40 in total), shuffle the deck to randomize the order.
        Collections.shuffle(deck);
        // Collections.shuffle() is a useful utility method here.
        // https://download.java.net/java/early_access/jdk23/docs/api/java.base/java/util/Collections.html#shuffle(java.util.List)

    }

    // Method to draw (remove and return) a card from the deck.
    // It removes the top card from the deck (last card in the list) and returns it to the caller.
    public Card drawCard() {
        // Check if the deck is empty before attempting to draw a card.
        if (deck.isEmpty())
            return null;
        else
            return deck.remove(deck.size()-1);
        // If the deck is empty, return null to indicate that no more cards are available.

        // Deck is empty, no more cards to draw


        // Remove and return the last card in the list (simulating drawing from the top of the deck).
        // The remove() method both removes the card from the deck and returns it.

    }
}