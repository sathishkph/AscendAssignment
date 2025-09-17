package com.student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailFast extends ArrayList {
	
	


	public static void main(String[] args) {
		/*
		 * List<String> s1 = new CopyOnWriteArrayList<>(); s1.add("sathish");
		 * s1.add("sasmitha");
		 * 
		 * Iterator<String> iterator = s1.iterator();
		 * 
		 * while (iterator.hasNext()) { String s = iterator.next();
		 * 
		 * System.out.println(s); s1.add("hi"); }
		 * 
		 * 
		 */
		
		
		
		List<String> s1 = new ArrayList<>();
		
		
		s1.add("hi");
		s1.add("hi");
		s1.add("sathish");
		System.out.println(s1);
		
		
//		Map<Integer,String> map1 = new TreeMap<>();
//		
//		map1.put(1, "sathish");
//		map1.put(2, "sathish");
//		map1.put(4, "sathish");
//		map1.put(3, "sathish");
//		map1.put(3, "sathish");
//		
//		
//		System.out.println(map1);
		
		Map<Integer,String> map = new HashMap<>();
		Map<Integer,String> map1 = new HashMap<>();
		map.put(1, "sathish");
		map.put(2, "sas");
		map.put(3, "hi");
		map1.putAll(map);
		
		String  s = map.get((1));
		
		int [] a = new int [3];
		
		a[0] = 1;
		a[1] = 2;
		a[2] = 3;
		
int [] b = new int [3];
		
		b[0] = 1;
		b[1] = 2;
		b[2] = 3;
		
	
		
		
		
		
		boolean b = map.containsKey(1);
		System.out.println(map1 + "******" + s + "****************" + b);
//		
//		Iterator<Entry<Integer, String>> iterator = map.entrySet().iterator();
//		while(iterator.hasNext()) {
//			Entry<Integer, String> s1 = iterator.next();
//			System.out.println(s1);
//		   map.put(4, "hi");
//		}
		
		
		

	}

	@Override
	public boolean add(Object e) {
		
		System.out.println("methid is geting");
		if (this.contains(e)) {
		
			return true;
		}
		else {
		
		return super.add(e);
		}
	}

}
