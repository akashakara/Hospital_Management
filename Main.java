import java.util.Scanner;

public class Main {

	public static LinkedList doctorList = new LinkedList();
	public static LinkedList patientList = new LinkedList();

    public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		String USERNAME = "akash";
		String PASSWORD = "admin";


		while (true) {
			System.out.print("\033[H\033[2J");
			System.out.flush();

			System.out.println("\t JAva Hospital ===>");
			System.out.println("\t---------------------");
			System.out.println("\t\t1. Special access");
			System.out.println("\t\t2. Patient access");
			System.out.println("\t\t3. Exit");
			System.out.print("\tChoose one: ");
			int key = input.nextInt();
	
			if (key == 1) {
				System.out.print("\033[H\033[2J");
				System.out.flush();
				System.out.println("\t--------------");
				System.out.print("\tUsername: ");
				String username = input.next();
				System.out.print("\tPassword: ");
				String password = input.next();

				if (username.equals(USERNAME) && password.equals(PASSWORD)) {
					System.out.print("\033[H\033[2J");
					System.out.flush();
					System.out.println("\t-----------------------");
					System.out.println("\tWelcome to Special part");
					specialAccess(username);
				}else {
					System.out.println("\t------------------------------");
					System.out.println("\tUsername or Password is wrong!");
					System.out.print("\t(b) for back: ");
					String pause1 = input.next();
				}
			}
	
			else if (key == 2) {
					System.out.print("\033[H\033[2J");
					System.out.flush();
					System.out.println("\t-----------------------");
					System.out.println("\tWelcome to Patient part");
					System.out.print("\tPlease, Enter your name: ");
					input.nextLine();
					String name = input.nextLine();
					patientAccess(name);
			}
			// exit
			else if (key == 3) {
				System.out.print("\033[H\033[2J");
				System.out.flush();
				System.out.println("Have nice time");
				System.exit(0);
			}
		}
    }

	private static void patientAccess(String name) {
		Scanner input = new Scanner(System.in);
		System.out.print("\033[H\033[2J");
		System.out.flush();
		System.out.println("\t-----------------------");
		System.out.printf("\tpatient name: %s\n", name);

		while (true){
			System.out.print("\033[H\033[2J");
			System.out.flush();

			System.out.println("\tPatient Access ===>");
			System.out.println("\t---------------------");
			System.out.println("\t\t1. Show Doctor List");
			System.out.println("\t\t2. Get ticket");
			System.out.println("\t\t3. Delete ticket");
			System.out.println("\t\t4. Show my ticket");
			System.out.println("\t\t5. back");
			System.out.print("\tChoose one: ");
			int key = input.nextInt();

			System.out.print("\033[H\033[2J");
			System.out.flush();

			if (key == 1){
				System.out.println("\tDoctor's List ===>");
				System.out.println("\t---------------------\n");
				doctorList.printList();
			}else if (key == 2){
				System.out.println("\tGet ticket ===>");
				System.out.println("\t---------------------\n");
				System.out.print("Enter Doctor name: ");
				input.nextLine();
				String docName = input.nextLine();
				System.out.print("Enter Doctor special: ");
				String docSpecial = input.next();
				if (!patientList.isExist(name, docName) && doctorList.isExist(docName, docSpecial)) {
					patientList.addEnd(name, docName);
					System.out.printf("Ticket saved for Dr.%s by %s!\n", docName, name);
				}else if (!doctorList.isExist(docName, docSpecial)){
					System.out.println("There is NOT Doctor with this data!");
				} else {
					System.out.println("There is Same ticket with this Data!");
				}
			}else if (key == 3){
				System.out.println("\tDelete ticket ===>");
				System.out.println("\t---------------------\n");
				System.out.print("Enter Doctor name: ");
				input.nextLine();
				String docName = input.nextLine();
				System.out.print("Enter Doctor special: ");
				String docSpecial = input.next();
				if (!patientList.isExist(name, docName)) {
					System.out.println("There is NOT any ticket with this data!");
				} else {
					patientList.deleteByData(name, docName);
					System.out.printf("ticket %s deleted!\n",docName);
				}
			}else if (key == 4){
				System.out.println("\tMy tickets ===>");
				System.out.println("\t---------------------\n");
				patientList.printList(name);
			}else if (key == 5){
				break;
			}
		}
	}

	private static void specialAccess(String username) {
		Scanner input = new Scanner(System.in);
		System.out.print("\033[H\033[2J");
		System.out.flush();
		System.out.println("\t-----------------------");
		System.out.printf("\tEnter as %s\n\n", username);

		while (true){
			System.out.print("\033[H\033[2J");
			System.out.flush();

			System.out.println("\tSpecial Access ===>");
			System.out.println("\t---------------------");
			System.out.println("\t\t1. Show Doctor List");
			System.out.println("\t\t2. Add Doctor");
			System.out.println("\t\t3. Edit Doctor Data");
			System.out.println("\t\t4. Search for Doctor");
			System.out.println("\t\t5. Delete Doctor");
			System.out.println("\t\t6. Show all tickets");
			System.out.println("\t\t7. Back");
			System.out.print("\tChoose one: ");
			int key = input.nextInt();

			System.out.print("\033[H\033[2J");
			System.out.flush();

			if (key == 1){
				System.out.println("\tDoctor's List ===>");
				System.out.println("\t---------------------\n");
				doctorList.printList();
			}else if (key == 2){
				System.out.println("\tAdd Doctor ===>");
				System.out.println("\t---------------------\n");
				System.out.print("Enter Doctor name: ");
				input.nextLine();
				String docName = input.nextLine();
				System.out.print("Enter Doctor special: ");
				String docSpecial = input.next();
				if (!doctorList.isExist(docName, docSpecial)) {
					doctorList.addEnd(docName, docSpecial);
					System.out.println("Doctor Saved!");
				}else {
					System.out.println("There is Same Doctor with this Data!");
				}
			}else if (key == 3){
				System.out.println("\tEdit Doctor ===>");
				System.out.println("\t---------------------\n");
				System.out.print("Enter Doctor name: ");
				input.nextLine();
				String docName = input.nextLine();
				System.out.print("Enter Doctor special: ");
				String docSpecial = input.next();
				if (!doctorList.isExist(docName, docSpecial)) {
					System.out.println("There is NOT Doctor with this Data!");
				}else {
					System.out.print("Enter Doctor's new name: ");
					input.nextLine();
					String newDocName = input.nextLine();
					System.out.print("Enter Doctor's new special: ");
					String newDocSpecial = input.next();
					doctorList.edit(docName, docSpecial, newDocName, newDocSpecial);
					System.out.printf("Doctor %s edited!\n",docName);
				}
			}else if (key == 4){
				System.out.println("\tSearch Doctor ===>");
				System.out.println("\t---------------------\n");
				System.out.print("Enter Doctor data: ");
				String doc = input.next();
				doctorList.search(doc);
			}else if (key == 5){
				System.out.println("\tDelete Doctor ===>");
				System.out.println("\t---------------------\n");
				System.out.print("Enter Doctor name: ");
				input.nextLine();
				String docName = input.nextLine();
				System.out.print("Enter Doctor special: ");
				String docSpecial = input.next();
				if (!doctorList.isExist(docName, docSpecial)) {
					System.out.println("There is NOT Doctor with this Data!");
				}else {
					doctorList.deleteByData(docName, docSpecial);
					System.out.printf("Doctor %s deleted!\n",docName);
				}
			}else if (key == 6){
				System.out.println("\tShow tickets ===>");
				System.out.println("\t---------------------\n");
				patientList.printList();
			}else if (key == 7){
				break;
			}
		}
	}
}

class LinkedList {

	public static class Pattern{
		String firstData;
		String secondData;
		Pattern link;
	}

	Pattern head = new Pattern();
	Pattern member;

	public boolean isExist(String data1, String data2){
		member = head;
		if (head.firstData == null){
			return false;

		}else {
			while (member.link != null){
				if (member.firstData.equals(data1) && member.secondData.equals(data2)){
					return true;
				}
				member = member.link;
			}
			return member.firstData.equals(data1) && member.secondData.equals(data2);
		}
	}

	public void addFront(String data1, String data2){
		Pattern newMember = new Pattern();

		member = head;
		if (head.firstData == null){
			head.firstData = data1;
			head.secondData = data2;

		}else {
			newMember.firstData = data1;
			newMember.secondData = data2;
			newMember.link = head;
			head = newMember;
		}
	}

	public void addEnd(String data1, String data2){
		Pattern newMember = new Pattern();

		member = head;
		if (head.firstData == null){
			head.firstData = data1;
			head.secondData = data2;

		}else {
			while (member.link != null){
				member = member.link;
			}
			member.link = newMember;
			newMember.firstData = data1;
			newMember.secondData = data2;
		}
	}

	public void edit(String data1, String data2, String newData1, String newData2){
		member = head;
		if (head.firstData == null) {
			System.out.println("List is empty!");
			return;
		}

		while (member.link != null){
			if (member.firstData.equals(data1) && member.secondData.equals(data2)){
				member.firstData = newData1;
				member.secondData = newData2;
			}
			member = member.link;
		}
		if (member.firstData.equals(data1) && member.secondData.equals(data2)){
			member.firstData = newData1;
			member.secondData = newData2;
		}
	}

	public void search(String data1){
		boolean flag = false;
		int counter = 0;
		member = head;
		if (head.firstData == null){
			System.out.println("List is empty!");

		}else {
			while (member.link != null){
				if (member.firstData.contains(data1) || member.secondData.contains(data1)){
					counter++;
					System.out.println("\t" + counter + ". " + member.firstData + " (" + member.secondData + ")");
					flag = true;
				}

				member = member.link;
			}
			counter++;
			if (member.firstData.contains(data1) || member.secondData.contains(data1)){
				System.out.println("\t" + counter + ". " + member.firstData + " (" + member.secondData + ")");
				flag = true;
			}

			if (!flag){
				System.out.println("Not found!");
			}
		}
	}

	public void deleteByData(String data1, String data2){
		Pattern newMember = new Pattern();

		member = head;
		if (head.firstData == null) {
			System.out.println("List is empty!");
			return;
		}

		while (member.link != null){
			if (member.firstData.equals(data1) && member.secondData.equals(data2)){
				if (member == head){
					head = head.link;
				}else {
					member = member.link;
					newMember.link = member;
				}
				break;
			}
			newMember = member;
			member = member.link;
		}
		if (member.firstData.equals(data1) && member.secondData.equals(data2)){
			member.firstData = null;
			member.secondData = null;
			newMember.link = null;
		}

	}

	public void printList(){
		int counter = 0;
		member = head;

		if (head.firstData == null) {
			System.out.println("\tList is Empty!");
			return;
		}

		while (member.link != null){
			counter++;
			System.out.println("\t" + counter + ". " + member.firstData + " (" + member.secondData + ")");
			member = member.link;
		}
		counter++;
		System.out.println("\t" + counter + ". " + member.firstData + " (" + member.secondData + ")");

	}

	public void printList(String data){
		int counter = 0;
		member = head;

		if (head.firstData == null) {
			System.out.println("\tList is Empty!");
			return;
		}

		while (member.link != null){
			if (member.firstData.equals(data)) {
				counter++;
				System.out.println("\t" + counter + ". " + member.firstData + " (" + member.secondData + ")");
				member = member.link;
			}
			member = member.link;
		}
		if (member.firstData.equals(data)) {
			counter++;
			System.out.println("\t" + counter + ". " + member.firstData + " (" + member.secondData + ")");
		}

	}
}