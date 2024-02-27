class Rational
{
	private final int numer;
	private final int denom;

	private static int gcd(int p, int q)
	{
		if (q == 0) return p;
		return gcd(q, p % q);
	}

	public Rational simplify()
	{
		int numer = this.numer / gcd(this.denom, this.numer);
		int denom = this.denom / gcd(this.denom, this.numer);
		if (denom < 0)
		{
			numer *= -1;
			denom *= -1;
		}
		return new Rational(numer, denom);
	}

	public Rational(int numer, int denom)
	{
		this.numer = numer;
		this.denom = denom;
	}

	public Rational plus(Rational other)
	{
		int numer = this.numer * other.denom + other.numer * this.denom;
		int denom = this.denom * other.denom;
		return (new Rational(numer, denom)).simplify();
	}

	public Rational minus(Rational other)
	{
		int numer = this.numer * other.denom - other.numer * this.denom;
		int denom = this.denom * other.denom;
		return (new Rational(numer, denom)).simplify();
	}

	public Rational times(Rational other)
	{
		int numer = this.numer * other.numer;
		int denom = this.denom * other.denom;
		return (new Rational(numer, denom)).simplify();
	}

	public Rational divides(Rational other)
	{
		int numer = this.numer * other.denom;
		int denom = this.denom * other.numer;
		return (new Rational(numer, denom)).simplify();
	}

	public Rational neg()
	{
		return new Rational(this.numer * -1, this.denom);
	}

	public Rational recip()
	{
		return (new Rational(this.denom, this.numer)).simplify();
	}

	public String toString()
	{
		return String.format("%d/%d", numer, denom);
	}

	public static void main(String[] args)
	{
		Rational a = new Rational(1, 2);
		Rational b = new Rational(1, 3);
		Rational c = new Rational(2, 7);

		StdOut.println("1/2: " + a);
		StdOut.println("1/3: " + b);
		StdOut.println("2/7: " + c);
		StdOut.println("1/1: " + a.plus(a));
		StdOut.println("0/1: " + a.minus(a));
		StdOut.println("5/6: " + a.plus(b));
		StdOut.println("5/6: " + b.plus(a));
		StdOut.println("1/6: " + a.times(b));
		StdOut.println("1/7: " + a.times(c));
	}
}
