package palindromes;

import java.util.ArrayList;
import java.util.EnumSet;

public class PalindromeApp {
	static boolean exit = false;
	
	public static void main(String[] args) {

		while(!exit) {
			Menu main = new Menu("main");
			main.setMenuItems(new ArrayList<Enum>(EnumSet.allOf(MainMenu.class)));
			PalindromeUtil.menu(main);
		}
		PalindromeUtil.exit();
	}
	
}
