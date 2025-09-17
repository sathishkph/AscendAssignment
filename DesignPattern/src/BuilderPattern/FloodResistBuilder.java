package BuilderPattern;

public class FloodResistBuilder implements Builder  {
	
	private Home floodResistHome = new Home();

	@Override
	public void buildFloor() {
		
		this.floodResistHome.floor = "10 Feet above";
	}

	@Override
	public void buildWall() {
		this.floodResistHome.wall = "Concrete Wall";
		
	}

	@Override
	public void buildTerrace() {
		this.floodResistHome.terrace = "concrete Terrace";
		
	}

	@Override
	public Home complexObject() {
		// TODO Auto-generated method stub
		return this.floodResistHome;
	}

}
