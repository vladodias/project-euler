package vlad.euler.grid;

public class Helper {

	public static String zeroPad(long number) {
		String str = "00" + number;
		return str.substring(str.length() - 2);
	}

}
