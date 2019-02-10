import java.awt.*;

import javax.swing.*;

public class Display extends JPanel
{
	public int iterations;
	public double zoom;
	public double locX;
	public double locY;
	public float hue;
	
	
	public Display()
	{
		this.setPreferredSize(new Dimension(VAR.DISPLAY_WIDTH, VAR.DISPLAY_HEIGHT));
		iterations = 100;
		zoom = 1;
		locX = 1;
		locY = 1.2;
		hue = 0.5f;
	}
	
	
	
	double n = 1000;
	double m = 1000;
	
	public void paint(Graphics g)
	{

		int Px = 0, Py=0;
		for(double i = locX/zoom; i >= (locX-3)/zoom; i-=2.0/(n*zoom), Px++)
		{
			for(double j = locY/zoom; j >= (locY-2.4)/zoom; j-=2.0/(m*zoom), Py++)
			{
				/*
				//https://stackoverflow.com/questions/369438/smooth-spectrum-for-mandelbrot-set-rendering
				double threshhold = Fractal.mandelbrot(new Complex(i,j), iterations);
				
				double smoothcolor = (iterations + 1 - Math.log(Math.log(threshhold)/Math.log(iterations))/Math.log(2))/iterations;
				
				//System.out.println(smoothcolor);
				g.setColor(new Color((int) (0.95f + 10 * Color.HSBtoRGB((float) (smoothcolor), 0.6f, 1.0f))));
				g.fillRect(x, y, 1, 1);
	
				//System.out.printf("(%f,%f): ", i,j);
				//System.out.print(Fractal.mandelbrot(new Complex(i,j), 40));
				//System.out.println();
				 
				 */
				
				double iteration = 0;
				int max_iteration = iterations;
				double x = 0.0, y = 0.0;
				while(x*x + y*y <= (1<<16) && iteration < max_iteration) {
					double xtemp = x*x - y*y + i;
					y = 2*x*y + j;
					x = xtemp;
					iteration++;
				}
				
				if(iteration < max_iteration) {
					double log_zn = Math.log(x*x + y*y)/2;
					double nu = Math.log(log_zn / Math.log(2)) / Math.log(2);
					iteration = iteration + 1 - nu;
				}
				
				//System.out.println(iteration);
				Color color1 = new Color(Color.HSBtoRGB( (float) (hue + iteration/max_iteration), 0.6f, 1.0f));
				Color color2 = new Color(Color.HSBtoRGB( (float) (hue + (iteration+1)/max_iteration), 0.6f, 1.0f));
				//System.out.println(iteration % 1);
				g.setColor(interpolate(color1, color2, (float) (iteration % 1)));
	
	
				g.fillRect(Px, Py, 1, 1);
				
			}
			Py=0;
		}	

	}
	
	Color interpolate(Color c1, Color c2, double frac)
	{
		return new Color((int)((c1.getRed()+c2.getRed())*0.5),(int)((c1.getGreen()+c2.getGreen())*0.5),(int)((c1.getBlue()+c2.getBlue())*0.5));
	}
	
}
