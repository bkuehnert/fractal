package fractal;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Display extends JPanel {

	public final int HORIZONTAL_SIZE;
	public final int VERITCAL_SIZE;

	// The real x coordinate of the top left corner
	protected double xLoc;
	// The real y coordinate of the top right corner
	protected double yLoc;
	// The (real) length of a single pixel
	public double scale;
	// For mouse drags, this variable tracks the last point at which the mouse was
	// seen.
	private Point dragOrigin;

	public Display(int horizontalSize, int verticalSize) {
		this.HORIZONTAL_SIZE = horizontalSize;
		this.VERITCAL_SIZE = verticalSize;
		this.setPreferredSize(new Dimension(this.HORIZONTAL_SIZE, this.VERITCAL_SIZE));

		this.xLoc = -2;
		this.yLoc = -1.1;
		this.scale = 0.005;

		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				dragOrigin = e.getPoint();
			}
		});
		this.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int dx = e.getX() - dragOrigin.x;
				int dy = e.getY() - dragOrigin.y;
				xLoc = xLoc - dx * scale;
				yLoc = yLoc - dy * scale;
				dragOrigin = e.getPoint();
				repaint();
			}
		});
		this.addMouseWheelListener(new MouseAdapter() {
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				// TODO FIX THIS TO BE MULTIPLATFORM
				double ratio = -0.5f * e.getPreciseWheelRotation();
				double scaleChange = -scale * ratio;
				xLoc = xLoc - e.getX() * scaleChange;
				yLoc = yLoc - e.getY() * scaleChange;
				scale += scaleChange;
				repaint();
			}
		});
	}
}
