package minesweeper;

public class Cell {
	public int[] location;
	private boolean isBomb = false;
	private int surroundingBombs = 0;
	private static String defaultCell = "[ ]";
	private String closed = "[ ]";
	private String open = "[ ]";
	
	//constructor
	public Cell(int[] location) {
		this.location = location;
	}
	
	//getters and setters
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

	public String getClosed() {
		return closed;
	}

	public String getOpen() {
		return open;
	}

	public void setOpen(String open) {
		this.open = open;
	}
	
	
	
	//default Cell string --> make property
//	public static String defaultCell() {
//		return "[ ]";
//	}
	
	
}
