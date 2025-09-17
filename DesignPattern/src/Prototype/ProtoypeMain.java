package Prototype;

public class ProtoypeMain {

	public static void main(String[] args) {

		Professioncache.loadCache();

		Profession doc = Professioncache.getCloneInstance(1);
		System.out.println(doc);
		Profession teacher = Professioncache.getCloneInstance(2);
		System.out.println(teacher);
		Profession doc2 = Professioncache.getCloneInstance(1);
		System.out.println(doc2);

	}

}
