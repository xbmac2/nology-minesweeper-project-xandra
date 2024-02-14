package minesweeper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Game {
	//protected static boolean isWon = false;
	protected static boolean isOver = false;
	public static int rows = 10;
	public static int columns = 10;
	public static int bombs = 10;
	public static int[][] locationsArr;
	public static Cell[] cellsArr;
	public static int openCells = 0;

	//getters and setters
	public static void setLocationsArr(int[][] locationsArr) {
		Game.locationsArr = locationsArr;
	}

	public static void setCellsArr(Cell[] cellsArr) {
		Game.cellsArr = cellsArr;
	}

	//setup, give Game class property that is an array of all cell locations
	protected static int[][] generateCellLocations() {
		int[] [] locationsArr = new int[rows * columns][2];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				locationsArr[i * columns + j] = new int[] {j + 1, i + 1};
			}
		}
		setLocationsArr(locationsArr);
		return locationsArr;
	}
	
	//setup, creates array of cells
	protected static void createCells() {
		Cell[] cellsArr = new Cell[rows * columns];
		for (int i = 0; i < rows * columns; i++) {
			cellsArr[i] = new Cell(locationsArr[i], i);
		}
		setCellsArr(cellsArr);
	}
	
	//setup, sets ten cells to bombs
	//generate random bomb indexes and set them
	protected static void setBombs() {
		ArrayList<Integer> indexesList = new ArrayList<Integer>();
		for (int i = 0; i < 100; i++) indexesList.add(i);
		Collections.shuffle(indexesList);
		for (int i = 0; i < 10; i++) {
			cellsArr[indexesList.get(i)].setBomb(true);
		}
	}
	
	//increments open cells prop
	protected static void incrementOpenCells() {
		Game.openCells += 1;
	}

	
	
	
}
