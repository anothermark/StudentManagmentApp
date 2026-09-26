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
			System.out.println(returnedStudentArrayListSER + " jiorcut0598");
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

			//But what do I do with ID? Caveat because the index is 0-based
			Integer ID = returnedStudentArrayListSER.size();
			System.out.println(ID.toString() + " poce8509454");
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
			if (returnedStudentArrayListSER.size() <= 2) {
				returnedStudentArrayListSER.add(studentAnon); // first student added
				// Now get the index
				System.out.println(returnedStudentArrayListSER + " returnedStudentArrayListSER poei59405");
				int index = returnedStudentArrayListSER.indexOf(studentAnon);
				// Then set the index in student object
				studentAnon.setIndexOfStudentObjInList(index);
				
				saveListOfStudentsToFile(returnedStudentArrayListSER); // Save the updated list (somewhere)
				
				System.out.println(returnedStudentArrayListSER + " returnedStudentArrayListSER ipoc85094c5");
				returnedStudentArrayListSER = getReturnedStudentArrayListSER();
				System.out.println(returnedStudentArrayListSER + " returnedStudentArrayListSER poer8906");
				System.out.println(returnedStudentArrayListSER.size() + " returnedStudentArrayListSER.size() i0c4896gry");
			}
		}
	}

	void saveListOfStudentsToFile(List<Student> returnedStudentArrayListSER) throws IOException {
	    try (var out = new ObjectOutputStream(
	            new BufferedOutputStream(new FileOutputStream(MainFrame.getSafeFilePath("returnedStudentArrayListSER"))))) {
	        out.writeObject(returnedStudentArrayListSER); 
	    }
	}

	List<Student> getReturnedStudentArrayListSER() {
		return returnedStudentArrayListSER;
	}

	@SuppressWarnings("unchecked")
	List<Student> getListOfStudents() throws IOException, ClassNotFoundException {
		//ArrayList<Student> listOfObject;

		try (var in = new ObjectInputStream(
				new BufferedInputStream(new FileInputStream(MainFrame.getSafeFilePath("returnedStudentArrayListSER"))))) {
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
		try (var out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(MainFrame.getSafeFilePath("aListForComboSER"))))) {
			out.writeObject(returnedStudentArrayListSER);
		}
	}

	List<String> getLastNameListSER() throws IOException, ClassNotFoundException {
		//ArrayList<String> listOfObject;

		try (var in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(MainFrame.getSafeFilePath("aListForComboSER"))))) {
			var listObject = in.readObject();
			if (listObject instanceof List)
				aListForComboSER = (ArrayList<String>) listObject;
			return aListForComboSER;
		} catch (IOException e) {
		}
		return aListForComboSER;
	}
}
