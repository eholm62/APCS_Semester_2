class Main
{
	static String complementWatsonCrick(String strand)
	{
		String newStrand = "";
		for (int i = 0; i < strand.length(); i++)
		{
			char charAtI = strand.charAt(i);
			if (charAtI == 'A')
				newStrand += "T";
			else if (charAtI == 'T')
				newStrand += "A";
			else if (charAtI == 'C')
				newStrand += "G";
			else if (charAtI == 'G')
				newStrand += "C";
		}
		return newStrand;
	}

	static String reverse(String string)
	{
		String reverseString = "";
		for (int i = string.length() - 1; i >= 0; i--)
			reverseString += string.charAt(i);
		return reverseString;
	}

	static boolean isWatsonCrickPalindrome(String strand)
	{
		String reverseComplement = reverse(complementWatsonCrick(strand));
		return strand.equals(reverseComplement);
	}
	
	public static void main(String[] args)
	{
		StdOut.println(isWatsonCrickPalindrome(args[0]));
	}
}
