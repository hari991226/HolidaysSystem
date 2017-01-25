import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

import javax.sound.sampled.Line;
public class HolidaysSystem {

	public static void main(String[] args) throws IOException {
		showMenu();
		int chooseOption = scannerForChoosingOption();
		menu(chooseOption);
	}
	public static void showMenu (){
		System.out.println("-----------------------");
		System.out.println("1. Declare a vacantion");
		System.out.println("2. See all the vacations");
		System.out.println("3. See vacantion of an employee ");
		System.out.println("4. Change holiday's status");
		System.out.println("5. Exit");
		System.out.println("-----------------------");
	}
	public static int scannerForChoosingOption() {
		  Scanner scanner = new Scanner(System.in);
		  System.out.println("Please choose an option:");
		  int option = scanner.nextInt();
		  return option;
	}
  public static void menu(int option) throws IOException {
	  switch (option){
	  	case 1:
	  		firstOption ();
		  break;
	  	case 2:
	  		secondOption();
	  		break;
	  	case 3:
	  		System.out.println();
	  		break;
	  	default:
	  	  System.out.println("There isn't an option like this"); 
	  	 int optionAfterDefault = scannerForChoosingOption();
	  	 menu(optionAfterDefault);
	  }	
}
  public static void firstOption () throws IOException{
	  nameEntering();
	  emailEntering();
	  PINentering ();
	  vacantionStart ();
	  vacantionEnd ();
	  vacantionType ();
	  afterChoosingFirstOption();
  }
  public static void secondOption() throws IOException{
	  int numberOfLines = countLinesInFile();
		String[] readInformationFromFile = readingFromATextFile(numberOfLines);
		showInformationInATableFormat(numberOfLines, readInformationFromFile);
  }
  public static void nameEntering (){
	  Scanner scanner = new Scanner(System.in);
	  String fullName = null;
	  do {
	  System.out.println("PLease enter your full name.");
	  fullName = scanner.nextLine();
	  savingInformationIntoTextFile(fullName);
	  }while (!  checkIfNameEnteringMethodContainsOnlyLetters(fullName));
  }
	  public static boolean checkIfNameEnteringMethodContainsOnlyLetters (String enteredLetters) {
	    	if(! Pattern.matches(".*[a-zA-Z]+.*", enteredLetters)) {
	    		System.out.println("Please, insert a correct name!");
	    		return false;
	    }else {
	    	return true ;
	    }  
  }
  public static void emailEntering (){
	  Scanner scanner = new Scanner(System.in);
	  String email = null;
	  do {
	  System.out.println("Please enter your email.");
	  email = scanner.nextLine();
	  savingInformationIntoTextFile(email);
	  }
	  while (!checkIfEmailEnteringMethodContainsAtAndCorrectPlatform(email));
  }	  
	  public static boolean checkIfEmailEnteringMethodContainsAtAndCorrectPlatform (String enteredAt) {
		  //Checking if in Email Entering Method there is @ and a correct platform
		  	if(! Pattern.matches(".*[@gmail.com]+.*.*[@abv.bg]+.*.*[@yahoo.com]+.*.*[mail.com]+.*", enteredAt )) {
		  		System.out.println("Please, insert a correct email!");
		  		return false;
		  	}else {
		  		return true ;
		  	}
  }
  public static void PINentering (){
	  Scanner scanner = new Scanner(System.in);
	  String PIN = null;
	  do {
	  System.out.println("Please enter your PIN.");
	  PIN = scanner.nextLine();
	  savingInformationIntoTextFile(PIN);
	  }
	  while (!checkIfPINEnteringMethodContainsOnlyDigits(PIN));
  }
	  public static boolean checkIfPINEnteringMethodContainsOnlyDigits (String enteredDigits) {
		  	if(! Pattern.matches("[0-9]{10}", enteredDigits )) {
		  		System.out.println("Please, insert a correct PIN!");
		  		return false;
		  	}else {
		  		return true ;
		  	}
  }
  public static void vacantionStart (){
	  Scanner scanner = new Scanner(System.in);
	  String vacantionStart = null;
	  do {
	  System.out.println("Please enter the date from which you want your vacantion to start.");
	  vacantionStart = scanner.nextLine();
	  savingInformationIntoTextFile(vacantionStart);
	  }
	  while (!checkIfDataIsCorrect(vacantionStart));
  }
  public static void vacantionEnd (){
	  Scanner scanner = new Scanner(System.in);
	  String vacantionEnd = null;
	  do {
	  System.out.println("Please enter the date when you want your vacantion to end.");
	  vacantionEnd = scanner.nextLine();
	  savingInformationIntoTextFile(vacantionEnd);
	  }
	  while (!checkIfDataIsCorrect(vacantionEnd));
  }
	  public static boolean checkIfDataIsCorrect (String enteredDigits){
		  if(! Pattern.matches("([0-9]{2}).([0-9]{2}).([0-9]{4})", enteredDigits)){
			  System.out.println("Please, eneter a correct date!");
			  return false;
		  }else {
			  return true;
			  
		  }
  }
  public static void vacantionType (){
	  Scanner scanner = new Scanner(System.in);
	  String vacantionType = null;
	  do {
	  System.out.println("Please enter tha type of your vacantion.");
	  vacantionType = scanner.nextLine();
	  savingInformationIntoTextFile(vacantionType);
	  }while (! checkIfVacantionTypeMethodIsCorrectlyEntered(vacantionType));
	  
  }
  public static boolean checkIfVacantionTypeMethodIsCorrectlyEntered (String enteredLetters) {
  	if(! Pattern.matches("paid", enteredLetters) && ! Pattern.matches("not paid", enteredLetters)) {
  		System.out.println("Please, insert a correct vacantion type!");
  		return false;
  	}else {
  		return true ;
  	}	  	
  } 
  public static void afterChoosingFirstOption() throws IOException{
	  System.out.println("You successfully declared a vacantion. You can choose another option!");
	  showMenu ();
	  int chooseOption = scannerForChoosingOption();
		menu(chooseOption);
  }
  public static void savingInformationIntoTextFile (String informationFromScanner){
	  FileWriter infoSaving;
	  try {
          infoSaving = new FileWriter("usersInformationFile.txt", true);         
          infoSaving.write(informationFromScanner);
          infoSaving.write("\r\n");
          infoSaving.close();

      } catch (IOException iox) {
          iox.printStackTrace();
      }
  }
  private static void showInformationInATableFormat(int numberOfLines, String[] informationInFile) {
		System.out.printf("%5s%30s%30s%50s%45s%40s", "Name", "Email", "PIN", "Vacantion start",
				"Vacantion end", "Vacantion type");
		System.out.println();
		for (int i = 0; i < numberOfLines; i += 6) {
			String name = informationInFile[i];
			String email = informationInFile[i + 1];
			String egn = informationInFile[i + 2];
			String vacantionStart = informationInFile[i + 3];
			String vacantionEnd = informationInFile[i + 4];
			String vacantionType = informationInFile[i + 5];
			System.out.format("%1s%35s%27s%37s%47s%43s", name, email, egn, vacantionStart,
					vacantionEnd, vacantionType);
			System.out.println();
		}
  }
  public static String[] readingFromATextFile (int linesInFile) throws FileNotFoundException {
	  BufferedReader readingFromTextFile = new BufferedReader(new FileReader("usersInformationFile.txt"));
	  String[] readInformationFromFile = new String [linesInFile];
	  try {
		for (int i=0; i < linesInFile; i++){
			readInformationFromFile[i] = readingFromTextFile.readLine();
		}
	  } catch (IOException e) {

			e.printStackTrace();
	  }
	  return readInformationFromFile;
  }
  private static int countLinesInFile() throws IOException {
		BufferedReader line = new BufferedReader(new FileReader("usersInformationFile.txt"));
		String singleLine;
		int numberOfLines = 0;
		try {
			while ((singleLine = line.readLine()) != null) {
				numberOfLines++;
			}
		} catch (IOException e) {

			e.printStackTrace();
		}
		line.close();
		return numberOfLines;
  }
}
  
