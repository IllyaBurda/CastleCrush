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
    final Hero[]
    List<Hero> heroArchive = new ArrayList<>();
    List<Hero> currentDeck = new ArrayList<>();

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

    private boolean sendHeroToFight(Hero hero, Cell startHeroPoint) {
        if (validatePosition() == true) {
            hero.setPosion(startHeroPoint);
        }
    }

    public Player(String name, int countCups, int experience, Castle myCastle) {
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
