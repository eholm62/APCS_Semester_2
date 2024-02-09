class ScytaleEncoder
{
	// hyphens are important for decoding they must be here, this code doesn't work because it doesn't insert dashes
	public static void main(String[] args)
	{
		final int numFaces = Integer.parseInt(args[0]);
		final int lineLength = Integer.parseInt(args[1]);

		final String userInput = StdIn.readLine();

		char[] encoded = new char[userInput.length()];
		for (int i = 0; i < userInput.length(); i += lineLength)
		{
			for (int j = i; j < i + lineLength; j++)
			{
				encoded[(j - i) * numFaces + i / lineLength] = userInput.charAt(j);
			}
		}

		StdOut.println(new String(encoded));
	}
}
