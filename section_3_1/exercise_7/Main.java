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

	static boolean isWhiteColumn(Picture picture, int column)
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
		String fileName = args[0];
		Picture picture = new Picture(fileName);

		int firstNonWhiteRow = 0;
		for (int i = 0; i < picture.height(); i++)
		{
			if (!isWhiteRow(picture, i)) 
			{
				firstNonWhiteRow = i;
				break;
			}
		}

		int lastNonWhiteRow = picture.height() - 1;
		for (int i = picture.height() - 1; i >= 0; i--)
		{
			if (!isWhiteRow(picture, i))
			{
				lastNonWhiteRow = i;
				break;
			}
		}

		int firstNonWhiteCol = 0;
		for (int i = 0; i < picture.width(); i++)
		{
			if (!isWhiteColumn(picture, i)) 
			{
				firstNonWhiteCol = i;
				break;
			}
		}

		int lastNonWhiteCol = picture.width() - 1;
		for (int i = picture.width() - 1; i >= 0; i--)
		{
			if (!isWhiteColumn(picture, i))
			{
				lastNonWhiteCol = i;
				break;
			}
		}

		StdOut.printf("Bottom Left: (%d, %d) \n", firstNonWhiteCol, lastNonWhiteRow);
		StdOut.printf("Top Right: (%d, %d) \n", lastNonWhiteCol, firstNonWhiteRow);

		Picture newPicture = new Picture(lastNonWhiteCol + 1 - firstNonWhiteCol, lastNonWhiteRow - firstNonWhiteRow);
		for (int row = firstNonWhiteRow; row <= lastNonWhiteRow; row++)
		{
			for (int col = firstNonWhiteCol; col < lastNonWhiteCol; col++)
			{
				Color pixel = picture.get(col, row);
				newPicture.set(col - firstNonWhiteCol, row - firstNonWhiteRow, pixel);
			}
		}

		newPicture.show();
	}
}
