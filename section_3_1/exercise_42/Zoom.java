class Zoom
{
	public static void main(String[] args)
	{
		final String inputFileName = args[0];
		final double scaleFactor = Double.parseDouble(args[1]);
		final double x = Double.parseDouble(args[2]);
		final double y = Double.parseDouble(args[3]);

		Picture inputImage = new Picture(inputFileName);
		int width = inputImage.width();
		int height = inputImage.height();
		Picture outputImage = new Picture(width, height);

		for (int col = 0; col < width; col++)
		{
			for (int row = 0; row < height; row++)
			{
				int trueCol = (int)(width * x) - (int)(((int)(width * 0.5) - col) * scaleFactor);
				int trueRow = (int)(height * y) - (int)(((int)(height * 0.5) - row) * scaleFactor);
				if (trueCol >= 0 && trueCol < width)
				{
					if (trueRow >= 0 && trueRow < height)
					{
						outputImage.set(col, row, inputImage.get(trueCol, trueRow));
					}
				}	
			}
		}

		outputImage.show();
	}
}
