package AdventOfCode.year24.day02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Report {

	Integer[] levels;
	boolean removeFunctionUsed = false;
	
	
	public Report(String s) {
		String[] levelsStr = s.split(" ");
		this.levels = new Integer[levelsStr.length];
		for(int i = 0;i<levelsStr.length;i++) {
			levels[i] = Integer.parseInt(levelsStr[i]);
		}
	}
	
	public int checkIncrease() {
		ArrayList<Integer>iPlus = new ArrayList<Integer>();
		ArrayList<Integer>iMinus = new ArrayList<Integer>();
		
		for(int i = 0;i<levels.length-1;i++) {
			
			if(levels[i] > levels[i+1]) {
				iMinus.add(i);
			}
			if(levels[i+1] > levels[i]) {
				iPlus.add(i);
			}
		}
		if(iPlus.size()>iMinus.size()) {
			return 1;
		}else {
			return -1;
		}
		
	}
	
	public boolean checkSafe3() {
		System.out.println("Checkanfang--------------");
		for(int i=0;i<levels.length;) {
			int sum = 0;
			int sum2 =0;
			if(i == levels.length-1) {
				return true;
			}
			if(checkIncrease() == 1) {
				sum = levels[i+1] - levels[i];
				if(i==levels.length-2) {
					sum2 = 1;
				}else {
					sum2 = levels[i+2] - levels[i];
				}
			}else {
				sum = levels[i] - levels[i+1];
				if(i==levels.length-2) {
					sum2 = 1;
				}else {
				sum2 = levels[i] - levels[i+2];
				}
				
			}
			System.out.println("Summe: " + sum);
			if(checkNumber(sum) == false) {
				if(removeFunctionUsed == false) { //Bearbeiten
					if(checkNumber(sum2)) {
						removeEntry(i+1);
					}else {
						removeEntry(i);
					}
					i=0;
					
					
					
					
				}else {
					return false;
				}
			}else {
				i++;
			}
		}	
		return true;
	}
	
	private void removeEntry(int entry) {
		if(removeFunctionUsed == false) {
		List<Integer> copyArr = new ArrayList<Integer>();
		for(int i = 0; i<levels.length;i++) {
			if(i == entry) {
				System.out.println("Zahl " + levels[i] );
			}else {
				copyArr.add(levels[i]);
			}
		}
		levels= Arrays.stream(copyArr.toArray())
                   .map(o -> (Integer) o) // Casting jedes Elements
                   .toArray(Integer[]::new);
		System.out.println("New Array: " + Arrays.toString(this.levels));
		removeFunctionUsed = true;
		}
	}
	
	public boolean checkNumber(int i) {
		if(i==1 || i==2 || i==3) {
			return true;
		}else {
			return false;
		}
	}
	
}
