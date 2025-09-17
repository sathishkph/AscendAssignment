package Singelton;

public class SingletonClass {
	
	private static SingletonClass singletonClass = new SingletonClass();
	
	
	private SingletonClass() {}
	
	public static SingletonClass getInstance() {
		
		System.out.println("object is getting created");
		
		return singletonClass;
	}
	

}
