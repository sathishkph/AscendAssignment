package StringAlgo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LongestSubString {
	
	static List<String> a ;
	
	public String longestSubstring(List<String> list) {
		
		
		
		for(String s:list ) {
			HashMap<String,Integer> h = new HashMap<>();
			
			int count = 0;
			int n = s.length(); 
			for(int i = 1;i<n;i++) 
				{
				
				//a ,aa,b,
				for (int j = 0; j< i;j++) {
					
					String temp =s.substring(j,i-j+1); //i = 0;j =0 -->(
					if (h.containsKey(temp)) { count++;}
					else { 
						h.put(temp, count);
						}
						
						
					
				}
				
				
			}
		}
		
		return null;
	}
	
	//aab,ab,aa
	//pwwkew,
	
	

	public static void main(String[] args) {
	a= new ArrayList<>();
		
		a.add("aab");
		a.add("pwwkew");
		a.add("abcbcabcda");
		
	}

}
