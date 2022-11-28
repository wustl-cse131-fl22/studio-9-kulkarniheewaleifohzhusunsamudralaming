package assignment7;

//TODO: Copy a working Student class from Assignment 7 over this file.
public class Student {
	private String firstName; //these are the instance variables - defined within the class, but not in the methods themselves
	private String lastName;
	private int idNumber;
	private int attemptedCredits;
	private int passingCredits;
	private double gradeQualityPoints;
	private double bearBucksBalance;

	//when do you use static and void when writing a method? 


	public Student (String firstName, String lastName, int idNumber) { //constructor 
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = idNumber;
	}

	/**
	 * 
	 * @return the first name
	 */

	public String getFirstName() {
		return this.firstName;
	}

	/**
	 * 
	 * @return the last name
	 */

	public String getLastName() {
		return this.lastName;
	}

	/**
	 * 
	 * @return the student ID number
	 */

	public int getIdNumber() {
		return this.idNumber;
	}

	/**
	 * 
	 * @return the number of the student's attempted credits
	 */

	public int getAttemptedCredits() {
		return this.attemptedCredits;
	}

	/**
	 * 
	 * @return the number of the student's passing credits
	 */

	public int getPassingCredits() {
		return this.passingCredits;
	}

	/**
	 * 
	 * @return the student's full name (first and last)
	 */

	public String getFullName() {
		return(this.firstName + " " + this.lastName);
	}

	/**
	 * 
	 * @return the student's ID number
	 */

	public int getId () {
		return(this.idNumber);
	}

	/**
	 * 
	 * @param grade is the student's grade for the course
	 * @param credits is the number of credits for the course
	 */

	public void submitGrade(double grade, int credits) {
		this.attemptedCredits += credits;

		if (grade >= 1.7) {
			this.passingCredits = this.passingCredits + credits;
		}

		this.gradeQualityPoints = (grade * credits) + this.gradeQualityPoints;
	}


	/**
	 * Returns the number of the student's total attempted credits
	 * @return the number of the student's total attempted credits
	 */

	public int getTotalAttemptedCredits() {
		return this.attemptedCredits;
	}


	/**
	 * 
	 * @return the number of the student's total passing credits
	 */

	public int getTotalPassingCredits() {
		return this.passingCredits;
	}


	/**
	 * 
	 * @return the student's GPA
	 */

	public double calculateGradePointAverage() {
		return this.gradeQualityPoints / this.attemptedCredits;
	}

	/**
	 *
	 * @return the student's class
	 */

	public String getClassStanding() {
		if (this.passingCredits < 30) {
			return "First Year";
		}
		else if (this.passingCredits >= 30 && this.passingCredits < 60) {
			return "Sophomore";
		}
		else if (this.passingCredits >= 60 && this.passingCredits < 90) {
			return "Junior";
		}
		else {
			return "Senior";
		}
	}

	/**
	 * 
	 * @return whether the student can join Phi Beta Kappa
	 */

	public boolean isEligibleForPhiBetaKappa() {
		if (this.attemptedCredits >= 98 && this.calculateGradePointAverage() >= 3.60) {
			return true;
		}
		else if (this.attemptedCredits >= 75 && this.calculateGradePointAverage() >= 3.80) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Returns the amount of bear bucks in the student's account after money is deposited
	 * @param amount - this is the amount of money in the student's account before any transaction
	 */

	public void depositBearBucks(double amount) {
		this.bearBucksBalance += amount;
	}


	/**
	 * Returns the amount of bear bucks in the student's account after money is withdrawn
	 * @param amount - this is the amount of money in the student's account before any transaction
	 */

	public void deductBearBucks (double amount) {
		this.bearBucksBalance -= amount;
	}


	/**
	 * Returns the student's bear bucks balance
	 * @return
	 */

	public double getBearBucksBalance () {
		return this.bearBucksBalance;
	}

	/**
	 * Subtracts a $10 administrative fee, then returns the amount left in the student's bear bucks account. Then zeroes out the account
	 * @return
	 */

	public double cashOutBearBucks() {
		double temp = this.bearBucksBalance;
		this.bearBucksBalance = 0;

		if (temp <= 10) {
			return 0.0;
		}
		else {
			return temp - 10.0;
		}
	}

	/**
	 * Returns the child's first name, last name, ID number
	 * @param firstName - this is the first name of the student
	 * @param other - this is the other parent
	 * @param isHyphenated - this determines whether the child has a hyphenated last name
	 * @param id - this is the studen't ID number 
	 * @return
	 */

	public Student createLegacy (String firstName, Student other, boolean isHyphenated, int id) {
		if (isHyphenated) {
			Student child = new Student(firstName, this.lastName + "-" + other.lastName, id);
			child.bearBucksBalance = this.cashOutBearBucks() + other.cashOutBearBucks();
			return child;
		}
		else {
			Student child = new Student(firstName, this.lastName, id);
			child.bearBucksBalance = this.cashOutBearBucks() + other.cashOutBearBucks();
			return child;
		}
	}

	/**
	 * Returns the student's full name and ID number as a String 
	 */

	public String toString() {
		return this.getFullName() + this.getIdNumber();
	}
}
