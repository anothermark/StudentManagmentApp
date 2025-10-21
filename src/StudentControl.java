import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StudentControl implements Serializable {

	private static final long serialVersionUID = 2L;

	List<Student> returnedStudentArrayListSER;
	int indexOfStudentObjInList;
	Student student;
	String searchThisString;
	String[] enteredValuesArray; // Very important, from values from mainframe
	ArrayList<String> aListForComboSER;

	StudentControl() {
	}

	// Build anonymous Student objects
	void studentFactory(String lastNameSearched, String[] enteredValuesArray) throws IOException {
		String lastNameTest = enteredValuesArray[0];

		try {
			returnedStudentArrayListSER = getListOfStudents();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}

		if (returnedStudentArrayListSER == null) {
			returnedStudentArrayListSER = new ArrayList<>();
		}

		NoLastName: if (lastNameTest.equals("")) {
			break NoLastName;
		} else {

			// Create anonymous Student object
			Student studentAnon = new Student() {
				private static final long serialVersionUID = 4L;
			}; // End of anonymous

			Integer ID = returnedStudentArrayListSER.size();
			studentAnon.setStudentID(ID.toString());
			studentAnon.setLastName(enteredValuesArray[0]);
			studentAnon.setFirstName(enteredValuesArray[1]);
			studentAnon.setStreetAddress(enteredValuesArray[2]);
			studentAnon.setCity(enteredValuesArray[3]);
			studentAnon.setState(enteredValuesArray[4]);
			studentAnon.setZipcode(enteredValuesArray[5]);
			studentAnon.setPhone(enteredValuesArray[6]);
			studentAnon.setEmail(enteredValuesArray[7]);
			studentAnon.setDoB(enteredValuesArray[8]);
			studentAnon.setSex(enteredValuesArray[9]);
			studentAnon.setMajor(enteredValuesArray[10]);
			studentAnon.setCurrentGPA(enteredValuesArray[11]);
			studentAnon.setBalance(enteredValuesArray[12]);
			studentAnon.setRace(enteredValuesArray[13]);

			// Add the student objects
			if (returnedStudentArrayListSER.size() < 5) {
				returnedStudentArrayListSER.add(studentAnon);
				// Now get the index
				int index = returnedStudentArrayListSER.indexOf(studentAnon);
				// Then set the index in student object
				studentAnon.setIndexOfStudentObjInList(index);
				saveListOfStudentsToFile(returnedStudentArrayListSER);
				returnedStudentArrayListSER = getReturnedStudentArrayListSER();
			}
		}
	}

	void saveListOfStudentsToFile(List<Student> returnedStudentArrayListSER) throws IOException {
		try (var out = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream("returnedStudentArrayListSER")))) {
			out.writeObject(returnedStudentArrayListSER); // I need to
		}
	}

	List<Student> getReturnedStudentArrayListSER() {
		return returnedStudentArrayListSER;
	}

	@SuppressWarnings("unchecked")
	List<Student> getListOfStudents() throws IOException, ClassNotFoundException {
		//ArrayList<Student> listOfObject;

		try (var in = new ObjectInputStream(
				new BufferedInputStream(new FileInputStream("returnedStudentArrayListSER")))) {
			var listObject = in.readObject();
			if (listObject instanceof List)
				returnedStudentArrayListSER = (ArrayList<Student>) listObject;
			return returnedStudentArrayListSER;
		} catch (IOException e) {
		}
		return returnedStudentArrayListSER;
	}

	void addUpdatedStudentToSerList(Student updatedStudent, int indexOfStudentObjInList)
			throws ClassNotFoundException, IOException {
		returnedStudentArrayListSER = getListOfStudents();
		returnedStudentArrayListSER.set(indexOfStudentObjInList, updatedStudent);
		saveListOfStudentsToFile(returnedStudentArrayListSER);
		returnedStudentArrayListSER = getListOfStudents();
	}

	Student getNextStudentFromList() {
		Student nextStudent = null;

		for (int i = 0; i < returnedStudentArrayListSER.size(); i++) {
			if (returnedStudentArrayListSER.get(i).getLastName() == null) {
				nextStudent = returnedStudentArrayListSER.get(i);
				return nextStudent;
			}
		}
		return nextStudent;
	}

	void saveLastNameListSER(List<String> aListForComboSER) throws IOException {
		try (var out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("aListForComboSER")))) {
			out.writeObject(returnedStudentArrayListSER);
		}
	}

	List<String> getLastNameListSER() throws IOException, ClassNotFoundException {
		//ArrayList<String> listOfObject;

		try (var in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("aListForComboSER")))) {
			var listObject = in.readObject();
			if (listObject instanceof List)
				aListForComboSER = (ArrayList<String>) listObject;
			return aListForComboSER;
		} catch (IOException e) {
		}
		return aListForComboSER;
	}
}
