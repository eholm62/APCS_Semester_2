class Main
{
	static boolean isValidDNA(String strand)
	{
		for (int i = 0; i < strand.length(); i++)
		{
			if (strand.charAt(i) == 'A') 
				continue;
			if (strand.charAt(i) == 'T')
				continue;
			if (strand.charAt(i) == 'C')
				continue;
			if (strand.charAt(i) == 'G')
				continue;
			return false;
		}
		return true;
	}
	
	public static void main(String[] args)
	{
		StdOut.println(isValidDNA(args[0]));
	}
}
