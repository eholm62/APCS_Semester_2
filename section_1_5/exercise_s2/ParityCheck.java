import java.util.ArrayList;

class ParityCheck	
{			
	public static void main(String[] args)
	{		
		final int n = Integer.parseInt(args[0]);

		int[][] userInput = new int[n][n];

		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				userInput[i][j] = StdIn.readInt();
			}
		}

		ArrayList<Integer> invalidRows = new ArrayList<Integer>();
		ArrayList<Integer> invalidCols = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) 
		{
			int rowSum = 0;
			int colSum = 0;
			for (int j = 0; j < n; j++)
			{
				rowSum += userInput[i][j];
				colSum += userInput[j][i];
			}
			if (rowSum % 2 != 0)
				invalidRows.add(i);
			if (colSum % 2 != 0)
				invalidCols.add(i);

		}

		if (invalidRows.size() == 0 && invalidCols.size() == 0) 
			StdOut.println("The matrix has the parity property.");
		else if (invalidRows.size() > 1 || invalidCols.size() > 1)
			StdOut.println("The matrix is corrupted.");
		else
			StdOut.printf("(%d, %d) \n", invalidRows.get(0), invalidCols.get(0));

	}
}			
