import java.awt.Color;

class ColorStudy
{
	public static void main(String[] args)
	{
		final int squareWidth;
		if (args.length > 0)
		{
			squareWidth = Integer.parseInt(args);
		}
		else
		{
			squareWidth = 16;
		}
		
		Picture image = new Picture(16 * squareWidth, 16 * squareWidth);

		for (int i = 0; i < 16; i++)
		{
			for (int
		}

		image.show();
	}
}
