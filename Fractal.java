public class Fractal 
{

	static double mandelbrot(Complex c, int iter)
	{
		return Complex.normComp(mandelbrot_h(c, c, iter));
	}
	
	static Complex mandelbrot_h(Complex z, Complex c, int iter)
	{
		if(iter == 0) return z;
		return mandelbrot_h(Complex.addComp(Complex.powComp(z, 2), c) ,c, iter-1);
	}
	
}
