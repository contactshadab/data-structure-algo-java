package shadab.ds.hashtable;

public class Main {

	public static void main(String[] args) {
		SimpleHashTable ht = new SimpleHashTable();
		Employee john = new Employee("smith", "John");
		Employee james = new Employee("doe", "James");
		Employee alice = new Employee("xi", "Alice");
		Employee jane = new Employee("t", "Jane");
		Employee joy = new Employee("main", "Joy");
		
		ht.put("smith", john);
		ht.put("doe", james);
		ht.put("xi", alice);
		//ht.put("t", jane);
		ht.put("main", joy);
		ht.put("ax", new Employee("ax", "Bob"));
		ht.display();
		System.out.println("ax: " + ht.get("ax"));
		System.out.println("Removed: " + ht.remove("main"));
		ht.display();
		System.out.println("ax: " + ht.get("ax"));
		ht.display();
	}

}
