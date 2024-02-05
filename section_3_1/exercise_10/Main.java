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
	
	public static void main(String[] args)
	{
		StdOut.println(complementWatsonCrick(args[0]));
	}
}
