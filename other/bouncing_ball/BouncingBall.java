import java.awt.Color;

class BouncingBall
{
	public static void main(String[] args)
	{
		StdDraw.setXscale(-1.0, 1.0);
		StdDraw.setYscale(-1.0, 1.0);
		StdDraw.setPenRadius(0.0025);
		StdDraw.clear(Color.BLACK);
		StdDraw.setPenColor(Color.RED);
		StdDraw.enableDoubleBuffering();

		final int fpsTarget = 40;

		final double radius = 0.1;
		final double bounceEnergyLoss = 0.1;
		final double airResistanceEnergyLoss = 0.003;

		StdAudio.save("octave.wav", MyAudio.sineWave(440, 0.2));
		StdAudio.save("root.wav", MyAudio.sineWave(220, 0.2));
		StdAudio.save("fifth.wav", MyAudio.sineWave(329.63, 0.2));
		StdAudio.save("third.wav", MyAudio.sineWave(277.183, 0.2));

		double maxXvelocity = 0.032;
		double maxYvelocity = 0.05;
		double gravity = 0.0004;

		double x = 0.5;
		double y = -0.5;
		
		double xVelocity = 0.032;
		double yVelocity = -0.05;

		while (true)
		{	
			long startTime = System.currentTimeMillis();

			maxXvelocity *= 1.0 - airResistanceEnergyLoss;
			maxYvelocity *= 1.0 - airResistanceEnergyLoss;
			
			if (Math.abs(xVelocity) > maxXvelocity)
			{
				if (xVelocity < 0.0) xVelocity = -maxXvelocity;
				else xVelocity = maxXvelocity;
			}
			if (Math.abs(yVelocity) > maxYvelocity)
			{
				if (yVelocity >= 0.0) yVelocity = maxYvelocity;
			}

			yVelocity -= gravity;

			if (x + radius >= 1.0)
			{
				maxXvelocity *= 1.0 - bounceEnergyLoss;
				xVelocity = -maxXvelocity;
				new Thread(() -> StdAudio.play("fifth.wav")).start();
			}
			else if (x - radius <= -1.0) 
			{
				maxXvelocity *= 1.0 - bounceEnergyLoss;
				xVelocity = maxXvelocity;
				new Thread(() -> StdAudio.play("third.wav")).start();
			}
			if (y + radius >= 1.0) 
			{
				maxYvelocity *= 1.0 - bounceEnergyLoss;
				yVelocity = -yVelocity;
				new Thread(() -> StdAudio.play("octave.wav")).start();
			}
			else if (y - radius <= -1.0) 
			{
				maxYvelocity *= 1.0 - bounceEnergyLoss;
				yVelocity = maxYvelocity;
				gravity += 0.0002;
				maxXvelocity *= 1.0 - bounceEnergyLoss / 4;
				new Thread(() -> StdAudio.play("root.wav")).start();
			}

			StdDraw.clear(Color.BLACK);
			StdDraw.filledCircle(x, y, radius);
			StdDraw.show();
			
			x += xVelocity;
			y += yVelocity;

			int wait = 1000 / fpsTarget - (int)(System.currentTimeMillis() - startTime);
			StdDraw.pause(wait >= 0 ? wait : 0);
		}
	}
}
