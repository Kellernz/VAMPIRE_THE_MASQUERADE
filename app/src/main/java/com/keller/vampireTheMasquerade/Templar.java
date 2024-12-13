/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.keller.vampireTheMasquerade;

/**
 *
 * @author Guilherme
 */

import java.util.Random;

public class Templar extends Creature {
    public Templar() {
	 super("Knight Mikael", 300, 10, 30, 12, 30);
    }

    public void divineVowl() {
         this.strength += 10;
	 this.arcane += 10;
	 this.mp -= 5;
    }

    public int righteousJustice() {
	int damage = (int) (2.25 * getArcane() + 1.75 * getStrength());
	this.mp -= 5;
	System.out.println("Templar" + getName() + " does a sweeping holy attack with all his might, dealing a total of " + damage + " damage!");
        return damage;
    }

    public int lightAttack() {
        int damage = getStrength() + (getAgility() / 2); 
        System.out.println("Templar" + getName() + " performs a light attack dealing " + damage + " damage!");
	return damage;
    }

    public int heavyAttack() {
        int damage = getStrength() * 2; 
        System.out.println("Templar" + getName() + " performs a heavy attack dealing " + damage + " damage!");
	return damage;
    }
    
    @Override public void rollDice() {
	    Random random = new Random();
            this.hp += random.nextInt(0) + 10;
            this.strength += random.nextInt(0) + 15;
            this.agility += random.nextInt(0) + 20;
    }
}
