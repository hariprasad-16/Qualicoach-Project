package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class demo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream("E:\\Automation_Practice\\qualicoach\\src\\main\\java\\resources\\QuizCorrectAnswers.txt");
		Scanner sc =new Scanner(fis);
		System.out.println(sc.nextLine());
		System.out.println(sc.nextLine());
		System.out.println(sc.nextLine());
	}

}
