package battleshipgame;

import java.util.ArrayList;

public class Battleship {
    private String shipName;
    private ArrayList<String> locationCells;

    public Battleship(String name, int size) {
        shipName = name;
        locationCells = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            locationCells.add(""); // Initialize the locations
        }
    }

    public void setLocationCells(ArrayList<String> locations) {
        locationCells = locations;
    }

    public String checkGuess(String guess) {
        int index = locationCells.indexOf(guess);

        if (index >= 0) {
            locationCells.set(index, "hit");
            if (locationCells.stream().allMatch(cell -> cell.equals("hit"))) {
                return "Sunk";
            }
            return "Hit";
        }

        return "Miss";
    }
}
