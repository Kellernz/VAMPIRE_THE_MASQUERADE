package com.keller.vampireTheMasquerade;

import java.util.Scanner;

public class Game {
	static Creature player;

    public static void createPlayer(Scanner sc) {
           int option;

	   System.out.print("What's your name? ");
	String name = sc.nextLine();
	
	do {
		System.out.println("1. Brujah");
		System.out.println("2. Lasombra");
		System.out.println("3. Gangrel");
		System.out.print("What's your nature? ");

		option = sc.nextInt();
		sc.nextLine();
	} while (option < 1 || option > 3);

	switch (option) {
   	    case 1:
	        player = new Brujah(name);
	  	break;
	    case 2:
	        player = new Lasombra(name);
	   	break;
	    case 3:
	        player = new Gangrel(name);
	  	break;
	}

	player.rollDice();
    }

    public static void main(String[] args){
	    Scanner sc = new Scanner(System.in);
	    
	    System.out.println("You awaken in your dimly lit apartment in Porto Alegre, the air heavy with the weight of something unnatural.");
	    System.out.println("The familiar hum of the city outside feels distant, as though you’ve been severed from the living pulse of the world.");
	    System.out.println("Your body feels alien—every sensation sharper, every shadow deeper—and then the hunger strikes, a gnawing void clawing at your insides.");
	    System.out.println("Whatever life you had before, it’s over. You are something else now. But what?");
	    
	    createPlayer(sc);

	    if (player instanceof Gangrel) {
		gangrelStory(sc);	    
	    } else if (player instanceof Lasombra) {
		lasombraStory(sc);
	    } else {
		brujahStory(sc);
	    }

	    System.out.println("Game over!");
    }

    public static void gangrelStory(Scanner sc) {
	   System.out.println("A primal connection to nature stirs within you, a feral instinct rising to the surface.");
	   System.out.println("You have become a Gangrel, a predator tied to the wilderness and the raw force of life itself.");
	   System.out.println("The knowledge is unsettling, but the truth is clear: you are no longer human. What will you do?");
	   System.out.println("1. Seek answers at the public library, a bastion of knowledge that might hold the truth.");
	   System.out.println("2. Venture into the shadows of the lower city, where whispers travel faster than light.");

	int choice;

	do {
		System.out.println("Your choice: ");
		choice = sc.nextInt();
		sc.nextLine();
	} while (choice < 0 || choice > 2);

	if (choice == 1) {
		System.out.println("The library is eerily quiet, each step echoing in the hollow halls. Among the dusty tomes, you find fragments of lore.");
		System.out.println("You uncover the truth of your embrace—the cursed ritual that turned you into this—and a conspiracy that binds your existence to something far darker.");
	} else {
		System.out.println("The lower city is a labyrinth of despair, where the desperate and the damned collide.");
		System.out.println("You uncover secrets whispered in dark alleys, truths about your creation and a conspiracy that stretches into the abyss.");
	}

	templarCombat(sc);
	System.out.println("Something in the way.");
    }

    public static void brujahStory(Scanner sc) {
	    System.out.println("The fire of rebellion burns within you, fierce and unyielding. You are Brujah, a warrior of passion and defiance.");
	    System.out.println("But the flames of justice flicker in the presence of a growing dread. Eyes are upon you, watching, waiting.");
	    System.out.println("You sense danger closing in. What will you do?");
	    System.out.println("1. Confront the shadowy figures trailing you, demanding answers with fists and fury.");
	    System.out.println("2. Flee to the Public Market, blending into the chaos and seeking safety among the crowd.");

	int choice;

	do {
		System.out.println("Your choice: ");
		choice = sc.nextInt();
		sc.nextLine();
	} while (choice < 0 || choice > 2);

	if (choice == 1) {
		System.out.println("You whirl around, catching your pursuers off guard. Their weapons flash in the dim light.");
		System.out.println("A brutal battle ensues, their resolve no match for your unrelenting drive.");
		battleInquisitors(sc);
		System.out.println("In the aftermath, you learn the Prince himself knows of your existence. A reckoning is inevitable.");
	} else {
		System.out.println("The market is a cacophony of noise and movement, a perfect veil for your escape.");
		System.out.println("But even here, whispers reach your ears: the Prince is aware of you, and he will not be ignored.");
	}

	System.out.println("The confrontation with the Prince is unavoidable. His royal guard stands between you and the truth.");
	templarCombat(sc);
	if (player.getHp() > 0) {
		System.out.println("Against all odds, you defeat the templar. The Prince falls, and with him, the old order crumbles.");
		System.out.println("You rise to power, but at what cost?");
	}
    }

    public static void battleInquisitors(Scanner sc) {
	System.out.println("The Inquisition is upon you, their resolve unwavering, their faith a shield against your shadows.");
	for (int i = 1; i <= (Math.random() * 3) + 3; i++) {
		var inquisitor = new Inquisitor();
		inquisitor.rollDice();
		System.out.println("Inquisitor " + i + " steps forward, a symbol of divine wrath.");
		
		new Combat(player, inquisitor, sc).start();

		if (player.getHp() <= 0)
			return;

		System.out.println("The Inquisitor falls, their sanctified weapon clattering to the ground. Yet, the fight is far from over.");
	}

	System.out.println("The final Inquisitor's defeat marks a bitter victory. The cost of survival weighs heavily upon you.");
    }

    public static void templarCombat(Scanner sc) {
	int choice;

	System.out.println("As you press forward, a templar blocks your path, his blade gleaming with divine retribution.");
	System.out.println("Do you stand and fight, or attempt to flee?");

	System.out.println("1. Fight");
	System.out.println("2. Flee");

	do {
		System.out.println("Your choice: ");
		choice = sc.nextInt();
		sc.nextLine();
	} while (choice < 0 || choice > 2);

	if (choice != 1) {
	    System.out.println("You escape into the night, but at a cost. The Prince exiles you from the city, a fate worse than death.");
	    return;
        }

	if (player.getHp() <= 0)
		return;
	
	var templar = new Templar();
	templar.rollDice();

	new Combat(player, templar, sc).start();
    }

    public static void lasombraStory(Scanner sc) {
	    System.out.println("You are Lasombra, master of shadows and manipulation. The tendrils of power coil around you, whispering promises of dominion.");
	    System.out.println("But power is never given freely. Where will you turn?");
	    System.out.println("1. Seek solace at the margins of Guaíba Lake, where an ancient power lies waiting.");
	    System.out.println("2. Descend into the city's underbelly, where the dispossessed and downtrodden might serve your ambitions.");

        int choice = sc.nextInt();
        sc.nextLine();

        if (choice == 1) {
		System.out.println("The lake is shrouded in mist, its still waters reflecting a darkness deeper than the night.");
		System.out.println("You encounter an ancient being, its presence suffocating, its gaze piercing through your soul.");
		System.out.println("Do you yield to its wisdom and speak to the Prince?");
		System.out.println("1. Yes");
		System.out.println("2. No");

            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
		    templarCombat(sc);
		    System.out.println("The Prince's court is a den of vipers, every word a weapon, every smile a snare.");
		    System.out.println("You confront him, but the price of power is exile or servitude. Neither feels like victory.");
	    } else {
			System.out.println("The ancient whispers, 'Power is fleeting, child of shadow. Yet in yielding, you may rise above.'");
			System.out.println("You decide to confront the Prince. The road to his court is perilous, fraught with those who seek to extinguish your dark flame.");
			battleInquisitors(sc);
			System.out.println("The Prince's court is a den of vipers, every word a weapon, every smile a snare.");
			System.out.println("You confront him, but the price of power is exile or servitude. Neither feels like victory.");
	    }
        } else {
		System.out.println("The city's underbelly welcomes you, a kingdom of shadows and whispers.");
		System.out.println("You build alliances among the anarchists, their hunger for change matching your thirst for power.");
		System.out.println("But the Prince will not let such defiance go unchallenged. His inquisitors hunt you relentlessly.");
		battleInquisitors(sc);
		System.out.println("Together, you seize control, but the darkness you wield consumes all who dare to hold it.");
	}
    }
}
