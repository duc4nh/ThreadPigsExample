package com.fdmgroup.exercises.threelittlepigs;


public class Pig implements Runnable {

	House house;	
	
	Pig(House house)
	{		
		this.house = house;
	}
	
	@Override
	public void run() {
		storyBegins();		
	}
	
	public void storyBegins()
	{	
		synchronized(house)
		{
			for (int i=0; i<3; i++)
			{
				System.out.println("Pig "+house.getHouseNum()+" building house");			
				house.buildHouse();									
									
				try {				
					house.wait();							
				} catch (InterruptedException e) {			
					e.printStackTrace();
				}	
				
				if (house.getHouseNum() == 3)
					System.out.println("Pigs are snug and safe in their strong house");						
				else
				{
					house.fallDown();
					System.out.println("Pig from house "+house.getHouseNum()+" runs to brother");
				}
				System.out.println();
				house.incrementHouse();
				house.notify();
			}
		}
	}		
}
