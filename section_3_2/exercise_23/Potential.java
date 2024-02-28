import java.awt.Color;
import java.util.ArrayList;

class Potential
{
	public static void main(String[] args)
	{
		ArrayList<Charge> charges = new ArrayList<Charge>();
		
		while (StdIn.hasNextLine())
		{
			charges.add(new Charge(StdIn.readDouble(), StdIn.readDouble(), StdIn.readDouble()));
		}

		Picture outputImage = new Picture(256, 256);

		for (int x = 0; x < outputImage.width(); x++)
		{
			for (int y = 0; y < outputImage.height(); y++)
			{
				double potential = 0.0;
				for (int i = 0; i < charges.size(); i++)
					potential += charges.get(i).potentialAt(x / 256.0, y / 256.0);
				int r = (int)(127 + potential / Math.pow(10, 10));
				if (r < 0) r = 0;
				if (r > 255) r = 255;
				int g = r;
				int b = r;
				Color pixel = new Color(r, g, b);
				outputImage.set(x, 255 - y, pixel);
			}
		}

		outputImage.show();
	}
}
