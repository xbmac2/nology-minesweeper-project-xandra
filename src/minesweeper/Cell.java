package minesweeper;

import java.util.ArrayList;

public class Cell {
	public int[] location;
	public int index;
	private boolean isBomb = false;
	private int surroundingBombs = 0;
	private static String defaultCell = "[ ]";
	boolean isOpen = false;
	
	public String visual = "[ ]";
	
	//constructor
	public Cell(int[] location, int index) {
		this.location = location;
		this.index = index;
	}
	
	//getters and setters
	public void setIndex(int index) {
		this.index = index;
	}
	
	public int[] getLocation() {
		return location;
	}


	public void setLocation(int[] location) {
		this.location = location;
	}
	public boolean isBomb() {
		return isBomb;
	}
	public void setBomb(boolean isBomb) {
		this.isBomb = isBomb;
	}
	public int getSurroundingBombs() {
		return surroundingBombs;
	}
	public void setSurroundingBombs(int surroundingBombs) {
		this.surroundingBombs = surroundingBombs;
	}

	public static String getDefaultCell() {
		return defaultCell;
	}

	public void setVisual(String visual) {
		this.visual = visual;
	}
	
	// method that opens cell and changes their visual for the re-print of grid
	public void open() {
		this.isOpen = true;
		String numberedVisual = String.format("[%s]", this.surroundingBombs);
		//this.setVisual("[o]");
		this.setVisual(numberedVisual);
	}	
	
	// method to calculate surrounding bombs; and then set surrounding bombs
	public void calculateSurroundingBombs() {
		ArrayList<Integer> arrlist = new ArrayList<Integer>(1);
		int bombCount = 0;
		
		//top row
		if (this.index > 0 && this.index < 9) {
			arrlist.add(this.index + 1);
		    arrlist.add(this.index + 11);
		    arrlist.add(this.index + 10);
		    arrlist.add(this.index + 9);
		    arrlist.add(this.index - 1);
		} else if (this.index > 90 && this.index < 99) {
			//bottom row
			arrlist.add(this.index - 1);
		    arrlist.add(this.index - 11);
		    arrlist.add(this.index - 10);
		    arrlist.add(this.index - 9);
		    arrlist.add(this.index + 1);
		} else if (this.index > 0 && this.index < 90 && this.index % 10 == 0) {
			//left col
			arrlist.add(this.index - 10);
		    arrlist.add(this.index - 9);
		    arrlist.add(this.index + 1);
		    arrlist.add(this.index + 11);
		    arrlist.add(this.index + 10);
		} else if (this.index > 9 && this.index < 99 && this.index % 10 == 9) {
			//right col
			arrlist.add(this.index - 10);
		    arrlist.add(this.index - 11);
		    arrlist.add(this.index - 1);
		    arrlist.add(this.index + 9);
		    arrlist.add(this.index + 10);
		} else if (this.index == 0) {
			//topleft corner
		    arrlist.add(this.index + 1);
		    arrlist.add(this.index + 11);
		    arrlist.add(this.index + 10);
		} else if (this.index == 9) {
			//topright corner
			arrlist.add(this.index - 1);
		    arrlist.add(this.index + 9);
		    arrlist.add(this.index + 10);
		} else if (this.index == 90) {
			//bottomleft corner
			arrlist.add(this.index - 10);
		    arrlist.add(this.index - 9);
		    arrlist.add(this.index + 1);
		} else if (this.index == 99) {
			//bottomright corner
			arrlist.add(this.index - 1);
		    arrlist.add(this.index - 11);
		    arrlist.add(this.index - 10);
		} else {
			//every other cell
			arrlist.add(this.index - 10);
		    arrlist.add(this.index - 9);
		    arrlist.add(this.index + 1);
		    arrlist.add(this.index + 11);
		    arrlist.add(this.index + 10);
		    arrlist.add(this.index - 11);
		    arrlist.add(this.index - 1);
		    arrlist.add(this.index + 9);
		}
		//make arraylist of Integer int[]
		int[] indexesToCheck = arrlist.stream().mapToInt(i -> i).toArray();
		
		//loop over indexes to check and tally bombCount
		for (int index : indexesToCheck) {
			if (Game.cellsArr[index].isBomb == true) bombCount += 1;
		}
		
		this.setSurroundingBombs(bombCount);

	}
}
