package classes;

public class TestMain {

	public static void main(String[] args) {
		Time openTime = new Time(9,0);
		Time startTime = new Time (8,30);
System.out.println(startTime.compareTo(openTime));
	}

}
