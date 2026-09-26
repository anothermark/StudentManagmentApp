import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SaveRecordToTextFile {

	void saveToText0(String dataForTextFile0) {
		// We wrap the file name inside MainFrame.getSafeFilePath()
		try (var writer0 = new BufferedWriter(new FileWriter(MainFrame.getSafeFilePath("0StudentFile.txt")))) {
			writer0.write(dataForTextFile0);
			writer0.newLine();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	void saveToText1(String dataForTextFile1) {
		// Doing the exact same thing for student 1
		try (var writer1 = new BufferedWriter(new FileWriter(MainFrame.getSafeFilePath("1StudentFile.txt")))) {
			writer1.write(dataForTextFile1);
			writer1.newLine();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	void saveToText2(String dataForTextFile2) {
		// Doing the exact same thing for student 2
		try (var writer2 = new BufferedWriter(new FileWriter(MainFrame.getSafeFilePath("2StudentFile.txt")))) {
			writer2.write(dataForTextFile2);
			writer2.newLine();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}