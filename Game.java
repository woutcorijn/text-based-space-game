import java.util.*;
import java.util.concurrent.TimeUnit;
import java.lang.Math;

class Game {

	static int Enemy_Health;
	static int Enemy_Damage;
	static int Player_Damage;
	static int Player_Health = 50;
	static int Moonstone = 20;
	static String Player_Input;
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws InterruptedException {

		//intro
		System.out.println("\n");
		System.out.println("\t Epic Text Based Game");
		System.out.println("\t----------------------- \n");
		intro();

	while(Player_Health > 0 && Moonstone > 0) {
		Enemy_Generator();
		Thread.sleep(1000);
		stats();

	while(Enemy_Health > 0 && Player_Health > 0 && Moonstone > 0) {
		Player_Input = scan.nextLine();

		if(Player_Input.equals("1") && Moonstone > 0) {
			Moonstone -= 2;
			Enemy_Damage = (int)(Math.random() * ((6 - 2) + 1)) + 2;
			Enemy_Health -=  Enemy_Damage;
			if (Enemy_Health <= 0) {
				Enemy_Health = 0;
			}
			System.out.println("Spaceboot Kick!: Enemy -" + Enemy_Damage + " Health");
		}	else if(Player_Input.equals("2")  && Moonstone > 0) {
			Moonstone -= 5;
			Enemy_Damage = (int)(Math.random() * ((12 - 6) + 1)) + 6;
			Enemy_Health -=  Enemy_Damage;
			if (Enemy_Health <= 0) {
				Enemy_Health = 0;
			}
			System.out.println("Laser Gun!: Enemy -" + Enemy_Damage + " Health");
	} else if(Player_Input.equals("3")  && Moonstone > 0) {
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
	System.out.println("Enter '1' for a Spaceboot Kick.");
	System.out.println("Damage: between -2 and -6 health");
	System.out.println("Cost: 2 Moonstones \n");
	System.out.println("Enter '2' for a Laser Gun attack.");
	System.out.println("Damage: between -6 and -12 health");
	System.out.println("Cost: 5 Moonstones \n");
	System.out.println("Enter '3' for generating 1 health for 1 moonstone.");
	System.out.println("\n");
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
//System.out.println("Enemy health: " + Enemy_Health);
System.out.println("Player health: " + Player_Health);
System.out.println("Moonstones: " + Moonstone);
System.out.println("\n");
System.out.println("   Enemy Stats");
System.out.println("-----------------");
System.out.println("Enemy health: " + Enemy_Health +"\n");
}

static void Enemy_Generator() throws InterruptedException {

	Thread.sleep(1000);

  Enemy_Health = (int)(Math.random() * ((40 - 10) + 1)) + 10;

	System.out.println("\n");
	System.out.println("!!Enemy apeared!!");
}

static void Player_Damage() {
		Player_Damage = (int)(Math.random() * ((10 - 2) + 1)) + 2;
		Player_Health -= Player_Damage;
		System.out.println("Enemy Attack!: Player -" + Player_Damage + " Health");
}

static void Loot() {
		Moonstone += (int)(Math.random() * ((40 - 19) + 1)) + 40;
		System.out.println("Enemy has dropped " + Moonstone + " Moonstones.");
}

static void Health() {
 Player_Health += 1;
 Moonstone -= 1;
}
}
