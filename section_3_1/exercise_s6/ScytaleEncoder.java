class ScytaleEncoder
{
	public static void main(String[] args)
	{
		final int numFaces = Integer.parseInt(args[0]);
		final int lineLength = Integer.parseInt(args[1]);

		final String userInput = StdIn.readLine();

		String encoded = "";
		for (int i = 0; i < lineLength; i++)
		{
			int count = 0;
			for (int j = i; j < userInput.length(); j += lineLength)
			{
				encoded += userInput.charAt(j);
				count++;
			}

			for (int j = 0; j < numFaces - count; j++)
			{
				encoded += '-';
			}
		}
		StdOut.println(encoded);
	}
}
