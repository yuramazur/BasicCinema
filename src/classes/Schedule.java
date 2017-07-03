package classes;

import java.util.Iterator;

import java.util.Set;
import java.util.TreeSet;

public class Schedule {
	private Time openTime;
	private Time closeTime;
	private Time faultTime;
	private Set<Seance> seances;

	public Schedule(Time openTime, Time closeTime, Time faultTime) {
		this.seances = new TreeSet<Seance>();
		this.openTime = openTime;
		this.closeTime = closeTime;
		this.faultTime = faultTime;

	}

	public Time getOpenTime() {
		return openTime;
	}

	public void setOpenTime(Time openTime) {
		this.openTime = openTime;
	}

	public Time getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(Time closeTime) {
		this.closeTime = closeTime;
	}

	public Time getFaultTime() {
		return faultTime;
	}

	public void setFaultTime(Time faultTime) {
		this.faultTime = faultTime;
	}

	public Set<Seance> getAllSeances() {
		return seances;
	}

	public void setAllSeances(Set<Seance> seances) {
		this.seances = seances;
	}

	public boolean seancesAddCheck(Seance newSeance) {
		Seance[] seance = new Seance[seances.size()];
		seances.toArray(seance);
		for (int i = 0; i < seance.length; i++) {
			if (newSeance.getStartTime().compareTo(seance[i].getStartTime()) > 0
					& newSeance.getStartTime().compareTo(Time.timePlusTime(seance[i].getEndTime(), faultTime)) < 0
					| newSeance.getEndTime().compareTo(seance[i].getStartTime()) > 0
							& newSeance.getEndTime().compareTo(Time.timePlusTime(seance[i].getEndTime(), faultTime)) < 0
					| newSeance.getStartTime().compareTo(Time.timePlusTime(seance[i].getEndTime(), faultTime)) < 0
							& newSeance.getEndTime().compareTo(seance[i].getStartTime()) > 0) {
				return false;
			}
		}

		return true;
	}

	public void addSeance() {

		// ---------------- ÌÅÍŞ ÂÂÎÄÓ ÄÀÍÈÕ ÄËß ÑÒÂÎĞÅÍÍß ÍÎÂÎÃÎ ÑÅÀÍÑÓ
		// ---------------------------------------------------

		System.out.println(
				"---------------------------------------------------------------------------------------------");
		System.out.println("Add new sence to day seances list :");
		System.out.println(
				"---------------------------------------------------------------------------------------------");
		System.out.println("Enter SEANCE START TIME :");
		System.out.println(
				"---------------------------------------------------------------------------------------------");
		System.out.println("Enter HOUER :");
		System.out.println(
				"---------------------------------------------------------------------------------------------");

		int startHH = MyScanner.scanerInt();

		System.out.println(
				"---------------------------------------------------------------------------------------------");
		System.out.println("Enter MINUTES :");
		System.out.println(
				"---------------------------------------------------------------------------------------------");

		int startMM = MyScanner.scanerInt();

		System.out.println(
				"---------------------------------------------------------------------------------------------");
		System.out.println("Enter MOVIE TITLE :");
		System.out.println(
				"---------------------------------------------------------------------------------------------");

		String movieTitle = MyScanner.scanerStr();

		System.out.println(
				"---------------------------------------------------------------------------------------------");
		System.out.println("Enter MOVIE DURATION TIME :");
		System.out.println(
				"---------------------------------------------------------------------------------------------");
		System.out.println("Enter HOUER :");
		System.out.println(
				"---------------------------------------------------------------------------------------------");

		int durHH = MyScanner.scanerInt();

		System.out.println(
				"---------------------------------------------------------------------------------------------");
		System.out.println("Enter MINUTES :");
		System.out.println(
				"---------------------------------------------------------------------------------------------");

		int durMM = MyScanner.scanerInt();

		// ---------------- ÑÒÂÎĞÅÍÍß ÎÁªÊÒÓ ÒÈÏÓ ÑÅÀÍÑ ÄËß ÏÅĞÅÂ²ĞÊÈ ²
		// ÄÎÄÀÂÀÍÍß ÄÎ ÑÏÈÑÊÓ ---------------------------------------

		Time newDurTime = new Time(durHH, durMM);
		Time newStartTime = new Time(startHH, startMM);
		Movie newMovie = new Movie(movieTitle, newDurTime);
		Seance newSeance = new Seance(newMovie, newStartTime);

		// ---------------- ÏÅĞÅÂ²ĞÊÀ ÍÎÂÎÃÎ ÎÁªÊÒÓ ÒÈÏÓ ÑÅÀÍÑ ² ÄÎÄÀÂÀÍÍß ÄÎ
		// ÑÏÈÑÊÓ Â ĞÀÇ² ÂÈÊÎÍÀÍÍß ÇÀÄÀÍÈÕ ÓÌÎÂ, --------------------
		// ---------------- À ÒÀÊÎÆ ÂÈÂÅÄÅÍÍß ÍÅ ÂÈÊÎÍÀÍÈÕ ÓÌÎÂ
		// ------------------------------------------------------------------------

		if (openTime.compareTo(newStartTime) <= 0 & closeTime.compareTo(newSeance.getEndTime()) >= 0) {
			if (seances.isEmpty()) {
				seances.add(newSeance);
			} else if (seancesAddCheck(newSeance)) {
				seances.add(newSeance);
			} else {
				System.out.println(
						"-------------------------------------------------------------------------------------");
				System.out.println("Seance time start or time end mistake!");
				System.out.println(
						"-------------------------------------------------------------------------------------");
				System.out.println(newSeance);
				System.out.println(
						"_____________________________________________________________________________________");
				print();
			}
		} else {
			System.out.println(
					"-----------------------------------------------------------------------------------------");
			System.out.println("The seance does not get in-time theater!");
			System.out.println(
					"-----------------------------------------------------------------------------------------");
			System.out.println(newSeance);
			System.out.println(
					"_________________________________________________________________________________________");
			System.out.println("The opening time:" + "(" + openTime + ")" + "                                         "
					+ "The close time:" + "(" + closeTime + ")");
		}
	}

	public boolean seancesDellCheck(Seance seance, Seance findSeance, Time findEndTime) {

		// ---------------- ÌÅÒÎÄ ÏÅĞÅÂ²ĞÊÈ ÄËß ÌÅÒÎÄÓ ÂÈÄÀËÅÍÍß ÑÅÀÍÑÓ ÇÀ
		// ÂÂÅÄÈÍÈÌÈ ÊĞÅÒÅĞ²ÌÈ
		// -----------------------------------------------------------

		if (findSeance == null) {
			return false;
		}
		if (findSeance.getStartTime() != null) {
			if (!findSeance.getStartTime().equals(seance.getStartTime())) {
				return false;
			}
		}
		if (findSeance.getMovie().getTitle() != null) {
			if (!findSeance.getMovie().getTitle().equals(seance.getMovie().getTitle())) {
				return false;
			}
		}
		if (findSeance.getMovie().getDuration() != null) {
			if (!findSeance.getMovie().getDuration().equals(seance.getMovie().getDuration())) {
				return false;
			}
		}
		if (findEndTime != null) {
			if (!findEndTime.equals(seance.getEndTime())) {
				return false;
			}
		}

		return true;
	}

	public void dellSeance() {

		// ---------------- ÌÅÍŞ ÂÂÎÄÓ ÄÀÍÈÕ ÄËß ÏÅĞÅÂ²ĞÊÈ ÍÀ ÂÈÄÀËÅÍÍß
		// -----------------------------------------------------------

		System.out.println(
				"---------------------------------------------------------------------------------------------");
		System.out.println("Removal seance by entered criteria :");
		System.out.println(
				"---------------------------------------------------------------------------------------------");
		System.out.println("Enter SEANCE START TIME :");
		System.out.println(
				"---------------------------------------------------------------------------------------------");
		System.out.println("Enter HOUER ( to skip enter 0):");
		System.out.println(
				"---------------------------------------------------------------------------------------------");

		int startHH = MyScanner.scanerInt();

		System.out.println(
				"---------------------------------------------------------------------------------------------");
		System.out.println("Enter MINUTES ( to skip enter 0):");
		System.out.println(
				"---------------------------------------------------------------------------------------------");

		int startMM = MyScanner.scanerInt();

		System.out.println(
				"---------------------------------------------------------------------------------------------");
		System.out.println("Enter MOVIE TITLE ( to skip push ENTER button):");
		System.out.println(
				"---------------------------------------------------------------------------------------------");

		String findMovieTitle = MyScanner.scanerStr();

		System.out.println(
				"---------------------------------------------------------------------------------------------");
		System.out.println("Enter MOVIE DURATION TIME :");
		System.out.println(
				"---------------------------------------------------------------------------------------------");
		System.out.println("Enter HOUER ( to skip enter 0):");
		System.out.println(
				"---------------------------------------------------------------------------------------------");

		int durHH = MyScanner.scanerInt();

		System.out.println(
				"---------------------------------------------------------------------------------------------");
		System.out.println("Enter MINUTES ( to skip enter 0):");
		System.out.println(
				"---------------------------------------------------------------------------------------------");

		int durMM = MyScanner.scanerInt();

		System.out.println(
				"---------------------------------------------------------------------------------------------");
		System.out.println("Enter MOVIE END TIME :");
		System.out.println(
				"---------------------------------------------------------------------------------------------");
		System.out.println("Enter HOUER ( to skip enter 0):");
		System.out.println(
				"---------------------------------------------------------------------------------------------");

		int endHH = MyScanner.scanerInt();

		System.out.println(
				"---------------------------------------------------------------------------------------------");
		System.out.println("Enter MINUTES ( to skip enter 0):");
		System.out.println(
				"---------------------------------------------------------------------------------------------");

		int endMM = MyScanner.scanerInt();

		// ---------------- ÏÅĞÅÂ²ĞÊÀ ÂÂÅÄÅÍÈÕ ÄÀÍÈÕ ² ÔÎĞÌÓÂÀÍÍß ÎÁªÊÒ²Â ÒÈÏÓ
		// ×ÀÑ ÄËß ÏÅĞÅÂ²ĞÊÈ ÍÀ ÂÈÄÀËÅÍÍß ----------------------

		Time findStartTime = null;
		if (startHH != 0 || startMM != 0) {
			findStartTime = new Time(startHH, startMM);
		}

		Time findDurTime = null;
		if (durHH != 0 || durMM != 0) {
			findDurTime = new Time(durHH, durMM);
		}

		Time findEndTime = null;
		if (endHH != 0 || endMM != 0) {
			findEndTime = new Time(endHH, endMM);
		}
		if (findMovieTitle.equals("")) {
			findMovieTitle = null;
		}

		// ---------------- ÑÒÂÎĞÅÍÍß ÎÁªÊÒÓ ÒÈÏÓ ÑÅÀÍÑ ÄËß ÏÅĞÅÂ²ĞÊÈ ÍÀ
		// ÂÈÄÀËÅÍÍß ------------------------------------------------

		Seance findSeance = new Seance(new Movie(findMovieTitle, findDurTime), findStartTime);

		// ---------------- ÂÈÄÀËÅÍÍß ÑÅÀÍÑÓ(-²Â) ²Ç ÒĞ²-ÑÅÒÓ ÑÅÀÍÑ²Â ÇÀ
		// ÑÏ²ÂÏÀÂØÈÌÈ ÊĞÈÒÅĞ²ßÌÈ ------------------------------------

		Iterator<Seance> iter = seances.iterator();
		while (iter.hasNext()) {
			if (seancesDellCheck(iter.next(), findSeance, findEndTime)) {
				iter.remove();
			}
		}
		// ---------------- Ê²ÍÅÖÜ ÌÅÒÎÄÓ
		// ------------------------------------------------------------------------------------------
	}

	public int controlSeances() {
		int count = 0;
		Iterator<Seance> iter = seances.iterator();
		while (iter.hasNext()) {
			Seance seanc = iter.next();
			if (seanc.getStartTime().compareTo(openTime) < 0 || seanc.getEndTime().compareTo(closeTime) > 0) {
				iter.remove();
				count++;
			} else if (seancesAddCheck(seanc)) {
				iter.remove();
				count++;
			}
		}
		return count;
	}

	public void print() {
		for (Seance seance : seances) {
			System.out.println(seance);
		}
	}

}
