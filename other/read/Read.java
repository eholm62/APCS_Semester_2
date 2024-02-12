class Read
{
	public static void main(String[] args)
	{
		String location = args[0];
		In in = new In(location);

		while (in.hasNextLine())
		{
			StdOut.println(in.readLine());
		}
	}
}
