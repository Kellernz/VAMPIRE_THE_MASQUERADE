/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.keller.vampireTheMasquerade;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Guilherme
 */
public class Gangrel extends Creature {
    private boolean animalFormActive;
    private int animalFormDuration;
  
    public Gangrel(String name) {
        super(name, 130, 40, 16, 12, 7); 
    }

    public int lightAttack() {
        int damage = getStrength() + (getAgility() / 2); 
        System.out.println(getName() + " performs a light attack dealing " + damage + " damage!");
	return damage;
    }

    public int heavyAttack() {
        int damage = getStrength() * 2; 
        System.out.println(getName() + " performs a heavy attack dealing " + damage + " damage!");
	return damage;
    }

    public void update() {
	if (animalFormActive) {
	   animalFormDuration -= 1;
	   if (animalFormDuration <= 0) {
		animalFormActive = false;
		setAgility(getAgility() - 12);
	   }
	}
    }
   
    public void animalForm() {
	if (animalFormActive) {
	   System.out.println("You are already on the Animal Form!");
	   return;
	}

        if (getMp() >= 20) {
            setAgility(getAgility() + 12); 
            setMp(getMp() - 20); 
            System.out.println(getName() + " transforms into an animal form, gaining 12 additional agility (20 MP consumed)!");
	    animalFormDuration = 4;
        } else {
            System.out.println("Not enough MP to use Animal Form!");
        }
    }

    @Override
    public void rollDice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("It is time, the light from the moon shines bright and the roll of dices will determine the attributes of your vampire (press enter)");
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("")) {
            Random random = new Random();
            this.hp = random.nextInt(51) + 120;
            this.mp = random.nextInt(31) + 40;
            this.strength = random.nextInt(11) + 20;
            this.agility = random.nextInt(11) + 6;
            this.arcane = random.nextInt(11) + 7;
            System.out.println("The blood moon is pleased! This are yor new stats: ");
	    this.print();
        } else {
            System.out.println("You defy the blood moon, thus, thy shall start with base attributes;.");
        }
    }
}
