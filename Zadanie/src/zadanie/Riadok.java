package zadanie;

public class Riadok {

	// C sluzba_id[.variacia_id] typ_otazky_id[.kategoria_id.[pod-kategoria_id]] P/N datum cas
	private char quesAns;
	private String serviceId;
	private String typeOfQest;
	private char typeOfAns;
	private String dateFrom;
	private String dateTo;
	private int timeOfAnswer;

	// constructor
	public Riadok(char quesAns, String serviceId, String typeOfQest, char typeOfAns, String dateFrom, String dateTo, int timeOfAnswer) {
		this.quesAns = quesAns;
		this.serviceId = serviceId;
		this.typeOfQest = typeOfQest;
		this.typeOfAns = typeOfAns;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		this.timeOfAnswer = timeOfAnswer;
	}

	public char getQuesAns() {return quesAns;}

	public String getServiceId() {return serviceId;}

	public String getTypeOfQest() {return typeOfQest;}

	public char getTypeOfAns() {return typeOfAns;}

	public String getDateFrom() {return dateFrom;}

	public String getDateTo() {return dateTo;}

	public int getTimeOfAnswer() {return timeOfAnswer;}

}