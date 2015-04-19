public class Tune {

	public static double[] combine_waves(double[] progression, double[] melody) {
		double[] wave = new double[melody.length];
		for (int i = 0; i < melody.length; i++) {
			wave[i] = (melody[i]*.2 + progression[i]*.8)*.5;
		}
		return wave;
	}
	

	public static void main(String[] args) {
		Scale cMmajor = new Scale();
		int measures = 30;
		double[] prog = Progression.gen_rand_prog(cMmajor, measures);
		double[] melo = Melody.gen_rand_mel(cMmajor, (double) (measures*2));

		double[] tune = combine_waves(prog, melo);
		//StdAudio.save("test.wav", tune);
		StdAudio.play(tune);

	}
}