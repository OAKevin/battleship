package battleshipgame;

import java.util.ArrayList;

public class BattleshipGame {
    private ArrayList<Battleship> battleships = new ArrayList<>();
    private GameHelper helper = new GameHelper();

    public void playGame() {
        System.out.println("Welcome to Battleship! Try to sink all the battleships.");

        createShips();

        while (!battleships.isEmpty()) {
            String userGuess = helper.getUserInput("Enter your guess:");
            checkGuesses(userGuess);
        }

        System.out.println("Congratulations! You've sunk all the battleships.");
    }

    private void createShips() {
        Battleship ship1 = new Battleship("Destroyer", 3);
        Battleship ship2 = new Battleship("Cruiser", 3);
        Battleship ship3 = new Battleship("Battleship", 4);

        battleships.add(ship1);
        battleships.add(ship2);
        battleships.add(ship3);

        System.out.println("Here's the game grid:");
        helper.printGrid();
    }

    private void checkGuesses(String userGuess) {
        for (Battleship battleship : battleships) {
            String result = battleship.checkGuess(userGuess);
            System.out.println(result);
            if (result.equals("Sunk")) {
                battleships.remove(battleship);
                break;
            }
        }
    }
}
