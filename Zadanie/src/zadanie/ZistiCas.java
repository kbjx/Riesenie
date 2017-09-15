package zadanie;

import java.text.ParseException;

public class ZistiCas {

	public static void main(String[] args) {

		Time time = new Time();
		time.createLines();
		try {
			time.findTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}
}