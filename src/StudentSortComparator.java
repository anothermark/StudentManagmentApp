import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentSortComparator {
	List<Student> sortedSERList;

	void sortStudentID(List<Student> sortedSERList) {
		Comparator<Student> STUDENT_ID_COMPARATOR = new Comparator<Student>() {
			public int compare(Student s1, Student s2) {
				return s1.getStudentID().compareTo(s2.getStudentID());
			}
		};

		try {
			Collections.sort(sortedSERList, STUDENT_ID_COMPARATOR);
		} catch (NullPointerException e) {
			System.out.println("NullPointerException");
		}
		saveSortedSERList(sortedSERList);
	}

	List<Student> sortLastNameAscending(List<Student> listStudent) {

		try {
			Collections.sort(listStudent);
		} catch (NullPointerException e) {
			System.out.println("NullPointerException");
		}
		return listStudent;
	}

	void sortLastNameReversed(List<Student> sortedSERList) {
		Comparator<Student> LAST_NAME_REVERSED_COMPARATOR = new Comparator<Student>() {
			public int compare(Student s1, Student s2) {
				int result = s2.getLastName().compareTo(s1.getLastName());
				return result;
			}
		};

		try {
			Collections.sort(sortedSERList, LAST_NAME_REVERSED_COMPARATOR);
		} catch (NullPointerException e) {
			System.out.println("NullPointerException");
		}
		saveSortedSERList(sortedSERList);
	}

	void sortCity(List<Student> sortedSERList) {
		Comparator<Student> CITY_COMPARATOR = new Comparator<Student>() {
			public int compare(Student s1, Student s2) {
				int result = s1.getCity().compareTo(s2.getCity());
				return result;
			}
		};

		try {
			Collections.sort(sortedSERList, CITY_COMPARATOR);
		} catch (NullPointerException e) {
			System.out.println("NullPointerException");
		}
		saveSortedSERList(sortedSERList);
	}

	void sortMajor(List<Student> sortedSERList) {
		Comparator<Student> MAJOR_COMPARATOR = new Comparator<Student>() {
			public int compare(Student s1, Student s2) {
				int result = s1.getMajor().compareTo(s2.getMajor());
				return result;
			}
		};

		try {
			Collections.sort(sortedSERList, MAJOR_COMPARATOR);
		} catch (NullPointerException e) {
			System.out.println("NullPointerException");
		}
		saveSortedSERList(sortedSERList);
	}

	void sortZipcode(List<Student> sortedSERList) { 
		Comparator<Student> ZIPCODE_COMPARATOR = new Comparator<Student>() {
			public int compare(Student s1, Student s2) {
				int result = Integer.parseInt(s1.getZipcode()) - Integer.parseInt(s2.getZipcode());
				return result;
			}
		};

		try {
			Collections.sort(sortedSERList, ZIPCODE_COMPARATOR);
		} catch (NullPointerException e) {
			System.out.println("NullPointerException");
		}
		saveSortedSERList(sortedSERList);
	}

	void sortGPA(List<Student> sortedSERList) {

		// PROBLEM WITH THESE DOUBLES THAT DON'T SORT PROPERLY
		Comparator<Student> GPA_COMPARATOR = new Comparator<Student>() {
			public int compare(Student s1, Student s2) {
				int result = (int) (Double.parseDouble(s1.getCurrentGPA()) - Double.parseDouble(s2.getCurrentGPA()));
				return result;
			}
		};

		try {
			Collections.sort(sortedSERList, GPA_COMPARATOR);
			System.out.println(sortedSERList);
		} catch (NullPointerException e) {
			System.out.println("NullPointerException");
		}
		saveSortedSERList(sortedSERList);
	}
	
	// sortBalance DISCONTINUED. NOT WORTH THE EFFORT TO REMOVE $ AND COMMAS, AND REINSERT.
	void sortBalance(List<Student> sortedSERList) {

		Comparator<Student> BALANCE_COMPARATOR = new Comparator<Student>() {
			public int compare(Student s1, Student s2) {
				int result = ((int) (Double.parseDouble(s1.getBalance()) - Double.parseDouble(s2.getBalance())));
				return result;
			}
		};

		try {
			Collections.sort(sortedSERList, BALANCE_COMPARATOR);
			System.out.println(sortedSERList);
		} catch (NullPointerException e) {
			System.out.println("NullPointerException");
		}
		saveSortedSERList(sortedSERList);
	}

	List<Student> saveSortedSERList(List<Student> sortedSERList) {
		try (var out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("sortedSERList")))) {
			out.writeObject(sortedSERList);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sortedSERList;
	}

	List<Student> returnSortedSERList() throws IOException, ClassNotFoundException {
		//ArrayList<Student> listOfObject;

		try (var in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("sortedSERList")))) {
			var listObject = in.readObject();
			if (listObject instanceof List)
				sortedSERList = (ArrayList<Student>) listObject; // Don't understand what they are getting at
				return sortedSERList;
		} catch (IOException e) {
		}
		return sortedSERList;

	}

}
