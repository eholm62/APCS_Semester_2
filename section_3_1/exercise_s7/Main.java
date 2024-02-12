import java.io.File;

class Main
{
	public static void main(String[] args)
	{
		final String location = args[0];
		final String digits = args[1];
		
		long length = (new File(location)).length();
		In reader = new In(location);

		int record = -1;
		int recordI = -1;
		int curStartI = -1;
		int digitsI = 0;
		for (int j = 0; j < length; j++)
		{
			int i;
			int dig;
			
			try 
			{
				i = reader.readInt();
				dig = reader.readInt();
			}
			catch (Exception e)
			{
				continue;
			}

			if (Character.getNumericValue(digits.charAt(digitsI)) == dig)
			{
				if (curStartI == -1)
				{
					curStartI = i;
				}
				digitsI++;
			}
			else if (digitsI > record)
			{
				record = digitsI;
				recordI = curStartI;
				curStartI = -1;
				digitsI = 0;
			}
			else
			{
				curStartI = -1;
				digitsI = 0;
			}

			reader.readLine();
		}

		StdOut.println(recordI);
	}
}
