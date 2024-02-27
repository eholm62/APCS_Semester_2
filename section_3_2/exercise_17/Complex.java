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

	public static Complex sqrt(double x)
	{
		if (x < 0) return new Complex(0, Math.sqrt(-x));
		return new Complex(Math.sqrt(x), 0);	
	}

	public String toString()
	{
		if (this.imag < 0)
			return String.format("(%f - %fi)", real, -imag);
		return String.format("(%f + %fi)", real, imag);
	}

	public static void main(String[] args)
	{
		final double a = Double.parseDouble(args[0]);
		final double b = Double.parseDouble(args[1]);
		final double c = Double.parseDouble(args[2]);

		double discriminant = b * b - 4 * a * c;
		Complex solution1 = ((new Complex(-b, 0)).add(sqrt(discriminant))).divide(new Complex(2 * a, 0));
		Complex solution2 = ((new Complex(-b, 0)).subtract(sqrt(discriminant))).divide(new Complex(2 * a, 0));

		StdOut.println(solution1 + " " + solution2);
		
	}
}
