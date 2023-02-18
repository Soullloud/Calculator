import java.util.Scanner;
public class Scan {
	public static void main(String[] args){
		Scanner scan = new Scanner (System.in);
		System.out.println("Введите число");
		if(scan.hasNextInt()){
			int number = scan.nextInt();
			System.out.println("Спасибо, что ввели число" + " " + number);
		} else {
			System.out.println("Простите, но это не похоже на число. Перезапустите программу и попробуйте снова!");
		}
		scan.close();
	}
}