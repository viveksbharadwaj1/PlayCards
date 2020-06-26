package com.cardGame;

import java.util.Scanner;

/**
 * A main class that provides varied operations that can be performed in single
 * card game amongst players
 *
 * @author Vivek S Bharadwaj
 */
public class DriverClass {

    public static void main(String args[]) {

        /**
         * Game Setup before user input
         */
        Game game = new Game();
        game.setUpGame();
        Scanner scanner = new Scanner(System.in);

        /**
         *  Menu option for the user input
         *  */
        int choice = 0;

        System.out.println("****************** WELCOME TO GAME OF CARDS ******************************");

        do {
            System.out.println("\n\n1:Add player(s) to the game.\n"
                    + "2:Remove player(s) to the game.\n"
                    + "3:Shuffle the deck.\n"
                    + "4:Print all the cards present in the deck.\n"
                    + "5:Start the game.\n"
                    + "6:Print the card each player is holding.\n"
                    + "7:Find the winner of the game.\n"
                    + "8:Finish the game\n"
                    + "9:Exit game\n");
            System.out.println("Enter you choice");

            choice = Integer.parseInt(scanner.next());
            switch (choice) {
                case 1:
                    System.out.println("Enter player Id");
                    Long playerId = scanner.nextLong();
                    game.addPlayer(playerId);
                    break;
                case 2:
                    System.out.println("Enter player Id to be removed");
                    Long playerIdRemove = scanner.nextLong();
                    game.removePlayer(playerIdRemove);
                    break;
                case 3:
                    game.shuffleCards();
                    System.out.println("Shuffling done");
                    break;
                case 4:
                    game.showDeck();
                    break;
                case 5:
                    game.startGame();
                    break;
                case 6:
                    game.showCard();
                    break;
                case 7:
                    game.findWinner();
                    break;
                case 8:
                    game.finishGame();
                    break;
                case 9:
                    System.out.println("Thank You Bye. Have fun ....");
                    break;
                default:
                    System.out.println("Invalid choice please select between 1-9");
                    break;
            }
        } while (choice != 9);

    }
}
