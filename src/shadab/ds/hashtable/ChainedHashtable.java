package shadab.ds.hashtable;

import java.util.LinkedList;
import java.util.ListIterator;

public class ChainedHashtable {
	
	LinkedList<Employee>[] hashtable;
	
	ChainedHashtable(){
		hashtable = new LinkedList[10];
		
		for(int i=0; i<hashtable.length; i++) {
			hashtable[i] = new LinkedList<Employee>();
		}
	}
	
	public int hashKey(String key) {
		return (Math.abs(key.hashCode()) % hashtable.length);
	}
	
	public void put(String key, Employee employee) {
		int hashedKey = hashKey(key);
		hashtable[hashedKey].add(employee);
	}
	
	public Employee get(String key) {
		int hashedKey = hashKey(key);
		
		ListIterator<Employee> listIterator = hashtable[hashedKey].listIterator();
		while(listIterator.hasNext()) {
			Employee employee = listIterator.next();
			if(employee.getKey().equals(key))
				return employee;
		}
		
		return null;
	}
	
	public Employee remove(String key) {
		int hashedKey = hashKey(key);
		
		ListIterator<Employee> listIterator = hashtable[hashedKey].listIterator();
		while(listIterator.hasNext()) {
			Employee employee = listIterator.next();
			
			if(employee.getKey().equals(key)) {
				hashtable[hashedKey].remove(employee);
				return employee;
			}
		}
		
		return null;
	}
	
	public void display() {
		for(int i=0; i<hashtable.length; i++) {
			if(hashtable[i] == null) {
				System.out.println("Position " + i + ": Empty");
			}else {
				System.out.print("Position " + i + ": ");
				ListIterator<Employee> listIterator = hashtable[i].listIterator();
				while(listIterator.hasNext()) {
					System.out.print(listIterator.next() + " -> ");
				}
				System.out.println("");
			}
		}
	}
	
	
}
