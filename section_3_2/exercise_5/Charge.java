// the mistake in the following code is that
// rx, ry, and q are declared again in the constructor
public class Charge
{
	private double rx, ry; // position
	private double q; // charge
	public Charge(double x0, double y0, double q0)
	{
		double rx = x0;
		double ry = y0;
		double q = q0;
	}
}
