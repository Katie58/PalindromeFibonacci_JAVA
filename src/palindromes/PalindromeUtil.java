package palindromes;

import java.util.ArrayList;
import java.util.Scanner;

public class PalindromeUtil {
	static Scanner scnr = new Scanner(System.in);
	static int center = 60;
	static String print = "";
	static String userInput = "";
	
	public static void header() {
		for(int i = 0; i < 7; i++) {
			System.out.println();
		}
		print = "WELCOME TO THE PALINDROME!";
		System.out.println(padding(center - (print.length() / 2), ' ') + print);
	}
	
	public static void stringPalindrome() {
		boolean retry = true;
		while(retry) {
			boolean valid = false;			
			while(!valid) {
				print = "Enter a word or phrase: ";
				System.out.print(padding(center - (print.length() / 2), ' ') + print);
				userInput = scnr.nextLine().trim();
				System.out.println();
				for (char letter : userInput.toCharArray()) {
					if (!validateCharAlpha(letter)) {
						valid = false;
						break;
					}
				}
				valid = true;
			}
			String output = userInput;
			for (int i = 0; i < output.length(); i++) {
				if (!validateCharAlpha(output.charAt(i))) {
					output = output.substring(0, i) + output.substring(i + 1, output.length());
					i--;
				}
			}
			results(output);	
			userInput = "";
			output = "";
			retry = retry("Enter another word?");
		}

	}
	
	public static void results(String input) {
		if (reverse(input)) {
			print = "TRUE! " + userInput + " & " + reverseOrder(userInput) + " is a panindrome!";
			System.out.println(padding(center - (print.length() / 2), ' ') + print);
		} else {
			print = "FALSE! " + userInput + " & " + reverseOrder(userInput) + " is not a panindrome!";
			System.out.println(padding(center - (print.length() / 2), ' ') + print);
		}
	}
	
	public static void intPalindrome() {
		boolean retry = true;
		while(retry) {
			boolean valid = false;			
			while(!valid) {
				print = "Please enter a number: ";
				System.out.print(padding(center - (print.length() / 2), ' ') + print);
				userInput = scnr.nextLine().trim();
				System.out.println();
				for (int i = 0; i < userInput.length(); i++) {
					if (!validateInt(Character.toString(userInput.charAt(i)))) {
						userInput = userInput.substring(0, i) + userInput.substring(i + 1, userInput.length());
						i--;
					}
				}
				if (!validateInt(userInput)) {
					valid = false;
					print = "NOT A VALID INTEGER!";
					System.err.print(padding(center - (print.length() / 2), ' ') + print + "\n");
					continue;
				}
				valid = true;
			}
			results(userInput);		
			retry = retry("Enter another number?");
		}

	}
	
	public static String reverseOrder(String input) {
		String reverse = "";
		for (int i = input.length() - 1; i >= 0; i--) {
			reverse += input.charAt(i);
		}
		return reverse;		
	}
	
	public static boolean reverse(String input) {
		String reverse = reverseOrder(input);
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) != reverse.charAt(i)) {
				return false;
			}
		}
		return true;
	}
	
	public static void fibonacci() {
		boolean retry = true;
		while(retry) {
			boolean valid = false;
			String input = "";
			while(!valid) {
				print = "Please enter a number: ";
				System.out.print(padding(center - (print.length() / 2), ' ') + print);
				input = scnr.nextLine().trim();
				System.out.println();
				if (!validateInt(input)) {
					valid = false;
					print = "NOT A VALID INTEGER!";
					System.err.print(padding(center - (print.length() / 2), ' ') + print + "\n");
					break;
				}
				valid = true;
			}
			int n = Integer.parseInt(input);
			int first = 0;
			int second = 1;
			int current = 1;
			ArrayList<Integer> fibonacci = new ArrayList<Integer>();
			fibonacci.add(current);
			for (int i = 1; i < n; i++) {
				current = first + second;
				if (current < 0) {
					print = "ERROR - something went wrong!";
					System.err.println(padding(center - (print.length() / 2), ' ') + print + "\n");
					print = "(F of 46 = 1836311903) which is the largest number this calculator can handle...";
					System.err.println(padding(center - (print.length() / 2), ' ') + print + "\n");
					i = n;
				}
				if (i != n) {
					first = second;
					second = current;
					fibonacci.add(current);					
				}
			}
			print = "0";
			for (int x : fibonacci) {
				print += ", " + Integer.toString(x);
			}
			while (print.length() > 120) {
				String printLine = print.substring(0, 120);
				int index = printLine.lastIndexOf(",");
				printLine = print.substring(0, index);
				System.out.println(padding(center - (printLine.length() / 2), ' ') + printLine);
				print = print.substring(index + 2);
			}
			System.out.print(padding(center - (print.length() / 2), ' ') + print + "\n");	
			retry = retry("Enter another number?");
		}

	}
	
	public static void menu(Menu menu) {
		header();
		int size = menu.getMenuItems().size();
		int select;
		System.out.println();
		for (int i = 0; i < size; i++) {
			System.out.println(padding(center - 9, ' ') + (i + 1) + ") " + menu.getMenuItems().get(i).name());
		}
		centerTerminal();
		print = "Choose a menu option: ";
		System.out.print("\n" + padding(center - (print.length() / 2), ' ') + print);
		select = validateMenu(size) - 1;
		((MenuInterface) menu.getEnum(select)).execute();
	}
	
	public static boolean validateInt(String input) {
		if (input.isEmpty()) {
			return false;
		}
		if (!input.matches("[-0-9]*")) {
			return false;
		}
		String maxInt = String.valueOf(Integer.MAX_VALUE);
		if (input.length() < maxInt.length()) {
			return true;
		} else if (input.length() > maxInt.length()) {
			return false;
		} else {
			for (int i = 0; i < input.length(); i++) {
				if (input.charAt(i) < maxInt.charAt(i)) {
					return true;
				} 
				if (input.charAt(i) > maxInt.charAt(i)) {
					return false;
				}
			}
			return true;
		}
	}
	
	public static boolean validateCharAlpha(char character) {
		String charString = Character.toString(character);
		if (charString.matches("[a-zA-Z]")) {
			return true;
		} else {
			return false;
		}			
	}
	
	public static int validateMenu(int menuCount) {
		int input = 0;
		boolean valid = false;
		while(!valid) {
			String in = scnr.nextLine().trim();
			if (in.isEmpty()) {
				print = "Perhaps check your numlock, try again... ";
				System.err.print(padding(center - (print.length() / 2), ' ') + print);
				continue;					
			} else if (in.matches("[0-9]*")) {
				input = Integer.parseInt(in);
				if (input >= 1 && input <= menuCount) {
					return input;
				} else {
					print = "Sorry, " + input + " is not a menu option, try again... ";
					System.err.print(padding(center - (print.length() / 2), ' ') + print);
					continue;
				}
			} else {
				print = "Looking for numbers, try again... ";
				System.err.print(padding(center - (print.length() / 2), ' ') + print);
				continue;
			}
		}
		return input;
	}
	
 	public static boolean retry(String question) {
 		char select = ' ';
 		print =  question + " (y/n) ";
		System.out.print("\n" + padding(center - (print.length() / 2), ' ') + print);
		if (scnr.hasNextLine()) {
			select = scnr.nextLine().charAt(0);
		}
		return validateYesNo(select);
	}
	
	public static boolean validateYesNo(char input) {
		while (input != 'y' && input != 'Y' && input != 'n' && input != 'N') {
			print = "This is a simple yes or no question, try again...";
			System.err.print(padding(center - (print.length() / 2), ' ') + print);
			if (scnr.hasNextLine()) {
				input = scnr.nextLine().charAt(0);
			}	
		}
		return (input == 'y' || input == 'Y');
	}
	
	public static String padding(int multiplier, char character) {
		String multiples = "";
		for (int i = 1; i <= multiplier; i++) {
			multiples += character;
		}
		return multiples;
	}
	
	public static void centerTerminal() {
		int multiplier = 14;
		for (int i = 0; i < multiplier;i++) {
			System.out.println(" ");
		}
	}
		
	public static void clearTerminal() {
		int multiplier = 30;
		for (int i = 0; i < multiplier;i++) {
			System.out.println(" ");
		}
	}

	public static void exit() {
		print = "Catch you later!";
		System.out.println(padding(center - (print.length() / 2), ' ') + print);
		scnr.close();		
	}
}
