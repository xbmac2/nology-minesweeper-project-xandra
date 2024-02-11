package minesweeper;

public class Grid {
	public static String gridTopCoords = "    1  2  3  4  5  6  7  8  9  10  ";
	public static int rows = 10;
	public String defaultRow;
	
	
	//prints 11 so fix this
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
}
