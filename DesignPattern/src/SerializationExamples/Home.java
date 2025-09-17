package SerializationExamples;

import java.io.Serializable;

public class Home implements Serializable {
	
	
	public  String wall;

	public  String floor;
	public  String terrace;
	
	public Home(String wall, String floor, String terrace) {
		super();
		this.wall = wall;
		this.floor = floor;
		this.terrace = terrace;
	}
	
	@Override
	public String toString() {
		return "Home [wall=" + wall + ", floor=" + floor + ", terrace=" + terrace + "]";
	}
	
}
