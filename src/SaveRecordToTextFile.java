import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SaveRecordToTextFile {

void saveToText0(String dataForTextFile0) {
	try(var writer0 = new BufferedWriter(new FileWriter("0StudentFile.txt"))) { 
		writer0.write(dataForTextFile0);
		writer0.newLine();
	} catch (IOException ex) {		
		ex.printStackTrace();
	}
}

void saveToText1(String dataForTextFile1) {
	try(var writer1 = new BufferedWriter(new FileWriter("1StudentFile.txt"))) { 
		writer1.write(dataForTextFile1);
		writer1.newLine();
	} catch (IOException ex) {		
		ex.printStackTrace();
	}
}

void saveToText2(String dataForTextFile2) {
	try(var writer2 = new BufferedWriter(new FileWriter("2StudentFile.txt"))) { 
		writer2.write(dataForTextFile2);
		writer2.newLine();
	} catch (IOException ex) {		
		ex.printStackTrace();
	}
}

void saveToText3(String dataForTextFile3) {
	try(var writer3 = new BufferedWriter(new FileWriter("3StudentFile.txt"))) { 
		writer3.write(dataForTextFile3);
		writer3.newLine();
	} catch (IOException ex) {		
		ex.printStackTrace();
	}
}

void saveToText4(String dataForTextFile4) {
	try(var writer4 = new BufferedWriter(new FileWriter("4StudentFile.txt"))) { 
		writer4.write(dataForTextFile4);
		writer4.newLine();
	} catch (IOException ex) {
		ex.printStackTrace();
	}
}


	
	
	
	
}
