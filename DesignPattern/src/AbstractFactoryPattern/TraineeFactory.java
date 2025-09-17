package AbstractFactoryPattern;

public class TraineeFactory extends AbstractFactory  {
	
	public Profession getInstance(String s ) {
		
		
		
		 if (s.equalsIgnoreCase("Doctor")) {
			TraineeDoctor d = new TraineeDoctor();
			d.getProfess();
			
			return d;
		}
		
		 else  if (s.equalsIgnoreCase("Teacher")) {
			 
			 TraineeTeacher t = new TraineeTeacher();
			 t.getProfess();
			
			return t;
		}
		 else 
				
				return null;
			}
		

}
