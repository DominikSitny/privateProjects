package AdventOfCode.year24.day02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


import org.springframework.util.ResourceUtils;


public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int counterSafe = 0;	
			try {
				File file = ResourceUtils.getFile("classpath:TXT2024/02.txt");
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				String line;
				int counter=0;
				try {
					while((line = br.readLine()) != null){
					    //process the line
						Report r = new Report(line); 
							if(r.checkSafe3()) {
								System.out.println("Richtig: " + (counter+1));
								counterSafe++;
							}
							counter++;		    
					}
					System.out.println("\nSafeCounter: " + counterSafe);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
