package shadab.ds.hashtable;

public class SimpleHashtable {
	
	Employee[] hashtable;
	
	SimpleHashtable(){
		hashtable = new Employee[5];
	}
	
	public int hashKey(String key) {
		return (key.length() % hashtable.length);
	}
	
	public void put(String key, Employee employee) {
		int hashedKey = hashKey(key);
		int position = findEmptyPosition(hashedKey);
		if(position >= 0)
			hashtable[position] = employee;
		else
			System.out.println("Could not find empty place for - " + employee);
			
	}
	
	
	public Employee get(String key) {
		int position = findKeyPosition(key);
		
		if(position >= 0)
			return hashtable[position];
		
		return null;
		
	}
	
	public Employee remove(String key) {
		int position = findKeyPosition(key);
		
		if(position >= 0) {
			Employee employee = hashtable[position];
			hashtable[position] = null;
			return employee;
		}
		
		return null;
		
	}
	
	
	public void display() {
		System.out.println("Printing start----");
		for(int i=0; i<hashtable.length; i++)
			System.out.println(hashtable[i]);
		System.out.println("------Printing Over");
	}
	
	
	private int findEmptyPosition(int hashedKey) {
		//Handle invalid key
		if(hashedKey < 0 || hashedKey >= hashtable.length )
			return -1;
		
		//Handle case if the passed key position is empty 
		if(hashtable[hashedKey] == null)
			return hashedKey;
		
		//Linear probing
		int current = (hashedKey+1) % hashtable.length;
		
		while(hashtable[current] != null && current != hashedKey) {
			current = (current+1) % hashtable.length;
		}
		
		if(hashtable[current] == null)
			return current;
		
		return -1;
	}
	
	private int findKeyPosition(String key) {
		int hashedKey = hashKey(key);
		
		if(hashtable[hashedKey] != null && hashtable[hashedKey].getKey() == key)
			return hashedKey;
		
		int current = (hashedKey + 1) % hashtable.length;
		while(current != hashedKey && 
				(hashtable[current] == null ||	!	hashtable[current].getKey().equals(key) )) {
			current = (current + 1) % hashtable.length;
		}
		
		if(hashtable[current].getKey() == key)
			return current;
		
		return -1;
	}

}
