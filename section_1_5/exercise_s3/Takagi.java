class Takagi
{
	static double sawtooth(double n)
	{
		return Math.abs(Math.round(n) - n);
	}

	static double takagi(int n, double x)
	{
		double sum = 0.0;
		for (int i = 0; i <= n; i++)
			sum += 1.0 / Math.pow(2, i) * sawtooth(Math.pow(2, i) * x);
		return sum;
	}
	
	public static void main(String[] args)
	{
		StdDraw.setPenRadius(0.0025);
		
		final int n = (int)Math.pow(2, Integer.parseInt(args[0]));

		double[] prevPoint = new double[] { 0.0, 0.0 };
		for (int i = 1; i <= n; i++)
		{
			double x = (double)i / n;
			double[] point = new double[] { x, takagi(n, x) };
			StdDraw.line(prevPoint[0], prevPoint[1], point[0], point[1]);
			prevPoint = point;
		}
	}
}
