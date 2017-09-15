package zadanie;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Time {

	// set range of Id, special char, no match output and date format
	private final int range = 0;
	private final char specChar = '*';
	private final char noMatch = '-';
	private final String dateFormat = "dd.MM.yyyy";

	private int timeAll = 0;
	private int countAnswer = 0;

	DateFormat format = new SimpleDateFormat(dateFormat);
	List<Riadok> riadky = new ArrayList<Riadok>();
	Nacitaj nacitaj = new Nacitaj();

	// detect special char or split id
	public String findId(String line) {
		if (line.charAt(0) == (specChar)) {
			return "0";
		} else {
			return line.split("\\.")[range];
		}
	}

	// create all line objects
	public void createLines() {
		for (int i = 1; i <= nacitaj.getCountLines(); i++) {

			// read and split line
			nacitaj.TentoRiadok(i);
			nacitaj.getLine().trim();
			String[] riadok = nacitaj.getLine().split("\\s+");

			char quesAns = riadok[0].charAt(0);
			String serviceID = findId(riadok[1]);
			String typeOfQest = findId(riadok[2]);
			char typeOfAns = riadok[3].charAt(0);

			// handle dates
			String[] dateFromTo = (riadok[4]).split("­");
			String dateFrom = dateFromTo[0];
			String dateTo = "0";
			if (dateFromTo.length > 1)
				dateTo = dateFromTo[1];

			// find if question or answer
			int timeOfAnswer = firstCon(quesAns) ? Integer.parseInt(riadok[5]) : 0;

			// create object with specific parameters
			riadky.add(new Riadok(quesAns, serviceID, typeOfQest, typeOfAns, dateFrom, dateTo, timeOfAnswer));
		}
	}

	// find time of answers which satisfy conditions
	public void findTime() throws ParseException {

		for (int i = 1; i < nacitaj.getCountLines(); i++) {

			timeAll = 0;
			countAnswer = 0;
			if (!(firstCon(riadky.get(i).getQuesAns()))) {

				for (int j = 0; j < i; j++) {
					boolean allCorrect = true;
					// convert string to date format
					Date questionFrom = format.parse(riadky.get(i).getDateFrom());
					Date answerFrom = format.parse(riadky.get(j).getDateFrom());

					// try first condition
					if (!(firstCon(riadky.get(j).getQuesAns())))
						allCorrect = false;
					// try second condition
					if (!(secondCon(riadky.get(i).getServiceId(), riadky.get(j).getServiceId())))
						allCorrect = false;
					// try third condition
					if (!(thirdCon(riadky.get(i).getTypeOfQest(), riadky.get(j).getTypeOfQest())))
						allCorrect = false;
					// try fourth condition
					if (!(fourthCon(questionFrom, answerFrom)))
						allCorrect = false;
					// try fifth condition
					if (!(fifthCon(riadky.get(i).getDateTo(), answerFrom)))
						allCorrect = false;
					// count time if satisfy all conditions
					if (allCorrect) {
						timeAll = timeAll + riadky.get(j).getTimeOfAnswer();
						countAnswer++;
					}
				}
				printTimes();
			}
		}
	}

	// print times
	private void printTimes() {
		if (countAnswer > 0) {
			System.out.println(timeAll / countAnswer);
		} else {
			System.out.println(noMatch);
		}
	}

	// conditions
	private boolean firstCon(char typeOfLine) {
		return typeOfLine == 'C';
	}

	private boolean secondCon(String questionSer, String answerSer) {
		return questionSer.equals(answerSer) || questionSer.equals("0");
	}

	private boolean thirdCon(String questionType, String answerType) {
		return questionType.equals(answerType) || questionType.equals("0");
	}

	private boolean fourthCon(Date quetionFrom, Date answerFrom) {
		return quetionFrom.before(answerFrom);
	}

	private boolean fifthCon(String date, Date answerFrom) throws ParseException {
		boolean con = true;
		if (!(date.equals("0"))) {
			Date dateQuestionTo = format.parse(date);
			if (dateQuestionTo.before(answerFrom))
				con = false;
		}
		return con;
	}

}