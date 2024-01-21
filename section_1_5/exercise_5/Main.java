class Main
{
	public static void main(String[] args)
	{
		int recordLength = 0;
		int recordNum = 0;
		
		int curLength = 0;
		int curNum = 0;
		
		int userInput = 0;
		while (StdIn.hasNextLine())
		{	
			try { userInput = Integer.parseInt(StdIn.readLine()); }
			catch (Exception e) 
			{
				StdOut.println("Must input ints");
				continue;
			}

			if (curLength == 0)
			{
				curLength++;
				curNum = userInput;
			}
			else if (userInput == curNum)
			{
				curLength++;
			}
			else
			{
				if (curLength > recordLength)
				{
					recordLength = curLength;
					recordNum = curNum;
				}

				curLength = 1;
				curNum = userInput;
			}
		}

		if (curLength > recordLength)
		{
			recordLength = curLength;
			recordNum = curNum;
		}

		StdOut.printf("Longest run: %d consecutive %ds \n", recordLength, recordNum);
	}	
}
