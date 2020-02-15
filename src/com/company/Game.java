package com.company;

import java.util.ArrayList;
import java.util.List;

public class Game {
    Player playerOne;
    Player playerTwo;
    List<Cell> battlefield = new ArrayList<>();
    final int HEIGHT_BY_Y = 61;
    final int WIDTH_BY_X = 30;
    StateGame stateGame = StateGame.EditState;

    public Game(Player playerOne) {
        for (int x = 0; x < 30; x++) {
            for (int y = 0; y < 61; y++) {
                Cell cell = new Cell(x, y);
                setCastlesAndDitch(cell);
            }
        }

        this.playerOne = playerOne;
        this.playerTwo = searchEnemyInGame(playerOne);
        this.playerOne.currentDeck.get(0).setPositon(2, 2, this);
        playerTwo.currentDeck.get(0).setPositon(2, 2, this);
        this.playerOne.currentDeck.get(0).fight(playerTwo.currentDeck.get(0));
    }

    private Player searchEnemyInGame(Player playerOne) {
        Armor armor2 = new Armor("Sword", 3, 20, TypeArmor.splash, TypeFrequency.low);
        return new Player("John", 0, 0, new Castle(1000, armor2, ""));
    }

    public Player getLinkOnEnemy(Player player) {
        Player result = null;
        if (player == playerOne) {
            result = playerTwo;
        } else {
            result = playerOne;
        }
        return result;
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
