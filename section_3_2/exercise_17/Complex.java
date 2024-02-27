class Complex
{
	private final double real;
	private final double imag;

	public Complex(double real, double imag)
	{
		this.real = real;
		this.imag = imag;
	}

	public Complex add(Complex other)
	{
		return new Complex(this.real + other.real, this.imag + other.imag);
	}

	public Complex subtract(Complex other)
	{
		return new Complex(this.real - other.real, this.imag - other.imag);
	}

	public Complex multiply(Complex other)
	{
		double real = this.real * other.real - this.imag * other.imag;
		double imag = this.real * other.imag + this.imag * other.real;
		return new Complex(real, imag);
	}

	public Complex divide(Complex other)
	{
		double real = (this.real * other.real + this.imag * other.imag) / (other.real * other.real + other.imag * other.imag);
		double imag = (this.imag * other.real - this.real * other.imag) / (other.real * other.real + other.imag * other.imag);
		return new Complex(real, imag);
	}

	public Complex sqrt(double x)
	{
		if (x < 0) return new Complex(0, Math.sqrt(x));
		return new Complex(Math.sqrt(x), 0);	
	}

	public String toString()
	{
		return String.format("(%f + %fi)", real, imag);
	}

	public static void main(String[] args)
	{
		Complex a = new Complex(1, 0);
		Complex b = new Complex(0, 1);
		Complex c = new Complex(1, 1);
		Complex d = new Complex(2, 3);
		Complex e = new Complex(7, 4);

		StdOut.printf("(1 + 0i): %s \n", a);
		StdOut.printf("(0 + 1i): %s \n", b);
		StdOut.printf("(1 + 1i): %s \n", c);
		StdOut.printf("(2 + 3i): %s \n", d);
		StdOut.printf("(7 + 4i): %s \n", e);
		StdOut.println("(1 + 1i): " + a.add(b));
		StdOut.println("(9 + 7i): " + d.add(e));
		StdOut.println("(2 + 29i): " + d.multiply(e));
		StdOut.println("(2 - 1i): " + e.divide(d));
	}
}
