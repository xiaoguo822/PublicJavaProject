package org.xiaoguo.iweb.volunteer.test;

import java.util.Arrays;
import java.util.Random;


public class Main {

	public static void main(String[] args) {
		Random random = new Random();
		double average = Arrays.asList(new Integer[100])
				.stream()
				.mapToInt(i->random.nextInt(100))
				.summaryStatistics()
				.getAverage();;
		
	}

}
