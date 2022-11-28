package studio9;

import java.util.HashMap;
import java.util.Map;

import assignment7.Student;

public class UniversityDatabase {
	//TODO: Complete this class according to the studio instructions
	
	private final Map <String, Student> database;

	//constructor
	public UniversityDatabase() {
		super();
		
		this.database = new HashMap < > ();
	}

	public void addStudent(String accountName, Student student) {
		
		this.database.put(accountName, student);
	}

	public int getStudentCount() {
		
		return this.database.size();
		
	}

	public String lookupFullName(String accountName) {
		
		if (this.database.containsKey(accountName)) {
			return this.database.get(accountName).getFullName();
		}
		
		else {
			return null;
		}

	}

	public double getTotalBearBucks() {
		
		double total = 0.0;
		for (String name : this.database.keySet()) {
			total += this.database.get(name).getBearBucksBalance();
		}
		
		return total;
	}
}
