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
import java.util.Scanner;

public abstract class Creature {
    protected String name;
    protected int hp;       
    protected int mp;       
    protected int strength; 
    protected int agility;  
    protected int arcane;   

    public Creature(String name, int hp, int mp, int strength, int agility, int arcane) {
        this.name = name;
        this.hp = hp;
        this.mp = mp;
        this.strength = strength;
        this.agility = agility;
        this.arcane = arcane;
    }

    
    public Creature() {
        this("", 100, 50, 10, 10, 10);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = Math.max(hp, 0); 
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = Math.max(mp, 0); 
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = Math.max(strength, 0);     }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = Math.max(agility, 0);
    }

    public int getArcane() {
        return arcane;
    }

    public void takeDamage(int amount) {
	this.hp -= amount;
	System.out.println(getName() + " takes " + amount + " damage!");
    }

    public void setArcane(int arcane) {
        this.arcane = Math.max(arcane, 0);
    }

    public void print() {
        System.out.println(getName());
	System.out.println("HP: " + hp);
	System.out.println("MP: " + mp);
	System.out.println("Strength: " + strength);
	System.out.println("Agility: " + agility);
	System.out.println("Arcane: " + arcane);
    }

    public abstract void rollDice();
}

   
