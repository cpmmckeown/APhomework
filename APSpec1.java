public class APSpec1 {

	public static void main(String[] args) 
	{
		final int REPS = 1000;

		NumericalGrid mNG = new NumericalGrid(10, 20);
		VisualGrid mVG = new VisualGrid(mNG);
		Render r = new Render(mVG, mNG, REPS);  //This should just make an empty JFrame that runs for the set reps time. 
		CarNS cNS = new CarNS(mNG.grid.length, mNG);
		CarEW cEW = new CarEW(mNG.grid[0].length, mNG);
		InitCars iC = new InitCars(cNS, cEW, mNG);
		Thread render = new Thread(r);
		render.start();
		Thread cars = new Thread (iC);
		cars.start();
	}

}
