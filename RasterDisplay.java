package fractal;

import java.awt.Graphics;

public class RasterDisplay extends Display {

	private Plottable plotter;

	public RasterDisplay(int horizontalSize, int verticalSize, Plottable plotter) {
		super(horizontalSize, verticalSize);
		this.plotter = plotter;
	}

	@Override
	public void paint(Graphics g) {
		double i = this.xLoc;
		double j = this.yLoc;
		for (int Px = 0; Px < this.HORIZONTAL_SIZE; Px++) {
			for (int Py = 0; Py < this.VERITCAL_SIZE; Py++) {
				g.setColor(plotter.plotPixel(i, j, scale));
				g.drawRect(Px, Py, 1, 1);
				j += this.scale;
			}
			i += this.scale;
			j = this.yLoc;
		}
	}
}
