class Rectangle
{
	private final double x, y;
	private final double width;
	private final double height;

	public Rectangle(double x, double y, double width, double height)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public String toString()
	{
		return String.format("Rectangle(%f, %f, %f, %f)", x, y, width, height);
	}

	public double area()
	{
		return width * height;
	}

	public boolean contains(double x, double y)
	{
		if (Math.abs(this.x - x) > width / 2.0)
			return false;
		if (Math.abs(this.y - y) > height / 2.0)
			return false;
		return true;
	}

	public boolean contains(Rectangle other)
	{
		if (!this.contains(other.x + other.height / 2.0, other.y + other.width / 2.0))
			return false;
		if (!this.contains(other.x + other.height / 2.0, other.y - other.width / 2.0))
			return false;
		if (!this.contains(other.x - other.height / 2.0, other.y + other.width / 2.0))
			return false;	
		if (!this.contains(other.x - other.height / 2.0, other.y - other.width / 2.0))
			return false;
		return true;
	}

	public void draw()
	{
		StdDraw.rectangle(this.x, this.y, this.width / 2.0, this.height / 2.0);
	}

	public static void main(String[] args)
	{
		Rectangle a = new Rectangle(0.5, 0.5, 0.5, 0.5);
		Rectangle b = new Rectangle(0.5, 0.5, 0.25, 0.35);
		Rectangle c = new Rectangle(0.5, 0.5, 0.75, 0.85);

		StdOut.println(a);
		StdOut.println(b);
		StdOut.println(c);

		a.draw();
		b.draw();
		c.draw();
	
		StdOut.println(a.contains(b));	// true
		StdOut.println(a.contains(c));	// false
		StdOut.println(c.contains(b));	// true
	}
}
