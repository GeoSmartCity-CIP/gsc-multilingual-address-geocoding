package com.services.rest;

public class Results {
	
	public Results()
	{
		
	}
	
	public int id;
	public String address;
	public String geometry;
	public double rank;
	
	public void getData(int id, String address, String geometry, double rank)
	{
		
		this.id= id;
		this.address = address;
	    this.geometry = geometry;
		this.rank = rank;
		
		
	}
}
