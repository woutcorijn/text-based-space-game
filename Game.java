import java.util.*;
import java.util.concurrent.TimeUnit;
import java.lang.Math;

public class Game {
	static String Player_Input;
	static Scanner scan = new Scanner(System.in);

	static Character Player = new Character();
	static Character Enemy = new Character();

	public static void main(String[] args) throws InterruptedException {

		Player.Health = 50;
		Player.Moonstone = 20;

		//intro
		System.out.println("\n");
		System.out.println("\t Epic Text Based Game");
		System.out.println("\t----------------------- \n");
		intro();

	while(Player.Health > 0 && Player.Moonstone > 0) {
		Enemy_Generator();
		Thread.sleep(1000);
		stats();

	while(Enemy.Health > 0 && Player.Health > 0 && Player.Moonstone > 0) {
		Player_Input = scan.nextLine();

		if(Player_Input.equals("1") && Player.Moonstone > 0) {
			Player.Moonstone -= 2;
			Enemy.Damage = (int)(Math.random() * ((6 - 2) + 1)) + 2;
			Enemy.Health -=  Enemy.Damage;
			if (Enemy.Health <= 0) {
				Enemy.Health = 0;
			}
			System.out.println("Spaceboot Kick!: Enemy -" + Enemy.Damage + " Health");
		}	else if(Player_Input.equals("2")  && Player.Moonstone > 0) {
			Player.Moonstone -= 5;
			Enemy.Damage = (int)(Math.random() * ((12 - 6) + 1)) + 6;
			Enemy.Health -=  Enemy.Damage;
			if (Enemy.Health <= 0) {
				Enemy.Health = 0;
			}
			System.out.println("Laser Gun!: Enemy -" + Enemy.Damage + " Health");
	} else if(Player_Input.equals("3")  && Player.Moonstone > 0) {
			Health();
			stats();
			continue;
		}
	Player_Damage();
	Thread.sleep(500);
	stats();
	}
	Loot();
}
}

static void intro() {
System.out.println("Do you want to read the tutorial? y/n");
Player_Input = scan.nextLine();
if (Player_Input.equals("y")) {
	System.out.println("\t Welcome to the tutorial.");
	System.out.println("\t-------------------------- \n");
	System.out.println("Player.Moonstone are the ingame currency.");
	System.out.println("Actions can be executed by entering a number.");
  System.out.println("\n");
	System.out.println("Enter '1' for a Spaceboot Kick.");
	System.out.println("Damage: between -2 and -6 health");
	System.out.println("Cost: 2 Player.Moonstones \n");
	System.out.println("Enter '2' for a Laser Gun attack.");
	System.out.println("Damage: between -6 and -12 health");
	System.out.println("Cost: 5 Player.Moonstones \n");
	System.out.println("Enter '3' for generating 1 health for 1 Player.Moonstone. \n");
	System.out.println("Start Game? y/n");
	Player_Input = scan.nextLine();
	if (Player_Input.equals("n")) {
		System.exit(0);
	}
}
}

static void stats() throws InterruptedException {

System.out.println("\n");
System.out.println("   Player Stats");
System.out.println("------------------");
//System.out.println("Enemy health: " + Enemy.Health);
System.out.println("Player health: " + Player.Health);
System.out.println("Player.Moonstones: " + Player.Moonstone);
System.out.println("\n");
System.out.println("   Enemy Stats");
System.out.println("-----------------");
System.out.println("Enemy health: " + Enemy.Health +"\n");
System.out.println("\n");
System.out.println("1: Kick, 2: Gun, 3: Health");
}

static void Enemy_Generator() throws InterruptedException {

	Thread.sleep(1000);

  Enemy.Health = (int)(Math.random() * ((40 - 10) + 1)) + 10;

	System.out.println("\n");
	System.out.println("!!Enemy apeared!!");
}

static void Player_Damage() {
		Player.Damage = (int)(Math.random() * ((10 - 2) + 1)) + 2;
		Player.Health -= Player.Damage;
		System.out.println("Enemy Attack!: Player -" + Player.Damage + " Health");
}

static void Loot() {
		Player.Moonstone += (int)(Math.random() * ((40 - 19) + 1)) + 40;
		System.out.println("Enemy has dropped " + Player.Moonstone + " Player.Moonstones.");
}

static void Health() {
 Player.Health += 1;
 Player.Moonstone -= 1;
}
}
