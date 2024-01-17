class Main
{
	public static void main(String[] args)
	{
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int curInt;
		while (StdIn.hasNextLine()) 
		{
			try { curInt = Integer.parseInt(StdIn.readLine()); }
			catch (Exception e) 
			{ 
				StdOut.println("Must input ints");
				continue; 
			}
			
			if (curInt < 0) 
			{
				StdOut.println("Input must be positive");
				continue;
			}

			if (curInt < min) min = curInt;
			if (curInt > max) max = curInt;
		}

		StdOut.printf("Max: %d \n", max);
		StdOut.printf("Min: %d \n", min);
	}
}
