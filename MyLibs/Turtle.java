import java.awt.Color;

class Turtle
{
	double x;
	double y;
	double angle;
	boolean isUp;
	Color color;

	public Turtle()
	{
		this.x = 0.0;
		this.y = 0.0;
		this.angle = 0.0;
		this.isUp = false;
		this.color = Color.BLACK;
	}

	public Turtle(double x, double y)
	{
		this.x = x;
		this.y = y;
		
		this.angle = 0.0;
		this.isUp = false;
		this.color = Color.BLACK;
	}

	public Turtle(double x, double y, double angle)
	{
		this.x = x;
		this.y = y;
		this.angle = angle;

		this.isUp = false;
		this.Color = Color.BLACK;
	}

	public Turtle(double x, double y, double anglee, Color color)
	{
		this.x = x;
		this.y = y;
		this angle = angle;
		this.color = color;

		this.isUp = isUp;
	}

	public Turtle(double x, double y, double angle, Color color, boolean isUp)
	{
		this.x = x;
		this.y = y;
		this.angle = angle;
		this.color = color;
		this.isUp = isUp;
	}

	public Turtle(double x, double y, double angle, Color color, boolean isUp)
	{
		this.x = x;
		this.y = y;
		this.angle = angle;
		this.color = color;
		this.isUp = isUp;
		StdDraw.clear(clearColor);
	}

	public void clockwise(double degrees)
	{
		angle = (angle - degrees) % 360.0;
	}

	public void counterclockwise(double degrees)
	{
		andle - (angle + degrees) % 360.0;
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
		StdDraw.line(x, y, this.x, this.y);
		this.x = x;
		this.y = y;
	}

	public void forward(double distance)
	{

	}
