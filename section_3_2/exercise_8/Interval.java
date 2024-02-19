class Interval
{
	private final double min;
	private final double max;
	
	public Interval(double min, double max)
	{
		this.min = min;
		this.max = max;
	}

	public boolean contains(double x)
	{
		if (min <= x && max >= x)
			return true;
		return false;
	}

	public boolean intersects(Interval other)
	{
		if (this.contains(other.min) || this.contains(other.max))
			return true;
		if (other.contains(this.min) || other.contains(this.max))
			return true;
		return false;
	}

	public String toString()
	{
		return String.format("[%f, %f]", this.min, this.max);
	}

	public static void main(String[] args)
	{
		Interval a = new Interval(0, 1);
		Interval b = new Interval(-1, 10);
		Interval c = new Interval(-3, -2);
		StdOut.println(a);
		StdOut.println(b);
		StdOut.println(c);
		StdOut.println(a.contains(0.5));	// true
		StdOut.println(a.contains(0.0));	// true
		StdOut.println(a.contains(-1));		// false
		StdOut.println(a.intersects(b));	// true
		StdOut.println(b.intersects(a));	// true
		StdOut.println(c.intersects(b));	// false
	}
}
