package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Player {
    String name;
    int countCups;
    int experience;
    Castle myCastle;
    final static List<Hero> startDeck = new ArrayList();
    List<Hero> heroArchive = new ArrayList<>();
    List<Hero> currentDeck = new ArrayList<>();

    static {
        startDeck.add(new Hero("Bug"));
        startDeck.add(new Hero("Bug1"));
        startDeck.add(new Hero("Bug2"));
        startDeck.add(new Hero("Bug3"));
        startDeck.add(new Hero("Bug4"));
        startDeck.add(new Hero("Bug5"));
        startDeck.add(new Hero("Bug6"));
        startDeck.add(new Hero("Bug7"));

    }

    private boolean changeHeroInArchiveAndInCurrentDeck(String heroName, int heroDeckPosition) {
        boolean result = false;
        Hero hero = searchHeroInArchive(heroName);
        if (hero != null) {
            heroArchive.add(currentDeck.get(heroDeckPosition));
            currentDeck.remove(heroDeckPosition);
            currentDeck.set(heroDeckPosition, hero);
            deleteHeroInArchive(heroName);
            result = true;
        }
        return result;
    }

    private boolean deleteHeroInArchive(String heroName) {
        return heroArchive.remove(searchHeroInArchive(heroName));
    }

    public List<Hero> returnListEnemy(Game game) {
        List<Hero> result = new ArrayList<>();
        Player enemy = game.getLinkOnEnemy(this);
        for (Hero hero : enemy.currentDeck) {
            if (hero.currentPosition.size() > 0) {
                result.add(hero);
            }
        }
        return result;
    }

    private Hero searchHeroInArchive(String name) {
        Hero resultHero = null;
        for (Hero hero : heroArchive) {
            if (hero.name.equals(name)) {
                resultHero = hero;
            }
        }
        return resultHero;
    }

    private boolean initializeDeck(Hero[] startDeck) {
        boolean result = false;
        if (startDeck.length == 8) {
            for (int i = 0; i < startDeck.length; i++) {
                currentDeck.add(new Hero(startDeck[i]));
            }
            result = true;
        }
        return result;
    }

    private boolean putHeroOnField(Hero hero, int x, int y, Game currentGame) {
        boolean result = false;
        if (validatePosition() == true) {
            hero.setPosion(x, y, currentGame);
            result = true;
        }
        return result;
    }

    private boolean validatePosition() {

        return true;
    }

    public Player(String name, int countCups, int experience, Castle myCastle) {
        if (countCups == 0 && experience == 0) {
            for (Hero hero : startDeck) {
                currentDeck.add(new Hero(hero));
            }
        }
        this.name = name;
        this.countCups = countCups;
        this.experience = experience;
        this.myCastle = myCastle;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", countCups=" + countCups +
                ", experience=" + experience +
                ", allCards=" + heroArchive +
                ", currentDeck=" + currentDeck +
                '}';
    }
}
