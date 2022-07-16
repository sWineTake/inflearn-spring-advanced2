package hello.proxy;


import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int v = sc.nextInt();

		int day = 0;
		int total = 0;
		int oneDay = a - b;

		while(true) {
			day++;
			total += a;
			if (total >= v) {
				break;
			}
			else {
				total -= b;
			}
		}
		System.out.println(day);
	}
}
