package AbstractFactoryPattern;

public class ProfessionFactory extends AbstractFactory {
	
	public Profession getInstance(String s ) {
		
		
		
		 if (s.equalsIgnoreCase("Doctor")) {
			Doctor d = new Doctor();
			d.getProfess();
			
			return d;
		}
		
		 else  if (s.equalsIgnoreCase("Teacher")) {
			 
			 Teacher t = new Teacher();
			 t.getProfess();
			
			return t;
		}
		 else 
				
				return null;
			}
		
		
		
	

}
