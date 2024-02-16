import java.awt.Color;

class Other
{
	public static void main(String[] args)
	{
		Picture image = new Picture(266, 266);	

		for (int col = 0; col < 256; col++)
		{
			for (int row = 0; row < 256; row++)
			{
				int r = col;
				int g = 81 + col * (255 - 81) / 256;
				int b = 157 + col * (255 - 157) / 256;

				image.set(col, row, new Color(r, g, b));
			}
		}

		image.show();
	}
}
