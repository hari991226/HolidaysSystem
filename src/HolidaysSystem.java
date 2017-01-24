import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;
public class HolidaysSystem {

	public static void main(String[] args) {
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
  public static void menu(int option) {
	  switch (option){
	  	case 1:
	  		firstOption ();
		  break;
	  	case 2:
	  		
	  		break;
	  	case 3:
	  		System.out.println();
	  		break;
	  default:
			System.out.println("There isn't an option like this");
			break;
	  }
}
  public static void firstOption (){
	  nameEntering();
	  emailEntering();
	  PINentering ();
	  vacantionStart ();
	  vacantionEnd ();
	  vacantionType ();
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
  public static void vacantionType (){
	  Scanner scanner = new Scanner(System.in);
	  String vacantionType = null;
	  do {
	  System.out.println("Please enter tha type of your vacantion.");
	  vacantionType = scanner.nextLine();
	  savingInformationIntoTextFile(vacantionType);
	  }while (! checkIfVacantionTypeMethodIsCorrectlyEntered(vacantionType));
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
  public static boolean checkIfNameEnteringMethodContainsOnlyLetters (String enteredLetters) {
	    	if(! Pattern.matches(".*[a-zA-Z]+.*", enteredLetters)) {
	    		System.out.println("Please, insert a correct name!");
	    		return false;
	    }else {
	    	return true ;
	    }
  }
  public static boolean checkIfVacantionTypeMethodIsCorrectlyEntered (String enteredLetters) {
  	if(! Pattern.matches("paid", enteredLetters) && ! Pattern.matches("not paid", enteredLetters)) {
  		System.out.println("Please, insert a correct vacantion type!");
  		return false;
  	}else {
  		return true ;
  	}	  	
  }
  public static boolean checkIfPINEnteringMethodContainsOnlyDigits (String enteredDigits) {
	  	if(! Pattern.matches("[0-9]{10}", enteredDigits )) {
	  		System.out.println("Please, insert a correct PIN!");
	  		return false;
	  	}else {
	  		return true ;
	  	}
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
  public static boolean checkIfDataIsCorrect (String enteredDigits){
	  if(! Pattern.matches("([0-9]{2}).([0-9]{2}).([0-9]{4})", enteredDigits)){
		  System.out.println("Please, eneter a correct date!");
		  return false;
	  }else {
		  return true;
		  
	  }
  }
}
