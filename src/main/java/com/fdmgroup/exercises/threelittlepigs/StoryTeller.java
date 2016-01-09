package com.fdmgroup.exercises.threelittlepigs;


public class StoryTeller {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		House house = new House();
		house.setHouseNum(1);
		
		Pig pig = new Pig(house);		
		Wolf wolf = new Wolf(house);
		
		Thread thread1 = new Thread(pig);
		Thread thread2 = new Thread(wolf);

		thread1.start();
		thread2.start();				
	}

}
