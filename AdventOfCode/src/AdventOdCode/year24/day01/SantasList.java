package AdventOdCode.year24.day01;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class SantasList {

	Set<Integer>listLeft = new TreeSet<>();
	Set<Integer>listRight = new TreeSet<>();
	
	public SantasList() {
		setLeftList();
		setRightList();
	}
	
	public void setLeftList() {
		
		this.listLeft.add(3);
		this.listLeft.add(4);
		this.listLeft.add(2);
		this.listLeft.add(1);
		this.listLeft.add(3);
		this.listLeft.add(3);
	}
	
	public void setRightList() {
		this.listRight.add(4);
		this.listRight.add(3);
		this.listRight.add(5);
		this.listRight.add(3);
		this.listRight.add(9);
		this.listRight.add(5);
	}
	public void showSets() {
		for(int i : listLeft) {
			System.out.println(i);
		}
	}
}
