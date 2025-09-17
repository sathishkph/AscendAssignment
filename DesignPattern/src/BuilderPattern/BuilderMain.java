package BuilderPattern;

public class BuilderMain {
	
	public static void main(String[] args) {
		
		EarthQuakeBuilder EQB = new EarthQuakeBuilder();
		
		Director d = new Director(EQB);
		d.manageConstruction();
		System.out.println(d.getComplexObject());
	}

}
