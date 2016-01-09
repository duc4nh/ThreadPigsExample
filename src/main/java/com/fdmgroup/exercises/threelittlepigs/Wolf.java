package com.fdmgroup.exercises.threelittlepigs;


public class Wolf implements Runnable {

	House house;	
	
	Wolf(House house)
	{
		this.house = house;
	}
		
	@Override
	public void run() {
		startChasing();		
	}
	
	public void startChasing()
	{					
		synchronized(house)
		{	
			for (int i=0; i<3; i++)
			{
				System.out.println("Wolf is looking to do damage");											
				System.out.println("Wolf sees pig is in house "+house.getHouseNum());		
				house.blowOnHouse();				
				house.notify();
				try {
					house.wait();
				} catch (InterruptedException e) {					
					e.printStackTrace();
				}
			}	
			System.out.println("Wolf gets stuck in chimney");
		}
	}
	
}