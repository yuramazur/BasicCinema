package classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.Iterator;

import java.util.Map;

import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;
import enums.Days;

public class Cinema  {

	private Time openTime;
	private Time closeTime;
	private Time faultTime;
	private Map<Days, Schedule> cinemaMap;
	private Set<Entry<Days, Schedule>> cinemaSet;
	private String name;

	public Cinema(int openHH, int openMM, int closeHH, int closeMM, int faultMM) {
		openTime = new Time(openHH, openMM);
		closeTime = new Time(closeHH, closeMM);
		faultTime = new Time(0, faultMM);
		this.cinemaMap = new TreeMap<Days, Schedule>();
		cinemaMap.put(Days.MONDAY, new Schedule(openTime, closeTime, faultTime));
		cinemaMap.put(Days.THURSDAY, new Schedule(openTime, closeTime, faultTime));
		cinemaMap.put(Days.WEDNESDAY, new Schedule(openTime, closeTime, faultTime));
		cinemaMap.put(Days.TUESDAY, new Schedule(openTime, closeTime, faultTime));
		cinemaMap.put(Days.FRIDAY, new Schedule(openTime, closeTime, faultTime));
		cinemaMap.put(Days.SATURDAY, new Schedule(openTime, closeTime, faultTime));
		cinemaMap.put(Days.SUNDAY, new Schedule(openTime, closeTime, faultTime));
		this.cinemaSet = cinemaMap.entrySet();
	}

	public Map<Days, Schedule> getCinemaMap() {
		return cinemaMap;
	}

	public void setCinemaMap(Map<Days, Schedule> cinemaMap) {
		this.cinemaMap = cinemaMap;
	}

	public Set<Entry<Days, Schedule>> getCinemaSet() {
		return cinemaSet;
	}

	public void setCinemaSet(Set<Entry<Days, Schedule>> cinemaSet) {
		this.cinemaSet = cinemaSet;
	}

	public Time getOpenTime() {
		return openTime;
	}

	public void setOpenTime(int openHH, int openMM) {
		this.openTime = new Time(openHH, openMM);
	}

	public Time getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(int closeHH, int closeMM) {
		this.closeTime = new Time(closeHH, closeMM);
	}

	public Time getFaultTime() {
		return faultTime;
	}

	public void setFaultTime(int faultMM) {
		this.faultTime = new Time(0, faultMM);
	}

	private void repitAddSeance(Days day) {
		// ----------- ����� ��� ���������� ��������� ���Ѳ� �� �����������
		// ���---------------------------
		int choise = 0;
		boolean swch;
		do {
			swch = false;
			cinemaMap.get(day).addSeance();
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("To continue , type 1) , type 0) to complete");
			System.out.println("--------------------------------------------------------------------------------");
			choise = MyScanner.scanerInt();
			if (choise != 0) {
				swch = true;
			}
		} while (swch);
	}

	public void addSeance() {
		System.out.println(
				"---------------------------------------------------------------------------------------------");
		System.out.println("Add new seance to day seances list :");
		System.out.println(
				"---------------------------------------------------------------------------------------------");
		System.out.println(" Select a day :");
		System.out.println(
				"---------------------------------------------------------------------------------------------");
		System.out.println(" 1) MONDAY.");
		System.out.println(" 2) TUESDAY.");
		System.out.println(" 3) WEDNESDAY.");
		System.out.println(" 4) THURSDAY.");
		System.out.println(" 5) FRIDAY.");
		System.out.println(" 6) SATURDAY.");
		System.out.println(" 7) SUNDAY");
		System.out.println(" 0) EXIT");
		System.out.println(
				"---------------------------------------------------------------------------------------------");
		System.out.println(" Select a number pleace!");
		System.out.println(
				"---------------------------------------------------------------------------------------------");
		int rez = 0;
		boolean swch = false;
		do {
			rez = MyScanner.scanerInt();
			if (rez < 0 || rez > 7) {
				swch = true;
				System.out.println(
						"---------------------------------------------------------------------------------------------");
				System.out.println(" The choice should be between 1) and 7) or 0) ! ");
				System.out.println(
						"---------------------------------------------------------------------------------------------");
			}
		} while (swch);
		switch (rez) {
		case 1:
			System.out
					.println("--------------------------------------------------------------------------------------");
			System.out.println(" You have chosen MONDAY:");
			System.out
					.println("--------------------------------------------------------------------------------------");
			repitAddSeance(Days.MONDAY);
			break;
		case 2:
			System.out
					.println("--------------------------------------------------------------------------------------");
			System.out.println(" You have chosen TUESDAY:");
			System.out
					.println("--------------------------------------------------------------------------------------");
			repitAddSeance(Days.TUESDAY);
			break;
		case 3:
			System.out
					.println("--------------------------------------------------------------------------------------");
			System.out.println(" You have chosen WEDNESDAY:");
			System.out
					.println("--------------------------------------------------------------------------------------");
			repitAddSeance(Days.WEDNESDAY);
			break;
		case 4:
			System.out
					.println("--------------------------------------------------------------------------------------");
			System.out.println(" You have chosen THURSDAY:");
			System.out
					.println("--------------------------------------------------------------------------------------");
			repitAddSeance(Days.THURSDAY);
			break;
		case 5:
			System.out
					.println("--------------------------------------------------------------------------------------");
			System.out.println(" You have chosen FRIDAY:");
			System.out
					.println("--------------------------------------------------------------------------------------");
			repitAddSeance(Days.FRIDAY);
			break;
		case 6:
			System.out
					.println("--------------------------------------------------------------------------------------");
			System.out.println(" You have chosen SATURDAY:");
			System.out
					.println("--------------------------------------------------------------------------------------");
			repitAddSeance(Days.SATURDAY);
			break;
		case 7:
			System.out
					.println("--------------------------------------------------------------------------------------");
			System.out.println(" You have chosen SUNDAY:");
			System.out
					.println("--------------------------------------------------------------------------------------");
			repitAddSeance(Days.SUNDAY);
			break;
		case 0:
			break;
		}
	}

	public void removeMovie() {
		System.out.println(
				"---------------------------------------------------------------------------------------------");
		System.out.println("Remove all film seases :");
		System.out.println(
				"---------------------------------------------------------------------------------------------");
		System.out.println(" Enter Movie title :");
		System.out.println(
				"---------------------------------------------------------------------------------------------");
		String removedMovie = MyScanner.scanerStr();
		int count = 0;
		for (Entry<Days, Schedule> entry : cinemaSet) {
			Iterator<Seance> iterator = entry.getValue().getAllSeances().iterator();
			while (iterator.hasNext()) {
				if (iterator.next().getMovie().getTitle().equals(removedMovie)) {
					iterator.remove();
					count++;
				}

			}
		}
		System.out.println(
				"---------------------------------------------------------------------------------------------");
		System.out.println("Removed " + count + " film seases.");
		System.out.println(
				"---------------------------------------------------------------------------------------------");

	}

	private void repitRemoveSeance(Days day) {
		// ----------- ����� ��� ���������� ��������� ���Ѳ� �� �����������
		// ��� �� ��������� ����������� ---------------------------
		int choise = 0;
		boolean swch;
		do {
			swch = false;
			cinemaMap.get(day).dellSeance();
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("To continue , type 1) , type 0) to complete");
			System.out.println("--------------------------------------------------------------------------------");
			choise = MyScanner.scanerInt();
			if (choise != 0) {
				swch = true;
			}
		} while (swch);
	}

	public void removeSeance() {
		System.out.println(
				"---------------------------------------------------------------------------------------------");
		System.out.println("Delete seance from day seances list :");
		System.out.println(
				"---------------------------------------------------------------------------------------------");
		System.out.println(" Select a day :");
		System.out.println(
				"---------------------------------------------------------------------------------------------");
		System.out.println(" 1) MONDAY.");
		System.out.println(" 2) TUESDAY.");
		System.out.println(" 3) WEDNESDAY.");
		System.out.println(" 4) THURSDAY.");
		System.out.println(" 5) FRIDAY.");
		System.out.println(" 6) SATURDAY.");
		System.out.println(" 7) SUNDAY");
		System.out.println(" 0) EXIT");
		System.out.println(
				"---------------------------------------------------------------------------------------------");
		System.out.println(" Select a number pleace!");
		System.out.println(
				"---------------------------------------------------------------------------------------------");
		int rez = 0;
		boolean swch = false;
		do {
			rez = MyScanner.scanerInt();
			if (rez < 0 || rez > 7) {
				swch = true;
				System.out.println(
						"---------------------------------------------------------------------------------------------");
				System.out.println(" The choice should be between 1) and 7) or 0) ! ");
				System.out.println(
						"---------------------------------------------------------------------------------------------");
			}
		} while (swch);
		switch (rez) {
		case 1:
			System.out
					.println("--------------------------------------------------------------------------------------");
			System.out.println(" You have chosen MONDAY:");
			System.out
					.println("--------------------------------------------------------------------------------------");
			repitRemoveSeance(Days.MONDAY);
			break;
		case 2:
			System.out
					.println("--------------------------------------------------------------------------------------");
			System.out.println(" You have chosen TUESDAY:");
			System.out
					.println("--------------------------------------------------------------------------------------");
			repitRemoveSeance(Days.TUESDAY);
			break;
		case 3:
			System.out
					.println("--------------------------------------------------------------------------------------");
			System.out.println(" You have chosen WEDNESDAY:");
			System.out
					.println("--------------------------------------------------------------------------------------");
			repitRemoveSeance(Days.WEDNESDAY);
			break;
		case 4:
			System.out
					.println("--------------------------------------------------------------------------------------");
			System.out.println(" You have chosen THURSDAY:");
			System.out
					.println("--------------------------------------------------------------------------------------");
			repitRemoveSeance(Days.THURSDAY);
			break;
		case 5:
			System.out
					.println("--------------------------------------------------------------------------------------");
			System.out.println(" You have chosen FRIDAY:");
			System.out
					.println("--------------------------------------------------------------------------------------");
			repitRemoveSeance(Days.FRIDAY);
			break;
		case 6:
			System.out
					.println("--------------------------------------------------------------------------------------");
			System.out.println(" You have chosen SATURDAY:");
			System.out
					.println("--------------------------------------------------------------------------------------");
			repitRemoveSeance(Days.SATURDAY);
			break;
		case 7:
			System.out
					.println("--------------------------------------------------------------------------------------");
			System.out.println(" You have chosen SUNDAY:");
			System.out
					.println("--------------------------------------------------------------------------------------");
			repitRemoveSeance(Days.SUNDAY);
			break;
		case 0:
			break;
		}
	}

	public void addToFile(String name) throws IOException {
		PrintWriter pw = new PrintWriter(name + ".txt");
		for (Entry<Days, Schedule> entry : cinemaSet) {
			pw.println(entry.getKey().toString());

			for (Seance seance : entry.getValue().getAllSeances()) {
				pw.print("- ");
				pw.println(seance.print());
			}
		}
		pw.flush();
		pw.close();

	}

	public void getFromFile(String name) throws IOException {
		this.name = name;
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader(name + ".txt"));
		String str;
		Days dayKey = null;
		while ((str = br.readLine()) != null) {
			String[] strArr = str.split(" ");
			if (!strArr[0].equals("-")) {

				cinemaMap.put(Days.valueOf(strArr[0]), new Schedule(openTime, closeTime, faultTime));
				dayKey = Days.valueOf(strArr[0]);

			} else {
				String[] strArrToIntStart = strArr[1].split(":");
				int startHH = Integer.parseInt(strArrToIntStart[0]);
				int startMM = Integer.parseInt(strArrToIntStart[1]);
				String[] strArrToIntDur = strArr[3].split(":");
				int durHH = Integer.parseInt(strArrToIntDur[0]);
				int durMM = Integer.parseInt(strArrToIntDur[1]);
				Seance seance = new Seance(new Movie(strArr[2], durHH, durMM), new Time(startHH, startMM));
				cinemaMap.get(dayKey).getAllSeances().add(seance);
			}
		}
	}

	@Override
	public String toString() {
		System.out.println("---------Cinema " + this.name + "----------");
		System.out.println("Open time: " + openTime + "--------" + "Close time: " + closeTime);
		System.out.println("--------------------------------------");
		String str = "";

		for (Entry<Days, Schedule> entry : cinemaSet) {

			str += entry.getKey().toString() + "\n" + "-------------------" + "\n";

			for (Seance sch : entry.getValue().getAllSeances()) {
				str += sch.toString() + "\n";
			}

			str += "\n";
		}
		return str;
	}

}
