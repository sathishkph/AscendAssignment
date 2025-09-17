package AbstractFactoryPattern;

public class AbstractFactoryProducer {
	
	public static AbstractFactory getProfession(boolean isTrainee) {
		
		if (isTrainee == true) {
			
			return new TraineeFactory();
			
		}
		
		else {
			
			return new ProfessionFactory();
		}
		
	}

}
