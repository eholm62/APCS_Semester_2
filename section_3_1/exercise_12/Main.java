class Main
{
	static int charToInt(char c)
	{
		if (c != 'X')
			return Integer.parseInt(String.valueOf(c));
		else
			return 10;
	}

	static char intToChar(int n)
	{
		if (n != 10)
			return Integer.toString(n).charAt(0);
		else
			return 'X';
	}
	
	static String checksum(String string)
	{
		int sum = 0;
		for (int i = 0; i < 9; i++)
			sum += (10 - i) * charToInt(string.charAt(i));
		return String.valueOf(intToChar(11 - sum % 11));
	}

	static String removeHyphens(String string)
	{
		String newString = "";
		for (int i = 0; i < string.length(); i++)
		{
			if (string.charAt(i) != '-')
				newString += string.charAt(i);
		}
		return newString;
	}

	static boolean isValidISBN(String nISBN)
	{
		String simplified = removeHyphens(nISBN);
		if (simplified[9] == checksum(simplified.substring(9))
			return true;
		return false;
	}

	public static void main(String[] args)
	{
		String input = args[0];
		StdOut.println(input + checksum(input));
	}
}
