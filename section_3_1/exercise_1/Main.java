class Main
{
	static String reverse(String a) 
	{
		String reverseA = "";
		for (int i = a.length() - 1; i >= 0; i--)
			reverseA += a.charAt(i);
		return reverseA;
	}

	public static void main(String[] args)
	{
		StdOut.println(reverse(args[0]));
	}
}
