package SerializationExamples;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SerializationExample {

	public static void main(String[] args) throws IOException {
		
		File a = new File("C:\\Users\\s0p05qj\\Documents");
		
		FileWriter fileWriter = new FileWriter(a);
		
		Home h = new Home("wood","terrance","Painting");
		
		

	}

}
