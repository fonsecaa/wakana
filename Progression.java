public class Progression {

	public static double[] gen_rand_prog(Scale key, int len) {

		double[] opt_freqs = key.scale_freq();
		double sps = 44100;
		int N = (int) (sps * 2 * len);
		double[] wave = new double[N];

		int k = 0;
		int n = 0;

		for (int i = 0; i < len; i++) {

			int degree = (int) (Math.random()*opt_freqs.length);
			double[] chord_hz = {opt_freqs[degree % 7], opt_freqs[(degree + 2) % 7], opt_freqs[(degree + 4) % 7]};

			n += 2 * sps;
			for (int j = k; j < n; j++) {
				double first = Math.sin(2 * Math.PI * j * chord_hz[0] / sps);
				double third = Math.sin(2 * Math.PI * j * chord_hz[1] / sps);
				double fifth = Math.sin(2 * Math.PI * j * chord_hz[2] / sps);
				wave[j] = (first + third + fifth)/3.0;
			}
			k = n;
		}
		return wave;
	}

	public static void main(String[] args) {
		Scale cMmajor = new Scale();
		StdAudio.play(gen_rand_prog(cMmajor, 4));
	}
}