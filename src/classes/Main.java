package classes;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map.Entry;

import enums.Days;

public class Main {

	public static void main(String[] args) throws IOException {
		boolean swch = true;
		Cinema cinema = new Cinema(0, 0, 0, 0, 0);
		PrintWriter pw1 = new PrintWriter("Cinemanames.txt");
		System.out.println("------------------- CINEMA ------------------------");
		System.out.println("");
		do {
			System.out.println("---------------------------------------------------");
			System.out.println("                     Menu:");
			System.out.println("---------------------------------------------------");
			System.out.println(" 1) Create new Cinema:");
			System.out.println(" 2) Change Cinema worck time:");
			System.out.println(" 3) Open cinema by the name of the file:");
			System.out.println(" 4) Add seance:");
			System.out.println(" 5) Remove seance:");
			System.out.println(" 6) Remove all film seances:");
			System.out.println(" 7) Seanses control( remove all inappropriate seances ):");
			System.out.println(" 8) Display cinema data on screen:");
			System.out.println(" 9) Save cinema to the file:");
			System.out.println(" 0) Exit:");

			boolean swch1;
			int choice;
			do {
				swch1 = false;
				System.out.println(" Select a number pleace!");
				choice = MyScanner.scanerInt();
				if (choice < 0 || choice > 9) {
					System.out.println("---------------------------------------------------");
					System.out.println(" The choice should be between 1) and 9) or 0) ! ");
					System.out.println("---------------------------------------------------");
					swch1 = true;
				}
			} while (swch1);
			switch (choice) {
			case 1:
				System.out.println(" Create new Cinema:");
				System.out.println("---------------------------------------------------");
				System.out.println("Enter worck time, and fault time:");
				System.out.println("---------------------------------------------------");
				System.out.println("Enter open HH:");
				int openHH = MyScanner.scanerInt();
				System.out.println("---------------------------------------------------");
				System.out.println("Enter open MM:");
				int openMM = MyScanner.scanerInt();
				System.out.println("---------------------------------------------------");
				System.out.println("Enter close HH:");
				int closeHH = MyScanner.scanerInt();
				System.out.println("---------------------------------------------------");
				System.out.println("Enter close MM:");
				int closeMM = MyScanner.scanerInt();
				System.out.println("---------------------------------------------------");
				System.out.println("Enter fault MM");
				int faultMM = MyScanner.scanerInt();
				System.out.println("---------------------------------------------------");
				cinema = new Cinema(openHH, openMM, closeHH, closeMM, faultMM);
				System.out.println(" New Cinema created!");
				break;
			case 2:
				System.out.println("Enter worck time, and fault time:");
				System.out.println("---------------------------------------------------");
				System.out.println("Enter open HH:");
				openHH = MyScanner.scanerInt();
				System.out.println("---------------------------------------------------");
				System.out.println("Enter open MM:");
				openMM = MyScanner.scanerInt();
				System.out.println("---------------------------------------------------");
				System.out.println("Enter close HH:");
				closeHH = MyScanner.scanerInt();
				System.out.println("---------------------------------------------------");
				System.out.println("Enter close MM:");
				closeMM = MyScanner.scanerInt();
				System.out.println("---------------------------------------------------");
				System.out.println("Enter fault MM");
				faultMM = MyScanner.scanerInt();
				System.out.println("---------------------------------------------------");
				cinema.setOpenTime(openHH, openMM);
				cinema.setCloseTime(closeHH, closeMM);
				cinema.setFaultTime(faultMM);
				for (Entry<Days, Schedule> day : cinema.getCinemaSet()) {
					day.getValue().setCloseTime(cinema.getCloseTime());
					day.getValue().setOpenTime(cinema.getOpenTime());
					day.getValue().setFaultTime(cinema.getFaultTime());
				}
				System.out.println(" Cinema worck time canged ");
				break;
			case 3:
				System.out.println("Open cinema by the name of the file:");
				System.out.println("---------------------------------------------------");
				System.out.println(" The next files exist: ");
				System.out.println("---------------------------------------------------");
				BufferedReader br = new BufferedReader(new FileReader("Cinemanames.txt"));
				String str;
				while ((str = br.readLine()) != null){
					System.out.println(str+".txt");
				}
				System.out.println("---------------------------------------------------");
				System.out.println("Enter file name:");
				System.out.println("---------------------------------------------------");
				String name = MyScanner.scanerStr();
				try {
					cinema.getFromFile(name);
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println("---------------------------------------------------");
				System.out.println("Opened cinema from " + name + ".txt file:");
				System.out.println(cinema.toString());
				break;
			case 4:
				System.out.println("Add seance-(s) to the chousen day:");
				System.out.println("---------------------------------------------------");
				cinema.addSeance();
				break;
			case 5:
				System.out.println("Remove seance-(s) from the chousen day, by entered criterias:");
				System.out.println("---------------------------------------------------");
				cinema.removeSeance();
				break;
			case 6:
				cinema.removeMovie();
				break;
			case 7:
				System.out.println("Seanses control( remove all inappropriate seances )");
				System.out.println("---------------------------------------------------");
				for (Entry<Days, Schedule> day : cinema.getCinemaSet()) {
					int count = day.getValue().controlSeances();
					System.out.println(day.getKey().name() + " : " + count + " inappropriate seanses removed!");
				}
				System.out.println("---------------------------------------------------");
				break;
			case 8:
				System.out.println(cinema.toString());
				break;
			case 9:
				System.out.println("Save cinema to the file:");
				System.out.println("---------------------------------------------------");
				System.out.println("Enter file name:");
				System.out.println("---------------------------------------------------");
				String name1 = MyScanner.scanerStr();
								
					pw1.println(name1);
					pw1.flush();
					
					
				try {
					cinema.addToFile(name1);
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println("---------------------------------------------------");
				System.out.println("Cinema saved to" + name1 + ".txt file:");
				break;
			case 0:
				swch = false;
				break;
			}

		} while (swch);
		
		pw1.close();
	}

}
