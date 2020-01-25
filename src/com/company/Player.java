package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Player {
    String name;
    int countCups;
    int experience;
    Castle myCastle;
    List<Hero> heroArchive = new ArrayList<>();
    List<Hero> currentDeck = new ArrayList<>();

    public boolean changeHeroInArchiveAndInCurrentDeck(String heroName, int heroDeckPosition) {
        boolean result = false;
        Hero hero = searchHeroInArchive(heroName);
        if (hero != null) {
            heroArchive.add(currentDeck.get(heroDeckPosition));
            currentDeck.remove(heroDeckPosition);
            currentDeck.set(heroDeckPosition, hero);
            deleteHeroInArchive(hero);
            result = true;
        }
        return result;
    }

    public boolean deleteHeroInArchive(Hero hero) {
        return heroArchive.removeIf((w) -> w.name.equals(hero.name));
    }

    public Hero searchHeroInArchive(String name) {
        Hero resultHero = null;
        for (Hero hero : heroArchive) {
            if (hero.name.equals(name)) {
                resultHero = hero;
            }
        }
        return resultHero;
    }

    public boolean addHeroToDeck(String heroName) {
        boolean result = false;
        if (currentDeck.size() < 8) {
            Hero choicedHero = searchHeroInArchive(heroName);
            if (choicedHero != null) {
                deleteHeroInArchive(choicedHero);
                currentDeck.add(choicedHero);
                result = true;
            }
        }
        return result;
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
