public class DrunkenTurtles
{
	public static void main(String[] args)
	{
		int n = Integer.parseInt(args[0]); // number of turtles
		int trials = Integer.parseInt(args[1]); // number of steps
		double step = Double.parseDouble(args[2]); // step size
		Turtle[] turtles = new Turtle[n];
		for (int i = 0; i < n; i++)
		{
			double x = StdRandom.uniform(0.0, 1.0);
			double y = StdRandom.uniform(0.0, 1.0);
			turtles[i] = new Turtle(x, y, 0.0);
		}
		for (int t = 0; t < trials; t++)
		{ // All turtles take one step.
			for (int i = 0; i < n; i++)
			{ // Turtle i takes one step in a random direction.
				Turtle turtle = turtles[i];
				turtle.turnLeft(StdRandom.uniform(0.0, 360.0));
				turtle.goForward(step);
				if (turtle.getX() < 0 || turtle.getX() > 1 || turtle.getY() < 0 || turtle.getY() > 1) {
					turtle.turnLeft(180);
					turtle.goForward(step);
				}
			}
		}
	}
}
