package FactoryPattern;

public class main {

	public static void main(String[] args) {
		ProfessionFactory professionFactory = new ProfessionFactory();
		
		System.out.println(professionFactory.getInstance("Doctor") );
		
		System.out.println(professionFactory.getInstance("Teacher"));
		
		System.out.println(professionFactory.getInstance("Doctor") );
		
	}

}
