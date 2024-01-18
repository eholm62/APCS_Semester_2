class Main
{
	public static void main(String[] args)
	{
		int recordRun = 0;
		int recordNum = 0;
		
		int curRun = 0;
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

			if (curRun == 0) curNum = userInput;
			if (userInput == curNum) curRun++;
			else
			{	
				if (curRun > recordRun) 
				{
					recordRun = curRun;
					recordNum = curNum;
				}
				
				curRun = 0;
			}
		}

		StdOut.printf("Longest run: %d consecutive %ds \n", recordRun, recordNum);
	}	
}
