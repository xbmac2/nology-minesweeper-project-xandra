package minesweeper;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Grid.printDefaultGrid();
		Game.generateCellLocations();
		//System.out.println(Arrays.deepToString(Game.locationsArr));
		Game.createCells();
		//System.out.println(Arrays.toString(Game.cellsArr[0])); returns Cell object
		
		Game.setBombs();
		
		//while loop
		while (Game.isOver == false && Game.openCells < 90) {
			Scanner scan = new Scanner(System.in);
			System.out.println("Please enter x coordinate");
			int userXCoord = scan.nextInt();
			System.out.println("Please enter y coordinate");
			int userYCoord = scan.nextInt();
			int[] userGuess = new int[] {userXCoord, userYCoord};
			
			for (Cell cell : Game.cellsArr) {
				//System.out.println("in for loop");
				//System.out.println(Arrays.toString(cell.location));
				//System.out.println(Arrays.toString(userGuess));
				if (Arrays.equals(cell.location, userGuess)) {
					System.out.println("guesss and lloca euals");
					System.out.println(cell.isBomb());
					if (cell.isBomb() == true) {
						System.out.println("BOOM!");
						Game.isOver = true;
						//set game status to game over
					} else {
						//open the cell
						//increment open cells
						Game.incrementOpenCells();
						System.out.println("not bomb");
						System.out.println(Game.openCells);
						//print new grid to screen
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
		
		System.out.println("Want to play again?");
		
		
	}

}
