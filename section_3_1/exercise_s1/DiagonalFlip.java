class DiagonalFlip
{
	public static void main(String[] args)
	{
		final String fileName = args[0];
		
		Picture inputImage = new Picture(fileName);
		Picture outputImage = new Picture(inputImage.height(), inputImage.width());

		for (int col = 0; col < inputImage.width(); col++)
		{
			for (int row = 0; row < inputImage.height(); row++)
			{
				outputImage.set(inputImage.height() - 1 - row, inputImage.width() - 1 - col, inputImage.get(col, row));
			}
		}

		outputImage.show();
	}
}
