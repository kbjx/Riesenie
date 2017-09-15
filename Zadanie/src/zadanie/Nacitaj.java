package zadanie;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Nacitaj {

	private String line;
	private int countLines;

	// read first line
	public Nacitaj() {
		try {
			File file = new File("vstup.txt");
			Scanner in = new Scanner(file);
			countLines = in.nextInt();
			in.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// read specific line
	public void TentoRiadok(int lineNumber) {
		try {
			FileInputStream fs = new FileInputStream("vstup.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fs));
			for (int i = 0; i < lineNumber; i++) {
				br.readLine();
			}
			String line = br.readLine();
			this.line = line;
			br.close();
			fs.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getLine() {return line;}

	public int getCountLines() {return countLines;}
}