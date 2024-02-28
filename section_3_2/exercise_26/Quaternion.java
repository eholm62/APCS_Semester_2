class Quaternion
{
	private final double r;
	private final double i;
	private final double j;
	private final double k;

	public Quaternion(double r, double i, double j, double k)
	{
		this.r = r;
		this.i = i;
		this.j = j;
		this.k = k;
	}

	public double magnitude()
	{
		double r = this.r * this.r;
		double i = this.i * this.i;
		double j = this.j * this.j;
		double k = this.k * this.k;
		return Math.sqrt(r + i + j + k);
	}

	public Quaternion conjugate()
	{
		return new Quaternion(this.r, -this.i, -this.j, -this.k);
	}

	public Quaternion inverse()
	{
		double r = this.r / Math.pow(this.magnitude(), 2);
		double i = -this.i / Math.pow(this.magnitude(), 2);
		double j = -this.j / Math.pow(this.magnitude(), 2);
		double k = -this.k / Math.pow(this.magnitude(), 2);
		return new Quaternion(r, i, j, k);
	}

	public Quaternion add(Quaternion other)
	{
		double r = this.r + other.r;
		double i = this.i + other.i;
		double j = this.j + other.j;
		double k = this.k + other.k;
		return new Quaternion(r, i, j, k);
	}

	public Quaternion subtract(Quaternion other)
	{
		double r = this.r - other.r;
		double i = this.i - other.i;
		double j = this.j - other.j;
		double k = this.k - other.k;
		return new Quaternion(r, i, j, k);
	}

	public Quaternion multiply(Quaternion other)
	{
		double r = this.r * other.r - this.i * other.i - this.j * other.j - this.k * other.k;
		double i = this.r * other.i + this.i * other.r + this.j * other.k - this.k * other.j;
		double j = this.r * other.j - this.i * other.k + this.j * other.r + this.k * other.i;
		double k = this.r * other.k + this.i * other.j - this.j * other.i + this.k * other.r;
		return new Quaternion(r, i, j, k);
	}

	public Quaternion divide(Quaternion other)
	{
		return this.multiply(other.inverse());
	}

	public Quaternion scalarProd(double scalar)
	{
		double r = this.r * scalar;
		double i = this.i * scalar;
		double j = this.j * scalar;
		double k = this.k * scalar;
		return new Quaternion(r, i, j, k);
	}

	public String toString()
	{
		return String.format("(%f + %fi + %fj + %fk)", r, i, j, k);
	}

	public static void main(String[] args) 
	{
		Quaternion A = new Quaternion(1, 2, 3, 4);
		Quaternion B = new Quaternion(-7, 12, -3, 5);
		Quaternion C = new Quaternion(0.5, 1.0/3, -Math.PI, Math.E);
		Quaternion R = new Quaternion(1, 0, 0, 0);
		Quaternion I = new Quaternion(0, 1, 0, 0);
		Quaternion J = new Quaternion(0, 0, 1, 0);
		Quaternion K = new Quaternion(0, 0, 0, 1);
		StdOut.println(A);
		StdOut.println(B);
		StdOut.println(C);
		StdOut.println(R);
		StdOut.println(I);
		StdOut.println(J);
		StdOut.println(K);
		StdOut.println(A.magnitude());
		StdOut.println(B.conjugate());
		StdOut.println(A.add(B));
		StdOut.println(B.scalarProd(3));
		StdOut.println(A.multiply(B));
		StdOut.println(B.multiply(A));
		StdOut.println(A.inverse());
		StdOut.println(A.divide(B));
		StdOut.println(B.divide(A));
	}
}
