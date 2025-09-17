package AbstractFactoryPattern;

public class main {

	public static void main(String[] args) {
		AbstractFactory abstractFactory = AbstractFactoryProducer.getProfession(false) ;
		
		
		
		
		System.out.println(abstractFactory.getInstance("Doctor") );
		
		System.out.println(abstractFactory.getInstance("Teacher"));
		
		System.out.println(abstractFactory.getInstance("Teacher"));
		System.out.println(abstractFactory.getInstance("Doctor"));
		
	}

}
