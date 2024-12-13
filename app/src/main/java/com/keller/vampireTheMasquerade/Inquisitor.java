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

public class Inquisitor extends Creature {
	public Inquisitor() {
	 super("Va'rum", 120, 0, 12, 22, 0);
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
    
    @Override public void rollDice() {
	    Random random = new Random();
            this.hp += random.nextInt(0) + 10;
            this.strength += random.nextInt(0) + 15;
            this.agility += random.nextInt(0) + 20;
    }
}
