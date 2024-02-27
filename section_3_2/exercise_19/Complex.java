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

	public Complex minus(Complex other)
	{
		return new Complex(this.real - other.real, this.imag - other.imag);
	}

	public Complex multiply(Complex other)
	{
		double real = this.real * other.real - this.imag * other.imag;
		double imag = this.real * other.imag + this.imag * other.real;
		return new Complex(real, imag);
	}

	public Complex divides(Complex other)
	{
		double real = (this.real * other.real + this.imag * other.imag) / (other.real * other.real + other.imag * other.imag);
		double imag = (this.imag * other.real - this.real * other.imag) / (other.real * other.real + other.imag * other.imag);
		return new Complex(real, imag);
	}

	public double theta()
	{
		return Math.atan(this.imag / this.real);
	}

	public Complex conjugate()
	{
		return new Complex(this.real, -this.imag);
	}

	public Complex power(int b)
	{
		Complex product = new Complex(this.real, this.imag);
		for (int i = 1; i < b; i++)
			product = product.multiply(this);
		return product;
	}

	public String toString()
	{
		if (this.imag < 0)
			return String.format("(%f - %fi)", real, -imag);
		return String.format("(%f + %fi)", real, imag);
	}

	public static void main(String[] args)
	{
		Complex a = new Complex(1, 1);
		Complex b = new Complex(2, 3);
		Complex c = new Complex(7, 4);

		StdOut.println("(1 + 1i): " + a);
		StdOut.println("(2 + 3i): " + b);
		StdOut.println("(7 + 4i): " + c);
		StdOut.println("0.78539816339: " + a.theta());
		StdOut.println("(5 + 1i): " + c.minus(b));
		StdOut.println("(1 - 1i): " + a.conjugate());
		StdOut.println("(2 - 1i): " + c.divides(b));
		StdOut.println("(7 + 525i): " + c.power(3));
	}
}
