package com.company;

public class Castle {
    int health;
    Armor armor;
    String urlImage;

    public Castle(int health, Armor armor, String urlImage) {
        this.health = health;
        this.armor = armor;
        this.urlImage = urlImage;
    }

    @Override
    public String toString() {
        return "Castle{" +
                "health=" + health +
                ", armor=" + armor +
                ", urlImage='" + urlImage + '\'' +
                '}';
    }
}
