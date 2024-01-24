class ZeroCrossings
{
	public static void main(String[] args)
	{
		int count = 0;
		int sign = 0;
		while (!StdIn.isEmpty())
		{
			double userInput = StdIn.readDouble();
			
			if (userInput < 0) 
			{
				if (sign == 1) count++;
				sign = -1;
			} 
			else if (userInput > 0)
			{
				if (sign == -1) count++;
				sign = 1;
			}
		}
		StdOut.println(count);
	}
}
