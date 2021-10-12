package com.company;
import java.util.Random;
import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        //System objects
        Scanner in = new Scanner(System.in);
        Random rand = new Random();
        //Game variables
        String[] enemies={"Skeleton", "Zombie", "Warrior", "Assasin"};
        String enemy;
        int maxEnemyHealth=75;
        int enemyAttackDamage=25;
        //Player variables
        int health=100;
        int attackDamage=50;
        int numHealthPotions=3;
        int healthPotionHealAmount=30;
        int healthPotionDropChance=50;// Percentage

        boolean running = true;
        System.out.println("Welcome to the Dungeon!!");
        GAME:
        while(running)
        {
            System.out.println("--------------------------------------------");
            int enemyHealth=rand.nextInt(maxEnemyHealth);
            enemy = enemies[rand.nextInt(enemies.length)];
            System.out.println("\t#"+ enemy + " has appeared! #\n");

            while(enemyHealth>0)
            {
                System.out.println("\tYour HP:" + health);
                System.out.println("\t" + enemy +"'s HP: " + enemyHealth);
                System.out.println("\n\tWhat would you like to do?");
                System.out.println("\t1.Attack");
                System.out.println("\t2.Drink health potion");
                System.out.println("\t3.Run");

                String input=in.nextLine();
                if(input.equals("1"))
                {
                    int damageDealt = rand.nextInt(attackDamage);
                    int damageTaken = rand.nextInt(enemyAttackDamage);

                    enemyHealth=enemyHealth-damageDealt;
                    health=health-damageTaken;

                    System.out.println("\t> You strike the" + enemy + "with" + damageDealt + " damage.");
                    System.out.println("\t> You recieve " + damageTaken + "in retaliation!");

                    if(health<1)
                    {
                        System.out.println("\t> You have taken too much damage, you are too weak to carry on!!");
                        break;
                    }
                }
                else if(input.equals("2"))
                {
                    if(numHealthPotions>0)
                    {
                        numHealthPotions--;
                        health+=healthPotionHealAmount;
                        System.out.println("/t> You drink a health potion, healing yourself for" + healthPotionHealAmount+"."
                                +"\n\t> You now have" + health + "HP."
                                +"\n\t> You have" + numHealthPotions + "health potions left now.\n");

                    }
                    else
                    {
                        System.out.println("/t> You have no health potions left now! Defeat enemies for a chance to obtain it.");
                    }
                }
                else if(input.equals("3"))
                {
                    System.out.println("\tYou run away from the" + enemy + "!!");
                    continue GAME;
                }
                else
                {
                    System.out.println("/tINVALID COMMAND!!");
                }
            }
            if (health<1)
            {
                System.out.println("You limp out of the dungeon, weak from the battle.");
                break;
            }
            System.out.println("-----------------------------------------");
            System.out.println(" # " + enemy +" was defeated!!" + "#" );
            System.out.println(" # " + health + " HP left. # ");
            if(rand.nextInt(100)< healthPotionDropChance)
            {
                numHealthPotions++;
                System.out.println(" # The " + enemy + "dropped a health potion!! # ");
                System.out.println(" # You now have " + numHealthPotions + "health potion(s). # ");
            }
            System.out.println("-----------------------------------------");
            System.out.println(" What would you like to do now ? ");
            System.out.println("1. Continue play ");
            System.out.println("2. Exit the dungeon ");

            String input = in.nextLine();
            while(!input.equals("1") && !input.equals("2"))
            {
                System.out.println("Invalid command");
                input = in.nextLine();
            }
            if (input.equals("1"))
            {
                System.out.println("You can continue on your adventure!!");
            }
            if (input.equals("2"))
            {
                System.out.println("You can exit from the game, adios amigo");
                break;
            }
        }
        System.out.println("##########################");
        System.out.println(" # Thanks for playing!! # ");
        System.out.println("##########################");
    }
}


