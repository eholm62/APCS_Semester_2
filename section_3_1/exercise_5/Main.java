import java.awt.Color;

class Main
{
	public static void main(String[] args)
	{
		String inputFileName = args[0];
		String outputFileName = args[1];
		
		Picture picture = new Picture(inputFileName);
		Picture newPicture = new Picture(picture.width(), picture.height());
		
		for (int i = 0; i < picture.width(); i++)
		{
			for (int j = 0; j < picture.height(); j++)
			{
				Color color = picture.get(i, picture.height() -1 - j);
				newPicture.set(i, j, color);
			}
		}

		newPicture.save(outputFileName);
	}
}
