
public class InitCars implements Runnable{

	CarNS carsNS;
	CarEW carsEW;
	int numberOfCars;

	public InitCars(CarNS cNS, CarEW cEW, NumericalGrid nG)
	{
		numberOfCars = nG.grid.length;
		carsNS = cNS;
		carsEW = cEW;
		
	}	

	public void run()
	{
		try
		{
		for (int i = 0;i<1;i++)
		{
			Thread c0 = new Thread(carsNS);
			Thread c2 = new Thread(carsEW);
			c0.start();
			c2.start();
			Thread.sleep(1000);
		}
		}
		catch (InterruptedException e){}
	}

}
