class Main
{
	static boolean arrayContains(int[] array, int value)
	{
		for (int i = 0; i < array.length; i++)
			if (array[i] == value) return true;
		return false;
	}

	
	public static void main(String[] args)
	{
		int n = Integer.parseInt(args[0]);

		int[] values = new int[n - 1];
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

			values[i] = userInput;
			i++;
		}

		for (int j = 1; j <= n; j++)
		{
			if (arrayContains(values, j))
			{
				StdOut.println(j);
				return;
			}
		}
	}
}
