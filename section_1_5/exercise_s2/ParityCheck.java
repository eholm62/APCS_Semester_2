class ParityCheck	
{			
	public static void main(String[] args)
	{		
		final int n = Integer.parseInt(args[0]);

		int[][] userInput;
		while (true)
		{
			StdOut.println("Input a 2D array of 0s and 1s");
			try { userInput = StdArrayIO.readInt2D(); }
			catch (Exception e) 
			{
				StdOut.println("Must input 0s and 1s");
				continue;
			}
			boolean valid = true;
			for (int i = 0; i < n; i++)
			{
				for (int j = 0; j < n; j++)
				{
					if (userInput[i][j] != 0 && userInput[i][j] != 1)
					{
						valid = false;
					}
				}
			}
			if (!valid)
			{
				System.out.println("Must input 0s and 1s");
				continue;
			}
			if (userInput[0].length != n)
			{
				StdOut.printf("Array must be %dx%d \n", n, n);
				continue;
			}
			else if (userInput.length != n)
			{
				StdOut.printf("Array must be %dx%d \n", n, n);
				continue;
			}
			break;
		}

		StdOut.println("broke");
		return;
	}
}			
