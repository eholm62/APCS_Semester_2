import java.awt.Color;

class PolarCoordinateFunctions
{
	static void quadratic()
	{
		double[] prevPoint = new double[] { 1296, -37.0 };
		for (double theta = -36.0; theta < 36.0; theta += 0.1)
		{
			double r = theta * theta;
			double[] prevPointCartesian = Coords.polarToCartesian(prevPoint[0], prevPoint[1]);
			double[] pointCartesian = Coords.polarToCartesian(r, theta);
			StdDraw.line(prevPointCartesian[0], prevPointCartesian[1], pointCartesian[0], pointCartesian[1]);
			prevPoint = new double[] { r, theta };
		}
	}
	
	public static void main(String[] args)
	{
		StdDraw.setXscale(-0.01, 0.01);
		StdDraw.setYscale(-0.01, 0.01);
		StdDraw.setPenRadius(0.0025);
		
		boolean exit = false;
		while (!exit)
		{
			String command = StdIn.readLine();

			switch (command)
			{
				case "quadratic":
					StdDraw.clear(Color.WHITE);
					quadratic();
					break;
				case "exit":
					exit = true;
					break;
			}
		}
	}
}
