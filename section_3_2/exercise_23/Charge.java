/*
*  Compilation:  javac Charge.java
*  Execution:    java Charge x y
*/

public class Charge {

    private final double rx, ry;   // position of charge
    private final double q;        // charge amount

    public Charge(double x0, double y0, double q0) {
	this.rx = x0;
	this.ry = y0;
	this.q  = q0;
    }

    public double potentialAt(double x, double y) {
	double k = 8.99e09;
	double dx = x - this.rx;
	double dy = y - this.ry;
	return k * this.q / Math.sqrt(dx*dx + dy*dy);
    }

    public String toString() {
	return q + " at (" + this.rx + ", " + this.ry + ")";
    }

    public static void main(String[] args) {
	double x = Double.parseDouble(args[0]);
	double y = Double.parseDouble(args[1]);
	Charge c1 = new Charge(0.51, 0.63, 21.3);
	Charge c2 = new Charge(0.13, 0.94, 81.9);
	StdOut.println(c1);
	StdOut.println(c2);
	double v1 = c1.potentialAt(x, y);
	double v2 = c2.potentialAt(x, y);
	StdOut.println(v1+v2);
    }
}