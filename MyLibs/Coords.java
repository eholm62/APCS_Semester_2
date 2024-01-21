class Coords
{
	public static double[] polarToCartesian(double r, double theta)
	{
		double x = Math.cos(Math.toRadians(theta)) * r;
		double y = Math.sin(Math.toRadians(theta)) * r;

		return new double[] { x, y };
	}
}
