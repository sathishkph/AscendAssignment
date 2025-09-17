package BuilderPattern;

public class Director {
	
	private Builder builder;
	
	public Director (Builder builder) {
		this.builder = builder;
	}

	public Home getComplexObject() {
		return this.builder.complexObject();
	}
	
	public void manageConstruction() {
		
		this.builder.buildFloor();
		this.builder.buildTerrace();
		this.builder.buildWall();
	}
}
