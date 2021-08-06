package com.company;

import java.util.Random;

public class Monster {
    Random rand = new Random();
    String[] names = {"Giant", "Werewolf", "Ghost", "Zombie", "Orc", "Warlock", "Demon", "Cyclops"};
    String name;
    int monsterHealth = 75;
    int monsterAttack = 25;

    public Monster(){
        this.name = names[rand.nextInt(names.length)];
        this.monsterHealth = rand.nextInt(monsterHealth);
    }
}
