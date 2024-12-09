package AdventOfCode.year24.day01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.util.ResourceUtils;

public class SantasList {

	List<Location>listLeft = new ArrayList<>();
	List<Location>listRight = new ArrayList<>();
	
	public SantasList() {
		setLists();
		this.listLeft.sort(new LocationComparator());
		this.listRight.sort(new LocationComparator());
	}
	
	public void setLists() {
		try {
			File file = ResourceUtils.getFile("classpath:TXT2024/01.txt");
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line;
			try {
				while((line = br.readLine()) != null){
				    //process the line
					String[] arr = line.split(" ");
				    this.listLeft.add(new Location(Integer.parseInt(arr[0])));
				    this.listRight.add(new Location(Integer.parseInt(arr[3])));
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int calcuateDistances() {
		
		int distance = 0;
		
		for(int i=0;i<1000;i++) {
			if(this.listRight.get(i).getId() > this.listLeft.get(i).getId()) {
				distance += this.listRight.get(i).getId() - this.listLeft.get(i).getId();
			}else if(this.listLeft.get(i).getId() > this.listRight.get(i).getId()){
				distance += this.listLeft.get(i).getId() - this.listRight.get(i).getId();
			}
		}
		return distance;
	}
	
	public int countSimilarity() {
		
		int counterSim = 0;
		int counterSum = 0;
		for(Location l : listLeft) {
			for(Location r: listRight) {
				if(l.getId() == r.getId()) {
					counterSim++;
				}
			}
			counterSum += l.getId() * counterSim;
			counterSim = 0;
		}
		return counterSum;
	}
	
	public void showLists() {
		for(int i=0;i<this.listLeft.size();i++) {
			System.out.println(this.listLeft.get(i) + "  " + this.listRight.get(i) + "\n");
		}
	}

}
