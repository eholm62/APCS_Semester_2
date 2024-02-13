class ScytaleDecoder
{
	static String removeHyphens(String s)
	{
		String newString = "";
		for (int i = 0; i < s.length(); i++)
		{
			if (s.charAt(i) != '-')
			{
				newString += s.charAt(i);
			}
		}
		return newString;
	}
	
	public static void main(String[] args)
	{
		final int numFaces = Integer.parseInt(args[0]);

		final String userInput = StdIn.readLine();

		String decoded = "";
		for (int i = 0; userInput.charAt(i) != '-'; i++)
		{
			for (int j = i; j < userInput.length(); j += numFaces)
			{
				decoded += userInput.charAt(j);
			}
		}
		StdOut.println(removeHyphens(decoded));
	}
}
