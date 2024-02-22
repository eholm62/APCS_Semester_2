class Rectangle
{
	private final double x, y;
	private final double width;
	private final double height;

	// expects x and y of lower left corner, stores x and y of middle
	public Rectangle(double x, double y, double width, double height)
	{
		this.x = x + width / 2.0;
		this.y = y + height / 2.0;
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

	public double perimeter()
	{
		return width * 2 + height * 2;
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

	static int i;

	public static void main(String[] args)
	{
		int n = Integer.parseInt(args[0]);
		double min = Double.parseDouble(args[1]);
		double max = Double.parseDouble(args[2]);

		StdDraw.setXscale(-1.0, 1.0);
		StdDraw.setYscale(-1.0, 1.0);

		double sumAreas = 0.0;
		double sumPerimeters = 0.0;
		Rectangle[] rectangles = new Rectangle[n];
		i = 0;
		
		new Thread(() -> {
			while (i < n)
			{
				StdOut.println(i);
			}
		}).start();

		while (i < n)
		{
			double width = min + Math.random() * (max - min);
			double height = min + Math.random() * (max - min);
			Rectangle rectangle = new Rectangle(0.0, 0.0, width, height);
			rectangles[i] = rectangle;
			sumAreas += rectangle.area();
			sumPerimeters += rectangle.perimeter();
			rectangle.draw();
			i++;
		}
	
		StdOut.printf("Average area: %f \n", sumAreas / n);
		StdOut.printf("Average perimeter: %f \n", sumPerimeters / n);
	}
}
