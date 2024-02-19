class Point
{
	private final double x;
	private final double y;

	public Point(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	public double distanceTo(Point other)
	{
		double xDiff = other.x - this.x;
		double yDiff = other.y - this.y;
		double radicand = Math.pow(xDiff, 2) + Math.pow(yDiff, 2);
		return Math.sqrt(radicand);
	}

	public String toString()
	{
		return String.format("(%f, %f)", this.x, this.y);
	}

	public static void main(String[] args)
	{
		Point a = new Point(0, 1);
		Point b = new Point(1, 2);
		StdOut.println(a);
		StdOut.println(b);
		StdOut.println(a.distanceTo(b));
	}
}
