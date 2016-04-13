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
		ArrayList<Character> strChar = new ArrayList<Character>();
		ArrayList<String> listName = new ArrayList<String>();
		
		Random r = new Random();
		Scanner in = new Scanner(System.in);
		
		System.out.println("Selamat Datang di Game TEBAK KATA");
		System.out.println("Silahkan menikmati!");
		
		try {
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			
			// Membaca file nama.txt serta 
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
						
			// Me-random kata
			while(strChar.size() != 0) {
				idx = r.nextInt(strChar.size());
							
				rndStr = rndStr + strChar.get(idx);
				strChar.remove(idx);
							
			}
						
			System.out.println("Tebak kata: " + rndStr);
			System.out.print("Jawab: ");
			ans = in.nextLine();
						
			while(!ans.equalsIgnoreCase(str)) {
				System.out.println("SALAH! Silahkan coba lagi");
				System.out.print("Jawab: ");
				ans = in.nextLine();
			}
			System.out.println("BENAR");
						
						
			// Mengkosongkan variable rndStr untuk dipakai pada loop selanjutnya
			rndStr = "";
						
			// --------------------------
		}
		
		System.out.println("THANK YOU!");

	}
	
	/*
	 * Method ini berfungsi untuk mendapatkan sebuah string dari sebuah ArrayList secara random
	 * Serta menghapus kata yang diambil dari ArrayList tersebut
	 * */
	public static String randWord(ArrayList<String> listName) {
		Random r = new Random();
		int rand = r.nextInt(listName.size());
		String str = listName.get(rand);
		listName.remove(rand);
		return str;
		
	}

}
