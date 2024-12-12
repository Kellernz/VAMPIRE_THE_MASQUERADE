/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.keller.vampireTheMasquered;

/**
 *
 * @author Guilherme
 */
import java.util.Random;
import java.util.Scanner;

public class Brujah extends Character {
    public Brujah() {
        super("", 120, 50, 18, 10, 8);
    }

    public void lightAttack() {
        int damage = getStrength() / 2;
        System.out.println(getName() + " performs a light attack dealing " + damage + " damage!");
    }

    public void heavyAttack() {
        int damage = getStrength() * 2;
        System.out.println(getName() + " performs a heavy attack dealing " + damage + " damage!");
    }

    @Override public void rollDice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("It is time, the light from the moon shines bright and the roll of dices will determine the attributes of your vampire (press enter)");
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("")) {
            Random random = new Random();
            this.hp = random.nextInt(71) + 140;
            this.mp = random.nextInt(11) + 20;
            this.strength = random.nextInt(21) + 10;
            this.agility = random.nextInt(11) + 4;
            this.arcane = random.nextInt(11) + 2;
            System.out.println("The blood moon is pleased! This are yor new stats: " + this);
        } else {
            System.out.println("You defy the blood moon, thus, thy shall start with base attributes;.");
        }
    }
}
