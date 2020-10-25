package dataStructure.hashtable;

public class Main {

	public static void main(String[] args) {
		//SimpleHashtable ht = new SimpleHashtable();
		ChainedHashtable ht = new ChainedHashtable();
		Employee john = new Employee("smith", "John");
		Employee james = new Employee("doe", "James");
		Employee alice = new Employee("xi", "Alice");
		Employee jane = new Employee("T", "Jane");
		Employee joy = new Employee("main", "Joy");
		
		ht.put("smith", john);
		ht.put("doe", james);
		ht.put("xi", alice);
		ht.put("t", jane);
		ht.put("main", joy);
		ht.put("ax", new Employee("ax", "Bob"));
		ht.put("TW", new Employee("TW", "Mary"));
		ht.display();
		System.out.println("ax: " + ht.get("ax"));
		System.out.println("Removed: " + ht.remove("ax"));
		ht.display();
		System.out.println("Removed: " + ht.remove("TW"));
		ht.display();
		System.out.println("Removed: " + ht.remove("xi"));
		ht.display();
//		System.out.println("ax: " + ht.get("ax"));
//		ht.display();
	}

}
