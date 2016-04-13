import java.io.*;
import java.util.*;
import java.lang.*;

/*
 * 
 * Class ini dibuat untuk menyelesaikan coding test dari acara Selection Internship Day oleh Veritrans
 * Class ini mengimplementasikan game acak kata dimana sumber kata-katanya berasal dari nama.txt
 * 
 * @author Fithriannisa Augustianti
 * @date 13/04/2016
 * 
 * */
public class Game {

	public static void main(String[] args) {
		String filename = "nama.txt";
		String str;
		String rndStr = "";
		String ans = "";
		int idx;
		boolean win = true;
		ArrayList<Character> strChar = new ArrayList<Character>();
		ArrayList<String> listName = new ArrayList<String>();
		
		Random r = new Random();
		Scanner in = new Scanner(System.in);
		
		System.out.println("Selamat Datang di Game TEBAK KATA");
		System.out.println("Silahkan menikmati!");
		
		try {
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			
			// Membaca file file input serta 
			while((str=br.readLine()) != null) {
				listName.add(str);
			}
			
		} catch (FileNotFoundException fnfe) {
			fnfe.getMessage();
		} catch (IOException ioe) {
			ioe.getMessage();
		}
		
		while(!listName.isEmpty()) {
			
			str = randWord(listName);
			
			int i = 0;
			int len = str.length();
						
			// Membuat array of char yang berisi character dari str
			while(i<len) {
				strChar.add(str.charAt(i));
				i++;
			}
			
			rndStr = randStr(strChar);
						
			System.out.println("Tebak kata: " + rndStr);
			System.out.print("Jawab: ");
			ans = in.nextLine();
			String giveup = "";
			while(!ans.equalsIgnoreCase(str)) {				
				System.out.println("SALAH! Apakah menyerah untuk kata ini?(yes/no)");
				giveup = in.nextLine();
				
				if(giveup.equalsIgnoreCase("yes") || giveup.equalsIgnoreCase("y")) {
					break;
				} else if(giveup.equalsIgnoreCase("no") || giveup.equalsIgnoreCase("n")) {
					System.out.println("Silahkan coba lagi!");
					System.out.print("Jawab: ");
					ans = in.nextLine();
				}
			}
			
			if(ans.equalsIgnoreCase(str)) {
				System.out.println("BENAR :)");
			}		
						
			// Mengkosongkan variable rndStr untuk dipakai pada loop selanjutnya
			rndStr = "";
						
			// --------------------------
		}
		
		System.out.println("Thanks for playing");
		
		System.out.println("- GAME END -");

	}
	
	/*
	 * Method ini berfungsi untuk mendapatkan sebuah string dari sebuah ArrayList secara random
	 * Serta menghapus string yang telah diambil dari ArrayList tersebut
	 * */
	public static String randWord(ArrayList<String> listName) {
		Random r = new Random();
		int rand = r.nextInt(listName.size());
		String str = listName.get(rand);
		listName.remove(rand);
		return str;
		
	}
	/*
	 * Method ini berfungsi untuk mendapatkan sebuah character dari sebuah ArrayList secara random
	 * Serta menghapus character yang telah diambil dari ArrayList tersebut 
	 * */
	
	public static char randChar(ArrayList<Character> chr) {
		Random r = new Random();
		int rand = r.nextInt(chr.size());
		char c = chr.get(rand);
		chr.remove(rand);
		return c;
	}

	/*
	 * Method ini berfungsi untuk membuat sebuah string menjadi random string
	 * Dimana random string merupakan suatu string yang memiliki character sama persis seperti string awal,
	 * hanya saja letak characternya berbeda
	 * 
	 * */
	public static String randStr(ArrayList<Character> chr) {
		String rndStr = "";
		
		// Me-random kata
		while(chr.size() != 0) {							
			rndStr = rndStr + randChar(chr);
		}
		return rndStr;
	}
}
