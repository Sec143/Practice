package Day2;

import java.util.Scanner;

public class FIZZBuzz {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
				System.out.println("Enter a number : ");
				int num=read.nextInt();
				for (int i=1;i<=num;i++) {
					if (i%3==0 && i%5==0)
						System.out.println("FIZZBUZZ");
					else if (i%3==0)
						System.out.println("Fizz");
					else if (i%5==0)
						System.out.println("buzz");
					else 
						System.out.println(i);
				}
				read.close();
				
	}

}
