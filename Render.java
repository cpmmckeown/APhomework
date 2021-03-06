/** a much simpler Render class for debugging */
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Render implements Runnable{
	int count; //this should set the program to run 2000 times. 
	VisualGrid vG;
	NumericalGrid nG;
	JTextArea jL;
	JFrame frame = new JFrame("intersection");

	/** The purpose of Render is to take 
	 * the Visual Grid generated by VG
	 * a print it as a String.
	 */
	Render(VisualGrid visGrid, NumericalGrid numGrid,int aCount)
	{
		vG = visGrid;
		nG = numGrid;
		count = aCount;
		makeFrame();
	}

	private void makeFrame() 
	{
		jL = new JTextArea(vG.toString());
		frame.addWindowListener((WindowListener) new WindowAdapter(){public void windowClosing(WindowEvent e){System.exit(0);}});
		frame.setContentPane(jL);
		frame.pack();
		frame.setVisible(true);
	}

	//making the run method
	public void run()
	{
		for (int i=0;i<count;i++)
		{
			try 
			{
				vG.setGrid(nG); //This will update the visual grid based on any changes to the numerical grid.
				jL = new JTextArea(vG.toString());
				frame.setContentPane(jL);
				frame.pack();
				Thread.sleep(20);
			}
			catch(InterruptedException e){}
		}
		System.exit(0);
	}

}