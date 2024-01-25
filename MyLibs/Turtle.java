import java.awt.Color;

class Turtle
{
	double x;
	double y;
	double angle;
	boolean isUp;
	
	Color color;
	Draw screen;

	public Turtle()
	{
		this.x = 0.0;
		this.y = 0.0;
		this.angle = 0.0;
		this.isUp = false;
		this.color = Color.BLACK;
		
		this.screen = new Draw();
	}

	public Turtle(double x, double y)
	{
		this.x = x;
		this.y = y;
		
		this.angle = 0.0;
		this.isUp = false;
		this.color = Color.BLACK;

		this.screen = new Draw();
	}

	public Turtle(double x, double y, double angle)
	{
		this.x = x;
		this.y = y;
		this.angle = angle;

		this.isUp = false;
		this.Color = Color.BLACK;

		this.screen = new Draw();
	}

	public Turtle(double x, double y, double anglee, Color color)
	{
		this.x = x;
		this.y = y;
		this.angle = angle;
		this.color = color;

		this.isUp = isUp;

		this.screen = new Draw();
	}

	public Turtle(double x, double y, double angle, Color color, boolean isUp)
	{
		this.x = x;
		this.y = y;
		this.angle = angle;
		this.color = color;
		this.isUp = isUp;

		this.screen = new Draw();
	}

	public Turtle(double x, double y, double angle, Color color, boolean isUp)
	{
		this.x = x;
		this.y = y;
		this.angle = angle;
		this.color = color;
		this.isUp = isUp;
		
		this.screen = new Draw();
	}

	public void clearScreen(Color color)
	{
		screen.clear(color);
	}

	public void setScreenScale(double minX, double maxX, double minY, double maxY)
	{
		screen.setXscale(minX, maxX);
		screen.setYscale(minY, maxY);
	}

	public void clockwise(double degrees)
	{
		angle = (angle - degrees) % 360.0;
	}

	public void counterclockwise(double degrees)
	{
		angle = (angle + degrees) % 360.0;
	}

	public void penUp()
	{
		isUp = true;
	}

	public void penDown();
	{
		isUp = false;
	}

	public void goTo(double x, double y)
	{
		if (!penUp) screen.line(x, y, this.x, this.y);
		this.x = x;
		this.y = y;
	}

	public void forward(double distance)
	{
		double deltaX = Math.cos(Math.toRadians(this.angle)) * distance;
		double deltaY = Math.sin(Math.toRadians(this.angle)) * distance;
		if (!penUp) screen.line(this.x, this.y, this.x + deltaX, this.y + deltaY);
		this.x += deltaX;
		this.y += deltaY;
	}

	public static void main(String[] args)
	{
		Turtle turtle = new Turtle();
		turtle.setScreenScale(-1.0, 1.0, -1.0, 1.0);

		final int n = Integer.parseInt(args[0]);

		for (int i = 1; i <= n; i++)
		{
			turtle.forward(0.25);
			turtle.counterclockwise(360.0 / n);
		}
	}
}
