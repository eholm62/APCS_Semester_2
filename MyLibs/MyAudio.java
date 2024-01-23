class MyAudio
{
	public static double[] sineWave(double hz, double duration)
	{
		final int SAMPLE_RATE = 44100;
		int n = (int)(SAMPLE_RATE * duration);
		double[] wave = new double[n];
		for (int i = 0; i < n; i++)
			wave[i] = Math.sin(2 * Math.PI * hz * i / SAMPLE_RATE);
		
		for (int i = n - 1; i >= n - 150; i--)
			wave[i] *= (n - 1 - i) / 150.0;
		for (int i = 0; i < 150; i++)
			wave[i] *= i / 150.0;

		return wave;
	}

	
	// public static double[] sineWave(int scaleDegrees)
	// {
	// }
	
	public static void main(String[] args)
	{
		StdAudio.save("test.wav", sineWave(277.183, 0.25));
		StdAudio.play("test.wav");
	}
}
