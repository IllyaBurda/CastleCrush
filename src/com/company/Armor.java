package com.company;

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
