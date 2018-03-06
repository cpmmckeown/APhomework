import java.util.concurrent.ThreadLocalRandom;

/**
 * Constructs a 'vehicle' to cross my intersection. 
 * In reality it just updates the Numerical Grid
 * which influences the render sequence 
 * @author Admin
 *
 */
public class CarEW extends Car implements Runnable
{
	public CarEW (int anIndex, NumericalGrid numG) 
	{
		super(anIndex, numG);	
	}

	public void run()
	{
		int i;
		startPlace = ThreadLocalRandom.current().nextInt(minSP, maxSP +1);
		System.out.println(this+"'s StartPlace is: " + startPlace);

		for (i = 0;i<index;i++) //run 
		{

			try
			{
				laneLock.lock();
				System.out.println(this+" has the lock");
				while (nG.grid[startPlace][(nG.grid[0].length - i)-1] > 0)//while the space ahead isn't empty
				{
					System.out.println(this + " is waiting");
					clearRoad.await();
				}
				System.out.print(this+" has seen the road is clear.");
				if(i-1>0)//test if this isn't the first movement
				{
					nG.grid[startPlace][(nG.grid[0].length - i)+1] = 0;//delete space before
					System.out.println(this +" Deleted previous space");
				}
				else {System.out.println(this + "'s First try; nothing to delete");}
				nG.grid[startPlace][nG.grid[0].length - i] = 2;
				System.out.println(this+" moved a space");
				clearRoad.signalAll();
				Thread.sleep((startPlace+1)*120);
			}
			catch(ArrayIndexOutOfBoundsException|InterruptedException e) {}
			finally 
			{
				laneLock.unlock();
				System.out.println(this+" has released the lock");
			}
		}
		nG.grid[startPlace][nG.grid[0].length - (i-1)] = 0;
	}


}
