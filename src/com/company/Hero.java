package com.company;

import java.util.ArrayList;
import java.util.List;

public class Hero {
    String urlImage;
    String name;
    int health;
    Armor armor;
    int speed;
    List<Cell> currentPosition = new ArrayList<>();
    int radiusOfVisibility;
    List<Hero> goalEnemyHeroes = new ArrayList<>();

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
