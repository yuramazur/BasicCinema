package classes;

public class Time implements Comparable<Time> {
	final static int maxHH = 24;
	final static int maxMM = 60;
	private int houers;
	private int minutes;

	public Time() {

	}

	public Time(int houers, int minutes) {
		houersCheck(houers);
		minutesCheck(minutes);

	}

	public int getHouers() {
		return houers;
	}

	public void setHouers(int houers) {
		houersCheck(houers);
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		minutesCheck(minutes);
	}

	private void houersCheck(int houers) {
		if (houers < 0) {
			houers = Math.abs(houers);
			System.out.println("Time can not be negative!");
			System.out.println("Entered houers value is taken as absolute.");
		}
		if (houers < maxHH) {
			this.houers = houers;
		} else {
			this.houers = maxHH - 1;
			System.out.println("Day has only 24 hours!");
			System.out.println("The entered value changed to the maximum allowable - 23.");
		}
	}

	private void minutesCheck(int minutes) {
		if (minutes < 0) {
			minutes = Math.abs(minutes);
			System.out.println("Time can not be negative!");
			System.out.println("Entered minutes value is taken as absolute.");
		}
		if (minutes < maxMM) {
			this.minutes = minutes;
		} else {
			this.minutes = maxMM - 1;
			System.out.println("One hour has only 60 minutes!");
			System.out.println("The entered value changed to the maximum allowable - 59.");
		}
	}

	public static Time timePlusTime(Time ot1, Time ot2) {
		int count = 0;
		int newHH = 0;
		int newMM = 0;
		if ((ot1.getMinutes() + ot2.getMinutes()) >= maxMM) {
			newMM = (ot1.getMinutes() + ot2.getMinutes()) - maxMM;
			count++;
		} else {
			newMM = (ot1.getMinutes() + ot2.getMinutes());
		}
		if ((ot1.getHouers() + ot2.getHouers() + count) > maxHH) {
			newHH = (ot1.getHouers() + ot2.getHouers() + count) - maxHH;
		} else {
			newHH = ot1.getHouers() + ot2.getHouers() + count;
		}

		Time newTime = new Time(newHH, newMM);
		return newTime;
	}

	@Override
	public String toString() {
		return ((houers / 10 > 0) ? houers : ("0" + houers)) + ":" + ((minutes / 10 > 0) ? minutes : ("0" + minutes));
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Time other = (Time) obj;
		if (houers != other.houers)
			return false;
		if (minutes != other.minutes)
			return false;
		return true;
	}

	@Override
	public int compareTo(Time o) {
		if (this.getHouers() - o.getHouers() != 0) {
			return this.getHouers() - o.getHouers();
		} else if (this.getMinutes() - o.getMinutes() != 0) {
			return this.getMinutes() - o.getMinutes();
		}
		return 0;
	}

}
