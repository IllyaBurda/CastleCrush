package com.company;

import java.util.ArrayList;
import java.util.List;

public class Hero {
    String urlImage;
    String name;
    int health;
    Armor armor;
    int speed;
    int cellCount = 1;
    List<Cell> currentPosition = new ArrayList<>();
    int radiusOfVisibility;
    List<Hero> goalEnemyHeroes = new ArrayList<>();
    final static Hero[] START_HEROES_IN_DECK = new Hero[8];

    public void moveTo(Cell cell) {

    }

    public void fight(Hero hero) {

    }

    public Hero(String urlImage, String name, int health, Armor armor, int speed, int radiusOfVisibility) {
        this.urlImage = urlImage;
        this.name = name;
        this.health = health;
        this.armor = armor;
        this.speed = speed;
        this.radiusOfVisibility = radiusOfVisibility;
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
}
