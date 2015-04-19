public class Pitch {

	private final double _hz;

	public Pitch(double hz) {
		this._hz = hz;
	}

	public double[] gen_wave(double t) {
		double sps = 44100;
		int n = (int) (sps * t);
		double[] wave = new double[n];
		for (int i = 0; i < n; i++) wave[i] = Math.sin(2 * Math.PI * i * _hz / sps);
		return wave;
	}

	public static double[] gen_wave(double t, double hz) {
		double sps = 44100;
		int n = (int) (sps * t);
		double[] wave = new double[n];
		for (int i = 0; i < n; i++) wave[i] = Math.sin(2 * Math.PI * i * hz / sps);
		return wave;
	}

	public static void main(String[] args) {
		Pitch temp = new Pitch(440);
		StdAudio.play(temp.gen_wave(1));
	}
}