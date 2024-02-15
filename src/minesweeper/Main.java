package minesweeper;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Grid.printDefaultGrid();
		Game.generateCellLocations();
		Game.createCells();
		
		Game.setBombs();

		for (Cell cell : Game.cellsArr) {
			cell.calculateSurroundingBombs();
		}
		
		Scanner scan = new Scanner(System.in);
		
		while (Game.isOver == false && Game.openCells < 90) {

			System.out.println("Please enter x coordinate");
			int userXCoord = scan.nextInt();

			while (userXCoord > 10 || userXCoord < 0) {
				System.out.println("Please enter a valid x coordinate");
				userXCoord = scan.nextInt();
			}
			
			
			System.out.println("Please enter y coordinate");
			int userYCoord = scan.nextInt();

			while (userYCoord > 10 || userYCoord < 0) {
				System.out.println("Please enter a valid y coordinate");
				userYCoord = scan.nextInt();
			}
			

			int[] userGuess = new int[] {userXCoord, userYCoord};
			
			for (Cell cell : Game.cellsArr) {
				if (Arrays.equals(cell.location, userGuess)) {
					if (cell.isOpen == true) {
						System.out.println("You already opened that cell");
					} else {
						if (cell.isBomb() == true) {
							System.out.println("BOOM!");
							Game.isOver = true;
						} else {
							cell.open();
							Game.incrementOpenCells();
							Grid.printUpdatedGrid();
						}
					}	
				}
			}
			
		}
		if (Game.isOver == true) {
			System.out.println("Game Over");
		}
		
		if (Game.openCells == 90) {
			System.out.println("You avoided all the mines!");
			System.out.println("You win!");
		}

		scan.close();
	}

}
