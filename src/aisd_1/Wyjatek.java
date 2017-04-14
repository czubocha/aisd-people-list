package aisd_1;

public class Wyjatek extends Exception {

	private static final long serialVersionUID = -2934501481364298980L;
	
	String s;
	
	public Wyjatek(String s) {
		super(s);
	}

}
