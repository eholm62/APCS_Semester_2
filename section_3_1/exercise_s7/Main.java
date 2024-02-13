import java.io.File;

class Main
{
	public static void main(String[] args)
	{
		final String digits = args[0];
		In reader = new In("https://oeis.org/A002205/b002205.txt");

		int recordI = -1;
		int recordLength = 0;
		int curI = -1;
		int curLength = 0;
		int location = 0;
		int i = 0;
		while (true)
		{ i++;
			int digit;
			
			try
			{
				reader.readInt();
				digit = reader.readInt();
			}
			catch (Exception e) 
			{
				break;
			}

			if (curI == -1)
			{
				curI = i;
			}
		        if (Character.getNumericValue(digits.charAt(location)) == digit)
			{
				location++;
				curLength++;
			}
			else 
			{
				if (curLength > recordLength)
				{
					recordLength = curLength;
					recordI = curI;
				}
				
				curI = -1;
				curLength = 0;
				location = 0;
			}
		}

		StdOut.printf("Record Length: %d \nAt: %d \n", recordLength, recordI);
	}
}
