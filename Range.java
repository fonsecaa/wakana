public class Range {

	private final double _lo;
	private final double _hi;

	public Range() {
		this._lo = 110;
		this._hi = 880;
	}

	public Range(double lo, double hi) {
		this._lo = lo;
		this._hi = hi;
	}

	public double[] included_freqs() {
		int cnt = 0;
		double track = _lo;
		while (track < _hi) {
			track = _lo * Math.pow(2, cnt/12.0);
			cnt++;
		}
		double[] rv = new double[cnt];
		for (int i = 0; i < cnt; i++) {
			rv[i] = _lo * Math.pow(2, cnt/12.0);
		}
		return rv;
	}

	public static void main(String[] args) {
		Range a1_a4 = new Range();
		double[] chromatic_hz = a1_a4.included_freqs();
		for (int i = 0; i < chromatic_hz.length; i++) {
			System.out
		}
	}
}