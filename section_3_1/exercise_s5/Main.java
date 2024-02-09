class Main
{
	public static void main(String[] args)
	{
		final String userInput = args[0];

		ArrayList<char[]> singleChars = new ArrayList<char[]>();
		for (int i = 0; i < userInput.length(); i++)
		{
			int location = singleChars.indexOf(new char[] {userInput.get(i)});
			if (location == -1)
			{
				ArrayList.add(new char[] {userInput.get(i)});
			}
			else
			{
				ArrayList.remove(location);
			}
		}
	}
}
