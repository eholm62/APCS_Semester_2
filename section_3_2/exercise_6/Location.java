class Location
{
	private final double lattitude;
	private final double longitude;

	public Location(double lattitude, double longitude)
	{
		this.longitude = longitude;
		this.lattitude = lattitude;
	}

	public double distanceTo(Location other)
	{
		double a = Math.sin(this.longitude) * Math.sin(other.longitude * other.longitude);
		double b = Math.cos(this.longitude) * Math.cos(other.longitude) * Math.cos(this.lattitude - other.lattitude);
		return 1.82 * 60 * Math.acos(a + b);
	}

	public static void main(String[] args)
	{
		Location london = new Location(51.51, -0.12);
		Location paris = new Location(48.86, 2.35);
		StdOut.println(london.distanceTo(paris));
		StdOut.println(paris.distanceTo(london));
	}
}
