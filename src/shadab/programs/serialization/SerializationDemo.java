package shadab.programs.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Employee implements Serializable{
	String name;
	transient int ssn;
	Employee(String name, int ssn){
		this.name = name;
		this.ssn = ssn;
	}
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("name : " + this.name);
		sb.append("ssn : " + this.ssn);
		return sb.toString();
	}
}

public class SerializationDemo {
	
	public void serialize(Employee emp, String filename){
		try {
			FileOutputStream fileOut = new FileOutputStream(filename);
			ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
			objOut.writeObject(emp);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Employee deserialize(String filename){
		Employee emp = null;
		try {
			FileInputStream fileInput = new FileInputStream(filename);
			ObjectInputStream objInput = new ObjectInputStream(fileInput);
			emp = (Employee) objInput.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
		
	}

	public static void main(String[] args) {
		SerializationDemo demo = new SerializationDemo();
		Employee emp1 = new Employee("Shadab", 123);
		demo.serialize(emp1, "employee.ser");
		Employee newEmployee = demo.deserialize("employee.ser");
        System.out.println(newEmployee);
	}

}
