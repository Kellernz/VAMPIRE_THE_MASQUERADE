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

public class Bakunin extends Brujah {
    public Bakunin() {
        super("Bakunin", 120, 50, 18, 10, 8);
    }

    @Override public void rollDice() {
	    Random random = new Random();
	    this.hp = random.nextInt(71) + 140;
	    this.mp = random.nextInt(11) + 20;
	    this.strength = random.nextInt(21) + 10;
	    this.agility = random.nextInt(11) + 4;
	    this.arcane = random.nextInt(11) + 2;
    }
}
