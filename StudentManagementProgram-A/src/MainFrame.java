/*Greatly indebted for some of the code I borrowed/lifted from books by Boyarsky and Selikoff, 
 * Zukowski, Marinacci and Adamson, and Christian Ullenboom. Special thanks to enthuware.com (the best).
 * Of course there's Google, without which this project would not have been possible.
 * And thank you Eclipse and WindowBuilder for making my life easier.
 *
*/


import javax.swing.JFormattedTextField;
import java.awt.EventQueue;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter; // eclipse tells me I don't use this, but I actually do
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Font;
//import java.awt.TextField;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.text.MaskFormatter;

import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.event.ActionEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.InputVerifier;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.io.InputStreamReader;

public class MainFrame extends JFrame implements Serializable {

	private static final long serialVersionUID = 1L;

	MaskFormatter formatter;
	MaskFormatter formatterDOB;
	JFormattedTextField phoneInput;
	JFormattedTextField DOBInput;
	int switchID;
	static int countFileSave = 0;
	static int count = 0;
	static String s;
	String dataForTextFile0 = "";
	String dataForTextFile1 = "";
	String dataForTextFile2 = "";
	String dataForTextFile3 = "";
	String dataForTextFile4 = "";

	// Table variables
	private DefaultTableModel model;
	String tableStudentID1;
	String tableStudentID2;
	String tableStudentID3;
	String tableStudentID4;
	String tableStudentID5;

	String tableLastName1;
	String tableLastName2;
	String tableLastName3;
	String tableLastName4;
	String tableLastName5;

	String tableFirstName1;
	String tableFirstName2;
	String tableFirstName3;
	String tableFirstName4;
	String tableFirstName5;

	String tableAddress1;
	String tableAddress2;
	String tableAddress3;
	String tableAddress4;
	String tableAddress5;

	String tableCity1;
	String tableCity2;
	String tableCity3;
	String tableCity4;
	String tableCity5;

	String tableState1;
	String tableState2;
	String tableState3;
	String tableState4;
	String tableState5;

	String tableZipcode1;
	String tableZipcode2;
	String tableZipcode3;
	String tableZipcode4;
	String tableZipcode5;

	String tableDoB1;
	String tableDoB2;
	String tableDoB3;
	String tableDoB4;
	String tableDoB5;

	String tableSex1;
	String tableSex2;
	String tableSex3;
	String tableSex4;
	String tableSex5;

	String tablePhone1;
	String tablePhone2;
	String tablePhone3;
	String tablePhone4;
	String tablePhone5;

	String tableEmail1;
	String tableEmail2;
	String tableEmail3;
	String tableEmail4;
	String tableEmail5;

	String tableMajor1;
	String tableMajor2;
	String tableMajor3;
	String tableMajor4;
	String tableMajor5;

	String tableGPA1;
	String tableGPA2;
	String tableGPA3;
	String tableGPA4;
	String tableGPA5;

	String tableBalance1;
	String tableBalance2;
	String tableBalance3;
	String tableBalance4;
	String tableBalance5;

	String tableRace1;
	String tableRace2;
	String tableRace3;
	String tableRace4;
	String tableRace5;

	List<Student> returnedStudentArrayListSER = getListOfStudents();
	Student retrievedStudent; // this one is important

	// Sorting variables
	List<Student> sortedSERList;
	String preupdateLastName;
	Student preupdateStudentLastName;
	String updatedLastName;
	String allNames; // this is for Print Preview, and Add and Update in order to save to a text file
	List<String> theListInCombo = new ArrayList<String>();
	static String[] somethingNewerish = new String[3];
	static String[] comboArrayFromList;
	static JComboBox<String> jcombo;
	static String inputOfLastName;
	static String[] arrayOfLastNames; // Very important. This is used with combo
	static List<String> aListForComboSER; // this also is very important

	String assignedLastName;
	static List<String> jComboListOfLastNames = new ArrayList<>();
	String lastNameCombo;
	String[] enteredValuesArray = new String[17];
	List<String> comboStringsList = new ArrayList<>();
	private JPanel contentPane;
	StudentControl studentControl;
	//Student1[] setValuesArray = new Student1[10];
	List<Student> returnedListOfStudents;
	Student returnedStudentObject;
	String searchedTerm;
	List<String> jcomboValues;
	List<Student> listStudent;

	// re Sort
	List<Student> sortListOfStudents;
	String sortOrderStr;
	static int countStudents = 0;
	//Student1 studentData;
	Student studentObj;
	Student createdStudentObj;
	int indexOfStudentObjInList;

	String studentID;
	String comboName;
	String searchedName;
	String firstName;
	String lastName;
	String streetAddress;
	String city;
	String state;
	String zipcode;
	String phone;
	String email;
	String dob;
	String lastFourOfSS;
	String sex;
	String race;
	String major;
	String currentGPA;
	String withdrawn;
	String balance;
	String update;
	String UPDATED;

	String[] comboArray = new String[3];
	String comboLastName;
	String comboOne = "first";
	String comboTwo = "second";
	String comboThree = "third";

	String lastNameSearched;
	String checkLastNameEmpty;
	boolean isLastNameEmpty;

	String[] lastNameArray = new String[3];
	String lastNameString;

	String strOne = "one11";
	String strTwo = "two22";
	String strThree = "three33";

	JTextArea textAreaDisplay; // for print preview and print
	static JTextField textFieldLastName;
	static JTextField textFieldFirstName;
	JTextField textFieldID;
	private JTextField textFieldDoB;
	static JTextField textFieldAddress;
	JTextField textFieldCity;
	//private JTextField textFieldZipcode;
	private JFormattedTextField textFieldZipcodeJFormat;

	//private JTextField textFieldPhone;
	private JTextField textFieldEmail;
	private JTextField textFieldMajor;
	private JTextField textFieldGPA;
	//private JFormattedTextField textFieldBalance;
	private JFormattedTextField textFieldBalanceForm;
	private JTextField textFieldUpdated;
	JTextField textFieldIndex;
	JTextField textFieldMessage;
	private JTextField textFieldEnrolled;
	private JButton btnClearPrintPreview;
	private JButton btnNewButton_1;
	private JTable table;
	private JTextField textFieldState;
	private JTextField textFieldSex;
	private JTextField textFieldRace;

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		JOptionPane.showMessageDialog(null,
				"A) If this is your initial visit, first, click the Automatically Load First Record button\n"
						+ "to load the text fields with data for the first student record, unless you enjoy typing.\n"
						+ "B) Then, click Add Student to save that record.\n"
						+ "C) At least two (2) student records are required to sort.",
				"Save Yourself Some Typing", JOptionPane.INFORMATION_MESSAGE);

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}); // end of anon Runnable

	}

	public MainFrame() throws ClassNotFoundException, IOException, ParseException {

		setForeground(new Color(64, 0, 0));
		setFont(new Font("Tahoma", Font.PLAIN, 40));
		setTitle("Senior Seminar PS-438 - The Federalist Papers - Enrollment limited to five (5) students");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1261, 610);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textFieldMessage = new JTextField();
		textFieldMessage.setText("Last and first name required to add a student.");
		textFieldMessage.setForeground(new Color(255, 0, 0));
		textFieldMessage.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldMessage.setBounds(98, 174, 502, 21);
		contentPane.add(textFieldMessage);
		textFieldMessage.setColumns(10);

		// re Validation
		textFieldLastName = new JTextField();
		textFieldLastName.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldLastName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldLastName.setBounds(98, 58, 153, 21);
		contentPane.add(textFieldLastName);
		textFieldLastName.setColumns(10);

		// Verify last name input is not empty or exceeds 25 characters
		InputVerifier verifier = new InputVerifier() {
			public boolean verify(JComponent comp) {
				//

				boolean returnValue = false;
				JTextField textField = (JTextField) comp;
				try {
					String textLength = textField.getText();
					String textLastName = textField.getText();
					// Verify no duplicate last names
					try {
						returnedStudentArrayListSER = getListOfStudents();
						if (returnedStudentArrayListSER == null) {
							returnedStudentArrayListSER = new ArrayList<Student>();
						}
					} catch (ClassNotFoundException | IOException e1) {
						e1.printStackTrace();
					}

					for (int i = 0; i < returnedStudentArrayListSER.size(); i++) {
						String studentLastName = returnedStudentArrayListSER.get(i).getLastName();
						if (textLastName.equalsIgnoreCase(studentLastName)) {
							JOptionPane.showMessageDialog(null,
									"This student record exists. \n " + "No duplicate records permitted. \n", null,
									JOptionPane.INFORMATION_MESSAGE);
							return false;
						}
					}

					// Verify no digits

					if (textLength.length() > 25 || textField.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Required. No numbers. Max 25 characters.", null,
								JOptionPane.INFORMATION_MESSAGE);
						returnValue = false;
					} else {
						String noDigitsString = textField.getText();
						for (int i = 0; i < noDigitsString.length(); i++) {
							char ch = noDigitsString.charAt(i);
							if (returnValue = Character.isDigit(ch) || !Character.isLetter(ch)) {
								JOptionPane.showMessageDialog(null,
										"No numbers/digits or special characters permitted. \nOnly letters.", null,
										JOptionPane.INFORMATION_MESSAGE);

								return false;
							}
						} // end of loop
							// else {
							// Capitalize first letter
						String lastNameText = textFieldLastName.getText();
						String firstLetter = lastNameText.substring(0, 1);
						firstLetter = firstLetter.toUpperCase();
						String remainingLetters = lastNameText.substring(1);
						String capitalizedString = firstLetter + remainingLetters;
						textFieldLastName.setText(capitalizedString);

						return true;
						// }

						// returnValue = true;
					}

				} catch (NumberFormatException e) {
					returnValue = false;
				}

				return returnValue;
			}//
		};
		textFieldLastName.setInputVerifier(verifier);

		textFieldFirstName = new JTextField();
		textFieldFirstName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldFirstName.setBounds(98, 82, 153, 21);
		contentPane.add(textFieldFirstName);
		textFieldFirstName.setColumns(10);

		// Verify first name input is not empty or exceeds 25 characters
		InputVerifier VerifierFirstName = new InputVerifier() {
			public boolean verify(JComponent comp) {
				boolean returnValue = false;

				//JTextField textField = (JTextField) comp;
				try {
					//String textLength = textField.getText();
					String textLengthFirstName = textFieldFirstName.getText();
					//boolean bool;
					// verify no digits

					if (textLengthFirstName.length() > 25 || textFieldFirstName.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Required. No numbers. Max 25 characters.", null,
								JOptionPane.INFORMATION_MESSAGE);
						returnValue = false;
					} else {
						String noDigitsString = textFieldFirstName.getText();
						for (int i = 0; i < noDigitsString.length(); i++) {
							char ch = noDigitsString.charAt(i);
							if (returnValue = Character.isDigit(ch) || !Character.isLetter(ch)) {
								JOptionPane.showMessageDialog(null,
										"No numbers/digits or special characters permitted. \\nOnly letters.", null,
										JOptionPane.INFORMATION_MESSAGE);
								return false;
							}
						} // end of loop
							// else {
							// Capitalize first letter
						String firstNameText = textFieldFirstName.getText();
						String firstLetter = firstNameText.substring(0, 1);
						firstLetter = firstLetter.toUpperCase();
						String remainingLetters = firstNameText.substring(1);
						String capitalizedString = firstLetter + remainingLetters;
						textFieldFirstName.setText(capitalizedString);
						return true;
						// }

						// returnValue = true;
					}
				} catch (NumberFormatException e) {
					returnValue = false;
				}

				return returnValue;
			}//
		};

		textFieldFirstName.setInputVerifier(VerifierFirstName);

		textFieldAddress = new JTextField();
		textFieldAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldAddress.setBounds(98, 104, 153, 21);
		contentPane.add(textFieldAddress);
		textFieldAddress.setColumns(10);

		JLabel labelLastName = new JLabel("*Last Name: ");
		labelLastName.setToolTipText("Enter a last name (required). 25 characters max.");
		labelLastName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelLastName.setHorizontalAlignment(SwingConstants.RIGHT);
		labelLastName.setBounds(0, 60, 88, 16);
		contentPane.add(labelLastName);

		textFieldID = new JTextField();
		textFieldID.setEditable(false);
		textFieldID.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldID.setColumns(2);
		textFieldID.setBounds(98, 33, 30, 21);
		contentPane.add(textFieldID);

		JLabel labelID = new JLabel("Student ID:");
		labelID.setHorizontalAlignment(SwingConstants.RIGHT);
		labelID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelID.setBounds(10, 32, 78, 16);
		contentPane.add(labelID);

		JComboBox<String> comboBoxSearchName = new JComboBox<>();

		aListForComboSER = getLastNameListSER(); // method is at the bottom of MainFrame
		if (aListForComboSER == null) {
			aListForComboSER = new ArrayList<String>();
		}
		try {
			saveLastNameListSER(aListForComboSER);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Important. Converts array to list
		if (aListForComboSER.size() <= 3) {
			arrayOfLastNames = aListForComboSER.toArray(new String[aListForComboSER.size()]); // see Comprehensive Guide
																								// for this fix
			comboBoxSearchName.setModel(new DefaultComboBoxModel<String>(arrayOfLastNames));
		}

		comboBoxSearchName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxSearchName.setMaximumRowCount(10);
		comboBoxSearchName.setBounds(138, 32, 209, 21);
		contentPane.add(comboBoxSearchName);

		JButton btnGetComboLastName = new JButton("Retrieve Student");
		btnGetComboLastName.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        textFieldMessage.setText("");
		        searchedTerm = (String) comboBoxSearchName.getSelectedItem();
		        
		        // Use .equals() for string comparisons instead of ==
		        if (searchedTerm == null || searchedTerm.trim().equals("")) {
		            textFieldMessage.setText("No such records exist. You must add a student.");
		            return; // Exit early if nothing is selected
		        }

		        try {
		            returnedStudentArrayListSER = getListOfStudents();
		            System.out.println(returnedStudentArrayListSER + " returnedStudentArrayListSER oeuit94856");
		        } catch (ClassNotFoundException | IOException e1) {
		            e1.printStackTrace();
		        }

		        // SAFETY: If the list is null, initialize an empty one so .size() doesn't crash
		        if (returnedStudentArrayListSER == null) {
		            returnedStudentArrayListSER = new ArrayList<Student>();
		        }

		        Integer numStudents = returnedStudentArrayListSER.size();
		        textFieldEnrolled.setText(numStudents.toString() + " of 3");
		        System.out.println(returnedStudentArrayListSER.size() + " returnedStudentArrayListSER.size() o44094gvn6");
		            
		        if (returnedStudentArrayListSER.isEmpty()) {
		            textFieldMessage.setText("No such records exist. You really need to add a student.");
		        } else {
		            textFieldMessage.setText("");
		            
		            // Reset retrievedStudent to null before searching to ensure no stale data
		            retrievedStudent = null; 
		            
		            for (int i = 0; i <= returnedStudentArrayListSER.size() - 1; ++i) {
		                if (searchedTerm.equals(returnedStudentArrayListSER.get(i).getLastName())) {
		                    retrievedStudent = returnedStudentArrayListSER.get(i);
		                } 
		            } // end of loop

		            // CRITICAL SAFETY GUARD: If no matching student was found, exit safely!
		            if (retrievedStudent == null) {
		                textFieldMessage.setText("Student record could not be located.");
		                return; 
		            }

		            // Now this section is 100% safe from NullPointerExceptions
		            textFieldIndex.setText("" + retrievedStudent.getIndexOfObjInList());
		            textFieldID.setText(Integer.toString(retrievedStudent.getIndexOfObjInList()));
		            textFieldLastName.setText(retrievedStudent.getLastName());
		            preupdateLastName = textFieldLastName.getText();
		            textFieldFirstName.setText(retrievedStudent.getFirstName());
		            textFieldAddress.setText(retrievedStudent.getStreetAddress());
		            textFieldCity.setText(retrievedStudent.getCity());
		            textFieldState.setText(retrievedStudent.getState());
		            textFieldZipcodeJFormat.setText(retrievedStudent.getZipcode());
		            phoneInput.setText(retrievedStudent.getPhone());
		            textFieldEmail.setText(retrievedStudent.getEmail());
		            DOBInput.setText(retrievedStudent.getDoB());
		            textFieldSex.setText(retrievedStudent.getSex());
		            textFieldMajor.setText(retrievedStudent.getMajor());
		            textFieldGPA.setText(retrievedStudent.getCurrentGPA());
		            textFieldBalanceForm.setText(retrievedStudent.getBalance());
		            textFieldRace.setText(retrievedStudent.getRace());
		        } // end of else

		        saveListOfStudentsFromMainFrame(returnedStudentArrayListSER);
		    } // end of actionPerformed()
		});

		btnGetComboLastName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGetComboLastName.setBounds(138, 11, 209, 21);
		contentPane.add(btnGetComboLastName);

		JButton btnClear = new JButton("Clear All");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				textFieldIndex.setText("");
				textFieldID.setText("");
				textFieldLastName.setText("");
				textFieldFirstName.setText("");
				textFieldAddress.setText("");
				textFieldCity.setText("");
				textFieldState.setText("");
				textFieldZipcodeJFormat.setText("");
				phoneInput.setText("");
				textFieldEmail.setText("");
				DOBInput.setText("");
				textFieldSex.setText("");
				textFieldMajor.setText("");
				textFieldGPA.setText("");
				textFieldBalanceForm.setText("");
				textFieldRace.setText("");
				textFieldUpdated.setText("");
				textFieldMessage.setText("");
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnClear.setBounds(348, 31, 105, 21);
		contentPane.add(btnClear);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldMessage.setText("");
				if (retrievedStudent == null) {
					textFieldMessage.setText("Must retrieve a student before updating");
				} else {
					for (int i = 0; i < returnedStudentArrayListSER.size(); i++) {
						if (returnedStudentArrayListSER.get(i).getLastName().equals(preupdateLastName)) {
							preupdateStudentLastName = returnedStudentArrayListSER.get(i);
							//String oldLastName = preupdateStudentLastName.getLastName();
							updatedLastName = textFieldLastName.getText();
							preupdateStudentLastName.setLastName(updatedLastName);
						}
					} // end of loop

					//String newUpdatedLastName = textFieldLastName.getText();
					// Get the combobox list from the add button
					try {
						aListForComboSER = getLastNameListSER();
					} catch (ClassNotFoundException | IOException e1) {
						e1.printStackTrace();
					}
					if (aListForComboSER == null) {
						aListForComboSER = new ArrayList<String>();
					}

					try {
						saveLastNameListSER(aListForComboSER);
						aListForComboSER = getLastNameListSER();
					} catch (IOException exc) {
						exc.printStackTrace();
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					}
					for (int i = 0; i < aListForComboSER.size(); i++) {
						if (aListForComboSER.get(i).equals(preupdateLastName)) {
							int indexComboLastName = aListForComboSER.indexOf(preupdateLastName);
							aListForComboSER.set(indexComboLastName, updatedLastName);
						}
					}
					if (aListForComboSER.size() <= 3) {
						arrayOfLastNames = aListForComboSER.toArray(new String[aListForComboSER.size()]);
						comboBoxSearchName.setModel(new DefaultComboBoxModel<String>(arrayOfLastNames));
					}
					try {
						saveLastNameListSER(aListForComboSER);
						aListForComboSER = getLastNameListSER();
					} catch (IOException exc) {
						exc.printStackTrace();
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					}
					preupdateStudentLastName.setLastName(updatedLastName);
					
					studentID = textFieldID.getText();
					
					firstName = textFieldFirstName.getText();
					retrievedStudent.setFirstName(firstName);
					streetAddress = textFieldAddress.getText();
					retrievedStudent.setStreetAddress(streetAddress);
					city = textFieldCity.getText();
					retrievedStudent.setCity(city);
					state = textFieldState.getText();
					retrievedStudent.setState(state);
					zipcode = textFieldZipcodeJFormat.getText();
					retrievedStudent.setZipcode(zipcode);
					dob = DOBInput.getText();
					retrievedStudent.setDoB(dob);
					sex = textFieldSex.getText();
					retrievedStudent.setSex(sex);
					phone = phoneInput.getText();
					retrievedStudent.setPhone(phone);
					email = textFieldEmail.getText();
					retrievedStudent.setEmail(email);
					major = textFieldMajor.getText();
					retrievedStudent.setMajor(major);
					currentGPA = textFieldGPA.getText();
					retrievedStudent.setCurrentGPA(currentGPA);
					balance = textFieldBalanceForm.getText();
					retrievedStudent.setBalance(balance);
					race = textFieldRace.getText();
					retrievedStudent.setRace(race);
					textFieldUpdated.setText(LocalTime.now().toString());

					// Write updates to text files
					SaveRecordToTextFile saveRecordToTextFile = new SaveRecordToTextFile();
					if (studentID != null) {
						switchID = Integer.parseInt(studentID);
					}

					switch (switchID) {
					case 0:
						dataForTextFile0 += textFieldID.getText() + "\n" + textFieldLastName.getText() + "\n"
								+ textFieldFirstName.getText() + "\n" + textFieldAddress.getText() + "\n"
								+ textFieldCity.getText() + "\n" + textFieldState.getText() + "\n"
								+ textFieldZipcodeJFormat.getText() + "\n" + DOBInput.getText() + "\n"
								+ textFieldSex.getText() + "\n" + phoneInput.getText() + "\n" + textFieldEmail.getText()
								+ "\n" + textFieldMajor.getText() + "\n" + textFieldGPA.getText() + "\n"
								+ textFieldBalanceForm.getText() + "\n" + textFieldRace.getText();
						saveRecordToTextFile.saveToText0(dataForTextFile0);
						break;
					case 1:
						dataForTextFile1 += textFieldID.getText() + "\n" + textFieldLastName.getText() + "\n"
								+ textFieldFirstName.getText() + "\n" + textFieldAddress.getText() + "\n"
								+ textFieldCity.getText() + "\n" + textFieldState.getText() + "\n"
								+ textFieldZipcodeJFormat.getText() + "\n" + DOBInput.getText() + "\n"
								+ textFieldSex.getText() + "\n" + phoneInput.getText() + "\n" + textFieldEmail.getText()
								+ "\n" + textFieldMajor.getText() + "\n" + textFieldGPA.getText() + "\n"
								+ textFieldBalanceForm.getText() + "\n" + textFieldRace.getText();
						saveRecordToTextFile.saveToText1(dataForTextFile1);
						break;
					case 2:
						dataForTextFile2 += textFieldID.getText() + "\n" + textFieldLastName.getText() + "\n"
								+ textFieldFirstName.getText() + "\n" + textFieldAddress.getText() + "\n"
								+ textFieldCity.getText() + "\n" + textFieldState.getText() + "\n"
								+ textFieldZipcodeJFormat.getText() + "\n" + DOBInput.getText() + "\n"
								+ textFieldSex.getText() + "\n" + phoneInput.getText() + "\n" + textFieldEmail.getText()
								+ "\n" + textFieldMajor.getText() + "\n" + textFieldGPA.getText() + "\n"
								+ textFieldBalanceForm.getText() + "\n" + textFieldRace.getText();
						saveRecordToTextFile.saveToText2(dataForTextFile2);
						break;
					case 3:
						dataForTextFile3 += textFieldID.getText() + "\n" + textFieldLastName.getText() + "\n"
								+ textFieldFirstName.getText() + "\n" + textFieldAddress.getText() + "\n"
								+ textFieldCity.getText() + "\n" + textFieldState.getText() + "\n"
								+ textFieldZipcodeJFormat.getText() + "\n" + DOBInput.getText() + "\n"
								+ textFieldSex.getText() + "\n" + phoneInput.getText() + "\n" + textFieldEmail.getText()
								+ "\n" + textFieldMajor.getText() + "\n" + textFieldGPA.getText() + "\n"
								+ textFieldBalanceForm.getText() + "\n" + textFieldRace.getText();
						saveRecordToTextFile.saveToText2(dataForTextFile3);
						break;
					case 4:
						dataForTextFile4 += textFieldID.getText() + "\n" + textFieldLastName.getText() + "\n"
								+ textFieldFirstName.getText() + "\n" + textFieldAddress.getText() + "\n"
								+ textFieldCity.getText() + "\n" + textFieldState.getText() + "\n"
								+ textFieldZipcodeJFormat.getText() + "\n" + DOBInput.getText() + "\n"
								+ textFieldSex.getText() + "\n" + phoneInput.getText() + "\n" + textFieldEmail.getText()
								+ "\n" + textFieldMajor.getText() + "\n" + textFieldGPA.getText() + "\n"
								+ textFieldBalanceForm.getText() + "\n" + textFieldRace.getText();
						saveRecordToTextFile.saveToText2(dataForTextFile4);
						break;
					} // End of switch

					textFieldID.setText("");
					textFieldLastName.setText("");
					textFieldFirstName.setText("");
					textFieldAddress.setText("");
					textFieldCity.setText("");
					textFieldState.setText("");
					textFieldZipcodeJFormat.setText("");
					phoneInput.setText("");
					textFieldEmail.setText("");
					sex = textFieldSex.getText();
					retrievedStudent.setSex(sex);
					textFieldSex.setText("");
					DOBInput.setText("");
					textFieldMajor.setText("");
					textFieldGPA.setText("");
					textFieldBalanceForm.setText("");
					textFieldRace.setText("");
					textFieldIndex.setText("");

					saveListOfStudentsFromMainFrame(returnedStudentArrayListSER);

				} // End of first else re null retrievedStudent, I think
			}
		});

		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUpdate.setBounds(348, 11, 105, 21);
		contentPane.add(btnUpdate);

		JLabel lblDOB = new JLabel("DoB:");
		lblDOB.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDOB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDOB.setBounds(448, 33, 77, 18);
		contentPane.add(lblDOB);

		// Use a phone mask
		// formatter = new MaskFormatter("'(###')' ###'-####");
		// phoneInput = new JFormattedTextField(formatter);
		// phoneInput.setBounds(348, 107, 103, 19);
		// contentPane.add(phoneInput);
		// phoneInput.setColumns(10);

		formatterDOB = new MaskFormatter("##/##/####'");
		DOBInput = new JFormattedTextField(formatterDOB);
		DOBInput.setBounds(529, 34, 171, 19);
		contentPane.add(DOBInput);
		DOBInput.setColumns(10);

		JLabel lblFirstName = new JLabel("*First Name:");
		lblFirstName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFirstName.setBounds(0, 81, 88, 21);
		contentPane.add(lblFirstName);

		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddress.setBounds(10, 104, 78, 21);
		contentPane.add(lblAddress);

		JLabel lblCity = new JLabel("*City:");
		lblCity.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCity.setBounds(15, 123, 73, 21);
		contentPane.add(lblCity);

		textFieldCity = new JTextField();
		textFieldCity.setBounds(98, 125, 153, 21);
		contentPane.add(textFieldCity);
		textFieldCity.setColumns(10);

		// Verify City input is not empty or exceeds 25 characters
		InputVerifier VerifierCity = new InputVerifier() {
			public boolean verify(JComponent comp) {
				boolean returnValue = false;

				//JTextField textField = (JTextField) comp;
				try {
					//String textLength = textField.getText();
					String textLengthCity = textFieldCity.getText();
					String twoWordsNoSpace = "";
					String twoCapWords = "";
					String firstWord;
					String secondWord;
					// verify no digits
					String noDigitsString = textFieldCity.getText();
					String cityText = textFieldCity.getText();
					;
					if (noDigitsString.contains(" ")) {
						// split them
						String[] citySectionsArray = cityText.split(Pattern.quote(" "));
						// assign words to variables
						firstWord = citySectionsArray[0];
						secondWord = citySectionsArray[1];
						// capitalize the first word
						String firstLetter = firstWord.substring(0, 1);
						firstLetter = firstLetter.toUpperCase();
						String remainingLetters = firstWord.substring(1);
						String capitalizedFirstWord = firstLetter + remainingLetters;

						// capitalize the second word
						String firstLetter2 = secondWord.substring(0, 1);
						firstLetter2 = firstLetter2.toUpperCase();
						String remainingLetters2 = secondWord.substring(1);
						String capitalizedSecondWord = firstLetter2 + remainingLetters2;

						twoWordsNoSpace = capitalizedFirstWord + capitalizedSecondWord; // this is to get by the only
																						// digits check
						twoCapWords = capitalizedFirstWord + " " + capitalizedSecondWord;
						// textFieldCity.setText(twoCapWords); // I assign the two cap words right after
						// the loop below

						// change this to check if the word has a space and if not use this
					}

					if (textLengthCity.length() > 25 || textFieldCity.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Required. No numbers. Max 25 characters.", null,
								JOptionPane.INFORMATION_MESSAGE);
						returnValue = false;
					} else {
						for (int i = 0; i < twoWordsNoSpace.length(); ++i) {
							char ch = twoWordsNoSpace.charAt(i);
							if (returnValue = Character.isDigit(ch) || !Character.isLetter(ch)) {
								JOptionPane.showMessageDialog(null,
										"No numbers/digits or special characters permitted. \n Only letters.", null,
										JOptionPane.INFORMATION_MESSAGE);
								return false;
							}
						} // end of loop

						// Capitalize first letter of all words

						if (!noDigitsString.contains(" ")) { // just capitalize the one word if no space and one word
																// only

							String firstLetter = cityText.substring(0, 1);
							firstLetter = firstLetter.toUpperCase();
							String remainingLetters = cityText.substring(1);
							String capitalizedString = firstLetter + remainingLetters;
							textFieldCity.setText(capitalizedString);
							return true;

						} else {
							textFieldCity.setText(twoCapWords);
							return true;
						}

						// returnValue = false;
					}
				} catch (NumberFormatException e) {
					returnValue = false;
				}

				return returnValue;
			}//
		};

		textFieldCity.setInputVerifier(VerifierCity);

		JLabel lblState = new JLabel("State:");
		lblState.setHorizontalAlignment(SwingConstants.RIGHT);
		lblState.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblState.setBounds(46, 148, 45, 21);
		contentPane.add(lblState);

		JLabel lblZip = new JLabel("*Zip: ");
		lblZip.setToolTipText("Only five digits");
		lblZip.setHorizontalAlignment(SwingConstants.RIGHT);
		lblZip.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblZip.setBounds(150, 152, 37, 13);
		contentPane.add(lblZip);

		// formatter = new MaskFormatter("#####");
		textFieldZipcodeJFormat = new JFormattedTextField();

		textFieldZipcodeJFormat.setToolTipText("Numbers only");

		textFieldZipcodeJFormat.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldZipcodeJFormat.setBounds(184, 151, 67, 19);
		contentPane.add(textFieldZipcodeJFormat);
		textFieldZipcodeJFormat.setColumns(10);
		// Add InputVerifier to force 5 digits
		// Decided not to use a mask with JFormatter. It won't work with InputVerifier
		InputVerifier verifierZip = new InputVerifier() {
			public boolean verify(JComponent comp) {
				//boolean returnValue = false;
				//JFormattedTextField textField = (JFormattedTextField) comp;				
				//String textLength = textField.getText();
				String zipString = textFieldZipcodeJFormat.getText();
				for (int i = 0; i < zipString.length(); i++) {
					char ch = zipString.charAt(i);
					if (!Character.isDigit(ch)) {
						JOptionPane.showMessageDialog(null,
								"Five (5) numbers/digits are required to leave.\n "
										+ "No letters, special characters or white space.",
								null, JOptionPane.INFORMATION_MESSAGE);
						return false;
					}
					if (zipString.length() != 5) {
						JOptionPane.showMessageDialog(null, "Exactly five (5) numbers/digits are required to leave.",
								null, JOptionPane.INFORMATION_MESSAGE);
						return false;
					}
					// return true;

				} // end of loop
				return true;

			} // end of verify

		};// end of InputVerifier
		textFieldZipcodeJFormat.setInputVerifier(verifierZip);

		JLabel lblPhone = new JLabel("Phone: ");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPhone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhone.setBounds(262, 104, 85, 21);
		contentPane.add(lblPhone);

		// Use a phone mask
		formatter = new MaskFormatter("'(###')' ###'-####");
		phoneInput = new JFormattedTextField(formatter);
		phoneInput.setBounds(348, 107, 103, 19);
		contentPane.add(phoneInput);
		phoneInput.setColumns(10);

		JLabel lblEmail = new JLabel("Email: ");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(294, 123, 51, 21);
		contentPane.add(lblEmail);

		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(348, 125, 183, 21);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);

		// Verify email (very basic)
		InputVerifier verifierEmail = new InputVerifier() {
			public boolean verify(JComponent comp) {
				boolean returnValue;
				JTextField textFieldEmail = (JTextField) comp;
				try {
					String textEmail = textFieldEmail.getText();					

					if (!textEmail.contains(".") || !textEmail.contains("@")) {
						JOptionPane.showMessageDialog(null,
								"You'll need the @ and (.) period characters in there somewhere", null,
								JOptionPane.INFORMATION_MESSAGE);
						returnValue = false;
					} else {
						returnValue = true;
					}
				} catch (NumberFormatException e) {
					returnValue = false;
				}
				return returnValue;
			}
		};
		textFieldEmail.setInputVerifier(verifierEmail);

		JLabel lblMajor = new JLabel("*Major: ");
		lblMajor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMajor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMajor.setBounds(461, 57, 70, 21);
		contentPane.add(lblMajor);

		textFieldMajor = new JTextField();
		textFieldMajor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldMajor.setBounds(529, 59, 171, 20);
		contentPane.add(textFieldMajor);
		textFieldMajor.setColumns(10);

		// Verify major input is not empty or exceeds 25 characters
		InputVerifier VerifierMajor = new InputVerifier() {
			public boolean verify(JComponent comp) {
				boolean returnValue = false;

				//JTextField textField = (JTextField) comp;
				try {
					//String textLength = textField.getText();
					String textLengthMajor = textFieldMajor.getText();					
					// verify no digits
					if (textLengthMajor.length() > 15 || textFieldMajor.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Required. No numbers. Max 15 characters.", null,
								JOptionPane.INFORMATION_MESSAGE);
						returnValue = false;
					} else {
						String noDigitsString = textFieldMajor.getText();
						for (int i = 0; i < noDigitsString.length(); ++i) { // but why is ++i flagged as "dead code"? Never heard of this
							char ch = noDigitsString.charAt(i);
							if (returnValue = Character.isDigit(ch) || !Character.isLetter(ch)) {
								JOptionPane.showMessageDialog(null,
										"No numbers/digits or special characters permitted. \\nOnly letters.", null,
										JOptionPane.INFORMATION_MESSAGE);
								return false;
							} else {
								// Capitalize first letter
								String firstNameText = textFieldMajor.getText();
								String firstLetter = firstNameText.substring(0, 1);
								firstLetter = firstLetter.toUpperCase();
								String remainingLetters = firstNameText.substring(1);
								String capitalizedString = firstLetter + remainingLetters;
								textFieldMajor.setText(capitalizedString);
								return true;
							}
						} // end of loop
						returnValue = true;
					}
				} catch (NumberFormatException e) {
					returnValue = false;
				}

				return returnValue;
			}//
		};

		textFieldMajor.setInputVerifier(VerifierMajor);

		// textFieldMajor.setInputVerifier(verifier);

		JLabel lblGPA = new JLabel("*GPA:  ");
		lblGPA.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGPA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGPA.setBounds(448, 82, 86, 21);
		contentPane.add(lblGPA);

		textFieldGPA = new JTextField();
		textFieldGPA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldGPA.setBounds(530, 83, 96, 19);
		contentPane.add(textFieldGPA);
		textFieldGPA.setColumns(10);
		// Add InputVerifier to force digitsGPA
		InputVerifier verifierGPA = new InputVerifier() {
			public boolean verify(JComponent comp) {
				char ch = 'a';
				boolean returnValue = false;
				JTextField textFieldgpa = (JTextField) comp;
				String textLength = textFieldgpa.getText();				
				String GPAString = textFieldgpa.getText();
				if (GPAString.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Cannot be empty.", null, JOptionPane.INFORMATION_MESSAGE);
					return false;
				}
				ch = GPAString.charAt(0);

				if (returnValue = Character.isDigit(ch) && textLength.length() < 5) {
				} else {
					JOptionPane.showMessageDialog(null, "Only 5 or fewer numbers/digits are permitted.\n No letters",
							null, JOptionPane.INFORMATION_MESSAGE);
				}

				if (!GPAString.contains(".")) {
					int intGPA = Integer.parseInt(GPAString);
					double doubleGPA = intGPA;
					textFieldgpa.setText(((Double) doubleGPA).toString());
				}

				return returnValue;

			} // end of verify()
		};
		textFieldGPA.setInputVerifier(verifierGPA);

		JLabel lblBalance = new JLabel("*Balance:");
		lblBalance.setToolTipText("Balance Remaining on Account");
		lblBalance.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBalance.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBalance.setBounds(448, 102, 81, 21);
		contentPane.add(lblBalance);

		// SAT - problem is it rerquires the $ sign to work, else it
		// simply uses the old number, so maybe concat a $ string?
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
		textFieldBalanceForm = new JFormattedTextField(currencyFormatter);
		// textFieldBalanceForm.setText("$");
		// textFieldBalanceForm.setValue(000);
		textFieldBalanceForm.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldBalanceForm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldBalanceForm.setBounds(530, 107, 96, 19);
		contentPane.add(textFieldBalanceForm);
		textFieldBalanceForm.setColumns(10);
		// SAT - USE An InputVerifier!!
		// Add InputVerifier to force $ sign
		InputVerifier verifierBalance = new InputVerifier() {
			public boolean verify(JComponent comp) {
				//char ch = 'a';
				//boolean returnValue = false;
				JTextField textFieldBalanceForm = (JTextField) comp;
				//String textLength = textFieldBalanceForm.getText();				
				String balanceString = textFieldBalanceForm.getText();
				if (balanceString.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Cannot be empty. Numbers must be preceded by the $ sign.",
							null, JOptionPane.INFORMATION_MESSAGE);
					return false;
				}

				Character Ch = balanceString.charAt(0);
				String dollarCheck = Ch.toString();
				
				if (dollarCheck.equals("$")) {
					return true;
				} else {
					JOptionPane.showMessageDialog(null,
							"The dollar sign ($) must be the first character, \n"
									+ "followed by numbers/digits. We'll fill in the commas.",
							null, JOptionPane.INFORMATION_MESSAGE);
					return false;
				}

				// return returnValue;

			} // end of verify()
		};
		textFieldBalanceForm.setInputVerifier(verifierBalance);

		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(128, 64, 64));
		separator.setBounds(10, 203, 1028, 0);
		contentPane.add(separator);

		JLabel lblUpdated = new JLabel("Updated: ");
		lblUpdated.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUpdated.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUpdated.setBounds(1040, 11, 62, 21);
		contentPane.add(lblUpdated);

		textFieldUpdated = new JTextField();
		textFieldUpdated.setForeground(new Color(255, 0, 0));
		textFieldUpdated.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldUpdated.setEditable(false);
		textFieldUpdated.setBounds(1101, 10, 136, 22);
		contentPane.add(textFieldUpdated);
		textFieldUpdated.setColumns(10);

		JButton btnAddStudent2 = new JButton("Add Student");
		btnAddStudent2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					returnedStudentArrayListSER = getListOfStudents();
					System.out.println(returnedStudentArrayListSER.size() + "returnedStudentArrayListSER.size() o44y6bm5");
					System.out.println(returnedStudentArrayListSER + "returnedStudentArrayListSER lrit565");
					if (returnedStudentArrayListSER == null) {
						returnedStudentArrayListSER = new ArrayList<Student>();
						saveListOfStudentsFromMainFrame(returnedStudentArrayListSER);
					}
				} catch (ClassNotFoundException | IOException e1) {
					e1.printStackTrace();
				}

				ClassFull: if (returnedStudentArrayListSER.size() >= 3) {
					textFieldMessage.setText("Enrollment maxed out. Try again next semester.");
					JOptionPane.showMessageDialog(null, "Sorry, but this class is full. Try again next semester.", null,
							JOptionPane.INFORMATION_MESSAGE);
					break ClassFull;
				} else {
					assignedLastName = textFieldLastName.getText();
					aListForComboSER.add(assignedLastName);
					try {
						saveLastNameListSER(aListForComboSER);
					} catch (IOException e1) {
						e1.printStackTrace();
					}

					String lastNameForArray = textFieldLastName.getText();
					enteredValuesArray[0] = lastNameForArray;
					enteredValuesArray[1] = textFieldFirstName.getText();
					enteredValuesArray[2] = textFieldAddress.getText();
					enteredValuesArray[3] = textFieldCity.getText();
					enteredValuesArray[4] = textFieldState.getText();
					enteredValuesArray[5] = textFieldZipcodeJFormat.getText();
					enteredValuesArray[6] = phoneInput.getText();
					enteredValuesArray[7] = textFieldEmail.getText();
					enteredValuesArray[8] = DOBInput.getText();
					enteredValuesArray[9] = textFieldSex.getText();
					enteredValuesArray[10] = textFieldMajor.getText();
					enteredValuesArray[11] = textFieldGPA.getText();
					enteredValuesArray[12] = textFieldBalanceForm.getText();
					enteredValuesArray[13] = textFieldRace.getText();

					lastNameSearched = textFieldLastName.getText();
					NoLastName: if (returnedStudentArrayListSER.size() <= 3 && lastNameSearched.equals("")) {
						textFieldMessage.setText("Last name is required");
						break NoLastName;
					} else if (studentControl != null && lastNameSearched != "") {
						try {
							
							// Send the array into the factory method
							studentControl.studentFactory(lastNameSearched, enteredValuesArray);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					} else if (studentControl == null && lastNameSearched != "") {
						studentControl = new StudentControl();
						try {
							studentControl.studentFactory(lastNameSearched, enteredValuesArray); // save list here
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}

					SaveRecordToTextFile saveRecordToTextFile = new SaveRecordToTextFile();
					countFileSave = returnedStudentArrayListSER.size();
					switch (countFileSave) {
					case 0:
						dataForTextFile0 += countFileSave + "\n" + textFieldLastName.getText() + "\n"
								+ textFieldFirstName.getText() + "\n" + textFieldAddress.getText() + "\n"
								+ textFieldCity.getText() + "\n" + textFieldState.getText() + "\n"
								+ textFieldZipcodeJFormat.getText() + "\n" + DOBInput.getText() + "\n"
								+ textFieldSex.getText() + "\n" + phoneInput.getText() + "\n" + textFieldEmail.getText()
								+ "\n" + textFieldMajor.getText() + "\n" + textFieldGPA.getText() + "\n"
								+ textFieldBalanceForm.getText() + "\n" + textFieldRace.getText();
						saveRecordToTextFile.saveToText0(dataForTextFile0);
						break;
					case 1:
						dataForTextFile1 += countFileSave + "\n" + textFieldLastName.getText() + "\n"
								+ textFieldFirstName.getText() + "\n" + textFieldAddress.getText() + "\n"
								+ textFieldCity.getText() + "\n" + textFieldState.getText() + "\n"
								+ textFieldZipcodeJFormat.getText() + "\n" + DOBInput.getText() + "\n"
								+ textFieldSex.getText() + "\n" + phoneInput.getText() + "\n" + textFieldEmail.getText()
								+ "\n" + textFieldMajor.getText() + "\n" + textFieldGPA.getText() + "\n"
								+ textFieldBalanceForm.getText() + "\n" + textFieldRace.getText();
						saveRecordToTextFile.saveToText1(dataForTextFile1);
						break;
					case 2:
						dataForTextFile2 += countFileSave + "\n" + textFieldLastName.getText() + "\n"
								+ textFieldFirstName.getText() + "\n" + textFieldAddress.getText() + "\n"
								+ textFieldCity.getText() + "\n" + textFieldState.getText() + "\n"
								+ textFieldZipcodeJFormat.getText() + "\n" + DOBInput.getText() + "\n"
								+ textFieldSex.getText() + "\n" + phoneInput.getText() + "\n" + textFieldEmail.getText()
								+ "\n" + textFieldMajor.getText() + "\n" + textFieldGPA.getText() + "\n"
								+ textFieldBalanceForm.getText() + "\n" + textFieldRace.getText();
						saveRecordToTextFile.saveToText2(dataForTextFile2);
						break;
					case 3:
						dataForTextFile3 += countFileSave + "\n" + textFieldLastName.getText() + "\n"
								+ textFieldFirstName.getText() + "\n" + textFieldAddress.getText() + "\n"
								+ textFieldCity.getText() + "\n" + textFieldState.getText() + "\n"
								+ textFieldZipcodeJFormat.getText() + "\n" + DOBInput.getText() + "\n"
								+ textFieldSex.getText() + "\n" + phoneInput.getText() + "\n" + textFieldEmail.getText()
								+ "\n" + textFieldMajor.getText() + "\n" + textFieldGPA.getText() + "\n"
								+ textFieldBalanceForm.getText() + "\n" + textFieldRace.getText();
						saveRecordToTextFile.saveToText2(dataForTextFile3);
						break;
					case 4:
						dataForTextFile4 += countFileSave + "\n" + textFieldLastName.getText() + "\n"
								+ textFieldFirstName.getText() + "\n" + textFieldAddress.getText() + "\n"
								+ textFieldCity.getText() + "\n" + textFieldState.getText() + "\n"
								+ textFieldZipcodeJFormat.getText() + "\n" + DOBInput.getText() + "\n"
								+ textFieldSex.getText() + "\n" + phoneInput.getText() + "\n" + textFieldEmail.getText()
								+ "\n" + textFieldMajor.getText() + "\n" + textFieldGPA.getText() + "\n"
								+ textFieldBalanceForm.getText() + "\n" + textFieldRace.getText();
						saveRecordToTextFile.saveToText2(dataForTextFile4);
						break;
					} // end of switch

					textFieldLastName.setText("");
					textFieldFirstName.setText("");
					textFieldAddress.setText("");
					textFieldCity.setText("");
					textFieldState.setText("");
					textFieldZipcodeJFormat.setText("");
					phoneInput.setText("");
					textFieldEmail.setText("");
					DOBInput.setText("");
					textFieldSex.setText("");
					textFieldMajor.setText("");
					textFieldGPA.setText("");
					textFieldBalanceForm.setText("");
					textFieldRace.setText("");

					try {
						aListForComboSER = getLastNameListSER();
						System.out.println(aListForComboSER.size() + "aListForComboSER.size() vtiltioior");
						System.out.println(aListForComboSER + "aListForComboSER koritort");
					} catch (ClassNotFoundException | IOException e1) {
						e1.printStackTrace();
					}
					if (aListForComboSER == null) {
						aListForComboSER = new ArrayList<String>();
					}
					try {						
						saveLastNameListSER(aListForComboSER);
						aListForComboSER = getLastNameListSER();
					} catch (IOException exc) {
						exc.printStackTrace();
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					}

					if (aListForComboSER.size() <= 3) {
						arrayOfLastNames = aListForComboSER.toArray(new String[aListForComboSER.size()]); // Important.
																											// Converts
																											// array to
																											// list. See
																											// Comprehensive
																											// guide for
																											// his bug
																											// fix
						comboBoxSearchName.setModel(new DefaultComboBoxModel<String>(arrayOfLastNames));
					}

					try {
						returnedStudentArrayListSER = getListOfStudents();
						System.out.println(returnedStudentArrayListSER + " por8t904c8");
						System.out.println(returnedStudentArrayListSER.size() + " oe954");
						Integer numStudents = returnedStudentArrayListSER.size();
						textFieldEnrolled.setText(numStudents.toString());
					} catch (ClassNotFoundException | IOException e1) {
						e1.printStackTrace();
					}
					textFieldMessage.setText("");
				}
			}
		});

		btnAddStudent2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddStudent2.setBounds(10, 9, 118, 22);
		contentPane.add(btnAddStudent2);

		textFieldIndex = new JTextField();
		textFieldIndex.setEditable(false);
		textFieldIndex.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldIndex.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldIndex.setBounds(600, 125, 26, 21);
		contentPane.add(textFieldIndex);
		textFieldIndex.setColumns(10);

		JLabel lblNewLabel = new JLabel("Index: ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(540, 125, 86, 21);
		contentPane.add(lblNewLabel);

		JLabel lblRequired = new JLabel("* Required");
		lblRequired.setHorizontalAlignment(SwingConstants.CENTER);
		lblRequired.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRequired.setBounds(10, 191, 81, 21);
		contentPane.add(lblRequired);

		JComboBox<String> comboBoxSortOrder = new JComboBox<String>();
		comboBoxSortOrder.setModel(new DefaultComboBoxModel<String>(new String[] { "Select Sort Order", "Student ID",
				"Last Name - Ascending", "Last Name - Descending", "City", "Zipcode", "Major", "GPA" }));
		comboBoxSortOrder.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxSortOrder.setBounds(159, 212, 146, 21);
		contentPane.add(comboBoxSortOrder);

		JButton btnSortBy = new JButton("Sort Students By:");
		btnSortBy.setToolTipText("Select a sort order first, then click this button.");
		btnSortBy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentSortComparator studentSortComparator = new StudentSortComparator();

				try {
					sortedSERList = getListOfStudents(); // returns returnedStudentArrayListSER but assigned to the sort
															// variable
					System.out.println(sortedSERList.size() + "sortedSERList.size() 94895vm54");

					if (sortedSERList == null) {
						sortedSERList = new ArrayList<Student>();
						studentSortComparator.saveSortedSERList(sortedSERList);
						sortedSERList = studentSortComparator.returnSortedSERList();
						System.out.println(sortedSERList.size() + "sortedSERList.size() o0c49546-");
					}

					if (sortedSERList.size() < 3) {
						textFieldMessage.setText("To sort, at least three students are required.");
					} else {
						textFieldMessage.setText("");
					}

				} catch (ClassNotFoundException | IOException e1) {
					e1.printStackTrace();
				}
				
				System.out.println(sortedSERList.size() + "sortedSERList.size() pe90494-m-");
				if (sortedSERList != null && sortedSERList.size() == 3) {
					System.out.println(sortedSERList.size() + "kpocfpt849854-m-");
					sortOrderStr = (String) comboBoxSortOrder.getSelectedItem();
					System.out.println(sortedSERList.size() + "k ceio89485-m-");
					//System.out.println(sortOrderStr.size() + "k korit0r98-m-");
					switch (sortOrderStr) {
					case "Student ID":
						model.setRowCount(0);
						System.out.println("k klcfe9t049-p-");
						
						studentSortComparator.sortStudentID(sortedSERList);
						System.out.println("k loper03895034-c-");
						tableStudentID1 = sortedSERList.get(0).getStudentID();
						tableLastName1 = sortedSERList.get(0).getLastName();
						tableFirstName1 = sortedSERList.get(0).getFirstName();
						tableCity1 = sortedSERList.get(0).getCity();
						tableState1 = sortedSERList.get(0).getState();
						tableAddress1 = sortedSERList.get(0).getStreetAddress();
						tableZipcode1 = sortedSERList.get(0).getZipcode();
						tableDoB1 = sortedSERList.get(0).getDoB();
						tableSex1 = sortedSERList.get(0).getSex();
						tablePhone1 = sortedSERList.get(0).getPhone();
						tableEmail1 = sortedSERList.get(0).getEmail();
						tableMajor1 = sortedSERList.get(0).getMajor();
						tableGPA1 = sortedSERList.get(0).getCurrentGPA();
						tableBalance1 = sortedSERList.get(0).getBalance();
						tableRace1 = sortedSERList.get(0).getRace();

						tableStudentID2 = sortedSERList.get(1).getStudentID();
						tableLastName2 = sortedSERList.get(1).getLastName();
						tableFirstName2 = sortedSERList.get(1).getFirstName();
						tableAddress2 = sortedSERList.get(1).getStreetAddress();
						tableCity2 = sortedSERList.get(1).getCity();
						tableState2 = sortedSERList.get(1).getState();
						tableZipcode2 = sortedSERList.get(1).getZipcode();
						tableDoB2 = sortedSERList.get(1).getDoB();
						tableSex2 = sortedSERList.get(1).getSex();
						tablePhone2 = sortedSERList.get(1).getPhone();
						tableEmail2 = sortedSERList.get(1).getEmail();
						tableMajor2 = sortedSERList.get(1).getMajor();
						tableGPA2 = sortedSERList.get(1).getCurrentGPA();
						tableBalance2 = sortedSERList.get(1).getBalance();
						tableRace2 = sortedSERList.get(1).getRace();

						tableStudentID3 = sortedSERList.get(2).getStudentID();
						System.out.println("k kdpoicrocrtir54z-");
						tableLastName3 = sortedSERList.get(2).getLastName();
						tableFirstName3 = sortedSERList.get(2).getFirstName();
						tableAddress3 = sortedSERList.get(2).getStreetAddress();
						tableCity3 = sortedSERList.get(2).getCity();
						tableState3 = sortedSERList.get(2).getState();
						tableZipcode3 = sortedSERList.get(2).getZipcode();
						tableDoB3 = sortedSERList.get(2).getDoB();
						tableSex3 = sortedSERList.get(2).getSex();
						tablePhone3 = sortedSERList.get(2).getPhone();
						tableEmail3 = sortedSERList.get(2).getEmail();
						tableMajor3 = sortedSERList.get(2).getMajor();
						tableGPA3 = sortedSERList.get(2).getCurrentGPA();
						tableBalance3 = sortedSERList.get(2).getBalance();
						tableRace3 = sortedSERList.get(2).getRace();

						studentSortComparator.saveSortedSERList(sortListOfStudents);
						System.out.println(" jxpo3i0498cf-");
						break;

					case "Last Name - Ascending":
						model.setRowCount(0);
						sortedSERList = studentSortComparator.sortLastNameAscending(sortedSERList);
						tableStudentID1 = sortedSERList.get(0).getStudentID();
						tableLastName1 = sortedSERList.get(0).getLastName();
						tableFirstName1 = sortedSERList.get(0).getFirstName();
						tableCity1 = sortedSERList.get(0).getCity();
						tableState1 = sortedSERList.get(0).getState();
						tableAddress1 = sortedSERList.get(0).getStreetAddress();
						tableZipcode1 = sortedSERList.get(0).getZipcode();
						tableDoB1 = sortedSERList.get(0).getDoB();
						tableSex1 = sortedSERList.get(0).getSex();
						tablePhone1 = sortedSERList.get(0).getPhone();
						tableEmail1 = sortedSERList.get(0).getEmail();
						tableMajor1 = sortedSERList.get(0).getMajor();
						tableGPA1 = sortedSERList.get(0).getCurrentGPA();
						tableBalance1 = sortedSERList.get(0).getBalance();
						tableRace1 = sortedSERList.get(0).getRace();

						tableStudentID2 = sortedSERList.get(1).getStudentID();
						tableLastName2 = sortedSERList.get(1).getLastName();
						tableFirstName2 = sortedSERList.get(1).getFirstName();
						tableAddress2 = sortedSERList.get(1).getStreetAddress();
						tableCity2 = sortedSERList.get(1).getCity();
						tableState2 = sortedSERList.get(1).getState();
						tableZipcode2 = sortedSERList.get(1).getZipcode();
						tableDoB2 = sortedSERList.get(1).getDoB();
						tableSex2 = sortedSERList.get(1).getSex();
						tablePhone2 = sortedSERList.get(1).getPhone();
						tableEmail2 = sortedSERList.get(1).getEmail();
						tableMajor2 = sortedSERList.get(1).getMajor();
						tableGPA2 = sortedSERList.get(1).getCurrentGPA();
						tableBalance2 = sortedSERList.get(1).getBalance();
						tableRace2 = sortedSERList.get(1).getRace();

						tableStudentID3 = sortedSERList.get(2).getStudentID();
						tableLastName3 = sortedSERList.get(2).getLastName();
						tableFirstName3 = sortedSERList.get(2).getFirstName();
						tableAddress3 = sortedSERList.get(2).getStreetAddress();
						tableCity3 = sortedSERList.get(2).getCity();
						tableState3 = sortedSERList.get(2).getState();
						tableZipcode3 = sortedSERList.get(2).getZipcode();
						tableDoB3 = sortedSERList.get(2).getDoB();
						tableSex3 = sortedSERList.get(2).getSex();
						tablePhone3 = sortedSERList.get(2).getPhone();
						tableEmail3 = sortedSERList.get(2).getEmail();
						tableMajor3 = sortedSERList.get(2).getMajor();
						tableGPA3 = sortedSERList.get(2).getCurrentGPA();
						tableBalance3 = sortedSERList.get(2).getBalance();
						tableRace3 = sortedSERList.get(2).getRace();

						studentSortComparator.saveSortedSERList(sortListOfStudents);
						break;
					case "Last Name - Descending":
						model.setRowCount(0);
						studentSortComparator.sortLastNameReversed(sortedSERList);
						try {
							sortedSERList = studentSortComparator.returnSortedSERList();
						} catch (ClassNotFoundException | IOException e1) {
							e1.printStackTrace();
						}

						tableStudentID1 = sortedSERList.get(0).getStudentID();
						tableLastName1 = sortedSERList.get(0).getLastName();
						tableFirstName1 = sortedSERList.get(0).getFirstName();
						tableCity1 = sortedSERList.get(0).getCity();
						tableState1 = sortedSERList.get(0).getState();
						tableAddress1 = sortedSERList.get(0).getStreetAddress();
						tableZipcode1 = sortedSERList.get(0).getZipcode();
						tableDoB1 = sortedSERList.get(0).getDoB();
						tableSex1 = sortedSERList.get(0).getSex();
						tablePhone1 = sortedSERList.get(0).getPhone();
						tableEmail1 = sortedSERList.get(0).getEmail();
						tableMajor1 = sortedSERList.get(0).getMajor();
						tableGPA1 = sortedSERList.get(0).getCurrentGPA();
						tableBalance1 = sortedSERList.get(0).getBalance();
						tableRace1 = sortedSERList.get(0).getRace();

						tableStudentID2 = sortedSERList.get(1).getStudentID();
						tableLastName2 = sortedSERList.get(1).getLastName();
						tableFirstName2 = sortedSERList.get(1).getFirstName();
						tableAddress2 = sortedSERList.get(1).getStreetAddress();
						tableCity2 = sortedSERList.get(1).getCity();
						tableState2 = sortedSERList.get(1).getState();
						tableZipcode2 = sortedSERList.get(1).getZipcode();
						tableDoB2 = sortedSERList.get(1).getDoB();
						tableSex2 = sortedSERList.get(1).getSex();
						tablePhone2 = sortedSERList.get(1).getPhone();
						tableEmail2 = sortedSERList.get(1).getEmail();
						tableMajor2 = sortedSERList.get(1).getMajor();
						tableGPA2 = sortedSERList.get(1).getCurrentGPA();
						tableBalance2 = sortedSERList.get(1).getBalance();
						tableRace2 = sortedSERList.get(1).getRace();

						tableStudentID3 = sortedSERList.get(2).getStudentID();
						tableLastName3 = sortedSERList.get(2).getLastName();
						tableFirstName3 = sortedSERList.get(2).getFirstName();
						tableAddress3 = sortedSERList.get(2).getStreetAddress();
						tableCity3 = sortedSERList.get(2).getCity();
						tableState3 = sortedSERList.get(2).getState();
						tableZipcode3 = sortedSERList.get(2).getZipcode();
						tableDoB3 = sortedSERList.get(2).getDoB();
						tableSex3 = sortedSERList.get(2).getSex();
						tablePhone3 = sortedSERList.get(2).getPhone();
						tableEmail3 = sortedSERList.get(2).getEmail();
						tableMajor3 = sortedSERList.get(2).getMajor();
						tableGPA3 = sortedSERList.get(2).getCurrentGPA();
						tableBalance3 = sortedSERList.get(2).getBalance();
						tableRace3 = sortedSERList.get(2).getRace();

						studentSortComparator.saveSortedSERList(sortListOfStudents);
						break;
					case "City":
						model.setRowCount(0);
						studentSortComparator.sortCity(sortedSERList);
						try {
							sortedSERList = studentSortComparator.returnSortedSERList();
						} catch (ClassNotFoundException | IOException e1) {
							e1.printStackTrace();
						}

						tableStudentID1 = sortedSERList.get(0).getStudentID();
						tableLastName1 = sortedSERList.get(0).getLastName();
						tableFirstName1 = sortedSERList.get(0).getFirstName();
						tableCity1 = sortedSERList.get(0).getCity();
						tableState1 = sortedSERList.get(0).getState();
						tableAddress1 = sortedSERList.get(0).getStreetAddress();
						tableZipcode1 = sortedSERList.get(0).getZipcode();
						tableDoB1 = sortedSERList.get(0).getDoB();
						tableSex1 = sortedSERList.get(0).getSex();
						tablePhone1 = sortedSERList.get(0).getPhone();
						tableEmail1 = sortedSERList.get(0).getEmail();
						tableMajor1 = sortedSERList.get(0).getMajor();
						tableGPA1 = sortedSERList.get(0).getCurrentGPA();
						tableBalance1 = sortedSERList.get(0).getBalance();
						tableRace1 = sortedSERList.get(0).getRace();

						tableStudentID2 = sortedSERList.get(1).getStudentID();
						tableLastName2 = sortedSERList.get(1).getLastName();
						tableFirstName2 = sortedSERList.get(1).getFirstName();
						tableAddress2 = sortedSERList.get(1).getStreetAddress();
						tableCity2 = sortedSERList.get(1).getCity();
						tableState2 = sortedSERList.get(1).getState();
						tableZipcode2 = sortedSERList.get(1).getZipcode();
						tableDoB2 = sortedSERList.get(1).getDoB();
						tableSex2 = sortedSERList.get(1).getSex();
						tablePhone2 = sortedSERList.get(1).getPhone();
						tableEmail2 = sortedSERList.get(1).getEmail();
						tableMajor2 = sortedSERList.get(1).getMajor();
						tableGPA2 = sortedSERList.get(1).getCurrentGPA();
						tableBalance2 = sortedSERList.get(1).getBalance();
						tableRace2 = sortedSERList.get(1).getRace();

						tableStudentID3 = sortedSERList.get(2).getStudentID();
						tableLastName3 = sortedSERList.get(2).getLastName();
						tableFirstName3 = sortedSERList.get(2).getFirstName();
						tableAddress3 = sortedSERList.get(2).getStreetAddress();
						tableCity3 = sortedSERList.get(2).getCity();
						tableState3 = sortedSERList.get(2).getState();
						tableZipcode3 = sortedSERList.get(2).getZipcode();
						tableDoB3 = sortedSERList.get(2).getDoB();
						tableSex3 = sortedSERList.get(2).getSex();
						tablePhone3 = sortedSERList.get(2).getPhone();
						tableEmail3 = sortedSERList.get(2).getEmail();
						tableMajor3 = sortedSERList.get(2).getMajor();
						tableGPA3 = sortedSERList.get(2).getCurrentGPA();
						tableBalance3 = sortedSERList.get(2).getBalance();
						tableRace3 = sortedSERList.get(2).getRace();

						studentSortComparator.saveSortedSERList(sortListOfStudents);
						break;
					case "Zipcode":
						model.setRowCount(0);
						studentSortComparator.sortZipcode(sortedSERList);

						tableStudentID1 = sortedSERList.get(0).getStudentID();
						tableLastName1 = sortedSERList.get(0).getLastName();
						tableFirstName1 = sortedSERList.get(0).getFirstName();
						tableCity1 = sortedSERList.get(0).getCity();
						tableState1 = sortedSERList.get(0).getState();
						tableAddress1 = sortedSERList.get(0).getStreetAddress();
						tableZipcode1 = sortedSERList.get(0).getZipcode();
						tableDoB1 = sortedSERList.get(0).getDoB();
						tableSex1 = sortedSERList.get(0).getSex();
						tablePhone1 = sortedSERList.get(0).getPhone();
						tableEmail1 = sortedSERList.get(0).getEmail();
						tableMajor1 = sortedSERList.get(0).getMajor();
						tableGPA1 = sortedSERList.get(0).getCurrentGPA();
						tableBalance1 = sortedSERList.get(0).getBalance();
						tableRace1 = sortedSERList.get(0).getRace();

						tableStudentID2 = sortedSERList.get(1).getStudentID();
						tableLastName2 = sortedSERList.get(1).getLastName();
						tableFirstName2 = sortedSERList.get(1).getFirstName();
						tableAddress2 = sortedSERList.get(1).getStreetAddress();
						tableCity2 = sortedSERList.get(1).getCity();
						tableState2 = sortedSERList.get(1).getState();
						tableZipcode2 = sortedSERList.get(1).getZipcode();
						tableDoB2 = sortedSERList.get(1).getDoB();
						tableSex2 = sortedSERList.get(1).getSex();
						tablePhone2 = sortedSERList.get(1).getPhone();
						tableEmail2 = sortedSERList.get(1).getEmail();
						tableMajor2 = sortedSERList.get(1).getMajor();
						tableGPA2 = sortedSERList.get(1).getCurrentGPA();
						tableBalance2 = sortedSERList.get(1).getBalance();
						tableRace2 = sortedSERList.get(1).getRace();

						tableStudentID3 = sortedSERList.get(1).getStudentID();
						tableLastName3 = sortedSERList.get(2).getLastName();
						tableFirstName3 = sortedSERList.get(2).getFirstName();
						tableAddress3 = sortedSERList.get(2).getStreetAddress();
						tableCity3 = sortedSERList.get(2).getCity();
						tableState3 = sortedSERList.get(2).getState();
						tableZipcode3 = sortedSERList.get(2).getZipcode();
						tableDoB3 = sortedSERList.get(2).getDoB();
						tableSex3 = sortedSERList.get(2).getSex();
						tablePhone3 = sortedSERList.get(2).getPhone();
						tableEmail3 = sortedSERList.get(2).getEmail();
						tableMajor3 = sortedSERList.get(2).getMajor();
						tableGPA3 = sortedSERList.get(2).getCurrentGPA();
						tableBalance3 = sortedSERList.get(2).getBalance();
						tableRace3 = sortedSERList.get(2).getRace();

						studentSortComparator.saveSortedSERList(sortListOfStudents);
						break;
					case "Major":
						model.setRowCount(0);
						studentSortComparator.sortMajor(sortedSERList);
						try {
							sortedSERList = studentSortComparator.returnSortedSERList();
						} catch (ClassNotFoundException | IOException e1) {
							e1.printStackTrace();
						}

						tableStudentID1 = sortedSERList.get(0).getStudentID();
						tableLastName1 = sortedSERList.get(0).getLastName();
						tableFirstName1 = sortedSERList.get(0).getFirstName();
						tableCity1 = sortedSERList.get(0).getCity();
						tableState1 = sortedSERList.get(0).getState();
						tableAddress1 = sortedSERList.get(0).getStreetAddress();
						tableZipcode1 = sortedSERList.get(0).getZipcode();
						tableDoB1 = sortedSERList.get(0).getDoB();
						tableSex1 = sortedSERList.get(0).getSex();
						tablePhone1 = sortedSERList.get(0).getPhone();
						tableEmail1 = sortedSERList.get(0).getEmail();
						tableMajor1 = sortedSERList.get(0).getMajor();
						tableGPA1 = sortedSERList.get(0).getCurrentGPA();
						tableBalance1 = sortedSERList.get(0).getBalance();
						tableRace1 = sortedSERList.get(0).getRace();

						tableStudentID2 = sortedSERList.get(1).getStudentID();
						tableLastName2 = sortedSERList.get(1).getLastName();
						tableFirstName2 = sortedSERList.get(1).getFirstName();
						tableAddress2 = sortedSERList.get(1).getStreetAddress();
						tableCity2 = sortedSERList.get(1).getCity();
						tableState2 = sortedSERList.get(1).getState();
						tableZipcode2 = sortedSERList.get(1).getZipcode();
						tableDoB2 = sortedSERList.get(1).getDoB();
						tableSex2 = sortedSERList.get(1).getSex();
						tablePhone2 = sortedSERList.get(1).getPhone();
						tableEmail2 = sortedSERList.get(1).getEmail();
						tableMajor2 = sortedSERList.get(1).getMajor();
						tableGPA2 = sortedSERList.get(1).getCurrentGPA();
						tableBalance2 = sortedSERList.get(1).getBalance();
						tableRace2 = sortedSERList.get(1).getRace();

						tableStudentID3 = sortedSERList.get(2).getStudentID();
						tableLastName3 = sortedSERList.get(2).getLastName();
						tableFirstName3 = sortedSERList.get(2).getFirstName();
						tableAddress3 = sortedSERList.get(2).getStreetAddress();
						tableCity3 = sortedSERList.get(2).getCity();
						tableState3 = sortedSERList.get(2).getState();
						tableZipcode3 = sortedSERList.get(2).getZipcode();
						tableDoB3 = sortedSERList.get(2).getDoB();
						tableSex3 = sortedSERList.get(2).getSex();
						tablePhone3 = sortedSERList.get(2).getPhone();
						tableEmail3 = sortedSERList.get(2).getEmail();
						tableMajor3 = sortedSERList.get(2).getMajor();
						tableGPA3 = sortedSERList.get(2).getCurrentGPA();
						tableBalance3 = sortedSERList.get(2).getBalance();
						tableRace3 = sortedSERList.get(2).getRace();

						studentSortComparator.saveSortedSERList(sortListOfStudents);
						break;
					case "GPA":
						model.setRowCount(0);
						studentSortComparator.sortGPA(sortedSERList);

						tableStudentID1 = sortedSERList.get(0).getStudentID();
						tableLastName1 = sortedSERList.get(0).getLastName();
						tableFirstName1 = sortedSERList.get(0).getFirstName();
						tableCity1 = sortedSERList.get(0).getCity();
						tableState1 = sortedSERList.get(0).getState();
						tableAddress1 = sortedSERList.get(0).getStreetAddress();
						tableZipcode1 = sortedSERList.get(0).getZipcode();
						tableDoB1 = sortedSERList.get(0).getDoB();
						tableSex1 = sortedSERList.get(0).getSex();
						tablePhone1 = sortedSERList.get(0).getPhone();
						tableEmail1 = sortedSERList.get(0).getEmail();
						tableMajor1 = sortedSERList.get(0).getMajor();
						tableGPA1 = sortedSERList.get(0).getCurrentGPA();
						tableBalance1 = sortedSERList.get(0).getBalance();
						tableRace1 = sortedSERList.get(0).getRace();

						tableStudentID2 = sortedSERList.get(1).getStudentID();
						tableLastName2 = sortedSERList.get(1).getLastName();
						tableFirstName2 = sortedSERList.get(1).getFirstName();
						tableAddress2 = sortedSERList.get(1).getStreetAddress();
						tableCity2 = sortedSERList.get(1).getCity();
						tableState2 = sortedSERList.get(1).getState();
						tableZipcode2 = sortedSERList.get(1).getZipcode();
						tableDoB2 = sortedSERList.get(1).getDoB();
						tableSex2 = sortedSERList.get(1).getSex();
						tablePhone2 = sortedSERList.get(1).getPhone();
						tableEmail2 = sortedSERList.get(1).getEmail();
						tableMajor2 = sortedSERList.get(1).getMajor();
						tableGPA2 = sortedSERList.get(1).getCurrentGPA();
						tableBalance2 = sortedSERList.get(1).getBalance();
						tableRace2 = sortedSERList.get(1).getRace();

						tableStudentID3 = sortedSERList.get(2).getStudentID();
						tableLastName3 = sortedSERList.get(2).getLastName();
						tableFirstName3 = sortedSERList.get(2).getFirstName();
						tableAddress3 = sortedSERList.get(2).getStreetAddress();
						tableCity3 = sortedSERList.get(2).getCity();
						tableState3 = sortedSERList.get(2).getState();
						tableZipcode3 = sortedSERList.get(2).getZipcode();
						tableDoB3 = sortedSERList.get(2).getDoB();
						tableSex3 = sortedSERList.get(2).getSex();
						tablePhone3 = sortedSERList.get(2).getPhone();
						tableEmail3 = sortedSERList.get(2).getEmail();
						tableMajor3 = sortedSERList.get(2).getMajor();
						tableGPA3 = sortedSERList.get(2).getCurrentGPA();
						tableBalance3 = sortedSERList.get(2).getBalance();
						tableRace3 = sortedSERList.get(2).getRace();

						studentSortComparator.saveSortedSERList(sortListOfStudents);
						break;

					case "Balance":
						model.setRowCount(0);
						studentSortComparator.sortBalance(sortedSERList);

						tableStudentID1 = sortedSERList.get(0).getStudentID();
						tableLastName1 = sortedSERList.get(0).getLastName();
						tableFirstName1 = sortedSERList.get(0).getFirstName();
						tableCity1 = sortedSERList.get(0).getCity();
						tableState1 = sortedSERList.get(0).getState();
						tableAddress1 = sortedSERList.get(0).getStreetAddress();
						tableZipcode1 = sortedSERList.get(0).getZipcode();
						tableDoB1 = sortedSERList.get(0).getDoB();
						tableSex1 = sortedSERList.get(0).getSex();
						tablePhone1 = sortedSERList.get(0).getPhone();
						tableEmail1 = sortedSERList.get(0).getEmail();
						tableMajor1 = sortedSERList.get(0).getMajor();
						tableGPA1 = sortedSERList.get(0).getCurrentGPA();
						tableBalance1 = sortedSERList.get(0).getBalance();
						tableRace1 = sortedSERList.get(0).getRace();
						tableStudentID2 = sortedSERList.get(1).getStudentID();
						tableLastName2 = sortedSERList.get(1).getLastName();
						tableFirstName2 = sortedSERList.get(1).getFirstName();
						tableAddress2 = sortedSERList.get(1).getStreetAddress();
						tableCity2 = sortedSERList.get(1).getCity();
						tableState2 = sortedSERList.get(1).getState();
						tableZipcode2 = sortedSERList.get(1).getZipcode();
						tableDoB2 = sortedSERList.get(1).getDoB();
						tableSex2 = sortedSERList.get(1).getSex();
						tablePhone2 = sortedSERList.get(1).getPhone();
						tableEmail2 = sortedSERList.get(1).getEmail();
						tableMajor2 = sortedSERList.get(1).getMajor();
						tableGPA2 = sortedSERList.get(1).getCurrentGPA();
						tableBalance2 = sortedSERList.get(1).getBalance();
						tableRace2 = sortedSERList.get(1).getRace();

						tableStudentID3 = sortedSERList.get(2).getStudentID();
						tableLastName3 = sortedSERList.get(2).getLastName();
						tableFirstName3 = sortedSERList.get(2).getFirstName();
						tableAddress3 = sortedSERList.get(2).getStreetAddress();
						tableCity3 = sortedSERList.get(2).getCity();
						tableState3 = sortedSERList.get(2).getState();
						tableZipcode3 = sortedSERList.get(2).getZipcode();
						tableDoB3 = sortedSERList.get(2).getDoB();
						tableSex3 = sortedSERList.get(2).getSex();
						tablePhone3 = sortedSERList.get(2).getPhone();
						tableEmail3 = sortedSERList.get(2).getEmail();
						tableMajor3 = sortedSERList.get(2).getMajor();
						tableGPA3 = sortedSERList.get(2).getCurrentGPA();
						tableBalance3 = sortedSERList.get(2).getBalance();
						tableRace3 = sortedSERList.get(2).getRace();

						studentSortComparator.saveSortedSERList(sortListOfStudents);
						break;
					} // End of switch

				} // End of if

				// re the sorting table
				Object[] newRow = { tableStudentID1, tableLastName1, tableFirstName1, tableAddress1, tableCity1,
						tableState1, tableZipcode1, tableDoB1, tableSex1, tablePhone1, tableEmail1, tableMajor1,
						tableGPA1, tableBalance1, tableRace1 };
				Object[] newRow2 = { tableStudentID2, tableLastName2, tableFirstName2, tableAddress2, tableCity2,
						tableState2, tableZipcode2, tableDoB2, tableSex2, tablePhone2, tableEmail2, tableMajor2,
						tableGPA2, tableBalance2, tableRace2 };
				Object[] newRow3 = { tableStudentID3, tableLastName3, tableFirstName3, tableAddress3, tableCity3,
						tableState3, tableZipcode3, tableDoB3, tableSex3, tablePhone3, tableEmail3, tableMajor3,
						tableGPA3, tableBalance3, tableRace3 };

				model.addRow(newRow);
				model.addRow(newRow2);
				model.addRow(newRow3);
				System.out.println( "lpe95045-");
			}// End of actionPerformed()
		}); // End of addActionListener

		btnSortBy.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSortBy.setBounds(10, 212, 146, 21);
		contentPane.add(btnSortBy);

		JLabel lblNewLabel_1 = new JLabel("Enrolled: ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(261, 148, 86, 21);
		contentPane.add(lblNewLabel_1);

		textFieldEnrolled = new JTextField();
		textFieldEnrolled.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldEnrolled.setForeground(new Color(255, 0, 0));
		textFieldEnrolled.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldEnrolled.setEditable(false);
		textFieldEnrolled.setBounds(348, 151, 105, 19);
		contentPane.add(textFieldEnrolled);
		textFieldEnrolled.setColumns(10);
		if (returnedStudentArrayListSER == null) {
			textFieldEnrolled.setText(" 0 of 5");
		} else {
			Integer numStudents = returnedStudentArrayListSER.size();
			textFieldEnrolled.setText(numStudents.toString() + " of 5");
		}

		JLabel lblNewLabel_2 = new JLabel("[M/F] Sex:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(261, 81, 86, 21);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("*Race: ");
		lblNewLabel_3.setToolTipText("Npot that it matters");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(454, 148, 66, 21);
		contentPane.add(lblNewLabel_3);

		JScrollPane scrollPaneTextArea = new JScrollPane();
		scrollPaneTextArea.setBounds(710, 10, 328, 223);
		contentPane.add(scrollPaneTextArea);

		JTextArea textAreaDisplay = new JTextArea();
		textAreaDisplay.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAreaDisplay.setEditable(false);
		scrollPaneTextArea.setViewportView(textAreaDisplay);

		JButton btnNewButton = new JButton("Student Print Preview --->");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				allNames = "THE FEDERALIST PAPERS - PS-438 \nStudent ID: " + textFieldID.getText();
				allNames += "\nLast Name: " + textFieldLastName.getText() + "\nFirst Name: "
						+ textFieldFirstName.getText() + "\nAddress: " + textFieldAddress.getText() + "\nCity: "
						+ textFieldCity.getText() + "\nState: " + textFieldState.getText() + "\nZipcode: "
						+ textFieldZipcodeJFormat.getText() + "\nDate Of Birth [DoB]: " + DOBInput.getText() + "\nSex: "
						+ textFieldSex.getText() + "\nPhone: " + phoneInput.getText() + "\nEmail: "
						+ textFieldEmail.getText() + "\nMajor: " + textFieldMajor.getText()
						+ "\nCurrent Grade Point Average [GPA]: " + textFieldGPA.getText()
						+ "\nBalance remaining on account: $" + textFieldBalanceForm.getText()
						+ "\nRace (Not that it matters): " + textFieldRace.getText();
				textAreaDisplay.setText(allNames);
			}
		});

		btnNewButton.setHorizontalAlignment(SwingConstants.RIGHT);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(530, 192, 170, 21);
		contentPane.add(btnNewButton);

		JButton btnPrint = new JButton("Print ---->");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					textAreaDisplay.print();
				} catch (PrinterException e1) {
					e1.printStackTrace();
				}
			}
		});

		btnPrint.setHorizontalAlignment(SwingConstants.RIGHT);
		btnPrint.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPrint.setBounds(530, 213, 170, 21);
		contentPane.add(btnPrint);

		btnClearPrintPreview = new JButton("Clear --->");
		btnClearPrintPreview.setHorizontalAlignment(SwingConstants.RIGHT);
		btnClearPrintPreview.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnClearPrintPreview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaDisplay.setText("");
			}
		});
		btnClearPrintPreview.setBounds(600, 172, 100, 21);
		contentPane.add(btnClearPrintPreview);
		btnNewButton_1 = new JButton("Close App");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setBounds(3, 171, 85, 22);
		contentPane.add(btnNewButton_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 243, 1227, 151);
		contentPane.add(scrollPane);

		StudentSortComparator studentSortComparator = new StudentSortComparator();
		sortedSERList = studentSortComparator.returnSortedSERList();
		// re Table
		Object rowData[][] = {};
		Object columnNames[] = { "ID", "Last Name", "First Name", "Street Address", "City", "State", "Zipcode", "DoB",
				"Sex", "Phone", "Email", "Major", "GPA", "Balance", "Race" };
		Object[] newRow = { tableStudentID1, tableLastName1, tableFirstName1, tableAddress1, tableCity1, tableState1,
				tableZipcode1, tableDoB1, tableSex1, tablePhone1, tableEmail1, tableMajor1, tableGPA1, tableBalance1,
				tableRace1 };
		Object[] newRow2 = { tableStudentID2, tableLastName2, tableAddress2, tableZipcode2, tableCity2, tableState2,
				tableZipcode2, tableDoB2, tableSex2, tablePhone2, tableEmail2, tableMajor2, tableGPA2, tableBalance2,
				tableRace2 };
		Object[] newRow3 = { tableStudentID3, tableLastName3, tableAddress3, tableZipcode3, tableCity3, tableState3,
				tableZipcode3, tableDoB3, tableSex3, tablePhone3, tableEmail3, tableMajor3, tableGPA3, tableBalance3,
				tableRace3 };

		model = new DefaultTableModel(rowData, columnNames);
		table = new JTable(model);
		Font customFont = new Font("Serif", Font.PLAIN, 14);
		table.setFont(customFont);
		table.setRowHeight(customFont.getSize() + 4);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		TableColumnModel columnModule = table.getColumnModel();
		TableColumn IDColumn = columnModule.getColumn(0);
		IDColumn.setPreferredWidth(30);
		TableColumn lastNameColumn = columnModule.getColumn(1);
		lastNameColumn.setPreferredWidth(150);
		TableColumn firstNameColumn = columnModule.getColumn(2);// not sure why this is triggered
		lastNameColumn.setPreferredWidth(90);
		TableColumn streetAddressColum = columnModule.getColumn(3);
		streetAddressColum.setPreferredWidth(150);
		TableColumn cityColumn = columnModule.getColumn(4);
		cityColumn.setPreferredWidth(120);
		TableColumn stateColumn = columnModule.getColumn(5);
		stateColumn.setPreferredWidth(40);
		TableColumn zipcodeColumn = columnModule.getColumn(6);
		zipcodeColumn.setPreferredWidth(50);
		TableColumn DoBColumn = columnModule.getColumn(7);
		DoBColumn.setPreferredWidth(80);
		TableColumn sexColumn = columnModule.getColumn(8);
		sexColumn.setPreferredWidth(40);
		TableColumn phoneColumn = columnModule.getColumn(9);
		phoneColumn.setPreferredWidth(100);
		TableColumn emailColumn = columnModule.getColumn(10);
		emailColumn.setPreferredWidth(200);
		TableColumn majorColumn = columnModule.getColumn(11);
		majorColumn.setPreferredWidth(100);
		TableColumn GPAColumn = columnModule.getColumn(12);
		GPAColumn.setPreferredWidth(40);
		TableColumn BalanceColumn = columnModule.getColumn(13);
		BalanceColumn.setPreferredWidth(100);
		TableColumn raceColumn = columnModule.getColumn(14);
		raceColumn.setPreferredWidth(50);
		scrollPane.setViewportView(table);

		textFieldState = new JTextField();
		textFieldState.setBounds(98, 151, 30, 19);
		contentPane.add(textFieldState);
		textFieldState.setColumns(2);

		// Verify input is not empty or exceeds 2 characters
		InputVerifier verifierState = new InputVerifier() {
			public boolean verify(JComponent comp) {
				boolean returnValue;// wrong. it is used below
				JTextField textFieldState = (JTextField) comp;
				try {
					String textLengthState = textFieldState.getText();
					if (textLengthState.length() < 2 || textFieldState.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Required. No numbers. Max 2 characters.", null,
								JOptionPane.INFORMATION_MESSAGE);
						returnValue = false;
					} else {
						String noDigitsString = textFieldState.getText();
						for (int i = 0; i < noDigitsString.length(); i++) {
							char ch = noDigitsString.charAt(i);
							if (returnValue = Character.isDigit(ch) || !Character.isLetter(ch)) {
								JOptionPane.showMessageDialog(null,
										"No numbers/digits or special characters permitted. \\nOnly letters.", null,
										JOptionPane.INFORMATION_MESSAGE);
								// break NoDigits;
								return false;
								// returnValue = true;
							} // end if
						} // end loop
					} // end else
				} catch (NumberFormatException e) {
					returnValue = false;
				}
				String stateText = textFieldState.getText();
				String toUpperState = stateText.toUpperCase();
				textFieldState.setText(toUpperState);

				return true;
			} // end verify()
		};
		textFieldState.setInputVerifier(verifierState);

		// SEX GOES HERE

		textFieldSex = new JTextField();
		textFieldSex.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldSex.setBounds(348, 84, 30, 19);
		contentPane.add(textFieldSex);
		textFieldSex.setColumns(10);

		// Verify sex input is not empty or exceeds one (1) character, M or F

		InputVerifier VerifierSex = new InputVerifier() {
			public boolean verify(JComponent comp) {
				boolean returnValue = false;

				//JTextField textField = (JTextField) comp;
				try {
					//String textLength = textField.getText();
					String textLengthSex = textFieldSex.getText();					
					// verify no digits
					if (textLengthSex.length() > 1 || textFieldSex.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Required. One (1) letter max, m or f.", null,
								JOptionPane.INFORMATION_MESSAGE);
						returnValue = false;
					} else {
						String noDigitsString = textFieldSex.getText();
						for (int i = 0; i < noDigitsString.length(); i++) { // I have no idea why i++ is called dead code
							char ch = noDigitsString.charAt(i);
							if (returnValue = Character.isDigit(ch) || !Character.isLetter(ch)) {
								JOptionPane.showMessageDialog(null,
										"No numbers/digits or special characters permitted. \n"
												+ "Let's keep it simple. Only letters m or f, or any other letter for that matter.\n"
												+ "I won't check.",
										null, JOptionPane.INFORMATION_MESSAGE);
								return false;
							} else {
								// Capitalize first letter
								String sexText = textFieldSex.getText();
								String firstLetter = sexText.substring(0, 1);
								firstLetter = firstLetter.toUpperCase();
								String remainingLetters = sexText.substring(1);
								String capitalizedString = firstLetter + remainingLetters;
								textFieldSex.setText(capitalizedString);
								return true;
							}
						} // end of loop
						returnValue = true;
					}
				} catch (NumberFormatException e) {
					returnValue = false;
				}

				return returnValue;
			}//
		};

		textFieldSex.setInputVerifier(VerifierSex);

		// race ///////////////////////////

		textFieldRace = new JTextField();
		textFieldRace.setBounds(529, 151, 73, 19);
		contentPane.add(textFieldRace);
		textFieldRace.setColumns(10);

		// FRI - RACE GOES HERE, DUMMY

		// start from scratch

		// Verify race (new) input is not empty or exceeds 25 characters
		InputVerifier VerifierRace = new InputVerifier() {
			public boolean verify(JComponent comp) {
				boolean returnValue = false;

				//JTextField textField = (JTextField) comp;
				try {
					//String textLength = textField.getText();
					String textLengthRace = textFieldRace.getText();				
					// verify no digits
					if (textLengthRace.length() > 15 || textFieldRace.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Required. No numbers. Max 15 characters.", null,
								JOptionPane.INFORMATION_MESSAGE);
						returnValue = false;
					} else {
						String noDigitsString = textFieldRace.getText();
						for (int i = 0; i < noDigitsString.length(); i++) {
							char ch = noDigitsString.charAt(i);
							if (returnValue = Character.isDigit(ch) || !Character.isLetter(ch)) {
								JOptionPane.showMessageDialog(null,
										"No numbers/digits or special characters permitted. \\nOnly letters.", null,
										JOptionPane.INFORMATION_MESSAGE);
								return false;
							}
						} // end of loop
						// Capitalize first letter
						String raceText = textFieldRace.getText();
						String firstLetter = raceText.substring(0, 1);
						firstLetter = firstLetter.toUpperCase();
						String remainingLetters = raceText.substring(1);
						String capitalizedString = firstLetter + remainingLetters;
						textFieldRace.setText(capitalizedString);
						return true;						
					}
				} catch (NumberFormatException e) {
					returnValue = false;
				}

				return returnValue;
			}//
		};

		textFieldRace.setInputVerifier(VerifierRace);

		JButton btnNewButton_3 = new JButton("Automatically Load First Record");
		btnNewButton_3.setToolTipText("Don't forget to click Add Student after the fields are populated");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_3.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        count = 0; // Reset count right at the start of the click
		        
		        try {
		            returnedStudentArrayListSER = getListOfStudents();
		            if (returnedStudentArrayListSER == null) {
		                returnedStudentArrayListSER = new ArrayList<Student>();
		            }
		        } catch (ClassNotFoundException | IOException e1) {
		            e1.printStackTrace();
		        }
		        
		        if (returnedStudentArrayListSER.size() >= 1) {
		            JOptionPane.showMessageDialog(null,
		                    "Sorry, but only one (1) initial record at startup may be added.\n"
		                            + "Please enter data in fields, beginning with a last name (required).",
		                    null, JOptionPane.INFORMATION_MESSAGE);
		        } else {
		            // Using getResourceAsStream to read from inside the JAR
		            try (var is = getClass().getResourceAsStream("/0StudentFILE.txt")) {
		                if (is == null) {
		                    JOptionPane.showMessageDialog(null, "Error: 0StudentFILE.txt not found inside the JAR!");
		                    return;
		                }
		                
		                try (var reader = new BufferedReader(new InputStreamReader(is))) {
		                    while ((s = reader.readLine()) != null) {
		                        ++count;
		                        if (count == 1) {
		                            textFieldLastName.setText(s);
		                            System.out.println(s + " s i05f8656jxhf");
		                        } else if (count == 2) {
		                            textFieldFirstName.setText(s);
		                        } else if (count == 3) {
		                            textFieldAddress.setText(s);
		                        } else if (count == 4) {
		                            textFieldCity.setText(s);
		                        } else if (count == 5) {
		                            textFieldState.setText(s);
		                        } else if (count == 6) {
		                            textFieldZipcodeJFormat.setText(s);
		                        } else if (count == 7) {
		                            DOBInput.setText(s);
		                        } else if (count == 8) {
		                            textFieldSex.setText(s);
		                        } else if (count == 9) {
		                            phoneInput.setText(s);
		                        } else if (count == 10) {
		                            textFieldEmail.setText(s);
		                        } else if (count == 11) {
		                            textFieldMajor.setText(s);
		                        } else if (count == 12) {
		                            textFieldGPA.setText(s);
		                        } else if (count == 13) {
		                            textFieldBalanceForm.setText(s);
		                        } else if (count == 14) {
		                            textFieldRace.setText(s);
		                        }
		                    }
		                } // Closes the reader try-with-resources
		            } catch (IOException e1) {
		                e1.printStackTrace();
		            }
		        } // Closes the else block
		    } // Closes actionPerformed
		}); // Closes addActionListener

		btnNewButton_3.setBounds(461, 10, 239, 20);
		contentPane.add(btnNewButton_3);

		JButton btnPrintTable = new JButton("Print Sorted Table");
		btnPrintTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					table.print();
				} catch (PrinterException e1) {
					e1.printStackTrace();
				}
			}
		});

		btnPrintTable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPrintTable.setBounds(315, 214, 198, 21);
		contentPane.add(btnPrintTable);

		////////////////////////////////////////////////////////////////////////////////////////////////////////////
		JButton btnReadMe = new JButton("README");
		btnReadMe.setForeground(new Color(255, 0, 0));
		btnReadMe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				allNames = "THE README FILE \n\n";
				File readMe = new File("README.txt");
				try (var reader = new BufferedReader(new FileReader(readMe))) {
					while ((s = reader.readLine()) != null) {
						allNames += s + "\n";
						textAreaDisplay.setText(allNames);
					}

				} catch (IOException excep) {

				}
			}

		});
		btnReadMe.setBounds(610, 150, 90, 21);
		contentPane.add(btnReadMe);
		
		JButton removeAllStudentsButt = new JButton("Remove All");
		
		
		removeAllStudentsButt.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        JOptionPane.showMessageDialog(null,
		                "All student records will be wiped.\nAfter clicking OK, please close and restart the application.");
		        
		        // 1. Safe cleaning of the object list
		        try {
		            returnedStudentArrayListSER = getListOfStudents();
		        } catch (ClassNotFoundException | IOException e1) {
		            e1.printStackTrace();
		        }
		        if (returnedStudentArrayListSER != null) {
		            returnedStudentArrayListSER.clear();
		            saveListOfStudentsFromMainFrame(returnedStudentArrayListSER);
		        }

		        // 2. Safe cleaning of the combobox list
		        try {
		            aListForComboSER = getLastNameListSER();
		        } catch (ClassNotFoundException | IOException e1) {
		            e1.printStackTrace();
		        }
		        if (aListForComboSER != null) {
		            aListForComboSER.clear();
		            try {
		                saveLastNameListSER(aListForComboSER);
		            } catch (IOException e1) {
		                e1.printStackTrace();
		            }
		        }

		        // 3. Physically delete the individual student text files to reset them completely
		        String[] filesToDelete = {"0StudentFile.txt", "1StudentFile.txt", "2StudentFile.txt", "3StudentFile.txt", "4StudentFile.txt"};
		        for (String fileName : filesToDelete) {
		            java.io.File file = new java.io.File(MainFrame.getSafeFilePath(fileName));
		            if (file.exists()) {
		                boolean deleted = file.delete();
		                if (deleted) {
		                    System.out.println(fileName + " successfully wiped from hard drive.");
		                }
		            }
		        }
		        
		        textFieldMessage.setText("System reset complete. Please restart.");
		    }
		});
		removeAllStudentsButt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		removeAllStudentsButt.setBounds(1101, 33, 136, 20);
		contentPane.add(removeAllStudentsButt);
		
		JButton removeStudentbutt = new JButton("Remove Student");
		removeStudentbutt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"These students never drop out or quit my classes, so it is \n"
						+ "pointless to try to remove them individually.\n"
						+ "If one quits they all quit in which case click 'Remove All'.");
			}
		});
		removeStudentbutt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		removeStudentbutt.setBounds(1101, 58, 136, 20);
		contentPane.add(removeStudentbutt);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{textFieldID, textFieldLastName, textFieldFirstName, textFieldAddress, textFieldCity, textFieldState, textFieldZipcodeJFormat, textFieldSex, phoneInput, textFieldEmail, DOBInput, textFieldMajor, textFieldGPA, textFieldBalanceForm, textFieldRace, textAreaDisplay, scrollPaneTextArea, contentPane, labelLastName, labelID, comboBoxSearchName, btnGetComboLastName, btnClear, btnUpdate, lblDOB, lblFirstName, lblAddress, lblCity, lblState, lblZip, lblPhone, lblEmail, lblMajor, lblGPA, lblBalance, separator, lblUpdated, textFieldUpdated, btnAddStudent2, textFieldIndex, lblNewLabel, lblRequired, textFieldMessage, comboBoxSortOrder, btnSortBy, lblNewLabel_1, textFieldEnrolled, lblNewLabel_2, lblNewLabel_3, btnNewButton, btnPrint, btnClearPrintPreview, btnNewButton_1, scrollPane, table, btnNewButton_3, btnPrintTable, btnReadMe, removeAllStudentsButt, removeStudentbutt}));

	} // End of constructor

	@SuppressWarnings("unchecked")
	List<Student> getListOfStudents() throws IOException, ClassNotFoundException {
	    // Looks for the full student objects inside the safe user folder
	    try (var in = new ObjectInputStream(
	            new BufferedInputStream(new FileInputStream(MainFrame.getSafeFilePath("returnedStudentArrayListSER"))))) {
	        var listObject = in.readObject();
	        if (listObject instanceof List)
	            returnedStudentArrayListSER = (ArrayList<Student>) listObject;
	        return returnedStudentArrayListSER;
	    } catch (IOException e) {
	        // Suppresses the error if the file doesn't exist yet on first launch
	    }
	    return returnedStudentArrayListSER;
	}

	void saveListOfStudentsFromMainFrame(List<Student> returnedStudentArrayListSER) {
	    // Routes the serialized student array list to our safe hidden folder
	    try (var out = new ObjectOutputStream(
	            new BufferedOutputStream(new FileOutputStream(MainFrame.getSafeFilePath("returnedStudentArrayListSER"))))) {
	        out.writeObject(returnedStudentArrayListSER);
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	} 

	void assignLastName(String assignedLastName) {
		this.assignedLastName = assignedLastName;
	}

	public static String getInputString() {
		return inputOfLastName;
	}

	void saveLastNameListSER(List<String> aListForComboSER) throws IOException {
	    // Routes the search combobox name list to our safe hidden folder
	    try (var out = new ObjectOutputStream(
	            new BufferedOutputStream(new FileOutputStream(MainFrame.getSafeFilePath("aListForComboSER"))))) {
	        out.writeObject(aListForComboSER);
	    }
	}

	List<String> getLastNameListSER() throws IOException, ClassNotFoundException {
	    // Looks for the combo box list inside the safe user folder
	    try (var in = new ObjectInputStream(
	            new BufferedInputStream(new FileInputStream(MainFrame.getSafeFilePath("aListForComboSER"))))) {
	        var listObject = in.readObject();
	        if (listObject instanceof List)
	            aListForComboSER = (ArrayList<String>) listObject; 
	        return aListForComboSER;
	    } catch (IOException e) {
	        // Suppresses the error if the file doesn't exist yet on first launch
	    }
	    return aListForComboSER;
	}
	
	// Central helper to get safe, writable file paths outside of the JAR
	public static String getSafeFilePath(String fileName) {
		
	    String userHome = System.getProperty("user.home");
	    java.io.File directory = new java.io.File(userHome, "studentapp_data");
	    if (!directory.exists()) {
	        directory.mkdirs(); // Automatically creates the folder if missing
	    }
	 // ADD THIS PRINT LINE TEMPORARILY:
	   // System.out.println("CRITICAL PATH CHECK: " + directory.getAbsolutePath());
	    return new java.io.File(directory, fileName).getAbsolutePath();
	}
} // End of MainFrame class
