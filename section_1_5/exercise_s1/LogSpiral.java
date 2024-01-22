class LogSpiral
{
	static double[] stepTowards(double[] point1, double[] point2, double percentage)
	{
		double x = point1[0] + (point2[0] - point1[0]) * percentage;
		double y = point1[1] + (point2[1] - point2[1]) * percentage;
		return new double[] { x, y };
	}
	
	public static void main(String[] args)
	{
		StdDraw.setXscale(-1.0, 1.0);
		StdDraw.setYscale(-1.0, 1.0);
		StdDraw.setPenRadius(0.0025);
		
		final double percentage = 0.01;
		final double radius = 0.75;
		final int n = Integer.parseInt(args[0]);

		double[][] mice = new double[n][];
		double[] prevPoint = new double[] { radius, 0.0 };
		for (int i = 1; i <= n; i++)
		{
			double[] point = Coords.polarToCartesian(radius, 360.0 / n * i);
			mice[i - 1] = point;
			StdDraw.line(point[0], point[1], prevPoint[0], prevPoint[1]);
			prevPoint = point;
		}

		
		double[][] newMice = new double[n][];
		while (true) 
		{
			int prevMouseI = n - 1;
			for (int i = 0; i < n; i++)
			{
				newMice[i] = stepTowards(mice[prevMouseI], mice[i], percentage);
				prevMouseI = i;
			}

			for (int i = 0; i < n; i++)
				StdDraw.line(mice[i][0], mice[i][1], newMice[i][0], newMice[i][1]);

			mice = newMice;
		}
			
	}
}
