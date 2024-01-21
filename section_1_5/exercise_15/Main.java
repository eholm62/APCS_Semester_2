class Main
{
	static double distSqrd(double x, double y, double z, double x1, double y1, double z1)
	{
		return Math.pow(x - x1, 2) + Math.pow(y - y1, 2) + Math.pow(z - z1, 2);
	}
	

	public static void main(String[] args)
	{
		double x = Double.parseDouble(args[0]);
		double y = Double.parseDouble(args[1]);
		double z = Double.parseDouble(args[2]);

		double closeX = -1.0;
		double closeY = -1.0;
		double closeZ = -1.0;

		double shortestDist = Double.MAX_VALUE;
		while (StdIn.hasNextLine())
		{
			double x1 = StdIn.readDouble();
			double y1 = StdIn.readDouble();
			double z1 = StdIn.readDouble();
			StdIn.readLine();

			double dist = distSqrd(x, y, z, x1, y1, z1);
			if (dist < shortestDist) 
			{
				shortestDist = dist;
				closeX = x1;
				closeY = y1;
				closeZ = z1;	
			}
		}

		StdOut.printf("(%.3f, %.3f, %.3f) \n", closeX, closeY, closeZ);
	}
}
