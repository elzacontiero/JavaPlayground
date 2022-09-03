package com.contieroellza.game;

import java.util.Random;
import java.util.Scanner;

// The 2 methods below have the responsibility of collecting names from users and printing them out.
class PlayerDetails {
    Scanner scan = new Scanner(System.in);
    String[] playersNames = new String[4]; //array is the best option to save the names of players.

    public void collectNamesFromUser() {
        System.out.println("Enter the names of the 4 players: ");
        // Loop over the position(index) of the playersNames array.
        for (int i = 0; i < playersNames.length; i++) {
            System.out.print("Player: " + (i + 1) + ": ");
            playersNames[i] = scan.nextLine();
        }
    }

    public void printNames() {
        System.out.println("The names of the players are: ");
        for (int i = 0; i < playersNames.length; i++) {
            System.out.println(playersNames[i]);
        }
    }
}

// Class Game inherits from PlayerDetails. It has all the methods and properties from PlayerDetails,
// as well as its own method,playTheGame().
class Game extends PlayerDetails {

    public void playTheGame()
    {
        // successes holds the number of correct guesses.
        int successes = 0;
        // an instance of a random generator.
        Random random = new Random();
        // 3 attempts
        for(int i=1;i<4; i++) {
            // nextInt produces a random number from 0 to length of the array and save on selected variable.
            int selected = random.nextInt(playersNames.length);
            // get the name of the person given the random index selected.
            String person = playersNames[selected];
            // prints out attempt i
            System.out.println("Attempt "+i);
            System.out.println("Knock knock. Who's there?");
            // the line below collects from user and saves it in variable guess.
            String guess = scan.nextLine();
            // if the person selected is the same as guess, then the player gets a point.
            if (person.equalsIgnoreCase(guess)) {
                successes++;
                System.out.println("Well done! You've guessed correctly!");
            } else {
                System.out.println("Sorry, wrong person. It was " + person);
            }
        }
        System.out.println("Your score is " + successes + " out of 3 attempts.");
    }
}

public class GuessTheNameGame {
    public static void main(String[] args) {
        // print out a welcome message.
        System.out.println("Welcome to 'Guess the Name!'");
        // create an instance of Game.
        Game game = new Game();
        // Below are methods that are going to be executed one after the other.
        game.collectNamesFromUser();
        game.printNames();
        game.playTheGame();
    }
}
