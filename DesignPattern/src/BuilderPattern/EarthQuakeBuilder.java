package BuilderPattern;

public class EarthQuakeBuilder implements Builder {
	
	private Home EarthQuakeHome = new Home();

	@Override
	public void buildFloor() {
		
		this.EarthQuakeHome.floor = "Wooden floor ";
	}

	@Override
	public void buildWall() {
		this.EarthQuakeHome.wall = "Wooden  Wall";
		
	}

	@Override
	public void buildTerrace() {
		this.EarthQuakeHome.terrace = "Wooden Terrace";
		
	}

	@Override
	public Home complexObject() {
		
		return this.EarthQuakeHome;
		
		
	}

}
