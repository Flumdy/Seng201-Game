package main;

import java.util.ArrayList;
import java.util.Scanner;

import supers.CrewMember;

public class GameEnviroment {
	int gameDays;
	int shipPieces;
	int crewMemeberCount;
	ArrayList crewMembers;
	
	public static void main(String args[]) {
		System.out.println("Welcome to the game bby");
		GameEnviroment game = new GameEnviroment();
		game.init();
	}

	public void init() {
		ArrayList<CrewMember> crewMemebers = new ArrayList<>();
		//this is for selecting charecters and lenght
		Scanner scanner = new Scanner(System.in);
		System.out.println("How many days should the game last for?");
		gameDays = scanner.nextInt();
		shipPieces = Math.round((gameDays*2)/3);
		System.out.println("How many crew memebers do you want?");
		crewMemeberCount = scanner.nextInt();
		for(int i = 0; i <= crewMemeberCount; i++) {
			System.out.println("Name for your crew memeber? ");
			String name = scanner.nextLine();
			CrewMember crewMemeber = new CrewMember(name, "Scout");
			crewMembers.add(crewMemeber);
		}
		System.out.println(crewMemebers);
	}
	
	public void gameday() {
		//each gameday this loop is called
		
	}
}
