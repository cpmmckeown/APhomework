//The numerical grid is the underlying grid that is not shown
//It influences the visual grid. 
public class NumericalGrid {

	//a 2D array
	public  int[][] grid;


	//constructor
	public NumericalGrid(int length, int breadth) 
	{
		grid = new int[length][breadth];
		// Loop through all rows
		for (int i=0; i<grid.length; i++) {
			// Loop through all elements of current row
			for (int j = 0; j < grid[i].length; j++) {
				//make each element 0
				grid[i][j] = 0;  
			}
		}
	}

	public int [][] getGrid(int length, int breadth)
	{
		grid = new int[length][breadth];
		// Loop through all rows
		for (int i=0; i<grid.length; i++) {
			// Loop through all elements of current row
			for (int j = 0; j < grid[i].length; j++) {
				//make each element 0
				grid[i][j] = 0;  
			}
		}
		return grid;

	}


}
