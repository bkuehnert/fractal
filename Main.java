import java.awt.*;
import javax.swing.*;

public class Main 
{
	public static void main(String[] args)
	{

		JFrame frame = new JFrame("Fractals");
		frame.setSize(new Dimension(VAR.TOTAL_WIDTH, VAR.DISPLAY_HEIGHT));
		Display d = new Display();
		frame.add(d, BorderLayout.WEST);
		
		frame.add(new Control(d), BorderLayout.EAST);
		

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setVisible(true);
		
	}
	

}
