/******************************************************************************
 *  Compilation:  javac Turtle.java
 *  Execution:    java Turtle
 *
 *  Data type for turtle graphics using standard draw.
 *
 ******************************************************************************/

import java.awt.Color;

public class Turtle {
	private double x, y;     // turtle is at (x, y)
    	private double angle;    // facing this many degrees counterclockwise from the x-axis
	private boolean isPenUp;
	private double minX;
	private double maxX;
	private double minY;
	private double maxY;

    	public Turtle(double x0, double y0, double a0) {
		x = x0;
		y = y0;
		angle = a0;
		isPenUp = false;
		minX = 0.0;
		maxX = 1.0;
		minY = 0.0;
		maxY = 1.0;
    	}
	
	// start at (x0, y0), facing a0 degrees counterclockwise from the x-axis
    	public Turtle(double x0, double y0, double a0, boolean down) {
		x = x0;
		y = y0;
		angle = a0;
		isPenUp = down;
		minX = 0.0;
		maxX = 1.0;
		minY = 0.0;
		maxY = 1.0;
    	}

	public void penUp() {
		isPenUp = true;
	}

	public void penDown() {
		isPenUp = false;
	}

    	// rotate orientation delta degrees counterclockwise
    	public void turnLeft(double delta) {
		angle += delta;
    	}

	public void turnRight(double delta) {
		angle -= delta;
	}

    	// move forward the given amount, with the pen down
    	public void goForward(double step) {
		double oldx = x;
		double oldy = y;
		x += step * Math.cos(Math.toRadians(angle));
		y += step * Math.sin(Math.toRadians(angle));
		if (isPenUp) return;
		StdDraw.line(oldx, oldy, x, y);
    	}

	public void goBack(double step) {
		double oldx = x;
		double oldy = y;
		x -= step * Math.cos(Math.toRadians(angle));
		y -= step * Math.sin(Math.toRadians(angle));
		if (isPenUp) return;
		StdDraw.line(oldx, oldy, x, y);
    	}

	public void switchPen() {
		isPenUp = !isPenUp;
	}

	public void walkTo(double x, double y) {
		double oldx = this.x;
		double oldy = this.y;
		this.x = x;
		this.y = y;
		if (isPenUp) return;
		StdDraw.line(oldx, oldy, x, y);
	}

	public void teleport(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

    	// copy to onscreen
    	public void show() {
		StdDraw.show();
    	}

    	// pause t milliseconds
    	public void pause(int t) {
		StdDraw.pause(t);
    	}


    	public void setColor(Color color) {
		StdDraw.setPenColor(color);
    	}

    	public void setRadius(double radius) {
		StdDraw.setPenRadius(radius);
    	}

    	public void setCanvasSize(int width, int height) {
		StdDraw.setCanvasSize(width, height);
    	}

    	public void setXscale(double min, double max) {
		this.minX = min;
		this.maxX = max;
		StdDraw.setXscale(min, max);
    	}

    	public void setYscale(double min, double max) {
		this.minY = min;
		this.maxY = max;
		StdDraw.setYscale(min, max);
    	}

	public double getMinX() {
		return minX;
	}

	public double getMaxX() {
		return maxX;
	}

	public double getMinY() {
		return minY;
	}

	public double getMaxY() {
		return maxY;
	}

	public static void main(String[] args) {
		Turtle franklin = new Turtle(0.0, 0.0, 0.0);
		franklin.setXscale(-400, 400);
		franklin.setYscale(-400, 400);
		franklin.teleport(-100, -100);
	  	for (int i = 0; i < 6; i++) {
	    		franklin.goForward(40);
	    		franklin.turnRight(360/6);
	  	}
	  	franklin.teleport(-200, 0);
	  	for (int i = 0; i < 6; i++) {
	    		if (i % 2 == 1) {
	      			franklin.penDown();
	    		} else {
	      			franklin.penUp();
	    		}
	    	franklin.goBack(40);
	    	franklin.turnLeft(360/6);
	  	}
	  	int x = 50;
	  	int y = 0;
	  	franklin.penUp();
	  	franklin.walkTo(x, y);
	  	franklin.penDown();
	  	for (int i = 0; i < 6; i++) {
	    		x -= 10;
	    		y -= 10;
	    		franklin.walkTo(x, y);
	    		franklin.switchPen();
	  	}
	}
}
