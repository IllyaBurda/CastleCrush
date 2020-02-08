package com.company;

import java.util.ArrayList;
import java.util.List;

public class Hero {
    String urlImage;
    String name;
    int health;
    Armor armor;
    int speed;
    int sizeHero;

    List<Cell> currentPosition = new ArrayList<>();
    int radiusOfVisibility;
    List<Hero> goalEnemyHeroes = new ArrayList<>();
    final static Hero[] START_HEROES_IN_DECK = new Hero[8];

    public void moveTo(Cell cell) {

    }

    public void fight(Hero hero) {

    }

    public Hero choiceEnemy(Game game, Player player) {
        Hero result = null;
        List<Hero> listEnemy = player.returnListEnemy(game);
        for (Hero hero : listEnemy) {
            if (hero.currentPosition.get(0).x == this.currentPosition.get(0).x) {
                result = hero;
            }
        }
        return result;
    }

    public Hero(String urlImage, String name, int health, Armor armor, int speed, int sizeHero, int radiusOfVisibility) {
        this.urlImage = urlImage;
        this.name = name;
        this.health = health;
        this.armor = armor;
        this.speed = speed;
        this.sizeHero = sizeHero;
        this.radiusOfVisibility = radiusOfVisibility;
    }

    public Hero(String name) {
        this.name = name;
    }

    public Hero(Hero hero) {
        this.urlImage = hero.urlImage;
        this.name = hero.name;
        this.health = hero.health;
        this.armor = new Armor(hero.armor);
        this.speed = hero.speed;
        this.radiusOfVisibility = hero.radiusOfVisibility;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", armor=" + armor +
                ", currentPosition=" + currentPosition +
                ", radiusOfVisibility=" + radiusOfVisibility +
                ", goalEnemyHeroes=" + goalEnemyHeroes +
                '}';
    }

    public void setPosion(int x, int y, Game currentGame) {
        for (Cell cell : currentGame.battlefield) {
            boolean startPosition = cell.y == y && cell.x == x;
            if (startPosition) {
                currentPosition.add(cell);
            }
            if (y == currentGame.HEIGHT_BY_Y / 2) {
                if ((cell.y == y - 1 && cell.x == x)) {
                    currentPosition.add(cell);
                }
            } else {
                if ((cell.y == y + 1 && cell.x == x)) {
                    currentPosition.add(cell);
                }
            }
        }

    }
}
