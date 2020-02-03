package com.company;

import java.util.ArrayList;

public class Armor {
    String name;
    int damageRadius;
    int damageForce;
    TypeArmor typeArmor;
    TypeFrequency typeFrequencyOfAttack;

    public Armor(String name, int damageRadius, int damageForce, TypeArmor typeArmor, TypeFrequency typeFrequencyOfAttack) {
        this.name = name;
        this.damageRadius = damageRadius;
        this.damageForce = damageForce;
        this.typeArmor = typeArmor;
        this.typeFrequencyOfAttack = typeFrequencyOfAttack;
    }

    public Armor(Armor armor) {
        this.name = armor.name;
        this.damageRadius = armor.damageRadius;
        this.damageForce = armor.damageForce;
        this.typeArmor = armor.typeArmor;
        this.typeFrequencyOfAttack = armor.typeFrequencyOfAttack;
    }

    @Override
    public String toString() {
        return "Armor{" +
                "name='" + name + '\'' +
                ", damageRadius=" + damageRadius +
                ", damageForce=" + damageForce +
                ", typeArmor=" + typeArmor +
                ", typeFrequencyOfAttack=" + typeFrequencyOfAttack +
                '}';
    }
}

enum TypeArmor {
    single, splash
}

enum TypeFrequency {
    low, middle, high
}
