package match;

public class Register {
	public Register(String name, String place, String dt) {
		this.name = name;
		this.place = place;
		this.dt = dt;
	}
	String name;
	String place;
	String dt;
	public String getName() {
		return name;
	}

	public String getPlace() {
		return place;
	}

	public String getDt() {
		return dt;
	}

}
