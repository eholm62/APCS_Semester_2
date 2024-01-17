class Main
{
	static double mean(double[] values)
	{
		double sum = 0.0;
		for ( double value : values )
			sum += value;
		return sum / values.length;
	}


	static double stdDeviation(double[] values, double mean)
	{
		double[] deviations = new double[values.length];
		for (int i = 0; i < values.length; i++)
			deviations[i] = Math.pow(values[i] - mean, 2);
		return Math.sqrt(mean(deviations));
	}
	

	public static void main(String[] args)
	{
		int n = Integer.parseInt(args[0]);
		double[] values = new double[n];

		int i = 0;
		while (i < n) 
		{
			double userInput;
			try { userInput = Double.parseDouble(StdIn.readLine()); }
			catch (Exception e) 
			{
				StdOut.println("Must input doubles");
				continue;
			}
			
			values[i] = userInput;
			i++;
		}
		
		double mean = mean(values);
		double stdDeviation = stdDeviation(values, mean);

		StdOut.printf("Mean: %.3f \n", mean);
		StdOut.printf("Standard Deviation: %.3f \n", stdDeviation);
	}
}
