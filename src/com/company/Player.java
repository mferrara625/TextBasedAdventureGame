package com.company;

public class Player {
    String name;
    int playerHealth = 100;
    int playerAttack = 50;
    int numberOfHeals = 3;
    int healAmount = 30;
    int score = 0;
    int monstersKilled = 0;

    public Player(String name){
        this.name = name;
    }

}
