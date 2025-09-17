package Prototype;

import java.util.Hashtable;

public class Professioncache {

	private static Hashtable<Integer, Profession> professionTable = new Hashtable<>();

	public static Profession getCloneInstance(int id) {

		Profession profession = professionTable.get(id);

		return (Profession) profession.cloneMethod();

	}

	public static void loadCache() {

		Doctor d = new Doctor();
		d.id = 1;

		professionTable.put(d.id, d);

		Teacher t = new Teacher();
		t.id = 2;
		professionTable.put(t.id, t);

	}

}
