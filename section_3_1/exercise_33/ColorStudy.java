import java.awt.Color;

class ColorStudy
{
	public static void main(String[] args)
	{
		Picture image = new Picture(266, 266);	

		for (int col = 0; col < 256; col++)
		{
			for (int row = 0; row < 256; row++)
			{
				int r = col;
				int g = 81 + row * (255 - 81) / 256;
				int b = 255;

				image.set(col, row, new Color(r, g, b));
			}
		}

		image.show();
	}
}
