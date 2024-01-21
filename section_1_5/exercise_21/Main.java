class Main
{
	public static void main(String[] args)
	{
		StdDraw.setPenRadius(0.0025);
		
		final int n = Integer.parseInt(args[0]);

		double[] prevPoint = new double[] { 0.5, 0.5 };
		for (double theta = 1.0; theta < 360.0; theta += 1.0)
		{
			double[] point = Coords.polarToCartesian(Math.sin(n * Math.toRadians(theta)), theta);
			point[0] = point[0] / 4 + 0.5;
			point[1] = point[1] / 4 + 0.5;
			StdDraw.line(point[0], point[1], prevPoint[0], prevPoint[1]);
			prevPoint = point;
		}

		StdDraw.line(prevPoint[0], prevPoint[1], 0.5, 0.5);
	}
}
