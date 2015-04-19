public class Melody {

	public static double[] gen_rand_mel(Scale key, double t) {
		double[] opt_freqs = key.scale_freq();
		double[] opt_duras = {.25, .25, .25, .25, .5, .5, 1};

		double sps = 44100;
		int N = (int) (sps * t);
		double[] wave = new double[N];
		double t0 = 0;
		int j = 0;
		int n = 0;

		while (t0 < t) {

			double temp_pitch = opt_freqs[(int) (Math.random()*opt_freqs.length)];
			double temp_duras = opt_duras[(int) (Math.random()*opt_duras.length)];
			if ((t - t0) < temp_duras) temp_duras = t - t0;
			n += (int) (sps * temp_duras);
			for (int i = j; i < n; i++) wave[i] = Math.sin(2 * Math.PI * i * temp_pitch / sps);
			j = n;
			t0 += temp_duras;

		}
		return wave;
	}

	public static void main(String[] args) {
		Scale cMmajor = new Scale();
		StdAudio.play(gen_rand_mel(cMmajor, 5));
	}
}










