class Main
{
	public static void main(String[] args)
	{
		StdDraw.setPenRadius(0.0025);
		final double radius = 0.25;

		final int n = Integer.parseInt(args[0]);
		final double p = Double.parseDouble(args[1]);

		double[][] points = new double[n][];

		for (int i = 0; i < n; i++)
		{
			double[] point = Coords.polarToCartesian(radius, 360.0 / n * i);
			points[i] = point;
			StdDraw.point(point[0] + 0.5, point[1] + 0.5);
		}

		for (int i = 0; i < n; i++) 
		{
			for (int j = 0; j < n; j++)
			{
				if (StdRandom.bernoulli(p))
				{
					double x1 = points[i][0] + 0.5;
					double y1 = points[i][1] + 0.5;
					double x2 = points[j][0] + 0.5;
					double y2 = points[j][1] + 0.5;

					StdDraw.line(x1 , y1, x2, y2);
				}
			}
		}
	}
}
