class Test
{
	// look at https://www.desmos.com/calculator/qzqbb3jks3 for reference
	static double curve(double x)
	{
		double fx = -1.0 / (1.0 + Math.pow(Math.E, 7.0 * (x - 0.6))) + 1.0;
		double fk = 0.0147740316933;
		return (fx - fk) * (1.0 / (1 - fk));
	}

	public static void main(String[] args)
	{
		final int n = Integer.parseInt(args[0]);
		
		StdDraw.setPenRadius(0.0025);

		double[] prevPoint = new double[] { 0.0, curve(0.0) };
		for (int i = 1; i <= n; i++)
		{
			double x = i * 1.0 / n;
			double y = curve(x);
			StdDraw.line(prevPoint[0], prevPoint[1], x, y);
			prevPoint[0] = x;
			prevPoint[1] = y;
		}
	}
}
