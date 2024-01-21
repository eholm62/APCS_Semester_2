class Main
{	
	static int sumtorial(int n)
	{
		return n * (n + 1) / 2;
	}
	
	public static void main(String[] args)
	{
		int n = Integer.parseInt(args[0]);

		int leftover = sumtorial(n);
		int i = 0;
		while (i < n - 1)
		{
			int userInput = 0;
			try { userInput = Integer.parseInt(StdIn.readLine()); }
			catch (Exception e)
			{
				StdOut.println("Must input ints");
				continue;
			}

			leftover -= userInput;

			i++;
		}

		StdOut.printf("Missing value: %d \n", leftover);
	}
}
