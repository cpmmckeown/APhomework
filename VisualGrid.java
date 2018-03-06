/** The visual grid is 
 * a 2D String array that
 * takes the nGrid as input
 * and converts it to a string 
 * for easy output
 */
public class VisualGrid 
{
	public String[][] grid;
	public String renderString;

	/**This is the constructor; it shapes the initial
	 * VG
	 * @param nG - the reference of this object will be specified
	 * in the main
	 */
	public VisualGrid(NumericalGrid nG) {
		//First, instantiate the visual grid, making it as long and 
		//as broad as the nG 
		this.grid = new String [nG.grid.length] [nG.grid[0].length];
		//loop through the rows
		for(int i=0;i<nG.grid.length;i++) {
			//loop through the elements of each row
			for (int j=0; j<nG.grid[0].length; j++) {
				//if the element in the nG = 0, make an empty space 
				if(nG.grid[i][j] == 0) 
				{
					this.grid[i][j] = "| |";
				}
				//if not, do something else
				else if(nG.grid[i][j] == 1) 
				{
					grid [i][j] = "|o|";
				}
				else if (nG.grid[i][j] == 2) 
				{
					grid [i][j] = "|-|"; 
				}
			}
		}
	}

	/** This allows me to remake the grid without 
	 * having to call the constructor again. 
	 * This helps with the animation process. 
	 * @param numG - this will be specified in the
	 * main loop but it will be the updated mNG 
	 */
	public void setGrid(NumericalGrid nG) 
	{
		this.grid = new String [nG.grid.length] [nG.grid[0].length];
		//loop through the rows
		for(int i=0;i<nG.grid.length;i++) {
			//loop through the elements of each row
			for (int j=0; j<nG.grid[0].length; j++) {
				//if the element in the nG = 0, make an empty space 
				if(nG.grid[i][j] == 0) 
				{
					this.grid[i][j] = "| |";
				}
				//if not, do something else
				else if(nG.grid[i][j] == 1) 
				{
					grid [i][j] = "|o|";
				}
				else if (nG.grid[i][j] == 2) 
				{
					grid [i][j] = "|-|"; 
				}

			}
		}
	}

	/** This simple method just helps with formatting. It just make a line
	 * 
	 * @param length - this parameter allows me to specify the length 
	 * when the method is invoked.
	 * @return
	 */
	private String line(int length) {
		String line = "";
		for (int j=0;j<(length*2.3);j++) {  //2.3 is a strange value but it seemed to provide the most accuracy in the JTextArea
			line += "-";
		}
		line += "\n";
		return line;
	}

	/** I overwrote the toString method to make it 
	 * easy to remember the method name	
	 */
	public String toString() 
	{
		renderString = "";
		renderString += line(grid[0].length);
		// Loop through all rows
		for (int i=0; i<grid.length; i++) {
			// Loop through all elements of current row
			// add to string.
			for (int j = 0; j < grid[i].length; j++) {
				renderString += grid[i][j];
			}
			renderString += "\n";
		}
		renderString += line(grid[0].length);
		return renderString;
	}


}
