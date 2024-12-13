/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.keller.vampireTheMasquerade;

import java.util.Random;

/**
 *
 * @author Guilherme
 */

public class Velkz extends Gangrel {
    public Velkz() {
	 super("Velkz");
    }
 
    @Override public void rollDice() {
	    Random random = new Random();
            this.hp = random.nextInt(51) + 120;
            this.mp = random.nextInt(31) + 40;
            this.strength = random.nextInt(11) + 20;
            this.agility = random.nextInt(11) + 6;
            this.arcane = random.nextInt(11) + 7;
    }
}
