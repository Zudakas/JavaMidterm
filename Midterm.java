import java.util.Scanner;
import java.util.ArrayList;

public class Midterm {
	
    public static void main(String[] args) {
		boolean appQuit = false;
		int listSize;
        ArrayList<Patient> patientList = new ArrayList<Patient>();
		
		while(appQuit == false){
			
		appQuit = showMenu(appQuit, patientList);
        
		}
	}
	public static boolean showMenu(boolean aQ, ArrayList<Patient> patientList){
		int menuItem;
		Scanner input = new Scanner(System.in);
		System.out.println("Please select an option: ");
		System.out.println("1. Add a Patient/Incident");
		System.out.println("2. View current patients");
		System.out.println("3. Search by Term");
		System.out.println("4. Quit Program");
		menuItem = input.nextInt();
		
		switch(menuItem){
			case 1:
				patientList.add(newPatient(patientList.size()));
				break;
			case 2:
				showPatients(patientList);
				break;
			case 3:
				searchByTerm(patientList);
				break;
			case 4:
				aQ = true;
				break;
			default: 
				break;
		}
		return aQ;
	}
	public static void showPatients(ArrayList<Patient> list){
		System.out.println();
		System.out.println("Current Patients\n______________________________________");
		for(Patient p : list){
			System.out.println("Patient ID: " + p.getPatientID());
			System.out.println("Patient Name: " + p.getLName() + ", " + p.getFName());
			System.out.println("Patient Age: " + p.getAge());
			System.out.println("Patient Address: " + p.getAddress());
			System.out.println();
			System.out.println("Injury information: ");
			System.out.println("Location: " + p.getInjuryLocation());
			System.out.println("Type: \t " + p.getInjuryType());
			System.out.println("Severity: " + p.getInjurySeverity());
			System.out.println();
			System.out.println("_____________________________________");
		}
	}	/*
	public static void searchByID(ArrayList<Patient> pList){
        ArrayList<Patient> searchList = new ArrayList<Patient>();
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please enter a 5 digit ID: ");
		int ID = input.nextInt();
		for (Patient p : pList){
			if(p.getPatientID() == ID){
				searchList.add(p);
			}	
		}
		showPatients(searchList);
	} */
	public static void searchByTerm(ArrayList<Patient> pList){
        ArrayList<Patient> searchList = new ArrayList<Patient>();
		Scanner input = new Scanner(System.in);
		
		System.out.print("Please enter a search term: ");
		String term = input.nextLine();
		for (Patient p : pList){
			if((term.equals(p.getLName())) || (term.equals(p.getFName())) || (term.equals(p.getAddress())) || 
				(term.equals(Integer.toString(p.getInjurySeverity()))) || (term.equals(p.getInjuryLocation())) 
				|| (term.equals(p.getInjuryType())) || (term.equals(Integer.toString(p.getAgeGroup()))) || 
				(term.equals(Integer.toString(p.getPatientID()))) || (term.equals(Integer.toString(p.getAge())))){
				searchList.add(p);
			}	
		}
		showPatients(searchList);
	}
	public static int checkAgeGroup(int num){
		int returnValue = 0;
		if((num >= 1) && (num <= 5)) {
			returnValue = 1;
		}else if ((num >= 6) && (num <= 10)) {
			returnValue = 2;
		}else if ((num >= 11) && (num <= 15)) {
			returnValue = 3;
		}else if ((num >= 16) && (num <= 20)) {
			returnValue = 4;
		}else if ((num >= 21) && (num <= 50)) {
			returnValue = 5;
		}else if (num >= 51) {
			returnValue = 6;
		}
		return returnValue;
	}
	public static Patient newPatient(int listSize){
		//This class creates a new Patient.
	
		int injuryType, injuryLoc;
		int injurySev;
		Scanner input = new Scanner(System.in);
		
		Patient p = new Patient();
		System.out.println("Patient last name: ");
		p.setLName(input.nextLine());
		System.out.println("Patient first name: ");
		p.setFName(input.nextLine());
		System.out.println("Patient ID is: " + (listSize+10000));
		p.setPatientID(listSize+10000);
		System.out.println("Patient address: ");
		p.setAddress(input.nextLine());
		System.out.println("Patient's Age: ");
		p.setAge(input.nextInt());
		p.setAgeGroup(checkAgeGroup(p.getAge()));
		System.out.println("Please select from the following injury types: ");
		System.out.println("1. Break \n 2. Sprain/Strain \n 3. Burn \n 4. Soft Tissue Slash \n 5. Soft Tissue Blunt");
		
		
		injuryType = input.nextInt();
		switch (injuryType) {
			case 1: 
				p.setInjuryType("Break");
				break;
			case 2:
				p.setInjuryType("Sprain/Strain");
				break;
			case 3:
				p.setInjuryType("Burn");
				break;
			case 4:
				p.setInjuryType("Soft Tissue Slash");
				break;
			case 5:
				p.setInjuryType("Soft Tissue Blunt");
				break;
			default: 
				System.out.println("Please select 1 - 5: ");
		}

			
			boolean isset = false;
			while (isset == false){
				System.out.println("Injury Severity (1 - 10)");
				injurySev = input.nextInt();
				if((injurySev <= 10) && (injurySev >= 1)){
					p.setInjurySeverity(injurySev);
					isset = true;
				}else {
					System.out.println("Please specify injury severity between 1 and 10: ");
					isset = false;
				}
			}
		System.out.println("Please select the location of the injury (1-4): ");
		System.out.println("1. Head \t 2. Abdomen \t 3. Arms \t 4. Legs");
		injuryLoc = input.nextInt();
		switch (injuryLoc){
			case 1:
				p.setInjuryLocation("Head");
				break;
			case 2: 
				p.setInjuryLocation("Abdomen");
				break;
			case 3:
				p.setInjuryLocation("Arms");
				break;
			case 4:
				p.setInjuryLocation("Legs");
				break;
			default:
				System.out.println("Please select a location (1-4): ");
		}
		
		return p;
	}
}