package application;

public class CrewRecord {
	private int id;
	private int pilot;
	private int copilot;
	private int fa1;
	private int fa2;
	private Airline airline;
	
	// Constructors
	public CrewRecord() {
		super();
		this.id = 0;
		this.pilot = 0;
		this.copilot = 0;
		this.fa1 = 0;
		this.fa2 = 0;
	}
	public CrewRecord(int id, int pilot, int copilot, int fa1, int fa2, Airline airline) {
		this.id = id;
		this.pilot = pilot;
		this.copilot = copilot;
		this.fa1 = fa1;
		this.fa2 = fa2;
		this.airline = airline;
	}
	
	public CrewRecord(int pilot, int copilot, int fa1, int fa2, Airline airline) {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPilot() {
		return pilot;
	}
	public void setPilot(int pilot) {
		this.pilot = pilot;
	}
	public int getCopilot() {
		return copilot;
	}
	public void setCopilot(int copilot) {
		this.copilot = copilot;
	}
	public int getFa1() {
		return fa1;
	}
	public void setFa1(int fa1) {
		this.fa1 = fa1;
	}
	public int getFa2() {
		return fa2;
	}
	public void setFa2(int fa2) {
		this.fa2 = fa2;
	}
	public Airline getAirline() {
		return airline;
	}
	public void setAirline(Airline airline) {
		this.airline = airline;
	}
	
}
