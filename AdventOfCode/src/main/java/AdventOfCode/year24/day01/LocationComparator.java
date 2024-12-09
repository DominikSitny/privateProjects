package AdventOfCode.year24.day01;

import java.util.Comparator;

public class LocationComparator implements Comparator<Location>{

	@Override
	public int compare(Location o1, Location o2) {
		// TODO Auto-generated method stub
		if(o1.getId()>o2.getId()) {
			return 1;
		}else if(o1.getId()<o2.getId()) {
			return -1;
		}else {
			return 0;
		}
	}

}
