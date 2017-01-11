import java.util.Scanner;

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
	  		emailEntering ();
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
	  System.out.println("PLease enter your full name");
	  String fullName = scanner.next();
  }
  public static void emailEntering (){
	  Scanner scanner = new Scanner(System.in);
	  System.out.println("Please enter your email");
	  String email = scanner.next();
  }
  public static void PINentering (){
	  Scanner scanner = new Scanner(System.in);
	  System.out.println("Please enter your PIN");
	  int PIN = scanner.nextInt();
  }
  public static void vacantionStart (){
	  Scanner scanner = new Scanner(System.in);
	  System.out.println("Please enter the date from which you want your vacantion to start");
	  String vacantionStart = scanner.next();
  }
  public static void vacantionEnd (){
	  Scanner scanner = new Scanner(System.in);
	  System.out.println("Please enter the date when you want your vacantion to end");
	  String vacantionEnd = scanner.next();
  }
  public static void vacantionType (){
	  Scanner scanner = new Scanner(System.in);
	  System.out.println("Please enter tha type of your vacantion");
	  String vacantionType = scanner.next();
  }
}
