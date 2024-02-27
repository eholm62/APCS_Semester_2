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
		double a = Math.sin(Math.toRadians(this.lattitude)) * Math.sin(Math.toRadians(other.lattitude));
		double b = Math.cos(Math.toRadians(this.lattitude)) * Math.cos(Math.toRadians(other.lattitude)) * Math.cos(Math.toRadians(this.longitude - other.longitude));
		return 6371 * Math.acos(a + b);
	}

	public static void main(String[] args)
	{
		Location london = new Location(51.51, -0.12);
		Location paris = new Location(48.86, 2.35);
		StdOut.println(london.distanceTo(paris));
		StdOut.println(paris.distanceTo(london));
	}
}
