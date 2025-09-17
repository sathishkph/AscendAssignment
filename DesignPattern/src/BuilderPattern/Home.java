package BuilderPattern;

import java.io.Serializable;

public class Home implements Serializable {
	
	
	public  String wall;
	public  String floor;
	public  String terrace;
	@Override
	public String toString() {
		return "Home [wall=" + wall + ", floor=" + floor + ", terrace=" + terrace + "]";
	}
	
}
