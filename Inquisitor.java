/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.keller.vampireTheMasquerade;

/**
 *
 * @author Guilherme
 */

public class Inquisitor extends Character {
	public Inquisitor() {
	 super("Va'rum", 120, 0, 12, 22, 0);
    }

    public void lightAttack() {
        int damage = getStrength() + (getAgility() / 2); 
        System.out.println(getName() + " performs a light attack dealing " + damage + " damage!");
    }

    public void heavyAttack() {
        int damage = getStrength() * 2; 
        System.out.println(getName() + " performs a heavy attack dealing " + damage + " damage!");
    }
    
    @Override public void rollDice() {
            this.hp += random.nextInt(0) + 10;
            this.strength += random.nextInt(0) + 15;
            this.agility += random.nextInt(0) + 20;
    }
}
