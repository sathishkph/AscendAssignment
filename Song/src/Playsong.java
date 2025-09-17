import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Playsong {
	
	 public static void shuffle(List<Integer> ls) {
		 
		 
		 int n = ls.size();
		 for (int i =n-1;i >= 0; i-- ) {   
			 
			 Random rand = new Random();
			 int v = rand.nextInt(i+1);  
			 int randomElement = ls.get(v);
			 
			 
			 int j = ls.get(i);
			 ls.set(i,randomElement);
			 
			 ls.set(v,j);
			 
			// System.out.println(j);
			 
			System.out.println(ls.get(i));
			 
			 
			 
			
		 }
		 
		 
		 
		 
	 } 
	 
	
	

	public static void main(String[] args) {
		List<Integer> ls = new ArrayList<>();
		ls.add(1);
		ls.add(2);
		ls.add(3);
		ls.add(4);
		ls.add(5);
		ls.add(6);
		
		Set<Integer> s =  new HashSet<>();
		
		s.add(1);
		s.add(2);
		s.add(3);
		s.add(4);
		s.add(5);
		s.add(6);
		
		System.out.println(s.toString());
		
	//	[1, 2, 3, 4, 5, 6]
		
		
		
	//shuffle(ls);
		


	}

}
