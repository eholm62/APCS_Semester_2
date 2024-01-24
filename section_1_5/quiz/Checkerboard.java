import java.awt.Color;

class Checkerboard
{
	public static void main(String[] args)
	{
		final int n = Integer.parseInt(args[0]);

		boolean black = true;
		for (int i = 0; i < n; i++)
		{
			double x = (1.0 / n / 2.0) + (i * 1.0 / n);   

			for (int j = 0; j < n; j++)
			{
				double y = (1.0 / n / 2.0) + (j * 1.0 / n);
				
				if (black) StdDraw.setPenColor(Color.BLACK);
				else StdDraw.setPenColor(Color.RED);
				black = !black;

				StdDraw.filledSquare(x, y, 1.0 / n / 2.0);
			}
			
			if (n % 2 == 0) black = !black;
		}
	}
}
