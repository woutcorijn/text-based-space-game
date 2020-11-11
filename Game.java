import java.util.*;
import java.util.concurrent.TimeUnit;
import java.lang.Math;

class Game {

	static int Enemyhealth = 50;
	static int Enemydamage;
	static int Playerdamage;
	static int Playerhealth = 50;
	static int Moonstone = 20;
	static String playerinp;
	static Scanner scan = new Scanner(System.in);

	static void stats() {
	try {
	Thread.sleep(1000);
	}
	catch(InterruptedException ex) {
	Thread.currentThread().interrupt();
	}
	System.out.println("\n");
	System.out.println("   Stats");
	System.out.println("------------");
	//System.out.println("Enemy health: " + Enemyhealth);
	System.out.println("Player health: " + Playerhealth);
	System.out.println("Moonstones: " + Moonstone);
}

	static void intro() {
	System.out.println("Do you want to read the tutorial? y/n");
	playerinp = scan.nextLine();
	if (playerinp.equals("y")) {
		System.out.println("\t Welcome to the tutorial.");
		System.out.println("\t-------------------------- \n");
		System.out.println("Enter '1' for a Spaceboot Kick.");
		System.out.println("Damage: between -2 and -6 health");
		System.out.println("Cost: 2 Moonstones \n");
		System.out.println("Enter '2' for a Laser Gun attack.");
		System.out.println("Damage: between -6 and -12 health");
		System.out.println("Cost: 5 Moonstones \n");
		System.out.println("Start Game? y/n");
		playerinp = scan.nextLine();
		if (playerinp.equals("y")) {
		} else {
			System.exit(0);
		}
	}
}

	static void EnemyDamage() {
			Playerdamage = (int)(Math.random() * ((10 - 2) + 1)) + 2;
			Playerhealth -= Playerdamage;
			System.out.println("Enemy Attack!: Player -" + Playerdamage + " Health");
	}

	public static void main(String[] args) throws InterruptedException {

		//drawing Draw = new drawing();
		//intro
		System.out.println("\n");
		System.out.println("\t Epic Text Based Game");
		System.out.println("\t----------------------- \n");
		intro();
		stats();
		System.out.println("\n");
		System.out.println("!!Enemy apeared!!");
		// Draw.img();
		System.out.println("Enemy health: " + Enemyhealth +"\n");

		playerinp = scan.nextLine();

	while(Playerhealth > 0 && Moonstone > 0) {
		if(playerinp.equals("1") && Moonstone > 0) {
			Moonstone -= 2;
			Enemydamage = (int)(Math.random() * ((6 - 2) + 1)) + 2;
			Enemyhealth -=  Enemydamage;
			System.out.println("Spaceboot Kick!: Enemy -" + Enemydamage + " Health");
			Thread.sleep(500);
            EnemyDamage();
			stats();
		}

		else if(playerinp.equals("2")  && Moonstone > 0) {
			Moonstone -= 5;
			Enemydamage = (int)(Math.random() * ((12 - 6) + 1)) + 6;
			Enemyhealth -=  Enemydamage;
			System.out.println("Laser Gun!: Enemy -" + Enemydamage + " Health");
			Thread.sleep(500);
            EnemyDamage();
			stats();
	}
	playerinp = scan.nextLine();
	}
}
}
