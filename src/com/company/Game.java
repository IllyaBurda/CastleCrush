package com.company;

import java.util.ArrayList;
import java.util.List;

public class Game {
    Player playerOne;
    Player playerTwo;
    List<Cell> battlefield = new ArrayList<>();
    final int HEIGHT_BY_Y = 61;
    final int WIDTH_BY_X = 30;

    public Game(Player playerOne, Player playerTwo) {
        for (int x = 0; x < 30; x++) {
            for (int y = 0; y < 61; y++) {
                Cell cell = new Cell(x, y);
                setCastlesAndDitch(cell);
            }
        }

        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public void setCastlesAndDitch(Cell cell) {
        if (cell.y <= 10 || cell.y >= 51 || cell.y == 31) {
            cell.isBusy = true;
        }
    }

    @Override
    public String toString() {
        return "Game{" +
                "playerOne=" + playerOne +
                ", playerTwo=" + playerTwo +
                ", battlefield=" + battlefield +
                ", HEIGHT=" + HEIGHT_BY_Y +
                ", WIDTH=" + WIDTH_BY_X +
                '}';
    }
}
