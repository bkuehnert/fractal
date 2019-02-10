
public class Complex 
{
	private double real;
	private double imaginary;
	
	public Complex(double r, double i)
	{
		real = r;
		imaginary = i;
	}
	
	public double getReal() 
	{
		return real;
	}

	public void setReal(double real) 
	{
		this.real = real;
	}

	public double getImaginary() 
	{
		return imaginary;
	}

	public void setImaginary(double imaginary) 
	{
		this.imaginary = imaginary;
	}
	
	static Complex addComp(Complex a, Complex b)
	{
		return new Complex(a.real+b.real, a.imaginary+b.imaginary);
	}
	
	static Complex powComp(Complex a, int pow)
	{
		return powComp_h(a, a, pow);
	}
	
	static Complex powComp_h(Complex a, Complex o, int pow)
	{
		if(pow == 1) return a;
		if(pow == 0) return new Complex(1,0);
		return powComp_h(new Complex(a.real*o.real - a.imaginary*o.imaginary, a.real*o.imaginary + a.imaginary*o.real), o, pow-1);
	}
	
	static double normComp(Complex a)
	{
		return Math.sqrt(Math.pow(a.real, 2) + Math.pow(a.imaginary, 2));
	}
	
	public String toString()
	{
		return ("(" + this.real + "," + this.imaginary + ")");
	}
}
