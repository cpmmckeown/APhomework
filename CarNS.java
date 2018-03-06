import java.util.concurrent.ThreadLocalRandom;

/**
 * Constructs a 'vehicle' to cross my intersection. 
 * In reality it just updates the Numerical Grid
 * which influences the render sequence 
 * @author Admin
 *
 */
public class CarNS extends Car implements Runnable
{
	protected CarNS(int anIndex, NumericalGrid numG) 
	{
		super(anIndex, numG);
	}

	public void run()
	{
		
		int i;	
		startPlace = ThreadLocalRandom.current().nextInt(minSP, maxSP +1);
		startPlace = 0;
		System.out.println(this+"'s StartPlace is: "+ startPlace);

		for (i = 0;i<index+1;i++)//Each movement the car makes is part of a for loop
		{
			//The car will try to first,
			try
			{
				laneLock.lock(); //pickup the lock.
				System.out.println(this+" has the lock");
				//This is causing issues because it tries to check the condition of a non-existent space!!!!
				while (nG.grid[i+1][startPlace] > 0)//While the space ahead (i+1) isn't empty
				{
					System.out.println(this +" is waiting");
					clearRoad.await(); //The car will wait
				}
				System.out.print(this+" has seen the road is clear.");
				if(i-1>=0)//test if this isn't the first movement
				{
					nG.grid[i-1][startPlace] = 0; //if that's the case, it will delete it's old mark on the grid. 
					System.out.println(this+" deleted previous space");
				}
				else {System.out.println(this+"'s first try; nothing to delete");}
				nG.grid[i][startPlace] = 1; //Once it clears, it will write to the space
				System.out.println(this+" moved a space");
				clearRoad.signalAll();
				Thread.sleep((startPlace+1)*120); //wait
			}
			
			catch(InterruptedException|ArrayIndexOutOfBoundsException e) {}
			finally 
			{
				laneLock.unlock();
				System.out.println(this+" has released lock");
			}
			
		}
		nG.grid[i-2][startPlace] = 0;
	}


}
