class Main
{
	public static void main(String[] args)
	{
		final String userInput;
		if (args.length > 0) userInput = args[0];
		else userInput = StdIn.readLine();
		
		int[] charCounts = new int[65536];
		for (int i = 0; i < userInput.length(); i++)
		{
			charCounts[userInput.charAt(i)] += 1;
		}

		for (int i = 0; i < userInput.length(); i++)
		{
			if (charCounts[userInput.charAt(i)] == 1)
			{
				StdOut.println(userInput.charAt(i));
				return;
			}
		}
	}
}
