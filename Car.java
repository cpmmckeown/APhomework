import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Constructs a 'vehicle' in an abstract sense
 * @author Admin
 *
 */
public class Car 
{

	protected NumericalGrid nG;
	protected int index;
	protected int startPlace;
	protected final int minSP = 0; //The minimum start place value is equal to 0 (i.e. the lowest position on the grid). 
	protected int maxSP;
	protected ReentrantLock laneLock;
	protected Condition clearRoad;
	/**
	 * Constructs 
	 * @param numG the numerical grid to manipulate
	 * @param index - where the grid will be updated first. 
	 */

	protected Car (int anIndex, NumericalGrid numG) 
	{
		laneLock = new ReentrantLock();
		clearRoad = laneLock.newCondition();
		index = anIndex;
		nG = numG;
		maxSP = numG.grid.length; //The maximum start place value is = to the maximum value of the grid.
	}



}
