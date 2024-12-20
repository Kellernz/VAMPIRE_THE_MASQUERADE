/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.keller.vampireTheMasquerade;

import java.util.Scanner;

/**
 *
 * @author Guilherme
 */

 public class Combat {
     private Creature player;
     private Creature enemy;
     private Scanner sc;

     private boolean isPlayerTurn;

     public Combat(Creature player, Creature enemy, Scanner sc) {
       this.player	= player;
       this.enemy=enemy;
       this.sc=sc;
       isPlayerTurn = this.player.getAgility() > this.enemy.getAgility();
     }

     public void gangrelAction(Gangrel gangrel)
     {
	     int option;
	     gangrel.update();

	     do {
		     System.out.println("Possible actions: ");
		     System.out.println("1. Light attack");
		     System.out.println("2. Heavy attack");
		    System.out.println("3. Animal form");
		    System.out.print("Choose one of the above (1-3): ");

		    option = sc.nextInt();
		    sc.nextLine();
		} while(option < 0 || option > 3);

	     switch (option) {
		case 1:
			enemy.takeDamage(gangrel.lightAttack());
			break;
		case 2:
			enemy.takeDamage(gangrel.heavyAttack());
			break;
		case 3:
			gangrel.animalForm();
			break;
	     }
     }
     
     public void lasombraAction(Lasombra lasombra)
     {
	     int option;

	     lasombra.update();
	     do {
		     System.out.println("Possible actions: ");
		     System.out.println("1. Light attack");
		     System.out.println("2. Heavy attack");
		     System.out.println("3. Shadow veil");
		     System.out.print("Choose one of the above (1-3): ");

		    option = sc.nextInt();
		    sc.nextLine();
		} while(option < 0 || option > 3);

	     switch (option) {
		case 1:
			enemy.takeDamage(lasombra.lightAttack());
		break;
		case 2:
			enemy.takeDamage(lasombra.heavyAttack());
			break;
		case 3:
			lasombra.shadowVeil();
			break;
	     }
     }

     public void brujahAction(Brujah brujah)
     {
	     int option;

	     do {
		     System.out.println("Possible actions: ");
		     System.out.println("1. Light attack");
		     System.out.println("2. Heavy attack");
		     System.out.print("Choose one of the above (1-2): ");
		     option = sc.nextInt();
		    sc.nextLine();
		} while(option < 0 || option > 2);

	     switch (option) {
		case 1:
			enemy.takeDamage(brujah.lightAttack());
			break;
		case 2:
			enemy.takeDamage(brujah.heavyAttack());
			break;
	     }
     }
     
     public void playerAction() 
     {
	     if (player instanceof Gangrel) {
		Gangrel gangrel = (Gangrel) player;
		gangrelAction(gangrel); 
	     } else if (player instanceof Brujah) {
		Brujah brujah = (Brujah) player;
		brujahAction(brujah); 
	     } else {
		Lasombra lasombra = (Lasombra) player;
                lasombraAction(lasombra);
	     }

	     isPlayerTurn = false;
     }

     public void templarAction(Templar templar)
     {
	int result = (int)(Math.random() * 11) + 1;

	if (result < 3) {
		player.takeDamage(templar.lightAttack());
	} else if (result < 6 || enemy.getMp() < 5) {
		player.takeDamage(templar.heavyAttack());
	} else if (result < 11) {
		player.takeDamage(templar.righteousJustice());
	} else {
		templar.divineVowl();
	}
     }
     
     public void inquisitorAction(Inquisitor inquisitor)
     {
	int result = (int)(Math.random() * 5) + 1;

	if (result < 3) {
		player.takeDamage(inquisitor.lightAttack());
	} else { 
		player.takeDamage(inquisitor.heavyAttack());
	}
     }

     public void velkzAction(Velkz velkz)
     {
	int result = (int) (Math.random() * 9) + 1;
	
	if (result < 3) {
		player.takeDamage(velkz.lightAttack());
	} else if (result < 6 || velkz.getMp() < 20) { 
		player.takeDamage(velkz.heavyAttack());
	} else {
		velkz.animalForm();
	}
     }

     public void bakuninAction(Bakunin bakunin)
     {
         int result = (int) (Math.random() * 4) + 1;
	 if (result < 3) {
		player.takeDamage(bakunin.lightAttack());
	 } else {
		player.takeDamage(bakunin.heavyAttack());
	 }
     }

     public void enemyAction()
     {
	if (enemy instanceof Templar) {
		templarAction((Templar) enemy);
	} else if (enemy instanceof Inquisitor) {
	        inquisitorAction((Inquisitor) enemy);
	} else if (enemy instanceof Velkz) {
		velkzAction((Velkz) enemy);
	} else {
		bakuninAction((Bakunin) enemy);
	}
	     
	     isPlayerTurn = true;
     }

     public void start()
     {
	  int playerFullHp = player.getHp();

	     System.out.println("Combat!");
	  if (isPlayerTurn) {
		System.out.println("Player does first turn");
	  } else {
		System.out.println("Enemy does first turn");
	  }

          while (player.getHp() > 0 && enemy.getHp() > 0) {
		if (isPlayerTurn) {
			player.print();
			System.out.print("\n\n"); 
			enemy.print();
			playerAction();
		} else {
			enemyAction();
		}
	  }

	  if (player.getHp() > 0) {
           System.out.println("Player raised a victory.");
	   player.setHp(playerFullHp);
	  } else {
           System.out.println("LMAOOO!! You died.");
	  }
     }
 };
