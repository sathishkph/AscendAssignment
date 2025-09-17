package Prototype;

public abstract class  Profession implements Cloneable  {
	
	
	
	public int id;
	public String name;
	
	abstract void print();
	
	public   Object cloneMethod() {
		
		try {
		
			return super.clone();
			
		}
		catch (Exception e) {
			return null;
		}
		
		
	}
	
	
	
	

}
