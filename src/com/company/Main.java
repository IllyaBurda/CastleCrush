package com.company;

public class Main {

    public static void main(String[] args) {

    Armor armor = new Armor("Bow", 2, 10, TypeArmor.single, TypeFrequency.low);
    Player player = new Player("John", 0, 0, new Castle(1000, armor, null));
    Game game = new Game(player);

}
}
