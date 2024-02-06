import java.awt.Color;

class Main
{
	static boolean isWhiteRow(Picture picture, int row)
	{
		for (int i = 0; i < picture.width(); i++)
		{
			Color pixel = picture.get(i, row);
			if (!pixel.equals(new Color(255, 255, 255)))
				return false;
		}
		return true;
	}

	static boolean isWhiteCol(Picture picture, int column)
	{
		for (int i = 0; i < picture.height(); i++)
		{
			Color pixel = picture.get(column, i);
			if (!pixel.equals(new Color(255, 255, 255)))
				return false;
		}
		return true;
	}
	
	public static void main(String[] args)
	{
		final String fileName = args[0];
		Picture inputImage = new Picture(fileName);
		
		int firstNonWhiteRow = 0;
		for (int row = 0; row < inputImage.height(); row++)
		{
			if (!isWhiteRow(inputImage, row))
			{
				firstNonWhiteRow = row;
				break;
			}
		}

		int lastNonWhiteRow = inputImage.height() - 1;
		for (int row = inputImage.height() - 1; row >= firstNonWhiteRow; row--)
		{
			if (!isWhiteRow(inputImage, row))
			{
				lastNonWhiteRow = row;
				break;
			}
		}

		int firstNonWhiteCol = 0;
		for (int col = 0; col < inputImage.width(); col++)
		{
			if (!isWhiteCol(inputImage, col))
			{
				firstNonWhiteCol = col;
				break;
			}
		}

		int lastNonWhiteCol = inputImage.width() - 1;
		for (int col = inputImage.width() - 1; col >= firstNonWhiteCol; col--)
		{
			if (!isWhiteCol(inputImage, col))
			{
				lastNonWhiteCol = col;
				break;
			}
		}

		int newWidth = lastNonWhiteCol + 1 - firstNonWhiteCol;
		int newHeight = lastNonWhiteRow + 1 - firstNonWhiteRow;
		Picture outputImage = new Picture(newWidth, newHeight);
		for (int col = firstNonWhiteCol; col <= lastNonWhiteCol; col++)
		{
			for (int row = firstNonWhiteRow; row <= lastNonWhiteRow; row++)
			{
				Color color = inputImage.get(col, row);
				outputImage.set(col - firstNonWhiteCol, row - firstNonWhiteRow, color);
			}
		}

		outputImage.show();

		StdOut.printf("Lower Left Corner: (%d, %d) \n", firstNonWhiteCol, lastNonWhiteRow);
		StdOut.printf("Top Right Corner: (%d, %d) \n", lastNonWhiteCol, firstNonWhiteRow);
	}
}
