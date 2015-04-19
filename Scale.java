public class Scale {

	private final String _tonic;
	private final int _oct;

	public Scale(String tonic, int oct) {
		this._tonic = tonic;
		this._oct = oct;
	}

	public Scale() {
		this("C", 2);
	}

	public int get_oct() {
		return _oct;
	}

	public double[] scale_freq() {
		String[] degree_names = {"A", "Bb", "B", "C", "Db", "D", "Eb", "E", "F", "Gb", "G", "Ab"};
		double[] steps = {2, 2, 1, 2, 2, 2, 1};
		int ind = 0;
		for (int i = 0; i < degree_names.length; i++) {if (degree_names[i].equals(_tonic)) ind = i;}

		double[] freqs = new double[7*_oct + 1];
		freqs[0] = 220 * Math.pow(2, ind/12.0);
		for (int i = 1; i < freqs.length; i++) {ind += steps[(i-1) % 7]; freqs[i] =  220 * Math.pow(2, ind/12.0);}
		return freqs;
	}


	public static void main(String[] args) {
		Scale cMmajor = new Scale();
		StdArrayIO.print(cMmajor.scale_freq());
		
	}
}