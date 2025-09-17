package com.student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

public class SortHashValue {
	
	public  static List<Entry<String,Integer>>  compare1() {
		
		return null;
		
	}

	public static void main(String[] args) {
		
		
		
		Map<String,Integer> map = new HashMap<>();
		
		map.put("Sathish", 1);
		map.put("Sathish2", 2);
		map.put("Sathish3", 3);
		map.put("Sathish4", 4);
		map.put("Sathish5", 5);
		map.put("hi", 4);
		map.put("sasmi", 5);
		
		System.out.println(map);
		
		
		
		//System.out.println(linkedMap);
		 Set<Entry<String,Integer>>  entrySet = map.entrySet();
		 
			System.out.println(entrySet);
		 
		// TreeSet<Entry<String,Integer>> treeset = new TreeSet<>(entrySet);
		 
		 List<Entry<String,Integer>> list = new ArrayList<>(entrySet);	
		 
		
		 
			list.sort((x,y) -> x.getValue().compareTo(y.getValue()));
			
			System.out.println(list);
			
			list.sort((x,y) -> x.getValue().compare(y.getValue(), x.getValue()));
			System.out.println(list);
			
			Map<String,Integer> linkedMap = new LinkedHashMap<>();
			list.stream().forEach(x -> linkedMap.put(x.getKey(),x.getValue()));
			
			System.out.println("sorted map" + linkedMap);
			
			
			
			
			
			
		
			
		
			
			
			
			
		
		
		
		
		

	}

}
