/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.james.fennell.javacollectionslabstarter;

/*
 * This is the main class for the CardGame.
 * It simulates a card game where players take turns drawing cards from a deck, 
 * and the game keeps track of player scores. The player with the highest score wins.
 */


// Import statements for Card and Deck classes
import com.james.fennell.javacollectionslabstarter.cards.Card;
import com.james.fennell.javacollectionslabstarter.cards.Deck;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

// Import Java utility classes such as Queue, Stack, Map, LinkedList, HashMap
import java.util.Queue;
import java.util.Stack;

public class CardGame {
    // A Deck object that represents the deck of cards used in the game
    private Deck deck;

    // A Queue to manage the players' turns in a First-In-First-Out (FIFO) order
    private Queue<Player> players;     
    
    // A Stack to store the discarded cards during the game
    // Since Stack follows Last-In-First-Out (LIFO) order, it is ideal for discarding the most recent card
    private Stack<Card> discardPile;  
    
    // A Map to track each player's score.
    // The key is the player's name (String) and the value is their current score (Integer).
    private Map<String, Integer> playerScores;  

    // Constructor for initializing the game components
    public CardGame() {
        // Initialize the deck with a new Deck object (cards will be shuffled in the Deck class)
        deck = new Deck();
        // Initialize the player queue using LinkedList which implements the Queue interface
        players = new LinkedList<>();
        // Initialize the discard pile using the Stack class
        discardPile = new Stack<>();
        // Initialize the playerScores using a HashMap to store player names and their scores
        playerScores = new HashMap<>();
    }

    // Method to add a player to the game
    // Players are added to both the player queue and the playerScores map (with an initial score of 0)
    public void addPlayer(Player player) {
        // Add the player to the queue for turn-based gameplay
        players.add(player);
        // Initialize the player's score in the playerScores map to 0
        playerScores.put(player.getName(), 0);
    }

    // Method to simulate playing the game for a certain number of rounds
    // Each player will take turns drawing a card and the game will update their score
 // Play the game for a specified number of rounds
public void playGame(int rounds) {

    // Loop through the specified number of rounds
    for(int i = 0; i < rounds; i++)
    {
        for(int j = 0; j < players.size(); j++)
        {

            Player currentPlayer = players.poll();
            Card drawnCard = deck.drawCard();
            if(drawnCard != null)
            {
                currentPlayer.addCard(drawnCard);
                System.out.println(currentPlayer.getName() + " drew " + drawnCard);
                int total = currentPlayer.getTotalCardValue();
                playerScores.put(currentPlayer.getName(), total);
                discardPile.push(drawnCard);
            }
            else {
                System.out.println("The deck is empty");
                break;
            }
            players.add(currentPlayer);
        }
    }
        // Get the number of players currently in the game

        // Loop through each player in the queue, allowing each to draw a card
        
            // Poll the current player from the queue (this removes them from the front)
            
            // Draw a card for the current player
            
            // If the deck has cards left, process the player's turn
            
                // Add the drawn card to the player's hand
                
                // Output the action of the player drawing a card
                
                // Update the player's score by calculating the total value of their hand

                // Store the updated score in the playerScores map

                // Push the drawn card onto the discard pile (optional step)

                // If the deck is empty, the game ends early

            

            // Place the current player back into the queue for the next round
        
    
}

    // Method to announce the winner based on the highest score at the end of the game
    public void announceWinner() {
        // Variables to track the player with the highest score
        int highestScore = 0;
        String highestPlayerName = "";
        // Hold the name of the winning player
        // Hold the highest score

        // Iterate over the playerScores map to find the player with the highest score
        for (Map.Entry<String, Integer> playerKV : playerScores.entrySet())
        {
            String currentPlayerName = playerKV.getKey();
            int currentScore = playerKV.getValue();
            System.out.println(currentPlayerName + " scored " + currentScore);

            if (currentScore > highestScore)
            {
                highestScore = currentScore;
                highestPlayerName = currentPlayerName;
            }
        }

        System.out.println("The winner is " + highestPlayerName + " and they scored " + highestScore);

            // Output the player's name and their final score

            // If the current player's score is higher than the highestScore, update the winner and highestScore

        // Output the winner of the game

    }
}
