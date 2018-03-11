package shadab.programs.hashtable.duplicateLinkedList;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;

public class RemoveDuplicateItemsLinkedList {

	public static void main(String[] args) {
		LinkedList<Employee> employees = new LinkedList();
		employees.add(new Employee("Jane", "Jones", 123));
        employees.add(new Employee("John", "Doe", 5678));
        employees.add(new Employee("Mike", "Wilson", 45));
        employees.add(new Employee("Mary", "Smith", 5555));
        employees.add(new Employee("John", "Doe", 5678));
        employees.add(new Employee("Bill", "End", 3948));
        employees.add(new Employee("Jane", "Jones", 123));
        
        Map<Integer, Employee> empMap = new HashMap();
        ListIterator<Employee> iterator = employees.listIterator();
        
        while(iterator.hasNext()) {
        	Employee employee = iterator.next();
        	if(empMap.containsKey(employee.getId())) {
        		iterator.remove();
        		System.out.println("Duplicate: " + employee);
        	}
        	else
        		empMap.put(employee.getId(), employee);
        }
        
        employees.forEach(emp -> System.out.println(emp));
        
	}

}
