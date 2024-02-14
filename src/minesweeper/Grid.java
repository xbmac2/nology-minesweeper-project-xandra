package minesweeper;

import java.util.Arrays;

public class Grid {
	public static String gridTopCoords = "    1  2  3  4  5  6  7  8  9  10  ";
	public static int rows = 10;
	
	
	public static void printDefaultRow() {
		for (int i = 0; i < rows - 1; i++) {
			System.out.print(Cell.getDefaultCell());
		}
		System.out.print(Cell.getDefaultCell() + "\n");
	}
	
	public static void printDefaultGrid() {
		System.out.println(Grid.gridTopCoords);
		
		for (int i = 0; i < rows - 1; i++) {
			System.out.print(i + 1 + "  ");
			Grid.printDefaultRow();
		}
		System.out.print(rows + " ");
		Grid.printDefaultRow();
	}
	
	//print updated state after every move
	public static void printUpdatedGrid() {
		System.out.println(Grid.gridTopCoords);
		//for 9 rows
		int startInd = 0;
		int endInd = 10;

		for (int i = 0; i < rows - 1; i++) {

			System.out.print(i + 1 + "  ");

			//print a row
			Cell[] rowOfCells = Arrays.stream(Game.cellsArr, startInd, endInd).toArray(Cell[]::new);
			for (Cell cell : rowOfCells) {
				System.out.print(cell.visual);
			}
			System.out.print("\n");
			startInd += 10;
			endInd += 10;
		}
		//printing row 10
		System.out.print(rows + " ");
		Cell[] rowOfCells = Arrays.stream(Game.cellsArr, 90, 100).toArray(Cell[]::new);
		for (Cell cell : rowOfCells) {
			System.out.print(cell.visual);
		}
		System.out.print("\n");
	}
}
