package classes;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MyScanner {
	public static Scanner sc;
	public static  int scanerInt() {

		// ---------------- ����� ����� ������ ���� �������� � ���²�����
		// -----------------------------------------------------------

		int rez = 0;
		boolean swch = false;
		while (!swch) {
			try {
				sc = new Scanner(System.in);
				rez = sc.nextInt();
				
				if (rez < 0 || rez > 23) {
					System.out.println("---------------------------------------------------");
//					System.out.println(" The choice should be between 1) and 9) or 0) ! ");
					System.out.println("Invalid value: (Only numbers! 0 to 23 )");
					System.out.println("---------------------------------------------------");
					swch = false;
				}else{
					swch = true;
				}

			} catch (InputMismatchException exc) {
				// exc.printStackTrace();
				System.out.println("-------------------------------------- ");
				System.out.println("------------- Exception! ------------- ");
				System.out.println("Invalid value: (Only numbers! 0 to 23 )");
				System.out.println("--------------------------------------");
				System.out.println("-----------  Try again! -------------- ");
				System.out.println("--------------------------------------");
				swch = false;
			}

		}
		return rez;
	}

	public static String scanerStr() {

		// ---------------- ����� ����� ������ ���� ��в��� � ���²�����
		// -----------------------------------------------------------

		String rez = "";
		boolean swch = false;
		while (!swch) {
			try {
				sc = new Scanner(System.in);
				rez = sc.nextLine();
				if (rez.equals("")) {
					return "";
				}
				swch = true;

			} catch (InputMismatchException exc) {
				// exc.printStackTrace();
				System.out.println("-------------------------------------- ");
				System.out.println("------------- Exception! ------------- ");
				System.out.println("Invalid value: (Only String) !:");
				System.out.println("--------------------------------------");
				System.out.println("-----------  Try again! -------------- ");
				System.out.println("--------------------------------------");
				swch = false;
			}

		}
		return rez;
	}
}
