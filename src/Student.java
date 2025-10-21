import java.io.Serializable;

public class Student implements Comparable<Student>, Serializable {

	private static final long serialVersionUID = 3L;

	int indexOfStudentObjInList;
	String studentID;
	String lastName; // 0
	String firstName; // 1
	String streetAddress; // 2
	String city; // 3
	String state; // 4
	String zipcode; // 5
	String phone; // 6
	String email; // 7
	String DoB; // 8
	String lastFourOfSS; // 9
	String sex; // 10
	String major; // 11
	String currentGPA; // 12
	String withdrawn; // 13
	String balance; // 14
	String race; // 15

	Student() {} // Don't really need this
	
	public int compareTo(Student student) {		
		return lastName.compareTo(student.lastName);		
	}

	public void setIndexOfStudentObjInList(int indexOfStudentObjInList) {
		this.indexOfStudentObjInList = indexOfStudentObjInList;
	}

	public int getIndexOfObjInList() {
		return indexOfStudentObjInList;
	}

	public void setStudentID(String studentId) {
		this.studentID = studentId;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCity() {
		return city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getState() {
		return state;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone() {
		return phone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setDoB(String DoB) {
		this.DoB = DoB;
	}
	
	public String getDoB() {
		return DoB;
	}
		
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getSex() {
		return sex;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getMajor() {
		return major;
	}

	public void setCurrentGPA(String currentGPA) {
		this.currentGPA = currentGPA;
	}

	public String getCurrentGPA() {
		return currentGPA;
	}
	
	public void setWithdrawn(String withdrawn) {
		this.withdrawn = withdrawn;
	}
	
	public String getWithdrawn() {
		return withdrawn;
	}
	
	public void setBalance(String balance) {
		this.balance = balance;
	}
	
	public String getBalance() {
		return balance;
	}
	
	public void setRace(String race) {
		this.race = race;
	}

	public String getRace() {
		return race;
	}
}
