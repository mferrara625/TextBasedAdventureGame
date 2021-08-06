package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("#############################");
        System.out.println("#### Enter name to begin ####");
        System.out.println("#############################");
        String input1 = scan.nextLine();
        Player player = new Player(input1);
        while (player.playerHealth > 0) {
            Monster monster = new Monster();
            System.out.println("----------------------------------");
            System.out.println(monster.name + " has appeared!");
            System.out.println("----------------------------------");
            while (monster.monsterHealth > 0) {
                System.out.println(player.name + "'s HP: " + player.playerHealth);
                System.out.println(monster.name + "'s HP: " + monster.monsterHealth);
                System.out.println("\t>Score: " + player.score);
                System.out.println("\t>Enemies Killed: " + player.monstersKilled);
                System.out.println("\t>Health potions: " + player.numberOfHeals);
                System.out.println("--------------------------");
                System.out.println("What would you like to do?");
                System.out.println("\t1. Attack!");
                System.out.println("\t2. Heal");
                System.out.println("\t3. Run!");
                String input2 = scan.nextLine();
                if (input2.equals("1")) {
                    int playAttack = rand.nextInt(player.playerAttack);
                    int monstAttack = rand.nextInt(monster.monsterAttack);
                    player.playerHealth -= monstAttack;
                    monster.monsterHealth -= playAttack;
                    System.out.println(">" + player.name + " attacked " + monster.name + " for " + playAttack + " damage!");
                    System.out.println(">" + player.name + " took " + monstAttack + " damage");
                    System.out.println("\n");
                    player.score += playAttack - monstAttack;
                    if(player.playerHealth <= 0){
                        System.out.println(player.name + " is too weak to go on!");
                        break;
                    }
                } else if (input2.equals("2")) {
                    heal(rand, player);
                } else if (input2.equals("3")) {
                    System.out.println("You ran away to safety.");
                    break;
                } else {
                    System.out.println("Invalid Selection");
                    input2 = scan.nextLine();
                }
            }
            if(monster.monsterHealth <= 0){
                System.out.println("You Defeated the " + monster.name + "!");
                player.monstersKilled++;
                if(rand.nextInt(2) == 1){
                    player.numberOfHeals++;
                    System.out.println(monster.name + " dropped a health potion");
                }
                System.out.println("-------------------------------------------");
                System.out.println("What would you like to do?");
                System.out.println("1.Continue on your journey");
                System.out.println("2.Return to the village");
                String input3 = scan.nextLine();
                if(input3.equals("1"))
                    continue;
                else if (input3.equals("2"))
                    System.out.println("\n" + player.name + " returns to the village, victoriously!");
                    break;

            }
            if(player.playerHealth <= 0){
                System.out.println("\n" + player.name + " must return to the village and rest to fight another day...");
                break;
            }
        }
        System.out.println("\n#################");
        System.out.println("### Game Over ###");
        System.out.println("#################");
    }

    private static void heal(Random rand, Player player) {
        if (player.numberOfHeals > 0) {
            player.numberOfHeals--;
            int thisHeal = rand.nextInt(player.healAmount);
            player.playerHealth += thisHeal;
            System.out.println("You heal yourself for " + thisHeal + " HP");
        } else {
            System.out.println("You have no heals left");
        }
    }
}