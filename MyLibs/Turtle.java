import java.awt.Color;

class Turtle
{
	double x;
	double y;
	double angle;
	boolean isUp;

	Draw canvas;

	public Turtle(Draw canvas)
	{
		this.x = 0.0;
		this.y = 0.0;
		this.angle = 0.0;
		this.isUp = false;
		canvas.setPenColor(Color.BLACK);
		canvas.setPenRadius(0.0025);
		
		this.canvas = canvas;
	}

	public Turtle(Draw canvas, double x, double y)
	{
		this.x = x;
		this.y = y;
		
		this.angle = 0.0;
		this.isUp = false;
		canvas.setPenColor(Color.BLACK);
		canvas.setPenRadius(0.0025);

		this.canvas = canvas;
	}

	public Turtle(Draw canvas, double x, double y, double angle)
	{
		this.x = x;
		this.y = y;
		this.angle = angle;

		this.isUp = false;
		canvas.setPenColor(Color.BLACK);
		canvas.setPenRadius(0.0025);

		this.canvas = canvas;
	}

	public Turtle(Draw canvas, double x, double y, double anglee, Color color)
	{
		this.x = x;
		this.y = y;
		this.angle = angle;
		canvas.setPenColor(color);

		this.isUp = isUp;
		canvas.setPenRadius(0.0025);

		this.canvas = canvas;
	}

	public Turtle(double x, double y, double angle, Color color, boolean isUp)
	{
		this.x = x;
		this.y = y;
		this.angle = angle;
		canvas.setPenColor(color);
		this.isUp = isUp;

		canvas.setPenRadius(0.0025);

		this.canvas = canvas;
	}

	public Turtle(double x, double y, double angle, Color color, boolean isUp, double penRadius)
	{
		this.x = x;
		this.y = y;
		this.angle = angle;
		canvas.setPenColor(color);
		this.isUp = isUp;
		canvas.setPenRadius(penRadius);

		this.canvas = canvas;
	}

	public void setPenColor(Color color)
	{
		canvas.setPenColor(color);
	}

	public void setPenRadius(double penRadius)
	{
		canvas.setPenRadius(penRadius);
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

	public void penDown()
	{
		isUp = false;
	}

	public void goTo(double x, double y)
	{
		if (!isUp) canvas.line(x, y, this.x, this.y);
		this.x = x;
		this.y = y;
	}

	public void forward(double distance)
	{
		double deltaX = Math.cos(Math.toRadians(this.angle)) * distance;
		double deltaY = Math.sin(Math.toRadians(this.angle)) * distance;
		if (!isUp) canvas.line(this.x, this.y, this.x + deltaX, this.y + deltaY);
		this.x += deltaX;
		this.y += deltaY;
	}

	public void pause(double seconds)
	{
		canvas.pause((int)(seconds * 1000));
	}

	public static void main(String[] args)
	{
		Draw canvas = new Draw();
		canvas.setXscale(-1.0, 1.0);
		canvas.setYscale(-1.0, 1.0);
		canvas.clear(Color.BLACK);
		
		Turtle turtle = new Turtle(canvas);
		turtle.setPenColor(Color.WHITE);

		final int n = Integer.parseInt(args[0]);

		for (int i = 1; i <= n; i++)
		{
			turtle.forward(0.25);
			turtle.counterclockwise(360.0 / n);
		}
	}
}
