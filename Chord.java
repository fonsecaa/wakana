public class Chord {

	private final Scale _key;
	private final int _degree;

	public Chord(Scale key, int degree) { //degree counts at 1
		this._key = key;
		this._degree = degree-1;
	}

	public int get_degree() {
		return _degree;
	}

	public double[] gen_wave(double hz, double t) {
		double sps = 44100;
		int n = (int) (sps * t);
		double[] wave = new double[n];
		for (int i = 0; i < n; i++) wave[i] = Math.sin(2 * Math.PI * i * hz / sps);
		return wave;
	}

	public double[] chord_freq() {
		double[] freqs = _key.scale_freq();
		double[] chord_hz = {freqs[_degree], freqs[(_degree + 2) % 7], freqs[(_degree + 4) % 7]};
		return chord_hz;
	}

	public double[] gen_wave(double t) {
		double[] chord_hz = chord_freq();
		double[] firstw = gen_wave(chord_hz[0], t);
		double[] thirdw = gen_wave(chord_hz[1],  t);
		double[] fifthw = gen_wave(chord_hz[2],  t);
		double[] chord_wave = new double[firstw.length];
		for (int i = 0; i < chord_wave.length; i++) chord_wave[i] = (firstw[i] + thirdw[i] + fifthw[i])/9.0;
		return chord_wave;
	}

	public void play(int t) {
		double[] chord_wave = gen_wave(t);
		StdAudio.play(chord_wave);
	}

	public static void main(String[] args) {

		Scale cMajor = new Scale();
		for (int i = 0; i < 4; i++){
				Chord temp = new Chord(cMajor, (int) (Math.random()*7 + 1));
				temp.play(2);
		}
	}
}