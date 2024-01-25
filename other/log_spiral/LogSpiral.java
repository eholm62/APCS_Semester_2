class LogSpiral
{
	static double[] stepTowards(double[] point1, double[] point2, int n)
	{
		double x = point1[0] + (point2[0] - point1[0]) / n;
		double y = point1[1] + (point2[1] - point1[1]) / n;
		return new double[] { x, y };
	}

	public static void main(String[] args)
	{
		StdDraw.setXscale(-1.0, 1.0);
		StdDraw.setYscale(-1.0, 1.0);
		StdDraw.setPenRadius(0.0025);

		final int unit = 9;
		final double radius = 0.75;
		final int n = Integer.parseInt(args[0]);
		final int iterations = Integer.parseInt(args[1]);

		double[][] mice = new double[n][];
		double[] prevPoint = new double[] { radius, 0.0 };
		for (int i = 1; i <= n; i++)
		{
			double[] point = Coords.polarToCartesian(radius, 360.0 / n * i);
			mice[i - 1] = point;
			StdDraw.line(point[0], point[1], prevPoint[0], prevPoint[1]);
			prevPoint = point;
		}

		for (int j = 0; j < iterations; j++)
		{
			double[] prevMouse = mice[0];
			for (int i = n - 1; i >= 0; i--)
			{
				double[] point = stepTowards(mice[i], prevMouse, unit);
				StdDraw.line(point[0], point[1], mice[i][0], mice[i][1]);
				StdDraw.line(prevMouse[0], prevMouse[1], mice[i][0], mice[i][1]);
				prevMouse = mice[i];
				mice[i] = point;
			}
		}
		
		if (args.length > 2) 
			StdDraw.save(args[2]);

		StdOut.println("Done");
	}
}
