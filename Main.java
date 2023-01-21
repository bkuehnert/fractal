package fractal;

import java.awt.FlowLayout;
import javax.swing.JFrame;

public class Main {

	private static void createAndShowGUI() {
		final JFrame frame = new JFrame("Ex");

		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().setLayout(new FlowLayout());
		frame.setResizable(false);

		frame.getContentPane().add(new Mandelbrot(500, 500));

	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();

			}
		});
	}
}
