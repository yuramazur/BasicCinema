package classes;

public class Seance implements Comparable<Seance> {

	private Movie movie;
	private Time startTime;
	private Time endTime;

	public Seance() {

	}

	public Seance(Movie movie, Time startTime) {
		this.movie = movie;
		this.startTime = startTime;
		setEndTime();
	}

	public Seance(String movTitle, int durHH, int durMM, int startHH, int startMM) {
		this.movie = new Movie(movTitle, durHH, durMM);
		this.startTime = new Time(startHH, startMM);
		setEndTime();
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
		setEndTime();
	}

	public void setMovie(String movie, int durHH, int durMM) {
		this.movie = new Movie(movie, durHH, durMM);
		setEndTime();
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
		setEndTime();
	}

	public void setStartTime(int hh, int mm) {
		this.startTime = new Time(hh, mm);
		setEndTime();
	}

	public Time getEndTime() {
		setEndTime();
		return endTime;
	}

	private void setEndTime() {
		try {
			this.endTime = Time.timePlusTime(getStartTime(), movie.getDuration());
		} catch (NullPointerException e) {
			this.endTime = null;
		}
	}

	public String print() {
		return startTime + " " + movie.getTitle() + " " + movie.getDuration();
	}

	@Override
	public String toString() {
		return "Seance Starting: (" + startTime + ") [ " + movie + " ]  Ending: (" + endTime + ")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result + ((movie == null) ? 0 : movie.hashCode());
		result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seance other = (Seance) obj;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (movie == null) {
			if (other.movie != null)
				return false;
		} else if (!movie.equals(other.movie))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		return true;
	}

	@Override
	public int compareTo(Seance o) {
		if (this.startTime.getHouers() - o.startTime.getHouers() != 0) {
			return this.startTime.getHouers() - o.startTime.getHouers();
		} else if (this.startTime.getMinutes() - o.startTime.getMinutes() != 0) {
			return this.startTime.getMinutes() - o.startTime.getMinutes();
		}
		return 0;
	}

}
