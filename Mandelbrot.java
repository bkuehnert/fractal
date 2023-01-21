package fractal;

import java.awt.Color;

public class Mandelbrot extends RasterDisplay {

	private static Plottable createMandelbrotPlotter() {
		return (double i, double j, double scale) -> {
  		// TODO: uncomment this when I figure out how to get scale in here
  		// int maxIterations =  (int)Math.round(15*Math.log(1/this.scale));
			int maxIterations = 500;
			float hue = 0.5f;
			double iter = 0;
			double x = 0.0, y = 0.0;
			while (x * x + y * y <= (1 << 16) && iter < maxIterations) {
				double xtemp = x * x - y * y + i;
				y = 2 * x * y + j;
				x = xtemp;
				iter++;
			}

			if (iter < maxIterations) {
				double log_zn = Math.log(x * x + y * y) / 2;
				double nu = Math.log(log_zn / Math.log(2)) / Math.log(2);
				iter = iter + 1 - nu;
			}

			Color c1 = new Color(Color.HSBtoRGB((float) (hue + iter / maxIterations), 0.6f, 1.0f));
			Color c2 = new Color(Color.HSBtoRGB((float) (hue + (iter + 1) / maxIterations), 0.6f, 1.0f));

			return new Color((int) ((c1.getRed() + c2.getRed()) * 0.5), (int) ((c1.getGreen() + c2.getGreen()) * 0.5),
					(int) ((c1.getBlue() + c2.getBlue()) * 0.5));
		};
	}

	public Mandelbrot(int horizontalSize, int verticalSize) {
		super(horizontalSize, verticalSize, createMandelbrotPlotter());
	}

}
