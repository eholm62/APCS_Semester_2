import java.awt.Color;

class Main
{
	public static void main(String[] args)
	{
		StdDraw.setPenRadius(0.0025);

		final int n = Integer.parseInt(args[0]);	// number of circles
		final double p = Double.parseDouble(args[1]); 	// probability each circle is black rather than white
		final double minRadius = Double.parseDouble(args[2]);
		final double maxRadius = Double.parseDouble(args[3]);

		for (int i = 0; i < n; i++)
		{
			if (StdRandom.bernoulli(p)) StdDraw.setPenColor(Color.BLACK);
			else StdDraw.setPenColor(Color.WHITE);

			double x = StdRandom.uniform(0.0, 1.0);
			double y = StdRandom.uniform(0.0, 1.0);
			double radius = StdRandom.uniform(minRadius, maxRadius);

			StdDraw.filledCircle(x, y, radius);
		}
	}
}
