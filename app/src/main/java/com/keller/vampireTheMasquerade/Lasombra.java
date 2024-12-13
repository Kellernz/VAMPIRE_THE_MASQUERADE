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
public class Lasombra extends Creature {
    private boolean shadowVeilActive; 
    private int shadowVeilDuration;   

 
    public Lasombra(String name) {
        super(name,100, 60, 12, 10, 15); 
        this.shadowVeilActive = false;
        this.shadowVeilDuration = 0;
    }


    public int lightAttack() {
        int damage = getStrength() + (getArcane() / 4); 
        System.out.println(getName() + " performs a light attack dealing " + damage + " damage!");
	return damage;
    }

  
    public int heavyAttack() {
        int damage = (getStrength() * 2) + (getArcane() / 2); 
        System.out.println(getName() + " performs a heavy shadow attack dealing " + damage + " damage!");
	return damage;
    }


    public void shadowVeil() {
        if (getMp() >= 15 && !shadowVeilActive) {
            setMp(getMp() - 15); 
            shadowVeilActive = true;
            shadowVeilDuration = 3;
            System.out.println(getName() + " activates Shadow Veil, reducing incoming damage for 3 turns (15 MP consumed)!");
        } else if (shadowVeilActive) {
            System.out.println("Shadow Veil is already active!");
        } else {
            System.out.println("Not enough MP to activate Shadow Veil!");
        }
    }

    // Method to reduce incoming damage
    @Override
    public void takeDamage(int damage) {
        if (shadowVeilActive) {
            damage /= 1.75; 
            System.out.println(getName() + " takes reduced damage due to Shadow Veil!");
        } else {
            System.out.println(getName() + " takes " + damage + " damage.");
        }

        setHp(Math.max(getHp() - damage, 0)); 
    }


    public void update() {
        if (shadowVeilActive) {
            shadowVeilDuration--;
            if (shadowVeilDuration <= 0) {
                shadowVeilActive = false;
                System.out.println(getName() + "'s Shadow Veil has worn off!");
            }
        }
    }
        @Override
	public void rollDice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("It is time, the light from the moon shines bright and the roll of dices will determine the attributes of your vampire (press enter)");
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("")) {
            Random random = new Random();
            this.hp = random.nextInt(41) + 50;
            this.mp = random.nextInt(21) + 60;
            this.strength = random.nextInt(11) + 8;
            this.agility = random.nextInt(11) + 10;
            this.arcane = random.nextInt(21) + 14;
            System.out.println("The blood moon is pleased! This are yor new stats: ");
	    this.print();
        } else {
            System.out.println("You defy the blood moon, thus, thy shall start with base attributes;.");
        }
    }
}

