class GlassFilter
{
	public static void main(String[] args)
	{
		final String inputFileName = args[0];
		final String outputFileName = args[1];
		final int tolerance = Integer.parseInt(args[2]);	// works well with a value of five here
	
		Picture inputImage = new Picture(inputFileName);
		Picture outputImage = new Picture(inputImage.width(), inputImage.height());

		for (int col = 0; col < outputImage.width(); col++)
		{
			for (int row = 0; row < outputImage.height(); row++)
			{
				int offsetCol = col + (int)Math.floor(Math.random() * tolerance * 2 + 1) - tolerance;
				int offsetRow = row + (int)Math.floor(Math.random() * tolerance * 2 + 1) - tolerance;

				if (offsetCol < 0)
					offsetCol = 0;
				else if (offsetCol >= inputImage.width())
					offsetCol = inputImage.width() - 1;
				if (offsetRow < 0)
					offsetRow = 0;
				else if (offsetRow >= inputImage.height())
					offsetRow = inputImage.height() - 1;

				outputImage.set(col, row, inputImage.get(offsetCol, offsetRow));
			}
		}

		outputImage.show();
		outputImage.save(outputFileName);
	}
}	
